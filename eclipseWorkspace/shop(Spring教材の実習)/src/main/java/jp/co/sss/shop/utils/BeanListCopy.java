package jp.co.sss.shop.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import jp.co.sss.shop.bean.ItemBean;
import jp.co.sss.shop.entity.Item;


//使い方 => @Autowired 
//         BeansListCopy listCopy; 
@Service
public class BeanListCopy {
	public List<ItemBean> copyItemToBean(List<Item> itemsList){
		List<ItemBean> itemBeanList = new ArrayList<ItemBean>();
		
		for(Item item : itemsList) {
			ItemBean itemBean = new ItemBean();
			BeanUtils.copyProperties(item, itemBean);
			itemBeanList.add(itemBean);
		}
		
		return itemBeanList;
	}
}
