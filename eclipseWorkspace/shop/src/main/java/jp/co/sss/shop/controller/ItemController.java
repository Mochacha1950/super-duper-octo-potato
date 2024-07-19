package jp.co.sss.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import jp.co.sss.shop.repository.ItemRepository;

@Controller
public class ItemController {
	
	@Autowired
	ItemRepository repository;
	
	@RequestMapping("/items/findAll")
	public String showItemList(Model model) {
		if(repository.findAll().isEmpty()) {
			return "items/null_item_list";
		}
		model.addAttribute("items", repository.findAll());
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
}
