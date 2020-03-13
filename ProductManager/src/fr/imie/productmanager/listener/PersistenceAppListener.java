package fr.imie.productmanager.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import fr.imie.productmanager.utils.PersistenceManager;

public class PersistenceAppListener implements ServletContextListener{

	@Override
    public void contextDestroyed(ServletContextEvent sce) {
        PersistenceManager.closeEntityManagerFactory();
    }
}
