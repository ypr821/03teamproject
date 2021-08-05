package com.devcdper.payment.dao;



import org.apache.ibatis.annotations.Mapper;

import com.devcdper.payment.domain.Payment;



@Mapper
public interface PaymentMapper {

	public int insertPayment(Payment paymentInfo);
	
	
}
