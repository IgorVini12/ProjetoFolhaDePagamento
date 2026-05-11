package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import model.Funcionario;

public class CalcularFolha {

    /* =========================INSS========================= */
    public BigDecimal calcularINSS(double salario) {
        double base = Math.min(salario, 7786.02); // ✅ teto aplicado aqui
        double inss = 0;

        if (base > 0) {
            inss += Math.min(base, 1412.00) * 0.075;
        }
        if (base > 1412.00) {
            inss += Math.min(base - 1412.00, 1254.68) * 0.09;
        }
        if (base > 2666.68) {
            inss += Math.min(base - 2666.68, 1333.35) * 0.12;
        }
        if (base > 4000.04) {
            inss += (base - 4000.04) * 0.14; // ✅ agora usa base (com teto), não salario
        }

        return BigDecimal.valueOf(inss).setScale(2, RoundingMode.HALF_UP);
    }

    /* =========================IRRF========================= */
     // Base de cálculo = salário - INSS - dedução por dependente
    public BigDecimal calcularIRRF(double salario, int dependentes) {
        double inss = calcularINSS(salario).doubleValue();
        double base = salario - inss - (dependentes * 189.59);

        if (base <= 2259.20) {
            return BigDecimal.ZERO; // isento
        } else if (base <= 2826.65) {
            return BigDecimal.valueOf(base * 0.075 - 169.44);
        } else if (base <= 3751.05) {
            return BigDecimal.valueOf(base * 0.15 - 422.25);
        } else if (base <= 4664.68) {
            return BigDecimal.valueOf(base * 0.225 - 763.30);
        } else {
            return BigDecimal.valueOf(base * 0.275 - 896.00);
        }
    }
    /* ====================VALETRANSPORTE======================= */
    public BigDecimal calcularValeTransporte(Funcionario f) {
        double valorMensal = f.getValeTransporteDia() * 20; // 20 dias uteis
        double desconto = f.getSalario() * 0.06; // 6% do salario

        return BigDecimal.valueOf(Math.min(valorMensal, desconto)).setScale(2, RoundingMode.HALF_UP);
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