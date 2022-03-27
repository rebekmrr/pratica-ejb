package com.gugawag.pdist.ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.gugawag.pdist.model.Mensagem;

@Stateless
public class MensagemDAO {
    @PersistenceContext(unitName="default")
    private EntityManager em;

    //inserir, listar e pesquisarPorId, que deve receber
    // o id de uma mensagem como parâmetro e pesquisar apenas a mensagem do id
    // especificado

    public void inserir (Mensagem novaMensagem){
        em.persist(novaMensagem);
    }

    public List listar() {
        return em.createQuery("FROM Mensagem").getResultList();
    }

    public Mensagem pesquisarPorId(long id) {
        return em.find(Mensagem.class, id);
    }
}
