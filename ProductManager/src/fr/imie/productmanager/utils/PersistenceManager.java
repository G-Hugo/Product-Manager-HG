package fr.imie.productmanager.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
	
	private static EntityManagerFactory emf = null;

    private PersistenceManager() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ProductManagerPersistenceUnit");
        }
        return emf;
    }

    public static void closeEntityManagerFactory() {
        getEntityManagerFactory().close();
    }

}
