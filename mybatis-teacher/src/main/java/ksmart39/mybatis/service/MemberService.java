package ksmart39.mybatis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart39.mybatis.dao.MemberMapper;
import ksmart39.mybatis.domain.Member;

@Service
@Transactional
public class MemberService {
	
	private static final Logger log = LoggerFactory.getLogger(MemberService.class);

	
	/**
	 * 필드 주입방식 (DI)
	 * MemberMapper memberMapper = new MemberMapper();
	 * setter 메소드 memberMapper
	 * 생성자메소드 memberMapper
	 */
	@Autowired
	private MemberMapper memberMapper;

	@PostConstruct
	public void memberServiceInit() {
		log.info("========================================");
		log.info("MemberService 객체 생성");
		log.info("========================================");
		//System.out.println("====================================");
		//System.out.println("MemberService 객체 생성");
		//System.out.println("====================================");
	}
	
	public Map<String, Object> loginMember(String memberId, String memberPw) {
		//로그인 여부
		boolean loginCheck = false;
		
		//로그인 결과 
		Map<String, Object> memberInfoMap = new HashMap<String, Object>();
		
		//로그인 처리
		Member member = memberMapper.getMemberInfoById(memberId);
		
		if(member != null && memberPw.equals(member.getMemberPw())) {
			loginCheck = true;
			memberInfoMap.put("loginMember", member);
		}
		
		memberInfoMap.put("loginCheck", loginCheck);
		
		return memberInfoMap;
	}
	
	public boolean removeMember(String memberId, String memberPw) {
		//삭제여부
		boolean removeCheck = false;
		
		//비밀번호 맞으면 삭제 
		Member member = memberMapper.getMemberInfoById(memberId);
		
		if(member != null && memberPw.equals(member.getMemberPw())) {
			//삭제프로세스
			//판매자
			if("2".equals(member.getMemberLevel())) {
				//1. 주문, 상품	
				memberMapper.removeOrderBySellerId(memberId);
				memberMapper.removeGoodsById(memberId);
			}

			//구매자
			if("3".equals(member.getMemberLevel())) {
				//1. 주문	
				memberMapper.removeOrderById(memberId);				
			}
			
			memberMapper.removeLoginById(memberId);
			memberMapper.removeMemberById(memberId);
			
			removeCheck = true;
		}
		
		return removeCheck;
	}
	
	
	public int modifyMember(Member member) {
		
		return memberMapper.modifyMember(member);
	}
	
	public Member getMemberInfoById(String memberId) {
		
		return memberMapper.getMemberInfoById(memberId);
	}
	
	
	public List<Member> getMemberList(Map<String, Object> paramMap){
		
		List<Member> memberList = memberMapper.getMemberList(paramMap);
		
		return memberList;
	}
	
	
	public int addMember(Member member) {
		
		int result = memberMapper.addMember(member);
		
		return result;
	}
	
	
	
	
	
	
	
	
	
}
