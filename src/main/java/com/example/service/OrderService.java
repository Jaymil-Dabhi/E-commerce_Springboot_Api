package com.example.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.exception.OrderException;
import com.example.model.Address;
import com.example.model.Order;
import com.example.model.Product;
import com.example.model.User;

public interface OrderService {

	public Order createOrder(User user, Address shippingAddress);
	
    public Order findOrderById(Long orderId) throws OrderException;
    
    public List<Order> usersOrderHistory(Long userId);
    
    public Order placedOrder(Long orderId) throws OrderException;
    
    public Order confirmedOrder(Long orderId) throws OrderException;
    
    public Order shippedOrder(Long orderId) throws OrderException;
    
    public void deleteOrder(Long orderId) throws OrderException;
    
    public Order deliveredOrder(Long orderId) throws OrderException;
    
    public Order cancledOrder(Long orderId) throws OrderException;

	public List<Order> getAllOrders();
    
    
}
