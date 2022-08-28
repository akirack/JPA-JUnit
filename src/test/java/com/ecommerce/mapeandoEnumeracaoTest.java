package com.ecommerce;

import com.ecommerce.model.Cliente;
import com.ecommerce.model.SexoCliente;
import org.junit.Assert;
import org.junit.Test;

public class mapeandoEnumeracaoTest extends EntityManagerTest{

    @Test
    public void testarEnum(){
        Cliente cliente = new Cliente();
        //cliente.setId(4);
        cliente.setNome("cliente");
        cliente.setSexo(SexoCliente.MASCULINO);

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteVerificacao);
    }

}
