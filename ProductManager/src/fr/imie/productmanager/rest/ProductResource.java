package fr.imie.productmanager.rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import fr.imie.productmanager.dao.DaoFactory;
import fr.imie.productmanager.entity.Product;

@Path("/products")
public class ProductResource {

	@GET
    @Path("/json/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProductsInJson() {
        return DaoFactory.get_JpaProductDao().findAllProduct();
    }
	
	@GET
    @Path("/xml/all")
    @Produces(MediaType.APPLICATION_XML)
    public List<Product> getAllProductsInXml() {
        return DaoFactory.get_JpaProductDao().findAllProduct();
    }
	
	@GET
    @Path("/json/{idProduct}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProductInJson(@PathParam("idProduct") Long id) {
        return DaoFactory.get_JpaProductDao().findProduct(id);
    }
}
