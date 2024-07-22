package jp.co.sss.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.shop.repository.ItemRepository;
import jp.co.sss.shop.utils.BeanListCopy;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;
import jp.co.sss.shop.bean.ItemBean;
import jp.co.sss.shop.entity.Item;

@Controller
public class ItemController {
	
	@Autowired
	ItemRepository repository;
	
	@Autowired
	BeanListCopy listCopy;
	
	
	@RequestMapping("/items/findAll")
	public String showItemList(Model model) {
		if(repository.findAll().isEmpty()) {
			return "items/null_item_list";
		}
		List<ItemBean> itemBeanList = listCopy.copyItemToBean(repository.findAll());
		model.addAttribute("items", itemBeanList);
		return "items/item_list";
	}
	
	@RequestMapping("/items/findAllByOrderByPriceDesc")
	public String showItemListByOrderByPriceDesc(Model model) {
		if(repository.findAll().isEmpty()) {
			return "items/null_item_list";
		}
		model.addAttribute("items", repository.findAllByOrderByPriceDesc());
		return "items/item_list";
	}
	
	//POSTでしたらどこまで表示される？
	@RequestMapping("/items/getOne/{id}")
	public String showItem(@PathVariable int id, Model model) {
		Item item = repository.getReferenceById(id);
		ItemBean itemBean = new ItemBean();
		BeanUtils.copyProperties(item, itemBean);
		model.addAttribute("item",itemBean);
		return "items/item";
	}
}
