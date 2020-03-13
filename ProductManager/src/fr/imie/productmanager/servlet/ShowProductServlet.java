package fr.imie.productmanager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.productmanager.dao.DaoFactory;
import fr.imie.productmanager.dao.ProductDao;
import fr.imie.productmanager.entity.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/showProduct")
public class ShowProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
        ProductDao productDao = DaoFactory.get_JpaProductDao();
        Product product = productDao.findProduct(Long.valueOf(id));
        req.setAttribute("product", product);
        RequestDispatcher rd = req.getRequestDispatcher("/showProduct.jsp");
        rd.forward(req, resp);
    }
}
