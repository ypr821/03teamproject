package ksmart39.exmybatis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import ksmart39.exmybatis.dao.MemberMapper;
import ksmart39.exmybatis.domain.Member;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;

	
	@PostConstruct
	public void memberServiceInit() {
		System.out.println("====================================");
		System.out.println("MemberService 객체생성");
		System.out.println("====================================");
	
	}

	
	//로그인 체크 
	public Map<String, Object> loginMember(String memberId, String memberPw){
		//로그인 여부 
		boolean loginCheck = false;
		//로그인 결과
		Map<String, Object> memberInfoMap  = new HashMap<String, Object>();
		
		//로그인 처리
		Member member = memberMapper.getMemberInfoById(memberId);
		
		if(member != null && memberPw.equals(member.getMemberPw())) {
			loginCheck = true;
			memberInfoMap.put("loginMember", member);
		}
		
		memberInfoMap.put("loginCheck", loginCheck);
		
		return memberInfoMap;
	}
	
	
	
	//로그인 멤버 삭제 
	public int removeLoinMember(String memberId) {
		System.out.println("====================================");
		System.out.println("removeLoinMember 실행");
		
		int result = memberMapper.removeLoinMember(memberId);
		return result;
	};
	
	//주문 멤버  삭제 
	public int removeOrderMember(String memberId) {
		System.out.println("====================================");
		System.out.println("removeOrderMember 실행");
		int result = memberMapper.removeOrderMember(memberId);
		return result;
	};
	
	//상품에 연관된 주문 삭제 
	public int removeOrderByGoods(String memberId) {
		System.out.println("====================================");
		System.out.println("removeOrderByGoods 실행");
		int result = memberMapper.removeOrderByGoods(memberId);
		return result;
	};
	
	//상품 멤버  삭제 
	public int removeGoodsMember(String memberId) {
		System.out.println("====================================");
		System.out.println("removeGoodsMember 실행");
		int result = memberMapper.removeGoodsMember(memberId);
		return result;
	};
	
	//회원 멤버  삭제 
	public int removeMember(String memberId) {
		System.out.println("====================================");
		System.out.println("removeMember 실행");
		int result = memberMapper.removeMember(memberId);
		return result;
	};
	
	
	

	
	public int modifyMember(Member member) {
		
		
		return memberMapper.modifyMember(member);
	}
	
	
	public Member getMemberInfoById(String memberId) {
		System.out.println("getMemberInfoById - service 실행");
		Member member = memberMapper.getMemberInfoById(memberId);
		return member;
	}
	
	
	public int addMember(Member member){
		return  memberMapper.addMember(member);
	}
	
	public List<Member> getMemberList() {
		System.out.println("MemberService getMemberList실행");
		List<Member> memberList = memberMapper.getMemberList();
		System.out.println(memberList);
		return memberList;
	}
	
	
	

}
