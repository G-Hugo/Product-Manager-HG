package fr.imie.productmanager.servlet;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.productmanager.dao.DaoFactory;
import fr.imie.productmanager.dao.ProductDao;
import fr.imie.productmanager.entity.Category;
import fr.imie.productmanager.entity.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/addProduct")
public class AddProductServlet extends HttpServlet{
	
	EntityManagerFactory emf = null;

    @Override
    public void init() throws ServletException {
        emf = Persistence.createEntityManagerFactory("ProductManagerPersistenceUnit");
    }
    
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = new Product();
        product.setName(req.getParameter("name"));
        product.setDescription(req.getParameter("description"));
        product.setPrice(Float.parseFloat(req.getParameter("price")));
        
        if (req.getParameter("category") != null && !req.getParameter("category").isEmpty()) {
            Category category = DaoFactory.get_JpaCategoryDao().findCategory(Integer.parseInt(req.getParameter("category")));
            product.setCategory(category);
        }

        DaoFactory.get_JpaProductDao().inserProduct(product);

        resp.sendRedirect("/showProduct?id=" + product.getId());
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("categorys", DaoFactory.get_JpaCategoryDao().findAllCategory());
        req.getRequestDispatcher("/auth/addProduct.jsp").forward(req, resp);
	}
	
	@Override
	public void destroy() {
		if(emf != null && emf.isOpen()) {
			emf.close();
		}
	}


}
