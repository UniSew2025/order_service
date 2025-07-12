package com.unisew.order_service.services;

import com.unisew.order_service.requests.CreateOrderRequest;
import com.unisew.order_service.requests.CreateQuotationRequest;
import com.unisew.order_service.requests.ProcessQuotationRequest;
import com.unisew.order_service.response.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface OrderService {

    ResponseEntity<ResponseObject> createOrder(CreateOrderRequest request);

    ResponseEntity<ResponseObject> viewOrders();

    ResponseEntity<ResponseObject> cancelOrder(int orderId);

    ResponseEntity<ResponseObject> createQuotation(CreateQuotationRequest request);

    ResponseEntity<ResponseObject> processQuotation(ProcessQuotationRequest request);

}
