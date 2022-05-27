package com.eCommerce.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_order")
@Data
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date orderDate;
	private Date shippingDate;
	private String shippingMethod;
	private String orderStatus;
	private BigDecimal orderTotal;
	
	@OneToMany(mappedBy = "order", cascade=CascadeType.ALL )
	private List<CartItem> cartItemList;
	
	@OneToOne(cascade=CascadeType.ALL)
	private ShippingAddress shippingAddress;
	

	
	@OneToOne(cascade=CascadeType.ALL)
	private Payment payment;
	
	@ManyToOne
	private User user;


	
}
