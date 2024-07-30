package com.project.fipecollectors.utils;

import com.project.fipecollectors.models.DadosRetorno;
import com.project.fipecollectors.service.ServiceDados;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private ServiceDados service = new ServiceDados();
    private TiposVeiculos escolhaTipo;

    public void inicial(){
        System.out.println("**** OPÇÕES ****\n" +
                            "Carros\n" +
                            "Motos\n" +
                            "Caminhoes\n" +
                            "Digite uma das opções para consultar valores:");
        String escolha = sc.nextLine();
        try{
            escolhaTipo = TiposVeiculos.valueOf(escolha.toUpperCase());
        } catch (EnumConstantNotPresentException e){
            System.out.println("Opção não existente. Tente de novo.");
            throw new EnumConstantNotPresentException(TiposVeiculos.class, escolha);
        }

        List<DadosRetorno> marcas = service.consultaMarcas(escolhaTipo);
        marcas.forEach(m -> System.out.println("Código: " + m.codigo() + " Nome: " + m.nome()));

        System.out.println("\nInforme o código da marca para consulta:");
        String marcaEscolha = sc.nextLine();
        Optional<DadosRetorno> escolhido = marcas.stream().filter(m -> m.codigo().equals(marcaEscolha)).findFirst();

        try{

        }

    }
}
