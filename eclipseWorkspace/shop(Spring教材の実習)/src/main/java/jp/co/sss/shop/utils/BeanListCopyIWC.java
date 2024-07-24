package jp.co.sss.shop.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import jp.co.sss.shop.bean.ItemWithCategoryBean;
import jp.co.sss.shop.entity.ItemWithCategory;

@Service
public class BeanListCopyIWC {
	
	
	
	public List<ItemWithCategoryBean> copyItemToBean(List<ItemWithCategory> itemList){
		
		List<ItemWithCategoryBean> beanList = new ArrayList<ItemWithCategoryBean>();
		
		for (ItemWithCategory item : itemList) {
			ItemWithCategoryBean bean = new ItemWithCategoryBean(); 
			BeanUtils.copyProperties(item, bean);
			
			beanList.add(bean);
		}
		
		return beanList;
	}
	
}
