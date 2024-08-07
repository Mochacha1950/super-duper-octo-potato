package jp.co.sss.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.sss.shop.entity.ItemWithCategory;
import jp.co.sss.shop.repository.ItemWithCategoryRepository;

@Controller
public class ItemWithCategoryPagingController {
	@Autowired
	ItemWithCategoryRepository repository;
	
	@GetMapping("/items/findAllPaging")
	public String showItemPagingList(Model model, Pageable pageable) {
		//商品情報を検索
		Page<ItemWithCategory> pageList = repository.findAll(pageable);
		//検索結果を保存する為のJavaBeans(リスト)を用意
		List<ItemWithCategory> itemList = pageList.getContent();
		//商品情報をリクエストスコープに保存
		model.addAttribute("pages", pageList);
		model.addAttribute("items", itemList);
		
		return "items/item_paging_list";
	}
}
