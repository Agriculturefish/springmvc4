package com.nyown.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nyown.pojo.Items;

@Repository
public interface ItemsMapper {

	List<Items> selectItemList(Items items);
	
	Items selectItemById(Items items);
}
