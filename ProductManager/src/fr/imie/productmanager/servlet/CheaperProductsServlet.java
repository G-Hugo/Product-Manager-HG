package fr.imie.productmanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/cheaperListProducts")
public class CheaperProductsServlet extends HttpServlet {
    
	EntityManagerFactory emf = null;

    @Override
    public void init() throws ServletException {
        emf = Persistence.createEntityManagerFactory("ProductManagerPersistenceUnit");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT product FROM Product product where price < 100");
        List list = query.getResultList();

        req.setAttribute("products", list);
        req.getRequestDispatcher("/auth/cheaperListProducts.jsp").forward(req, resp);
    }
    
    @Override
	public void destroy() {
		if(emf != null && emf.isOpen()) {
			emf.close();
		}
	}
}