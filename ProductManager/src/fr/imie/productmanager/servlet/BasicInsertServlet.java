package fr.imie.productmanager.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.productmanager.dao.ProductDao;
import fr.imie.productmanager.entity.Category;
import fr.imie.productmanager.entity.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/basicInsert")
public class BasicInsertServlet extends HttpServlet {
	
	private EntityManagerFactory emf;
	
	@Override
	public void init() throws ServletException {
		emf = Persistence.createEntityManagerFactory("ProductManagerPersistenceUnit");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = new Product();
		product.setName("test");
		product.setDescription("test");
		product.setPrice(10);
		
		Category category = new Category();
		category.setName("une categorie");
		
		product.setCategory(category);
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(category);
		em.persist(product);
		em.getTransaction().commit();
		em.close();
		
		resp.getWriter().println("Le produit a été ajouté !"); 
	}
	
	@Override
	public void destroy() {
		if(emf != null && emf.isOpen()) {
			emf.close();
		}
	}


}
