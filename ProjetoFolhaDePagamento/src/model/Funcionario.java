package model;

public class Funcionario implements IFuncionario {

    private int matricula;
    private String nome;
    private String cargo;
    private double salario;
    private int dependentes;
    private int filhosMenores14;
    private double valeTransporteDia;

    // CONSTRUTOR
    public Funcionario(int matricula,
                       String nome,
                       String cargo,
                       double salario,
                       int dependentes,
                       int filhosMenores14,
                       double valeTransporteDia) {

        this.matricula = matricula;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.dependentes = dependentes;
        this.filhosMenores14 = filhosMenores14;
        this.valeTransporteDia = valeTransporteDia;
    }

    // GETTERS E SETTERS

    @Override
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public int getDependentes() {
        return dependentes;
    }

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }

    @Override
    public int getFilhosMenores14() {
        return filhosMenores14;
    }

    public void setFilhosMenores14(int filhosMenores14) {
        this.filhosMenores14 = filhosMenores14;
    }

    @Override
    public double getValeTransporteDia() {
        return valeTransporteDia;
    }

    public void setValeTransporteDia(double valeTransporteDia) {
        this.valeTransporteDia = valeTransporteDia;
    }
}