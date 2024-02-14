package com.espe.correcion.idao;

import com.espe.correcion.model.Electrodomestico;

import java.util.List;

public interface IElectrodomesticoDAO {
    List<Electrodomestico> get();
    Electrodomestico getCodigoElec(String codigo);
    List<Electrodomestico> getElectrodomesticosMenosDe10Unidades();
    List<Electrodomestico> getElectrodomesticosConCeroUnidades();

}
