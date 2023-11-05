package domain;

import enums.SexoAnimal;
import utils.Utilidade;

import java.util.*;


public class Animal
{
    Scanner sc = new Scanner(System.in);
    public static List<Animal> animais = new ArrayList<>();

    public static List<Cliente> clientes = new ArrayList<>();

    private int id;
    private SexoAnimal sexoAnimal;
    private int idadeAnimal;
    private String especie;

    public Animal() {

    }

    public Animal(int id, SexoAnimal sexoAnimal, int idadeAnimal, String especie) {
        this.id = id;
        this.sexoAnimal = sexoAnimal;
        this.idadeAnimal = idadeAnimal;
        this.especie = especie;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SexoAnimal getSexoAnimal() {
        return sexoAnimal;
    }

    public void setSexoAnimal(SexoAnimal sexoAnimal) {
        this.sexoAnimal = sexoAnimal;
    }

    public int getIdadeAnimal() {
        return idadeAnimal;
    }

    public void setIdadeAnimal(int idadeAnimal) {
        this.idadeAnimal = idadeAnimal;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void cadastrarAnimal(Cliente cliente){
        Utilidade.imprimaMensagem("Solicitando operação...\n");

        System.out.println("Sexo do animal: \n(M/m) - masculino \n(F/f) - feminino\n");
        char sexo = sc.next().charAt(0);

        System.out.println("Idade do animal:\n");
        int idade = sc.nextInt();

        sc.nextLine();

        System.out.println("Espécie:\n");
        String especie = sc.next();

        SexoAnimal sexoAnimal = null;
        if (sexo == 'M' || sexo == 'm') {
            sexoAnimal = SexoAnimal.MASCULINO;
        } 
        else if (sexo == 'F' || sexo == 'f') {
            sexoAnimal = SexoAnimal.FEMININO;
        }
        else{
            sexoAnimal = sexoAnimal.OUTRO;
        }

        Animal animal = new Animal(cliente.getId(), sexoAnimal, idade, especie);

        animais.add(animal);

        Utilidade.imprimaMensagem("********COMPROVANTE DE SOLICITAÇÃO DE CONSULTA********\n");

        System.out.println(" > Id do cliente: " + cliente.getId());
        System.out.println(" > Nome do cliente: " + cliente.getNomeCliente());
        System.out.println(" > Id do animal: " + animal.getId());
        System.out.println(" > Sexo do animal : " + animal.getSexoAnimal());
        System.out.println(" > Idade do animal : " + animal.getIdadeAnimal());
        System.out.println(" > Espécie do animal : " + animal.getEspecie());
        Utilidade.imprimaMensagem("\n*****************************************\n");
    }

    public static void listaAnimais(Cliente cliente) {
        if (!animais.isEmpty()) {
            Utilidade.imprimaMensagem("********REALIZANDO LISTAGEM DOS ANIMAIS PARA CONSULTA*********\n");
            for (Animal animal : animais) {
                if (animal.getId() == cliente.getId()){
                    System.out.println(" > Id do cliente: " + cliente.getId());
                    System.out.println(" > Nome do cliente: " + cliente.getNomeCliente());
                    System.out.println(" > Sexo do animal: " + animal.getSexoAnimal());
                    System.out.println(" > Idade do animal: " + animal.getIdadeAnimal());
                    System.out.println(" > Espécie do animal: " + animal.getEspecie());
                    System.out.println("\n*****************************************\n");
                }

            }
        }
        else {
            Utilidade.imprimaMensagem("Não há animais em espera por consulta ainda.\n");
        }
    }


}
