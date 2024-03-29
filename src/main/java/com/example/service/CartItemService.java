package com.example.service;

import com.example.exception.CartItemException;
import com.example.exception.UserException;
import com.example.model.Cart;
import com.example.model.CartItem;
import com.example.model.Product;

public interface CartItemService {

	public CartItem createCartItem(CartItem cartItem);
	
	public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException;
	
	public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId);
	
	public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException;
	
	public void findCartItemById(Long cartItemId) throws CartItemException;
}
