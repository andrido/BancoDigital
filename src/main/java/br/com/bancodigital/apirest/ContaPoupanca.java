package br.com.bancodigital.apirest;

import br.com.bancodigital.apirest.IConta;

public class ContaPoupanca implements IConta {
    private String titular;
    private double saldo;

    public ContaPoupanca(String titular) {
        this.titular = titular;
        this.saldo = saldo; // Poupança começa com saldo 0
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipo() {
        return "poupanca";
    }

    @Override
    public void depositar(double valor) { // Certifique-se de que é public
        if (valor > 0) {
            this.saldo += valor;
        } else {
            throw new IllegalArgumentException("Valor deve ser positivo.");
        }
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente!");
        }
    }
}
