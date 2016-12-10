package com.taufik.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;
import com.taufik.model.Role;

@Service
public class RoleService extends BaseService<Role, JpaRepository<Role,Integer>>{

}
