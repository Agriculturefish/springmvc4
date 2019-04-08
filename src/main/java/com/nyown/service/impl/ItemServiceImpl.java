package com.nyown.service.impl;

import java.util.List;

import javax.annotation.Resource;
//import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


import com.nyown.mapper.ItemsMapper;
import com.nyown.pojo.Items;
import com.nyown.pojo.ItemsVO;
import com.nyown.service.ItemService;
import com.nyown.util.CommonUtils;

@Service("itemService")
@EnableTransactionManagement
public class ItemServiceImpl implements ItemService {

	
//	@Autowired
	@Resource
    private ItemsMapper itemsMapper;
	@Transactional
	public List<Items> getItemList(ItemsVO itemsvo) {
		Items items = new Items();
		items.setCreatetime(CommonUtils.convert(itemsvo.getStarttime()));
        List<Items> list = itemsMapper.selectItemList(items);
        return list;
	}
	
	@Transactional
	public Items getItem(ItemsVO itemsvo) {
		Items items = new Items();
		items.setId(itemsvo.getId());
		items = itemsMapper.selectItemById(items);
        return items;
	}

}
