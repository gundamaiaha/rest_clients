//package com.example.productsclient.service;
//
//// write unit test cases for the ProductClientService class
//
//
//import com.example.productsclient.exception.InvalidProductRequestException;
//import com.example.productsclient.model.Product;
//import com.example.productsclient.repository.ProductClientRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.reactive.function.client.ClientResponse;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//class ProductClientServiceTest {
//
//    @Mock
//    private WebClient webClient;
//
//    @InjectMocks
//    private ProductClientService productClientService;
//
//
//    @Test
//    void addProduct_InvalidProductRequestException() {
//        // Arrange
//        Product product = new Product();
//        product.setId(2);
//        product.setName("Product 2");
//        product.setPrice(200);
//
//        WebClient.RequestBodySpec requestBodySpec = Mockito.mock(WebClient.RequestBodySpec.class);
//        RequestHeadersSpec<?> requestHeadersSpec = Mockito.mock(RequestHeadersSpec.class);
//        ResponseSpec responseSpec = Mockito.mock(ResponseSpec.class);
//        RequestHeadersUriSpec<?> requestHeadersUriSpec = Mockito.mock(RequestHeadersUriSpec.class);
//        ClientResponse clientResponse = Mockito.mock(ClientResponse.class);
//
//        when(webClient.post()).thenReturn(requestHeadersUriSpec);
//        when(requestHeadersUriSpec.uri(any(String.class))).thenReturn(requestBodySpec);
//        when(requestBodySpec.bodyValue(any(Product.class))).thenReturn(requestHeadersSpec);
//        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
//        when(responseSpec.onStatus(any(), any())).thenReturn(Mono.error(new InvalidProductRequestException("Bad Request")));
//        when(clientResponse.statusCode()).thenReturn(HttpStatus.BAD_REQUEST);
//
//        // Act and Assert
//        assertThrows(InvalidProductRequestException.class, () -> productClientService.addProduct(product).block());
//    }
//}
