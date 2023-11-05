package domain;

import enums.tipoConsulta;
import utils.Utilidade;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Consulta {

    public static List<Consulta> consultas = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    private static Veterinario nomeVeterinario;
    private static tipoConsulta consulta;
    static LocalDate localDate = LocalDate.now();

    public Consulta(){

    }
    public Consulta(Veterinario nomeVeterinario)
    {
        this.nomeVeterinario = nomeVeterinario;
    }

    public Consulta(LocalDate localDate, Veterinario nomeVeterinario, tipoConsulta consulta) {
    }

    public static tipoConsulta getConsulta() {
        return consulta;
    }
    public void setConsulta(tipoConsulta consulta) {
        this.consulta = consulta;
    }

    public static Veterinario getNomeVeterinario(){
        return nomeVeterinario;
    }
    public void setNomeVeterinario(Veterinario nomeVeterinario){
        this.nomeVeterinario = nomeVeterinario;
    }
    public boolean determinaConsulta() {
        System.out.println("Digite o tipo de consulta:\n (1) INVESTIGATIVA \n (2) DIAGNÓSTICA \n");
        int consulta = sc.nextInt();

        if ((int) tipoConsulta.INVESTIGAÇÃO.ordinal() == consulta - 1) {
            this.consulta = getConsulta().INVESTIGAÇÃO;
            return true;
        }
        else if ((int) tipoConsulta.DIAGNÓSTICO.ordinal() == consulta - 1) {
            this.consulta = getConsulta().DIAGNÓSTICO;
            return true;
        }
        return true;
    }
    public String comprovanteConsulta(){
        Utilidade.imprimaMensagem("*******CONSULTA***********\n");
        String dados = ("\nData da consulta: " + localDate +
                            "\nProfissional da consulta : " + getNomeVeterinario() +
                            "\nTipo de consulta : " + getConsulta());
        Consulta consulta1 = new Consulta(localDate, nomeVeterinario, consulta);

        consultas.add(consulta1);
        return dados;
    }


}
