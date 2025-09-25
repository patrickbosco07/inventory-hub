//package com.example.inventoryhub;
//
//import com.example.inventoryhub.domain.fornecedor.Fornecedor;
//import com.example.inventoryhub.repository.ArmazemRepository;
//import com.example.inventoryhub.repository.FornecedorRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class InventoryHubSemWeb implements CommandLineRunner {
//
//    @Autowired
//    private FornecedorRepository fornecedorRepository;
//    @Autowired
//    private ArmazemRepository armazemRepository;
//
//    public static void main(String[] args) {
//        SpringApplication.run(InventoryHubSemWeb.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        var principal = new Principal(fornecedorRepository, armazemRepository);
//        principal.menu();
//    }
//}
