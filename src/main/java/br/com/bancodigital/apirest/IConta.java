package br.com.bancodigital.apirest;

public interface IConta {
    String getTitular();
    double getSaldo();
    String getTipo();
    void depositar(double valor);
    void sacar(double valor);
}
