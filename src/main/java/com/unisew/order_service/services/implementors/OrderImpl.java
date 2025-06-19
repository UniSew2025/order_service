package com.unisew.order_service.services.implementors;

import com.unisew.order_service.models.Order;
import com.unisew.order_service.repositories.OrderDetailRepo;
import com.unisew.order_service.repositories.OrderRepo;
import com.unisew.order_service.requests.AssignGarmentRequest;
import com.unisew.order_service.requests.CancelOrderRequest;
import com.unisew.order_service.requests.CreateOrderRequest;
import com.unisew.order_service.requests.CreateQuotationRequest;
import com.unisew.order_service.requests.ProcessQuotationRequest;
import com.unisew.order_service.requests.UpdateOrderRequest;
import com.unisew.order_service.response.ResponseObject;
import com.unisew.order_service.services.OrderService;
import com.unisew.order_service.utils.ResponseBuilder;
import com.unisew.order_service.validation.OrderValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final OrderDetailRepo orderDetailRepo;

    @Override
    public ResponseEntity<ResponseObject> createOrder(CreateOrderRequest request) {
        String error = OrderValidation.validateCreateOrder(request);
        if(!error.isEmpty()) return ResponseBuilder.build(HttpStatus.BAD_REQUEST, error, null);
        return null;
    }

    private void createOrderDetail(Order order){

    }

    @Override
    public ResponseEntity<ResponseObject> viewOrder(CreateOrderRequest request) {
        String error = OrderValidation.validateViewOrder(request);
        if(!error.isEmpty()) return ResponseBuilder.build(HttpStatus.BAD_REQUEST, error, null);
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject> updateOrder(UpdateOrderRequest request) {
        String error = OrderValidation.validateUpdateOrder(request);
        if(!error.isEmpty()) return ResponseBuilder.build(HttpStatus.BAD_REQUEST, error, null);
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject> cancelOrder(CancelOrderRequest request) {
        String error = OrderValidation.validateCancelOrder(request);
        if(!error.isEmpty()) return ResponseBuilder.build(HttpStatus.BAD_REQUEST, error, null);
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject> createQuotation(CreateQuotationRequest request) {
        String error = OrderValidation.validateCreateQuotation(request);
        if(!error.isEmpty()) return ResponseBuilder.build(HttpStatus.BAD_REQUEST, error, null);
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject> processQuotation(ProcessQuotationRequest request, String action) {
        String error = OrderValidation.validateProcessQuotation(request);
        if(!error.isEmpty()) return ResponseBuilder.build(HttpStatus.BAD_REQUEST, error, null);
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject> assignGarment(AssignGarmentRequest request) {
        String error = OrderValidation.validateAssignGarment(request);
        if(!error.isEmpty()) return ResponseBuilder.build(HttpStatus.BAD_REQUEST, error, null);
        return null;
    }
}
