package domain;

public class Veterinario {
    private String nomeVeterinario;
    private String usuario;
    private String senha;

    public Veterinario()
    {

    }

    public Veterinario(String nomeVeterinario, String usuario, String senha) {
        this.nomeVeterinario = nomeVeterinario;
        this.usuario = usuario;
        this.senha = senha;

    }

    public String getNomeVeterinario() {
        return nomeVeterinario;
    }

    public void setNomeVeterinario(String nomeVeterinario) {
        this.nomeVeterinario = nomeVeterinario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
