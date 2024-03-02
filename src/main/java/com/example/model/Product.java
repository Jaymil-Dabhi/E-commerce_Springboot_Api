package com.example.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Product {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	
	private String title;
	
	
	private String description;
	
	
	private String price;
	
	@Column(name="discount_price")
<<<<<<< HEAD
	private String discountedPrice;
	
	@Column(name="discount_percent")
	private String discountedPercent;
=======
	private String discountPrice;
	
	@Column(name="discount_percent")
	private String discountPercent;
>>>>>>> b85a357c66aeb8ae99b89a940ff6945a4067f389
	
	@Column(name="quantity")
	private String quantity;
	
	
	private String brand;
	
	private String color;
	
	@Embedded
	@ElementCollection
	@Column(name="sizes")
	private Set<Size> sizes = new HashSet<>();
	
	@Column(name="image_url")
	private String imageUrl;
	
	@OneToMany(mappedBy="product",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Rating> ratings = new ArrayList<>();
	
	@OneToMany(mappedBy="product",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Review> reviews = new ArrayList<>();
	
	@Column(name="num_ratings")
	private int numRatings;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category categoryId;
	
	private LocalDateTime createdAt;	
	
	public Product() {
		
	}

	public Product(Long id, String title, String description, String price, String discountPrice,
			String discountPercent, String quantity, String brand, String color, Set<Size> sizes, String imageUrl,
			List<Rating> ratings, List<Review> reviews, int numRatings, Category categoryId, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
<<<<<<< HEAD
		this.discountedPrice = discountPrice;
		this.discountedPercent = discountPercent;
=======
		this.discountPrice = discountPrice;
		this.discountPercent = discountPercent;
>>>>>>> b85a357c66aeb8ae99b89a940ff6945a4067f389
		this.quantity = quantity;
		this.brand = brand;
		this.color = color;
		this.sizes = sizes;
		this.imageUrl = imageUrl;
		this.ratings = ratings;
		this.reviews = reviews;
		this.numRatings = numRatings;
		this.categoryId = categoryId;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDiscountPrice() {
<<<<<<< HEAD
		return discountedPrice;
	}

	public void setDiscountPrice(String discountPrice) {
		this.discountedPrice = discountPrice;
	}

	public String getDiscountPercent() {
		return discountedPercent;
	}

	public void setDiscountPercent(String discountPercent) {
		this.discountedPercent = discountPercent;
=======
		return discountPrice;
	}

	public void setDiscountPrice(String discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(String discountPercent) {
		this.discountPercent = discountPercent;
>>>>>>> b85a357c66aeb8ae99b89a940ff6945a4067f389
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Set<Size> getSizes() {
		return sizes;
	}

	public void setSizes(Set<Size> sizes) {
		this.sizes = sizes;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public int getNumRatings() {
		return numRatings;
	}

	public void setNumRatings(int numRatings) {
		this.numRatings = numRatings;
	}

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
