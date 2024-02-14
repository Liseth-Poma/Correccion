package com.espe.correcion.controller;

import com.espe.correcion.dao.ElectrodomesticoDAOImpl;
import com.espe.correcion.idao.IElectrodomesticoDAO;
import com.espe.correcion.model.Electrodomestico;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class ElectrodomesticoBean {
    private String codigo;
    private Electrodomestico electrodomestico;
    private IElectrodomesticoDAO electroDAO = new ElectrodomesticoDAOImpl();
    private List<Electrodomestico> electrodomesticos;
    private List<Electrodomestico> electrodomesticosMenosDe10Unidades;
    private List<Electrodomestico> electrodomesticosConCeroUnidades;

    public ElectrodomesticoBean() {

        electrodomesticos = electroDAO.get();
        electrodomesticosMenosDe10Unidades = electroDAO.getElectrodomesticosMenosDe10Unidades();
        electrodomesticosConCeroUnidades = electroDAO.getElectrodomesticosConCeroUnidades();
    }

    public List<Electrodomestico> getElectrodomesticos() {
        return electrodomesticos;
    }

    public String buscarElectro() {
        ElectrodomesticoDAOImpl electroDAO = new ElectrodomesticoDAOImpl();
        electrodomestico = electroDAO.getCodigoElec(codigo);

        if (electrodomestico != null) {
            int numeroUnidades = electrodomestico.getCantidad();

            if (numeroUnidades > 10) {
                return "mayor";
            } else if (numeroUnidades > 0) {
                return "menor";
            } else {
                return "noexiste";
            }
        } else {
            return "noexiste";
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Electrodomestico getElectrodomestico() {
        return electrodomestico;
    }

    public void setElectrodomestico(Electrodomestico electrodomestico) {
        this.electrodomestico = electrodomestico;
    }

    public List<Electrodomestico> getElectrodomesticosMenosDe10Unidades() {
        return electrodomesticosMenosDe10Unidades;
    }

    public List<Electrodomestico> getElectrodomesticosConCeroUnidades() {
        return electrodomesticosConCeroUnidades;
    }
}