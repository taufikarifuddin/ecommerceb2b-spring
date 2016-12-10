package com.taufik.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;
import com.taufik.model.ProductTag;

@Service
public class ProductTagService extends BaseService<ProductTag, JpaRepository<ProductTag,Integer>>{

}
