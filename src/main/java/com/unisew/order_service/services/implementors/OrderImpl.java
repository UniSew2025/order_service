package com.unisew.order_service.services.implementors;

import com.unisew.order_service.enums.AppConfig;
import com.unisew.order_service.enums.ClothSize;
import com.unisew.order_service.enums.Status;
import com.unisew.order_service.models.Order;
import com.unisew.order_service.models.OrderDetail;
import com.unisew.order_service.models.Quotation;
import com.unisew.order_service.repositories.OrderDetailRepo;
import com.unisew.order_service.repositories.OrderRepo;
import com.unisew.order_service.repositories.QuotationRepo;
import com.unisew.order_service.requests.CreateOrderRequest;
import com.unisew.order_service.requests.CreateQuotationRequest;
import com.unisew.order_service.requests.ProcessQuotationRequest;
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
import java.util.HashMap;
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
        if (!error.isEmpty())
            return ResponseBuilder.build(HttpStatus.BAD_REQUEST, error, null);

        Order order = orderRepo.save(
                Order.builder()
                        .schoolId(request.getSchoolId())
                        .deadline(request.getDeadline())
                        .serviceFee(AppConfig.SERVICE_FEE.getFee())
                        .orderDate(LocalDate.now())
                        .note(request.getNote())
                        .status(Status.ORDER_CREATED)
                        .price(0)
                        .garmentId(null)
                        .feedbackId(null)
                        .build()
        );
        return createOrderDetail(order, request);
    }

    private ResponseEntity<ResponseObject> createOrderDetail(Order order, CreateOrderRequest request) {
        List<OrderDetail> orderDetailList = new ArrayList<>();

        for (CreateOrderRequest.Cloth cloth : request.getClothList()) {
            for (CreateOrderRequest.Size size : cloth.getSizeList()) {
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

        if (orderDetailList.isEmpty()) {
            return ResponseBuilder.build(HttpStatus.BAD_REQUEST, "Fail to create order", null);
        }
        orderDetailRepo.saveAll(orderDetailList);
        return ResponseBuilder.build(HttpStatus.CREATED, "Order created", null);
    }

    @Override
    public ResponseEntity<ResponseObject> viewOrder(int id) {
        String error = OrderValidation.validateViewOrder(id);
        if (!error.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ResponseObject.builder().message(error).build());
        }

        Order order = orderRepo.findById(id).orElse(null);
        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ResponseObject.builder().message("Order not found").build());
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseObject.builder()
                        .message("View order successfully")
                        .data(buildOrder(order))
                        .build());
    }

    private Map<String, Object> buildOrder(Order order) {
        Map<String, Object> data = new HashMap<>();
        data.put("id", order.getId());
        data.put("deadline", order.getDeadline());
        data.put("price", order.getPrice());
        data.put("serviceFee", order.getServiceFee());
        data.put("orderDate", order.getOrderDate());
        data.put("note", order.getNote());
        data.put("status", order.getStatus());
        data.put("schoolId", order.getSchoolId());
        data.put("garmentId", order.getGarmentId());
        data.put("orderDetails", buildOrderDetails(order.getOrderDetails()));
        data.put("quotations", buildQuotations(order.getQuotations()));
        data.put("feedbackId", order.getFeedbackId());
        return data;
    }

    private List<Map<String, Object>> buildOrderDetails(List<OrderDetail> orderDetails) {
        if (orderDetails == null) return List.of();
        return orderDetails.stream().map(detail -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", detail.getId());
            map.put("size", detail.getSize());
            map.put("quantity", detail.getQuantity());
            map.put("clothId", detail.getClothId());
            return map;
        }).toList();
    }

    private List<Map<String, Object>> buildQuotations(List<Quotation> quotations) {
        if (quotations == null) return List.of();
        return quotations.stream().map(quotation -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", quotation.getId());
            map.put("earlyDeliveryDate", quotation.getEarlyDeliveryDate());
            map.put("price", quotation.getPrice());
            map.put("note", quotation.getNote());
            map.put("status", quotation.getStatus());
            map.put("garmentId", quotation.getGarmentId());
            return map;
        }).toList();
    }

    @Override
    public ResponseEntity<ResponseObject> cancelOrder(int id) {
        String error = OrderValidation.validateCancelOrder(id);
        if (!error.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ResponseObject.builder().message(error).build());
        }

        Order order = orderRepo.findById(id).orElse(null);
        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ResponseObject.builder().message("Order not found").build());
        }

        order.setStatus(Status.ORDER_CANCELED);
        orderRepo.save(order);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseObject.builder()
                        .message("Cancel order successfully")
                        .data(buildOrder(order))
                        .build());
    }

    @Override
    public ResponseEntity<ResponseObject> createQuotation(CreateQuotationRequest request) {
        String error = OrderValidation.validateCreateQuotation(request);
        if (!error.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ResponseObject.builder().message(error).build());
        }

        Order order = orderRepo.findById(request.getOrderId()).orElse(null);
        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ResponseObject.builder().message("Order not found").build());
        }

        Quotation quotation = Quotation.builder()
                .earlyDeliveryDate(request.getEarlyDeliveryDate())
                .price(request.getPrice())
                .note(request.getNote())
                .status(Status.ORDER_PENDING_QUOTE)
                .garmentId(request.getGarmentId())
                .order(order)
                .build();

        quotationRepo.save(quotation);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseObject.builder()
                        .message("Create quotation successfully")
                        .build());
    }

    @Override
    public ResponseEntity<ResponseObject> processQuotation(ProcessQuotationRequest request) {
        String error = OrderValidation.validateProcessQuotation(request);
        if (!error.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ResponseObject.builder().message(error).build());
        }

        Quotation quotation = quotationRepo.findById(request.getQuotationId()).orElse(null);
        if (quotation == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ResponseObject.builder().message("Quotation not found").build());
        }

        Order order = quotation.getOrder();
        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ResponseObject.builder().message("Order not found for this quotation").build());
        }

        if ("accept".equalsIgnoreCase(request.getAction())) {
            quotation.setStatus(Status.QUOTATION_ACCEPTED);

            order.setPrice(quotation.getPrice());
            order.setDeadline(quotation.getEarlyDeliveryDate());
            long serviceFee = Math.round(quotation.getPrice() * 0.1);
            order.setServiceFee(serviceFee);
            order.setStatus(Status.ORDER_PAID);

            orderRepo.save(order);
            quotationRepo.save(quotation);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(ResponseObject.builder()
                            .message("Quotation accepted and order updated successfully")
                            .build());
        } else if ("reject".equalsIgnoreCase(request.getAction())) {
            quotation.setStatus(Status.QUOTATION_REJECTED);
            quotationRepo.save(quotation);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(ResponseObject.builder()
                            .message("Quotation rejected successfully")
                            .build());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ResponseObject.builder().message("Invalid action").build());
        }
    }

}
