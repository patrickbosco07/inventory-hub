package com.example.inventoryhub;

import com.example.inventoryhub.entity.fornecedor.DadosCadastroEndereco;
import com.example.inventoryhub.entity.fornecedor.DadosCadastroFornecedor;
import com.example.inventoryhub.entity.fornecedor.Fornecedor;
import com.example.inventoryhub.repository.FornecedorRepository;

import java.util.Scanner;

public class Principal {

    private FornecedorRepository fornecedorRepository;

    private Scanner scanner = new Scanner(System.in);

    private ConexaoApi conexaoApi = new ConexaoApi();

    private final String ENDRECO = "https://viacep.com.br/ws/";

    private ConverteDados converteDados = new ConverteDados();

    public Principal(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public void menu(){
        var opcao = -1;
        while (opcao != 2){
            System.out.println("Insira o CNPJ: ");
            var cnpj = scanner.nextLine();

            System.out.println("Insira o nome: ");
            var nome = scanner.nextLine();

            System.out.println("Insira o CEP: ");
            var cep = scanner.nextLine();

            var endereco = pesquisaCep(cep);
            var fornecedor = new Fornecedor(new DadosCadastroFornecedor(cnpj,nome,endereco));
            fornecedorRepository.save(fornecedor);

            System.out.println("Deseja cadastrar um novo fornecedor?");
            opcao = scanner.nextInt();
        }

    }

    public DadosCadastroEndereco pesquisaCep(String cep) {
        var endereco = ENDRECO + cep + "/json/";

        var json = conexaoApi.conectar(endereco);
        return converteDados.converte(json);
    }
}
