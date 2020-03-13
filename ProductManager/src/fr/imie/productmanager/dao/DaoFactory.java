package fr.imie.productmanager.dao;

import fr.imie.productmanager.dao.jpa.JpaCategoryDao;
import fr.imie.productmanager.dao.jpa.JpaProductDao;
import fr.imie.productmanager.utils.PersistenceManager;

public class DaoFactory {

	private DaoFactory() {
	}

	public static JpaCategoryDao get_JpaCategoryDao(){
		return new JpaCategoryDao(PersistenceManager.getEntityManagerFactory());
	}

	public static JpaProductDao get_JpaProductDao(){
		return new JpaProductDao(PersistenceManager.getEntityManagerFactory());
	}


}
