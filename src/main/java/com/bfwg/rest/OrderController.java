package com.bfwg.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bfwg.model.Order;
import com.bfwg.model.OrderDetail;
import com.bfwg.service.OrderService;

@RestController
@RequestMapping( value = "/api/order", produces = MediaType.APPLICATION_JSON_VALUE )
public class OrderController {
    @Autowired
    private OrderService orderService;


    @RequestMapping( method = GET, value= "/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Order> loadAll() {
        return this.orderService.findAllOrder();
    }
    
    @RequestMapping( method = RequestMethod.GET, value= "/one-order-detail")
    @PreAuthorize("hasRole('ADMIN')")
    public List<OrderDetail> loadAllOrderDetail(@RequestParam int id) {
        return this.orderService.findOneOrderDetail(id);
    }
    
    @RequestMapping( method = GET, value= "/all-order-detail")
    @PreAuthorize("hasRole('ADMIN')")
    public List<OrderDetail> loadAllOrderDetail() {
        return this.orderService.findAllOrderDetail();
    }
    
//    @RequestMapping( method = RequestMethod.POST, value = "/insert-order")
//    @PreAuthorize("hasRole('USER')")
//    public void insertOrder(@RequestBody List<OrderDetail> orderDetails) {
//    	orderService.insertOrder(orderDetails);
//    }
    
    @RequestMapping( method = RequestMethod.POST, value = "/insert-order-detail")
    @PreAuthorize("hasRole('USER')")
    public void insertOrderDetail(@RequestBody List<OrderDetail> orderDetails) {
    	orderService.insertOrderDetail(orderDetails);
    }
    
    @RequestMapping( method = GET, value= "/update-order-detail")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateOrderDetail(@RequestParam Long id) {
        orderService.updateOrderDetail(id);
    }
}
