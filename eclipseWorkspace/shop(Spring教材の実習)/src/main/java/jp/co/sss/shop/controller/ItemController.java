package jp.co.sss.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;
import jp.co.sss.shop.repository.ItemRepository;
import jp.co.sss.shop.utils.BeanListCopy;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;
import jp.co.sss.shop.bean.ItemBean;
import jp.co.sss.shop.entity.Item;
import jp.co.sss.shop.form.ItemForm;

@Controller
public class ItemController {
	
	@Autowired
	ItemRepository repository;
	
	@Autowired
	BeanListCopy listCopy;
	
	
	@RequestMapping("/items/findAll")
	public String showItemList(Model model, HttpSession session) {
		session.invalidate();
		if(repository.findAll().isEmpty()) {
			return "items/null_item_list";
		}
		List<ItemBean> itemBeanList = listCopy.copyItemToBean(repository.findAll());
		model.addAttribute("items", itemBeanList);
		return "items/item_list";
	}
	
	@RequestMapping("/items/findAllByOrderByPriceDesc")
	public String showItemListByOrderByPriceDesc(HttpSession session) {
		if(repository.findAll().isEmpty()) {
			return "items/null_item_list";
		}
		session.setAttribute("items", repository.findAllByOrderByPriceDesc());
		return "items/item_list_ordered";
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
	
	@RequestMapping("/items/findByPrice/{name}")
	public String showItemListByPrice(@PathVariable String name, Model model) {
		model.addAttribute("items", repository.findByName(name));
		return "items/item_list";
	}
	
//	@RequestMapping("/items/findByPrice/{price}")
//	public String showItemListByPrice(@PathVariable int price, Model model) {
//		model.addAttribute("items", repository.findByPrice(price));
//		return "items/item_list";
//	}
	
	@RequestMapping("/items/findByNameAndPrice/{name}/{price}")
	public String findByNameAndPrice(@PathVariable String name, @PathVariable int price, Model model) {
		model.addAttribute("items", repository.findByNameAndPrice(name,price));
		return "/items/item_list";
	}
	
	@RequestMapping("/items/findByNameOrPrice/{name}/{price}")
	public String findByNameOrPrice(@PathVariable String name, @PathVariable int price, Model model) {
		model.addAttribute("items", repository.findByNameOrPrice(name,price));
		return "/items/item_list";
	}
	
	@RequestMapping("/items/findByNameLike/{name}")
	public String showItemListByNameLike(@PathVariable String name, Model model) {
		
		List<ItemBean> itemBeanList = listCopy.copyItemToBean(repository.findByNameContaining(name));
				 
		model.addAttribute("items", itemBeanList);
		return "items/item_list";
	}
	
	
	@RequestMapping("/items/findAllAndSetDropdown")
	public String itemListSetDropdown(HttpSession session) {
		List<ItemBean> itemBeanList = listCopy.copyItemToBean(repository.findAll());
		session.setAttribute("items",itemBeanList);
		return "items/item_list_dropdown";
	}
	
	@RequestMapping("/items/create/input")
	public String createInput() {
		return "items/create_input";
	}
	
	@RequestMapping(path = "/items/create/complete", method = RequestMethod.POST)
	public String createComplete(ItemForm form, Model model) {
		Item item = new Item();
		BeanUtils.copyProperties(form,item,"id");
		item=repository.save(item);
		ItemBean itemBean = new ItemBean();
		BeanUtils.copyProperties(item,itemBean);
		
		model.addAttribute("item", itemBean);
		//書いて見た
		//model.addAttribute("item",repository.getReferenceById(form.getId()));
		return "items/item";
	}
	
	//書いて見た
	@RequestMapping(path = "/items/selectedItem", method = RequestMethod.GET)
	public String showSelectedItem(ItemForm form, Model model) {
		ItemBean item = new ItemBean();
		BeanUtils.copyProperties(form, item);
		
		model.addAttribute("item",item);
		
		return "items/item";
	}
	
	@RequestMapping("/items/update/input/{id}")
	public String updateInput(@PathVariable int id, Model model) {
		Item item = repository.getReferenceById(id);
		ItemBean itembean = new ItemBean();
		
		BeanUtils.copyProperties(item, itembean);
		
		model.addAttribute("item", itembean);
		
		return "items/update_input";
	}
	
	@RequestMapping(path = "/items/update/complete/{id}", method = RequestMethod.POST)
	public String updateComplete(@PathVariable int id, ItemForm form, Model model) {
		Item item = repository.getReferenceById(id);
		BeanUtils.copyProperties(form, item, "id");
		item = repository.save(item);
		
		ItemBean itembean = new ItemBean();
		BeanUtils.copyProperties(item, itembean);
		
		model.addAttribute("item", itembean);
		
		return "items/item";
	}
	
	@RequestMapping("/items/delete/input")
	public String deleteInput(Model model) {
		List<ItemBean> itemBeanList = listCopy.copyItemToBean(repository.findAll());
		model.addAttribute("items", itemBeanList);
		return "items/delete_input";
	}
	
	@RequestMapping(path = "/items/delete/complete", method = RequestMethod.POST)
	public String deleteComplete(ItemForm form) {
		
		
		repository.deleteById(form.getId());
		
		
		return "redirect:/items/findAll";
	}
	
}
