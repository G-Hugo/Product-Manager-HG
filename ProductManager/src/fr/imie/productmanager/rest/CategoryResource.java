package fr.imie.productmanager.rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import fr.imie.productmanager.dao.DaoFactory;
import fr.imie.productmanager.entity.Category;


@Path("/category")
public class CategoryResource {

	 @GET
	    @Path("/json/{idCategory}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Category getCategoryInJson(@PathParam("idCategory") Integer id) {
	        return DaoFactory.get_JpaCategoryDao().findCategory(id);
	    }
	 
	 @GET
	    @Path("/json/all")
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Category> getAllCategoryInJson() {
	        return DaoFactory.get_JpaCategoryDao().findAllCategory();
	    }
	 
	 @POST
	    @Path("/json/add")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public String addJsonCategory(Category category){
	        DaoFactory.get_JpaCategoryDao().insertCategory(category);
	        return category.toString();
	    }
	 
	 @PUT
	    @Path("/json/update/{id}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public String updateCategory(@PathParam("id") Integer id, Category category){

	        Category categoryBdd = DaoFactory.get_JpaCategoryDao().findCategory(id);
	        categoryBdd.setName(category.getName());
	        DaoFactory.get_JpaCategoryDao().updateCategory(categoryBdd);
	        return category.toString();
	    }
}
