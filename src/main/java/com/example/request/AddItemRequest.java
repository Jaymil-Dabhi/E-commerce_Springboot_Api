package com.example.request;

public class AddItemRequest {

	private Long productId;
	private String size;
	private int quantiry;
	private Integer price;
	
	public AddItemRequest() {
		
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getQuantiry() {
		return quantiry;
	}

	public void setQuantiry(int quantiry) {
		this.quantiry = quantiry;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}
