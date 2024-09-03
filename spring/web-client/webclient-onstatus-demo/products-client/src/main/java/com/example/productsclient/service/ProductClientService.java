package com.example.productsclient.service;

import com.example.productsclient.exception.InvalidProductRequestException;
import com.example.productsclient.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductClientService {


    private final WebClient webClient;


    public Mono<Product> addProduct(Product product) {
        return webClient.post()
                .uri("/products")
                .bodyValue(product)
                .retrieve()
                .onStatus(HttpStatusCode::isError, this::handleError)
                .bodyToMono(Product.class);

    }

    private Mono<? extends Throwable> handleError(org.springframework.web.reactive.function.client.ClientResponse clientResponse) {
        if (clientResponse.statusCode().equals(HttpStatus.BAD_REQUEST)) {

            return clientResponse.bodyToMono(String.class)
                    .flatMap(error -> Mono.error(new InvalidProductRequestException(error)));
        }

        return clientResponse.bodyToMono(String.class)
                .flatMap(error -> Mono.error(new RuntimeException(error)));
    }


    public Mono<List<Product>> getAllProducts() {
        return webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(Product.class)
                .collectList();

    }


}
