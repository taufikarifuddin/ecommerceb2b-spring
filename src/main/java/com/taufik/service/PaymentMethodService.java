package com.taufik.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;
import com.taufik.model.PaymentMethod;

@Service
public class PaymentMethodService extends BaseService<PaymentMethod, JpaRepository<PaymentMethod,Integer>>{

}
