package com.github.mayconmoraesdm.entidades;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void menu() throws SQLException {
    try{
        int n;
        do {
            Scanner tecla = new Scanner(System.in);
            System.out.println("------------------MENU-------------------");
            System.out.println("1- Listar todos os registros");
            System.out.println("2- Listar um unico registro por ID");
            System.out.println("3- Listar um unico registro por nome");
            System.out.println("4- Inserir novo registro");
            System.out.println("5- Alterar registro existente");
            System.out.println("6- Excluir registro existente");
            System.out.println("7- Fechar aplicação");
            n = tecla.nextInt();

            switch (n) {
                case 1:
                    listaTodos();
                    break;
                case 2:
                    listaTodos();
                    listaId();
                    break;
                case 3:
                    listaNome();
                    break;
                case 4:
                    insere();
                    break;
                case 5:
                    listaTodos();
                    altera();
                    break;
                case 6:
                    listaTodos();
                    exclui();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("***INVÁLIDO***\n");
                    break;
            }if(n!=7)
            {
            System.out.println("\n0 Para voltar ao MENU.\n7 SAIR.");
            n = tecla.nextInt();
            }

        }while(n!=7);
        System.out.println("PROGRAMA FINALIZADO!!!");

    }catch(SQLException e){
        e.printStackTrace();
    }
}


    public static void listaTodos() throws SQLException {
        System.out.println("**LISTA TODOS**\n");
        Contato contato = new Contato();
        List<Contato> contatos = contato.busca();
        if (contatos.size() == 0) {
            System.out.printf("Nenhum contato na agenda!");
        } else {
            contatos.forEach(c -> System.out.println(String.format("Id: %d\nNome: %s\nTelefone: %s \nTelefone2: %s\nCelular: %s\nCelular2: %s\nE-mail: %s\n",
                    c.getId(), c.getNome(), c.getTelefone(), c.getTelefone2(), c.getCelular(), c.getCelular2(), c.getEmail())));
        }
    }

    public static void listaId() {
        int id;
        Scanner tecla = new Scanner(System.in);
        System.out.println("Qual ID deseja ver:");
        id = tecla.nextInt();
        Contato c = new Contato(id);
        if(Contato.verifica == 1) {
            System.out.println("\n**LISTA UM CONTATO**");
            System.out.println(String.format("Id: %d\nNome: %s\nTelefone: %s\nTelefone2: %s\nCelular: %s\nCelular2: %s \nE-mail: %s\n",
                    c.getId(), c.getNome(), c.getTelefone(), c.getTelefone2(), c.getCelular(), c.getCelular2(), c.getEmail()));
        }else {
            System.out.println(" Id Inválido");
        }
    }
    public static void listaNome() {
        String nome;
        Scanner tecla = new Scanner(System.in);
        System.out.println("Qual nome deseja Buscar");
        nome = tecla.nextLine();
        Contato c = new Contato(nome);
        if (Contato.verifica == 1) {
            System.out.println("**LISTA UM CONTATO**");
            System.out.println(String.format("Id: %d\nNome: %s\nTelefone: %s\nTelefone2: %s\nCelular: %s\nCelular2: %s \nE-mail: %s\n",
                    c.getId(), c.getNome(), c.getTelefone(), c.getTelefone2(), c.getCelular(), c.getCelular2(), c.getEmail()));
        }else {
            System.out.println("***NOME NÃO CONSTA NO BANCO DE DADOS ***");
        }
    }

    public static void insere() {
        System.out.println("Inserindo contato");
        try {

            String nome;
            String fone;
            String fone2;
            String cel;
            String cel2;
            String email;

            Scanner tecla = new Scanner(System.in);

            Contato contato = new Contato();
            System.out.println("Nome do contato: ");
            nome = tecla.nextLine();
            contato.setNome(nome);
            System.out.println("Primeiro telefone para contato:");
            fone = tecla.nextLine();
            contato.setTelefone(fone);
            System.out.println("Segundo telefone:");
            fone2 = tecla.nextLine();
            contato.setTelefone2(fone2);
            System.out.println("Celular para contato:");
            cel = tecla.nextLine();
            contato.setCelular(cel);
            System.out.println("Celular para contato 2:");
            cel2 = tecla.nextLine();
            contato.setCelular2(cel2);
            System.out.println("Email para contato :");
            email = tecla.nextLine();
            contato.setEmail(email);
            contato.insere();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Contato inserido\n");
    }

    public static void altera() {
        try {

            int cod, op;
            Scanner tecla = new Scanner(System.in);
            System.out.println("Qual o ID do registro que você deseja alterar?");
            cod = tecla.nextInt();
            System.out.println("Qual dado você deseja alterar");
            System.out.println("1- Nome");
            System.out.println("2- Telefone");
            System.out.println("3- Telefone 2");
            System.out.println("4- Celular");
            System.out.println("5- Celular 2");
            System.out.println("6- Email");
            op = tecla.nextInt();
            Contato contato = new Contato(cod);
            switch(op) {
                case 1:
                    String nome;
                    System.out.println("Novo nome do contato: ");
                    nome = tecla.nextLine();
                    nome = tecla.nextLine();
                    contato.setNome(nome);
                    break;
                case 2:
                    String fone;
                    System.out.println("Novo primeiro telefone para contato:");
                    fone = tecla.nextLine();
                    fone = tecla.nextLine();
                    contato.setTelefone(fone);
                    break;
                case 3:
                    String fone2;
                    System.out.println("Novo segundo telefone:");
                    fone2 = tecla.nextLine();
                    fone2 = tecla.nextLine();
                    contato.setTelefone2(fone2);
                    break;
                case 4:
                    String cel;
                    System.out.println("Novo celular para contato:");
                    cel = tecla.nextLine();
                    cel = tecla.nextLine();
                    contato.setCelular(cel);
                    break;
                case 5:
                    String cel2;
                    System.out.println("Novo celular para contato 2:");
                    cel2 = tecla.nextLine();
                    cel2 = tecla.nextLine();
                    contato.setCelular2(cel2);
                    break;
                case 6:
                    String email;
                    System.out.println("Novo email para contato :");
                    email = tecla.nextLine();
                    email = tecla.nextLine();
                    contato.setEmail(email);
                    break;
                default:
                    System.out.println("\n**Comando Inválido**");
                    break;
            }
            contato.altera();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void exclui(){
        try {

            int idc;
            Scanner tecla = new Scanner(System.in);
            System.out.println("Qual id do contato para excluir?");
            idc = tecla.nextInt();
            System.out.println("Excluindo contato...\n");
            Contato contato = new Contato(idc);
            contato.exclui();
            System.out.println("Contato excluido!\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
