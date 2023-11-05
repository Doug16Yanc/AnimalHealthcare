package domain;

import java.util.*;

public class Exame {

    private String descricaoExame;

    private static int id;

    public Exame()
    {

    }

    public Exame(String descricaoExame) {
        this.descricaoExame = descricaoExame;
    }

    public String getDescricaoExame() {
        return descricaoExame;
    }

    public void setDescricaoExame(String descricaoExame) {
        this.descricaoExame = descricaoExame;
    }

    public void registrarExame(){
        List <Exame> exames = new ArrayList<>();

        System.out.println("Registrando exame...");

        UUID idOperacao = UUID.randomUUID();

        System.out.println("ID da operação : " + idOperacao + "\n");
    }

    public void consultarExame(){
        System.out.println("Descricao exame: " + descricaoExame);
    }
}
