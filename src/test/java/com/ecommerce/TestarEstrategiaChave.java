package com.ecommerce;

import com.ecommerce.model.Categoria;
import org.junit.Assert;
import org.junit.Test;

public class TestarEstrategiaChave extends EntityManagerTest {

    @Test
    public void testarEstrateggiaChave(){
        Categoria categoria = new Categoria();
        categoria.setNome("Eletronicos");

        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria categoriaVerificacao = entityManager.find(Categoria.class, categoria.getId());
        Assert.assertNotNull(categoriaVerificacao);
    }
}
