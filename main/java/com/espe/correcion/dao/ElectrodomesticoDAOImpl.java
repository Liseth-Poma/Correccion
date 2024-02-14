package com.espe.correcion.dao;

import com.espe.correcion.idao.IElectrodomesticoDAO;
import com.espe.correcion.model.Electrodomestico;
import com.espe.correcion.model.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public class ElectrodomesticoDAOImpl implements IElectrodomesticoDAO {

    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();


    @Override
    public List<Electrodomestico> get() {
        Query query = entityManager.createQuery("SELECT e FROM Electrodomestico e");
        return query.getResultList();
    }

    @Override
    public Electrodomestico getCodigoElec(String codigo) {
        Query query = entityManager.createQuery("SELECT e FROM Electrodomestico e WHERE e.codigo = :codigo");
        query.setParameter("codigo", codigo);
        List<Electrodomestico> results = query.getResultList();
        if (!results.isEmpty()) {
            return results.get(0);
        } else {
            return null;
        }
    }


    @Override
    public List<Electrodomestico> getElectrodomesticosMenosDe10Unidades() {
        Query query = entityManager.createQuery("SELECT e FROM Electrodomestico e WHERE e.cantidad < 10");
        return query.getResultList();
    }

    @Override
    public List<Electrodomestico> getElectrodomesticosConCeroUnidades() {
        Query query = entityManager.createQuery("SELECT e FROM Electrodomestico e WHERE e.cantidad = 0");
        return query.getResultList();
    }
}



