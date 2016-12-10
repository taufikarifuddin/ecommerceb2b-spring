package com.taufik.service;

import org.springframework.stereotype.Service;

import com.taufik.base.BaseService;
import com.taufik.model.Member;
import com.taufik.repository.MemberRepository;

@Service
public class MemberService extends BaseService<Member,MemberRepository>{}
