package com.alan.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.alan.springboot.bean.Product;

@Mapper
public interface ProductMapper {
	@Insert("INSERT INTO products(pname,type,price) VALUES(#{pname},#{type},#{price})")
	public Integer add(Product product);
	@Delete("DELETE FROM products WHERE pid=#{arg1}")
	public Integer deleteById(Integer id);
	@Update("UPDATE products SET pname=#{pname},type=#{type},price=#{price} WHERE pid=#{pid}")
	public Integer update(Product product);
	@Select("SELECT * FROM products WHERE pid=#{arg1}")
	public Product getById(Integer id);
	@Select("SELECT * FROM products ORDER BY id DESC")
	public List<Product> queryByLists();
	
}
