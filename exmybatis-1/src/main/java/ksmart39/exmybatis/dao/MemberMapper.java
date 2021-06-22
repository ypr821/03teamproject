package ksmart39.exmybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.ui.Model;

import ksmart39.exmybatis.domain.Member;

@Mapper
public interface MemberMapper {
	
	
	//로그인 멤버 삭제 
	public int removeLoinMember(String memberId);
	
	//주문 멤버  삭제 
	public int removeOrderMember(String memberId);
	
	//상품에 연관된 주문 삭제 
	public int removeOrderByGoods(String memberId);
	
	//상품 멤버  삭제 
	public int removeGoodsMember(String memberId);
	
	//회원 멤버  삭제 
	public int removeMember(String memberId);
	
	
	
	//회원 수정
	public int modifyMember(Member member);
	
	
	//한명회원 조회
	public Member getMemberInfoById(String memberId);
	
	//회원가입
	public int addMember(Member member);
	
	//회원목록 조회
	public List<Member> getMemberList();
	
	
}
