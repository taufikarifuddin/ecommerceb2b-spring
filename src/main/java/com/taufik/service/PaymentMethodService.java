package com.taufik.service;

import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;
import com.taufik.model.PaymentMethod;
import com.taufik.repository.PaymentMethodRepository;

@Service
public class PaymentMethodService extends BaseService<PaymentMethod, PaymentMethodRepository>{

}
