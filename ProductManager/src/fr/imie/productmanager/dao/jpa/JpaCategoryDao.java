package fr.imie.productmanager.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.imie.productmanager.dao.CategoryDao;
import fr.imie.productmanager.entity.Category;

public class JpaCategoryDao implements CategoryDao {

	private EntityManagerFactory emf;
	
	public JpaCategoryDao(EntityManagerFactory emf) {
		this.emf = emf;
    }

    @Override
    public Category insertCategory(Category c) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.persist(c);
            t.commit();
        } finally {
            if (t.isActive()) t.rollback();
            em.close();
        }
        return c;
    }

    @Override
    public Category updateCategory(Category c) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.merge(c);
            t.commit();
        } finally {
            if (t.isActive()) t.rollback();
            em.close();
        }
        return c;
    }

    @Override
    public Category findCategory(Integer id) {
        EntityManager em = emf.createEntityManager();
        Category category = null;
        try {
            category = (Category) em.createQuery("SELECT c FROM Category c WHERE c.id = :id")
                    .setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return category;
    }

    @Override
    public List<Category> findAllCategory() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Category> query = em.createQuery("from Category", Category.class);
        return query.getResultList();
    }

}
