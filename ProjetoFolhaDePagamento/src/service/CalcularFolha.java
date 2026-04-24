package service;

import java.math.BigDecimal;
import java.util.function.Function;

import model.Funcionario;

public class CalcularFolha {

    /* =========================INSS========================= */
    public BigDecimal calcularINSS(double salario) {
        BigDecimal s = BigDecimal.valueOf(salario);

        if (salario <= 1412.00) {
            // s.multiplay = salario * 0,075, assim evitar erro de ponto
            return s.multiply(BigDecimal.valueOf(0.075));
        } else if (salario <= 2666.68) {
            return s.multiply(BigDecimal.valueOf(0.09));
        } else if (salario <= 4000.04) {
            return s.multiply(BigDecimal.valueOf(0.12));
        } else {
            return s.multiply(BigDecimal.valueOf(0.14));
        }

    }

    /* =========================IRRF========================= */
    public BigDecimal calcularIRRF(double salario, int dependentes) {
        double base = salario - (dependentes * 189.59); // desconto por dependente

        if (base <= 2259.20) {
            return BigDecimal.ZERO; // nao paga IRRF
        } else if (base <= 2826.) {
            return BigDecimal.valueOf(base * 0.075 - 169.44);
        } else if (base <= 3751.05) {
            return BigDecimal.valueOf(base * 0.15 - 422.25);
        } else if (base <= 4664.68) {
            return BigDecimal.valueOf(base * 0.225 - 763.3);
        } else {
            return BigDecimal.valueOf(base * 0.275 - 869.36);
        }
    }

    /* ====================VALETRANSPORTE======================= */
    public BigDecimal calcularValeTransporte(Funcionario f) {
        double valorDiario = f.getValeTransporteDia() * 20; // 20 dias uteis
        double desconto = valorDiario * 0.06; // menos 6% do salario

        return BigDecimal.valueOf(Math.min(valorDiario, desconto));
    }

    /* ======================SALARIO FAMILIA ========================= */
    public BigDecimal calcularSalarioFamilia(double salario, int filhosMenores14) {
        if (salario <= 1819.26) {
            return BigDecimal.valueOf(filhosMenores14 * 62.04);
        }
        return BigDecimal.ZERO; // nao tem salario familia se o salario for maior que 1.819,26
    }

    /* =========================FGTS(amigao)========================= */
    public BigDecimal calcularFGTS(double salario) {
        return BigDecimal.valueOf(salario * 0.08); // 8% do salario
    }

    /* =========================SalarioLIquido========================= */
    // f = funcionario
    public BigDecimal calcularSalarioLiquido(Funcionario f) {

        BigDecimal salario = BigDecimal.valueOf(f.getSalario());
        BigDecimal inss = calcularINSS(f.getSalario());
        BigDecimal irrf = calcularIRRF(f.getSalario(), f.getDependentes());
        BigDecimal valeTransporte = calcularValeTransporte(f);
        BigDecimal salarioFamilia = calcularSalarioFamilia(f.getSalario(), f.getFilhosMenores14());

        return salario.subtract(salarioFamilia)
                .subtract(inss)
                .subtract(irrf)
                .subtract(valeTransporte);
    }
}