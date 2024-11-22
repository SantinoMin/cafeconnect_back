package com.kong.cc.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kong.cc.dto.MemberDto;
import com.kong.cc.entity.Member;
import com.kong.cc.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder encoder;

    public Member join(MemberDto memberDto) throws Exception {

    	Member member = Member.builder()
                .username(memberDto.getUsername())
                .password(encoder.encode(memberDto.getPassword()))
                .deptName(memberDto.getDeptName())
                .build();

        return memberRepository.save(member);

    }

}