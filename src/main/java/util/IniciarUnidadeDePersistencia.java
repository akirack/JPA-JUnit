package util;

import com.ecommerce.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class IniciarUnidadeDePersistencia {

    public static void  main(String[] args){
        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory("Ecommerce-PU");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Do tests here
        Produto produto = entityManager.find(Produto.class, 1);

        entityManager.close();
        entityManagerFactory.close();
    }

}
