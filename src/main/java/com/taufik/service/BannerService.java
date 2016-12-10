package com.taufik.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;
import com.taufik.model.Banner;

@Service
public class BannerService extends BaseService<Banner, JpaRepository<Banner,Integer>>{

}
