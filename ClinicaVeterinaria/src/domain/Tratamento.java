package domain;


public class Tratamento {
    private String inicialTratamento;
    private String fimTratamento;

    private static int id;

    public Tratamento()
    {

    }
    public Tratamento(String inicialTratamento, String fimTratamento)
    {
        this.inicialTratamento = inicialTratamento;
        this.fimTratamento = fimTratamento;
    }

    public String getInicialTratamento() {
        return inicialTratamento;
    }

    public void setInicialTratamento(String inicialTratamento) {
        this.inicialTratamento = inicialTratamento;
    }

    public String getFimTratamento() {
        return fimTratamento;
    }

    public void setFimTratamento(String fimTratamento) {
        this.fimTratamento = fimTratamento;
    }

    @Override
    public String toString() {
        return "\nDados das datas do tratamento:" +
                "\nTratamento inicial : " + inicialTratamento +
                "\nFim do tratamento:" + fimTratamento;
    }

}
