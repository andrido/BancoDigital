package br.com.bancodigital.apirest;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    private List<IConta> contas = new ArrayList<>();

    @PostMapping("/criar")
    public String criarConta(@RequestBody ContaRequest contaRequest) {
        IConta conta;
        String tipo = contaRequest.getTipo();
        String titular = contaRequest.getTitular();
        double saldo = contaRequest.getSaldo(); // Agora você pode pegar o saldo

        if ("corrente".equalsIgnoreCase(tipo)) {
            conta = new ContaCorrente(titular, saldo); // Usando o saldo do JSON
        } else if ("poupanca".equalsIgnoreCase(tipo)) {
            conta = new ContaPoupanca(titular);
        } else {
            return "Tipo de conta inválido!";
        }
        contas.add(conta);
        return "Conta criada com sucesso!";
    }

    @GetMapping
    public List<ContaResponse> listarContas() {
        List<ContaResponse> resposta = new ArrayList<>();
        for (IConta conta : contas) {
            resposta.add(new ContaResponse(conta.getTitular(), conta.getSaldo(), conta.getTipo()));
        }
        return resposta;
    }
}
