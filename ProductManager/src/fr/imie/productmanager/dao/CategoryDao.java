package fr.imie.productmanager.dao;

import java.util.List;

import fr.imie.productmanager.entity.Category;

public interface CategoryDao {

	public List<Category> findAllCategory();

	public Category findCategory(Integer id);

	public Category updateCategory(Category c);

	public Category insertCategory(Category c);

	

}
