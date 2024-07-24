package jp.co.sss.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jp.co.sss.shop.bean.ItemWithCategoryBean;
import jp.co.sss.shop.entity.Category;
import jp.co.sss.shop.entity.ItemWithCategory;
import jp.co.sss.shop.repository.ItemWithCategoryRepository;
import jp.co.sss.shop.utils.BeanListCopyIWC;

@Controller
public class ItemWithCategoryController {
	@Autowired
	ItemWithCategoryRepository repository;
	
	@Autowired
	BeanListCopyIWC listCopy;
	
	@Autowired
	EntityManager entityManager;
	
	@RequestMapping("/items/findItemAndCategory")
	public String showItemAndCategoryList(Model model) {
		model.addAttribute("items", repository.findAll());
		return "items/item_category_list";
	}
	
	
	@RequestMapping("/items/serachByCategoryId/{categoryId}")
	public String searchByCategoryId(@PathVariable Integer categoryId, Model model){
		Category category = new Category();
		category.setId(categoryId);
		List<ItemWithCategory> itemList = repository.findByCategory(category);
		
		List<ItemWithCategoryBean> beanList = listCopy.copyItemToBean(itemList);
		
		model.addAttribute("items", beanList);
		
		return "items/item_category_list";
	}
	
	@RequestMapping("/items/searchWithNamedQuery/{id}")
	public String searchWithNamedQuery(@PathVariable Integer id, Model model) {
		Query query = entityManager.createNamedQuery("findByIdNamedQuery");
		query.setParameter("id", id);
		
		List<ItemWithCategory> itemList = listCopy.copyItemToBean(query.getResultList());
		model.addAttribute("items", itemList);
		
		return "items/item_category_list";
	}
	
	
}
