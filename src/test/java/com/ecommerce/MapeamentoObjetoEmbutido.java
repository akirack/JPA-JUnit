package com.ecommerce;

import com.ecommerce.model.EnderecoEntregaPedido;
import com.ecommerce.model.Pedido;
import com.ecommerce.model.StatusPedido;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MapeamentoObjetoEmbutido extends EntityManagerTest {

    @Test
    public void analisarMapeamentoObejtoEmbutido(){
        EnderecoEntregaPedido endereco = new EnderecoEntregaPedido();

        endereco.setCep("60833-55");
        endereco.setLogradouro("rua 1");
        endereco.setBairro("123");
        endereco.setNumero("Centro");
        endereco.setCidade("Uberlandia");
        endereco.setEstado("MG");

        Pedido pedido = new Pedido();

        //pedido.setId(1);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(new BigDecimal(1000.00));
        pedido.setEnderecoEntregaPedido(endereco);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());

        Assert.assertNotNull(pedidoVerificacao);
        Assert.assertNotNull(pedidoVerificacao.getEnderecoEntregaPedido());
        Assert.assertNotNull(pedidoVerificacao.getEnderecoEntregaPedido().getCep());

    }

}
