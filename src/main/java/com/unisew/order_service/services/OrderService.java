package com.unisew.order_service.services;

import com.unisew.order_service.requests.AssignGarmentRequest;
import com.unisew.order_service.requests.CancelOrderRequest;
import com.unisew.order_service.requests.CreateOrderRequest;
import com.unisew.order_service.requests.CreateQuotationRequest;
import com.unisew.order_service.requests.ProcessQuotationRequest;
import com.unisew.order_service.requests.UpdateOrderRequest;
import com.unisew.order_service.requests.ViewOrderRequest;
import com.unisew.order_service.response.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface OrderService {

    ResponseEntity<ResponseObject> createOrder(CreateOrderRequest request);

    ResponseEntity<ResponseObject> viewOrder(int orderId);

    ResponseEntity<ResponseObject> cancelOrder(int orderId);

    ResponseEntity<ResponseObject> createQuotation(CreateQuotationRequest request);

    ResponseEntity<ResponseObject> processQuotation(ProcessQuotationRequest request);

}
