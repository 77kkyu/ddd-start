package com.example.dddstart.order.query.dao;

import com.example.dddstart.order.query.dto.OrderSummary;
import com.example.dddstart.order.query.dto.OrderSummary_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class OrdererIdSpec implements Specification<OrderSummary> {
	private String ordererId;

	public OrdererIdSpec(String ordererId) {
		this.ordererId = ordererId;
	}

	@Override
	public Predicate toPredicate(
		Root<OrderSummary> root,
		CriteriaQuery<?> query,
		CriteriaBuilder criteriaBuilder
	) {
		return criteriaBuilder.equal(root.get(OrderSummary_.ordererId), ordererId);
	}
}
