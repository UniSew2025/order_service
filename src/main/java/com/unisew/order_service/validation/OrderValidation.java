package com.unisew.order_service.validation;

import com.unisew.order_service.requests.AssignGarmentRequest;
import com.unisew.order_service.requests.CancelOrderRequest;
import com.unisew.order_service.requests.CreateOrderRequest;
import com.unisew.order_service.requests.CreateQuotationRequest;
import com.unisew.order_service.requests.ProcessQuotationRequest;
import com.unisew.order_service.requests.UpdateOrderRequest;
import com.unisew.order_service.requests.ViewOrderRequest;

public class OrderValidation {

    public static String validateCreateOrder(CreateOrderRequest request){
        return "";
    }

    public static String validateViewOrder(int orderId){
        return "";
    }

    public static String validateUpdateOrder(UpdateOrderRequest request){
        return "";
    }

    public static String validateCancelOrder(CancelOrderRequest request){
        return "";
    }

    public static String validateCreateQuotation(CreateQuotationRequest request){
        return "";
    }

    public static String validateProcessQuotation(ProcessQuotationRequest request){
        return "";
    }

    public static String validateAssignGarment(AssignGarmentRequest request){
        return "";
    }

}
