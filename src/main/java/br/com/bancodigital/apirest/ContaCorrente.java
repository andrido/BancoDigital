package br.com.bancodigital.apirest;

public class ContaCorrente implements IConta {
    private String titular;
    private double saldo;

    public ContaCorrente(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipo() {
        return "corrente";
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
