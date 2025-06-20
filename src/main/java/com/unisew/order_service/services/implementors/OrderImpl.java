package com.unisew.order_service.services.implementors;

import com.unisew.order_service.enums.AppConfig;
import com.unisew.order_service.enums.ClothSize;
import com.unisew.order_service.enums.Status;
import com.unisew.order_service.models.Order;
import com.unisew.order_service.models.OrderDetail;
import com.unisew.order_service.repositories.OrderDetailRepo;
import com.unisew.order_service.repositories.OrderRepo;
import com.unisew.order_service.repositories.QuotationRepo;
import com.unisew.order_service.requests.AssignGarmentRequest;
import com.unisew.order_service.requests.CancelOrderRequest;
import com.unisew.order_service.requests.CreateOrderRequest;
import com.unisew.order_service.requests.CreateQuotationRequest;
import com.unisew.order_service.requests.ProcessQuotationRequest;
import com.unisew.order_service.requests.UpdateOrderRequest;
import com.unisew.order_service.requests.ViewOrderRequest;
import com.unisew.order_service.response.ResponseObject;
import com.unisew.order_service.services.OrderService;
import com.unisew.order_service.utils.ResponseBuilder;
import com.unisew.order_service.validation.OrderValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final OrderDetailRepo orderDetailRepo;
    private final QuotationRepo quotationRepo;

    @Override
    @Transactional
    public ResponseEntity<ResponseObject> createOrder(CreateOrderRequest request) {
        String error = OrderValidation.validateCreateOrder(request);
        if (!error.isEmpty()) return ResponseBuilder.build(HttpStatus.BAD_REQUEST, error, null);

        Order order = orderRepo.save(
                Order.builder()
                        .schoolId(request.getSchoolId())
                        .deadline(request.getDeadline())
                        .serviceFee(AppConfig.SERVICE_FEE.getFee())
                        .orderDate(LocalDate.now())
                        .note(request.getNote())
                        .status(Status.ORDER_QUEUE)

                        .price(0)
                        .garmentId(null)
                        .feedbackId(null)
                        .build()
        );


        return createOrderDetail(order, request);
    }

    private ResponseEntity<ResponseObject> createOrderDetail(Order order, CreateOrderRequest request) {
        List<OrderDetail> orderDetailList = new ArrayList<>();

        for(CreateOrderRequest.Cloth cloth: request.getClothList()) {
            for(CreateOrderRequest.Size size: cloth.getSizeList()) {
                orderDetailList.add(
                        OrderDetail.builder()
                                .clothId(cloth.getId())
                                .order(order)
                                .size(ClothSize.valueOf(size.getName().toUpperCase()))
                                .quantity(size.getQuantity())
                                .build()
                );
            }
        }

        if(orderDetailList.isEmpty()) {
            return ResponseBuilder.build(HttpStatus.BAD_REQUEST, "Fail to create order", null);
        }

        orderDetailRepo.saveAll(orderDetailList);

        return ResponseBuilder.build(HttpStatus.CREATED, "Order created", null);
    }

    @Override
    public ResponseEntity<ResponseObject> viewOrder(ViewOrderRequest request) {
        String error = OrderValidation.validateViewOrder(request);
        if (!error.isEmpty()) return ResponseBuilder.build(HttpStatus.BAD_REQUEST, error, null);

        

        return null;
    }

    @Override
    public ResponseEntity<ResponseObject> updateOrder(UpdateOrderRequest request) {
        String error = OrderValidation.validateUpdateOrder(request);
        if (!error.isEmpty()) return ResponseBuilder.build(HttpStatus.BAD_REQUEST, error, null);
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject> cancelOrder(CancelOrderRequest request) {
        String error = OrderValidation.validateCancelOrder(request);
        if (!error.isEmpty()) return ResponseBuilder.build(HttpStatus.BAD_REQUEST, error, null);
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject> createQuotation(CreateQuotationRequest request) {
        String error = OrderValidation.validateCreateQuotation(request);
        if (!error.isEmpty()) return ResponseBuilder.build(HttpStatus.BAD_REQUEST, error, null);
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject> processQuotation(ProcessQuotationRequest request, String action) {
        String error = OrderValidation.validateProcessQuotation(request);
        if (!error.isEmpty()) return ResponseBuilder.build(HttpStatus.BAD_REQUEST, error, null);
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject> assignGarment(AssignGarmentRequest request) {
        String error = OrderValidation.validateAssignGarment(request);
        if (!error.isEmpty()) return ResponseBuilder.build(HttpStatus.BAD_REQUEST, error, null);
        return null;
    }
}
