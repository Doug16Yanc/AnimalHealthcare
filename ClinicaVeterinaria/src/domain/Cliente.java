package domain;

import enums.StatusCliente;

import java.util.*;

public class Cliente {

    public static List<Cliente> clientes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    private int id;
    private String nomeCliente;
    private String enderecoCliente;
    private long cepCliente;
    private String telefoneCliente;
    private String emailCliente;

    private StatusCliente statusCliente;

    public Cliente()
    {

    }

    public Cliente(int id, String nomeCliente, String enderecoCliente, long cepCliente, String telefoneCliente, String emailCliente) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.enderecoCliente = enderecoCliente;
        this.cepCliente = cepCliente;
        this.telefoneCliente = telefoneCliente;
        this.emailCliente = emailCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public long getCepCliente() {
        return cepCliente;
    }

    public void setCepCliente(long cepCliente) {
        this.cepCliente = cepCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public StatusCliente getStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(StatusCliente statusCliente) {
        this.statusCliente = statusCliente;
    }

    private static int gerarID() {
        int num = 0;
        Random random = new Random();
        int entrada = random.nextInt(100000, 1000000);

        boolean aux;

        while (true) {
            aux = true;

            for (Cliente cliente : clientes) {
                if (entrada == cliente.getId()) {
                    aux = false;
                    break;
                }
            }

            if (aux) {
                return entrada;
            }
            else {
                entrada = random.nextInt(100000, 1000000);
            }
        }
    }

    public static void cadastrarCliente() {

        int idCliente = gerarID();

        System.out.println("Processando...\n");

        sc.nextLine();

        System.out.println("Nome completo:");
        String nome = sc.nextLine();

        System.out.println("Endereço do cliente:");
        String endereco = sc.nextLine();

        System.out.println("Cep:");
        long cep = sc.nextInt();

        sc.nextLine();

        System.out.println("Telefone:");
        String telefone = sc.nextLine();

        System.out.println("Email:");
        String email = sc.nextLine();


        Cliente cliente = new Cliente(idCliente, nome, endereco, cep, telefone, email);


        clientes.add(cliente);

        System.out.println("*************COMPROVANTE*****************\n");
        System.out.println("Id do cliente : " + cliente.getId() +
                "\nNome :" + cliente.getNomeCliente() +
                "\nEndereço: " + cliente.getEnderecoCliente() +
                "\nCep : " + cliente.getCepCliente() +
                "\nTelefone : " + cliente.getTelefoneCliente() +
                "\nEmail : " + cliente.getEmailCliente() +
                "\nStatus do cliente : " + cliente.getStatusCliente().CADASTRADO +
                "\n\n Código da operação : " + UUID.randomUUID()
        );
    }
    public static void consultarDados(Cliente cliente){
        System.out.println("Id do cliente : " + cliente.getId() +
                "\nNome :" + cliente.getNomeCliente() +
                "\nEndereço: " + cliente.getEnderecoCliente() +
                "\nCep : " + cliente.getCepCliente() +
                "\nTelefone : " + cliente.getTelefoneCliente() +
                "\nEmail : " + cliente.getEmailCliente() +
                "\nStatus do cliente : " + cliente.getStatusCliente().CADASTRADO);
    }
}
