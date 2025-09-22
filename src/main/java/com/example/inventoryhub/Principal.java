package com.example.inventoryhub;

import com.example.inventoryhub.entity.armazem.Armazem;
import com.example.inventoryhub.entity.armazem.DadosCadastroArmazem;
import com.example.inventoryhub.entity.fornecedor.DadosCadastroEndereco;
import com.example.inventoryhub.entity.fornecedor.DadosCadastroFornecedor;
import com.example.inventoryhub.entity.fornecedor.Fornecedor;
import com.example.inventoryhub.repository.ArmazemRepository;
import com.example.inventoryhub.repository.FornecedorRepository;

import java.util.Scanner;

public class Principal {

    private FornecedorRepository fornecedorRepository;

    private ArmazemRepository armazemRepository;

    private Scanner scanner = new Scanner(System.in);

    private ConexaoApi conexaoApi = new ConexaoApi();

    private final String ENDRECO = "https://viacep.com.br/ws/";

    private ConverteDados converteDados = new ConverteDados();

    public Principal(FornecedorRepository fornecedorRepository, ArmazemRepository armazemRepository) {
        this.fornecedorRepository = fornecedorRepository;
        this.armazemRepository = armazemRepository;
    }

    public void menu(){
        var opcao = -1;
        while (opcao != 3){
            var menu = """
                    Esolha a opção para cadastrar:\n
                    1 - Cadastrar fornecedor\n
                    2 - Cadastrar aramzém\n
                    3 - Sair
                    """;
            System.out.println(menu);
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao){
                case 1:
                    System.out.println("Insira o CNPJ: ");
                    var cnpj = scanner.nextLine();

                    System.out.println("Insira o nome: ");
                    var nome = scanner.nextLine();

                    System.out.println("Insira o CEP: ");
                    var cep = scanner.nextLine();

                    var endereco = pesquisaCep(cep);
                    var fornecedor = new Fornecedor(new DadosCadastroFornecedor(cnpj,nome,endereco));
                    fornecedorRepository.save(fornecedor);
                    break;
                case 2:
                    System.out.println("Insira o nome: ");
                    var nome2 = scanner.nextLine();

                    System.out.println("Insira o CEP: ");
                    var cep2 = scanner.nextLine();

                    var endereco2 = pesquisaCep(cep2);
                    var armazem = new Armazem(new DadosCadastroArmazem(nome2,endereco2));
                    armazemRepository.save(armazem);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
            }

        }

    }

    public DadosCadastroEndereco pesquisaCep(String cep) {
        var endereco = ENDRECO + cep + "/json/";

        var json = conexaoApi.conectar(endereco);
        return converteDados.converte(json);
    }
}
