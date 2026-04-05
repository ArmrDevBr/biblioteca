package br.com.armrdev.services;

import br.com.armrdev.exceptions.BibliotecaException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validador {
    private final Scanner input = new Scanner(System.in);

    public int validacaoInt(String msg) {
        while (true) {
            try {
                System.out.println(msg);
                String inputUser = this.input.nextLine();

                if (inputUser.isBlank()) {
                    
        System.out.println("|---------------------------------------------------|");
                    System.out.println("O valor não pode ser vazio! ");
                } else {
                    return Integer.parseInt(inputUser);
                }
            } catch (NumberFormatException e) {
                
        System.out.println("|---------------------------------------------------|");
                System.out.println("Digite um numero!");
            }
        }
    }

    public int validacaoIntMaxAndMin( int min,int max,String msg) {
        while (true) {
            try {
                
        System.out.println("|---------------------------------------------------|");
                System.out.println(msg);
                String inputUser = this.input.nextLine();
                int userResponse = Integer.parseInt(inputUser);

                if (userResponse < min) {
                    
        System.out.println("|---------------------------------------------------|");
                    System.out.println("O não pode ser menor que " + min);
                } else if (userResponse > max) {
                    
        System.out.println("|---------------------------------------------------|");
                    System.out.println("O número não pode ser maior que " + max);
                } else {
                    return userResponse;
                }
            } catch (NumberFormatException e) {
                
        System.out.println("|---------------------------------------------------|");
                System.out.println("Digite um numero!");
            }
        }
    }

    public String validacaoString(String msg) {
        while (true) {

            System.out.println("|---------------------------------------------------|");
            System.out.println(msg);
            String inputUser = this.input.nextLine();
            if (inputUser.isBlank()) {

                System.out.println("|---------------------------------------------------|");
                System.out.println("O valor não pde ser vazio!");
            }else {
                return inputUser;
            }
        }

    }

    public String emailValidator(String msg) {
        while (true) {
            
        System.out.println("|---------------------------------------------------|");
            System.out.println(msg);
            String inputUser = this.input.nextLine();

            if (inputUser.isBlank()) {
                
        System.out.println("|---------------------------------------------------|");
                System.out.println("Digite um email! o campo não pode ser vazio!");
            } else if (!inputUser.contains("@") || inputUser.length() <= 10) {
                
        System.out.println("|---------------------------------------------------|");
                System.out.println("O email não é válido!");
            } else {
                return inputUser;
            }
        }
    }
}
