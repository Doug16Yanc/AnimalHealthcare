package domain;

import utils.Utilidade;

import java.util.ArrayList;
import java.util.Iterator;

public class Consultorio {
    private ArrayList<Consulta> consultas;
    private Veterinario veterinario;
    private int numeroConsult;

    public Consultorio (Veterinario veterinario, int numeroConsult){
        this.veterinario = veterinario;
        this.numeroConsult = numeroConsult;
        consultas = new ArrayList<>();
    }
    public void relatorioConsultorio(){
        if (consultas.size() > 0){
            Iterator it = consultas.iterator();
            while(it.hasNext()){
                Consulta consulta = (Consulta) it.next();
                Utilidade.imprimaMensagem(consulta.comprovanteConsulta());
            }
        }
    }

}
