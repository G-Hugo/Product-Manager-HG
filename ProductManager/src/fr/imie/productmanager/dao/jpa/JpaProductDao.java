package fr.imie.productmanager.dao.jpa;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.imie.productmanager.dao.ProductDao;
import fr.imie.productmanager.entity.Product;

public class JpaProductDao implements ProductDao {

	private EntityManagerFactory emf;
	
	public JpaProductDao(EntityManagerFactory emf) {
		this.emf = emf;
    }

    @SuppressWarnings("finally")
	@Override
    public Product inserProduct(Product p) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            em.persist(p);
            t.commit();
        } finally {
            if (t.isActive()) t.rollback();
            em.close();
            return p;
        }
    }

    @SuppressWarnings("finally")
	@Override
    public Product updateProduct(Product p) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            em.merge(p);
            t.commit();
        } finally {
            if (t.isActive()) t.rollback();
            em.close();
            return p;
        }
    }

    @Override
    public Product findProduct(Long id) {
        EntityManager em = emf.createEntityManager();
        Product product = null;
        try {
            product = (Product) em.createQuery("SELECT p FROM Product p WHERE p.id = :id")
                    .setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return product;
    }

    @Override
    public List<Product> findAllProduct() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Product> query = em.createQuery("from Product ", Product.class);
        return query.getResultList();
    }
}
