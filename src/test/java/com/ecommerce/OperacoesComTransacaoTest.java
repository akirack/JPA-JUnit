package com.ecommerce;

import com.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacoesComTransacaoTest extends EntityManagerTest {

    @Test
    public void atualizaObjeto(){

        Produto produto = new Produto();

        produto.setId(1);
        produto.setNome("AAAAAAA");
        produto.setDescricao("dsadsadsa");
        produto.setPreco(new BigDecimal(900.62));

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);

    }

    @Test
    public void removerObjeto(){
        Produto produto = entityManager.find(Produto.class, 3);

        entityManager.getTransaction().begin();
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        Produto produtoVerificacao = entityManager.find(Produto.class, 3);
        Assert.assertNull(produtoVerificacao);
    }

    @Test
    public void inserirPrimeiroObjeto(){
        Produto produto = new Produto();
        produto.setId(3);
        produto.setNome("Camera Canon aaaa");
        produto.setPreco(new BigDecimal(329.0));
        produto.setDescricao("Certamente é uma camera");

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);

    }

    @Test
    public void abrirEfecharTransacao(){

//        Produto produto = new Produto();

        entityManager.getTransaction().begin();

//        entityManager.persist(produto);
//        entityManager.merge(produto);
//        entityManager.remove(produto);

        entityManager.getTransaction().commit();
    }

}
