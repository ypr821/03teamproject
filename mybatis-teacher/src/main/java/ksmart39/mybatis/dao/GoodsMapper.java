package ksmart39.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.mybatis.domain.Goods;

@Mapper
public interface GoodsMapper {

	//상품목록조회 
	public List<Goods> getGoodsList(Map<String, Object> paramMap);
	
	//상품등록
	public int addGoods(Goods goods);
}
