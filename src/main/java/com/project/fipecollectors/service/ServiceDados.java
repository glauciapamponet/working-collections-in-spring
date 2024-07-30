package com.project.fipecollectors.service;

import com.project.fipecollectors.models.DadosRetorno;
import com.project.fipecollectors.utils.TiposVeiculos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceDados {
    private ConverteDados conversor = new ConverteDados();
    private ConsumoAPI consumo = new ConsumoAPI();
    private TiposVeiculos escolhaTipo;
    private String escolhaModelo;

    public List<DadosRetorno> consultaMarcas(TiposVeiculos tipoVeiculo){
        this.escolhaTipo = tipoVeiculo;
        var json = consumo.obterDados(tipoVeiculo.toString().toLowerCase() + "/marcas");
        DadosRetorno[] arrayVeiculos = conversor.colecaoDados(json, DadosRetorno[].class);
        return Arrays.stream(arrayVeiculos).collect(Collectors.toList());
    }

    public List<DadosRetorno> consultaModelos(String marca){
        var json = consumo.obterDados(escolhaTipo.toString().toLowerCase() + "/marcas/" + marca);
        DadosRetorno[] arrayVeiculos = conversor.colecaoDados(json, DadosRetorno[].class);
        return Arrays.stream(arrayVeiculos).collect(Collectors.toList());
    }
}
