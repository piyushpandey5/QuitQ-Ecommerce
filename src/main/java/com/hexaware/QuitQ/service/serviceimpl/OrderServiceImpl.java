package com.hexaware.QuitQ.service.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.QuitQ.entity.CartItem;
import com.hexaware.QuitQ.entity.Order;
import com.hexaware.QuitQ.entity.OrderStatusValues;
import com.hexaware.QuitQ.entity.ProductStatus;
import com.hexaware.QuitQ.exception.LoginException;
import com.hexaware.QuitQ.exception.OrderException;
import com.hexaware.QuitQ.repository.OrderDao;
import com.hexaware.QuitQ.service.CustomerService;
import com.hexaware.QuitQ.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao oDao;
	
	@Autowired
	private CustomerService cs;
	
	@Override
	public List<Order> getAllOrders() throws OrderException {
		// TODO Auto-generated method stub
		List<Order> orders = oDao.findAll();
		if(orders.size()>0)
			return orders;
		else
			throw new OrderException("No Orders exists on your account");
	}
	
	@Override
	public Order getOrderByOrderId(Integer OrderId) throws OrderException {
		return oDao.findById(OrderId).orElseThrow(()-> new OrderException("No order exists with given OrderId "+ OrderId));
		
	}
	
	@Override
	public Order cancelOrderByOrderId(Integer OrderId,String token) throws OrderException {
		Order order= oDao.findById(OrderId).orElseThrow(()->new OrderException("No order exists with given OrderId "+ OrderId));
		if(order.getCustomer().getCustomerId()==cs.getLoggedInCustomerDetails(token).getCustomerId()) {
			if(order.getOrderStatus()==OrderStatusValues.PENDING) {
				order.setOrderStatus(OrderStatusValues.CANCELLED);
				oDao.save(order);
				return order;
			}
			else if(order.getOrderStatus()==OrderStatusValues.SUCCESS) {
				order.setOrderStatus(OrderStatusValues.CANCELLED);
				List<CartItem> cartItemsList= order.getOrdercartItems();
				
				for(CartItem cartItem : cartItemsList ) {
					Integer addedQuantity = cartItem.getCartProduct().getQuantity()+cartItem.getCartItemQuantity();
					cartItem.getCartProduct().setQuantity(addedQuantity);
					if(cartItem.getCartProduct().getStatus() == ProductStatus.OUTOFSTOCK) {
						cartItem.getCartProduct().setStatus(ProductStatus.AVAILABLE);
					}
				}
				
				oDao.save(order);
				return order;
			}
			else {
				throw new OrderException("Order was already cancelled");
			}
		}
		else {
			throw new LoginException("Invalid session token for customer"+"Kindly Login");
		}

		
	}
	
	@Override
	public List<Order> getAllOrdersByDate(LocalDate date) throws OrderException {
		
		List<Order> listOfOrdersOntheDay= oDao.findByOrderDate(date);
		return listOfOrdersOntheDay;
	}
}
