package applications;

import domain.*;
import utils.Utilidade;

import java.util.*;

import static java.lang.System.exit;

public class Program {

    private static List<Veterinario> veterinarios = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        criaVeterinarios();
        Veterinario v1 =(Veterinario)veterinarios.get(0);
        Veterinario v2 = (Veterinario)veterinarios.get(0);
        Cliente cliente = new Cliente();
        Animal animal = new Animal();
        Utilidade.imprimaMensagem("Bem-vindo(a) ao sistema de controle da clínica veterinária.\n");

        do{
            int tentativas = 0;

            mostraMenu();

            int opcao = sc.nextInt();

            switch(opcao){
                case 1:
                    interageVeterinario(v1, v2, tentativas, animal);
                    break;
                case 2:
                    interageCliente(cliente);
                    break;
                case 3:
                    Utilidade.imprimaMensagem("Uma pena que tenha saído, espero que volte logo!\n");
                    exit(0);
                default:
                    System.out.println("Opção impossível.\n");
            }
        }
        while(true);
    }

    public static void mostraMenu(){

        Utilidade.imprimaMensagem("    CONTROLE DE ACESSO E PRIVILÉGIO     \n");
        System.out.println("    (1)  Veterinário            \n");
        System.out.println("    (2)  Cliente                \n");
        System.out.println("    (3)  Encerrar aplicação     \n");
    }

    private static void criaVeterinarios(){
        Veterinario v1 = new Veterinario("Hugo", "ADMIN", "1530");
        Veterinario v2 = new Veterinario("Patrícia", "VETER", "2652");

        veterinarios.add(v1);
        veterinarios.add(v2);
    }
    private static void interageVeterinario(Veterinario v1, Veterinario v2, int tentativas, Animal animal){
        boolean acesso = false;
        int chances = 3;

        Utilidade.imprimaMensagem("     LOGIN           \n");

        do{
            System.out.println("Senha : ");
            String senha = sc.next();

            if (v1.getSenha().equals(senha) || v2.getSenha().equals(senha)){
                acesso = true;

                Utilidade.imprimaMensagem("     ACESSO      \n");
                Utilidade.imprimaMensagem("Bem-vindo(a) caríssimo (a) veterinário(a)\n");
                menuVeterinario(v1, v2, animal);
            }
            else {
                Utilidade.imprimaMensagem("Senha incorreta\n");
                tentativas++;
                chances--;
                Utilidade.imprimaMensagem("você tem " + chances + " chance(s).\n");
            }
        }
        while(tentativas < 3 && !acesso);

        if (tentativas >= 3 && !acesso){
            Utilidade.imprimaMensagem("Três tentativas de login fracassadas com sucesso! Retornando ao início\n");
            sc.nextLine();
        }
    }
    private static void menuVeterinario(Veterinario v1, Veterinario v2, Animal animal){
        Cliente cliente = new Cliente();
        Consulta consulta = new Consulta();
        boolean sairMenuVet = false;
        do{
            Utilidade.imprimaMensagem("Selecione uma alternativa");
            System.out.println("    |   1 - Realizar consulta                   |\n");
            System.out.println("    |   2 - Emitir comprovantes de consultas    |\n");
            System.out.println("    |   3 - Sair                                |\n");

            int opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    animal.listaAnimais(cliente);
                    break;
                case 2:
                    consulta.comprovanteConsulta();
                    break;
                case 3:
                    return;
                default:
                    Utilidade.imprimaMensagem("Opção inválida.\n");
            }
        }
        while(true);
    }
    private static void interageCliente(Cliente cliente){
        Utilidade.imprimaMensagem("         OLÁ, CARÍSSIMO(A)!      ");
        System.out.println("Já é cliente? Digite seu código identificador, caso contrário, faça seu cadastro");
        System.out.println(" S/s - Cliente cadastrado\n");
        System.out.println(" N/n - Cliente não cadastrado\n");
        char opcao = sc.next().charAt(0);

        if (opcao == 'N' || opcao == 'n'){
            cliente.cadastrarCliente();
        }
        else if (opcao == 'S' || opcao == 's'){
            System.out.println("Digite seu código identificador:\n");
            int id = sc.nextInt();
            boolean clienteEncontrado = false;

            for (Cliente c : Cliente.clientes) {

                if (c.getId() == id) {
                    menuCliente(c);
                    clienteEncontrado = true;
                }
            }
            if (!clienteEncontrado){
                Utilidade.imprimaMensagem("Código identificador não encontrado. Saindo...\n");
                sc.nextLine();
            }
        }
    }
    private static void menuCliente(Cliente c){
        Animal animal = new Animal();
        Utilidade.imprimaMensagem("         PÁGINA DO CLIENTE           \n");
        System.out.println("Bem-vindo(a), " + c.getNomeCliente() + ".\n");

        do {
            System.out.println("Desejas : \n (1) Visualizar dados de cadastro \n (2) Marcar consulta de animal \n (3) Sair \n");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    c.consultarDados(c);

                    break;
                case 2:
                    animal.cadastrarAnimal(c);
                    break;
                case 3:
                    return;
                default:
                    Utilidade.imprimaMensagem("Opção impossível.\n");
            }
        }
        while(true);
    }
}