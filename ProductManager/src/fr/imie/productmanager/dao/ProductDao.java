package fr.imie.productmanager.dao;


import java.util.List;

import fr.imie.productmanager.entity.Product;

public interface ProductDao {

	public Product inserProduct(Product p);

	public Product updateProduct(Product p);

	public Product findProduct(Long id);

	public List<Product> findAllProduct();
	
	



}
