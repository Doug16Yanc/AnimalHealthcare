package domain;

import java.util.*;

public class ListaClientes{

    public static Scanner sc = new Scanner(System.in);
    public static List<Cliente> clientes = new ArrayList<>();
    private static Map<String, List<Cliente>> copiaLista;
    private static Cliente cli;

    private static Map<String, List<Cliente>> getCopiaLista(){
        return copiaLista;
    }
    private static void setCopiaLista (Map<String, List<Cliente>> copiaLista){
        copiaLista = copiaLista;
    }


}
