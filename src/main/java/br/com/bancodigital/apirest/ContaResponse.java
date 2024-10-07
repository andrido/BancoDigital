package br.com.bancodigital.apirest;

public class ContaResponse {
    private String titular;
    private double saldo;
    private String tipo;

    public ContaResponse(String titular, double saldo, String tipo) {
        this.titular = titular;
        this.saldo = saldo;
        this.tipo = tipo;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipo() {
        return tipo;
    }
}
