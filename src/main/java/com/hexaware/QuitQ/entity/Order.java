package com.hexaware.QuitQ.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long orderId;
	private double totalAmount;
	private LocalDate orderDate;
	@Enumerated(EnumType.STRING)
	private OrderStatusValues orderStatus;
	
	@OneToMany
	List<CartItem> ordercartItems = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "customerId")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "address_id", referencedColumnName = "addressId")
	private Address address;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(long orderId, double totalAmount, LocalDate orderDate, OrderStatusValues orderStatus,
			List<CartItem> ordercartItems, Customer customer, Address address) {
		super();
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.ordercartItems = ordercartItems;
		this.customer = customer;
		this.address = address;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatusValues getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatusValues orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<CartItem> getOrdercartItems() {
		return ordercartItems;
	}

	public void setOrdercartItems(List<CartItem> ordercartItems) {
		this.ordercartItems = ordercartItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", totalAmount=" + totalAmount + ", orderDate=" + orderDate
				+ ", orderStatus=" + orderStatus + ", ordercartItems=" + ordercartItems + ", customer=" + customer
				+ ", address=" + address + "]";
	}
	
	

}
