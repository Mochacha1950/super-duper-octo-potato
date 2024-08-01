package jp.co.sss.shop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.sss.shop.entity.Category;
import jp.co.sss.shop.entity.ItemWithCategory;

public interface ItemWithCategoryRepository extends JpaRepository<ItemWithCategory, Integer>{
	List<ItemWithCategory> findByCategory(Category category);
	
	@Query("select i from ItemWithCategory i where i.id = :id")
	public List<ItemWithCategory> findByIdQuery(@Param("id") Integer id);
	
	@Query("select i from ItemWithCategory i where i.price >=" + "(select avg(i2.price) from ItemWithCategory i2)")
	public List<ItemWithCategory> findByPriceGreaterThanEqualAVGPriceQuery();
	
	public Page<ItemWithCategory> findByNameContaining(String name, Pageable pageable);
	
}

