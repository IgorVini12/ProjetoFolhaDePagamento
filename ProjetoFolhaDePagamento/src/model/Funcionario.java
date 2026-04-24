package model;

public class Funcionario implements IFuncionario {
    private int Matricula;
    private String nome;
    private String cargo;
    private double salario;
    private int dependentes;
    private int filhosMenores14;
    private double valetransporteDia;

    public Funcionario(int matricula, String nome, String cargo, double salario, int dependentes, int filhosMenores14,
            double valetransporteDia) {
        Matricula = matricula;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.dependentes = dependentes;
        this.filhosMenores14 = filhosMenores14;
        this.valetransporteDia = valetransporteDia;
    }

    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int matricula) {
        Matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getDependentes() {
        return dependentes;
    }

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }

    public int getFilhosMenores14() {
        return filhosMenores14;
    }

    public void setFilhosMenores14(int filhosMenores14) {
        this.filhosMenores14 = filhosMenores14;
    }

    public double getValetransporteDia() {
        return valetransporteDia;
    }

    public void setValetransporteDia(double valetransporteDia) {
        this.valetransporteDia = valetransporteDia;
    }

    @Override
    public double getValeTransporteDia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getValeTransporteDia'");
    }
    
}
