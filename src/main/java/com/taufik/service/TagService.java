package com.taufik.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;
import com.taufik.model.Tag;

@Service
public class TagService extends BaseService<Tag, JpaRepository<Tag,Integer>>{

}
