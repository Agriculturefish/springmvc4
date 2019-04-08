package com.nyown.service;

import java.util.List;

import com.nyown.pojo.Items;
import com.nyown.pojo.ItemsVO;


public interface ItemService {

	List<Items> getItemList(ItemsVO itemvo);
	
	Items getItem(ItemsVO itemvo);
}
