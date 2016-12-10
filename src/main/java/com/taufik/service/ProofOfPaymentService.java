package com.taufik.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;
import com.taufik.model.ProofOfPayment;

@Service
public class ProofOfPaymentService extends BaseService<ProofOfPayment, JpaRepository<ProofOfPayment,Integer>>{

}
