package ui;

import Users.Admin;
import database.Database;
import login.Login;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static login.Login.getUser;
import static login.Login.verifyCredentials;

public class UIMenu {
    public UIMenu(){
    }
    private static void runMenuWithOptions(List<String> options, List<Runnable> actions, String textReturn) {
        int numOptions = options.size();
        if (numOptions != actions.size()) {
            System.out.println("Error: Los arreglos de opciones y acciones no tienen la misma longitud");
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println();
            for (int i = 0; i < numOptions; i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
            System.out.println("0. " + textReturn);

            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            try {
                int response = Integer.parseInt(input)-1;
                if (response+1 == 0) {
                    running = false;
                } else if (response < 0 || response  >= numOptions) {
                    System.out.println("Por favor seleccione una opción válida");
                } else {
                    actions.get(response).run();
                }
            } catch (NumberFormatException e) {
                if (input.equals("x") || input.equals("X") || input.equals("exit")){
                    running = false;
                } else {
                    System.out.println("Error: La entrada no es válida. Ingrese solo números.");
                }
            }
        }
    }
    public void showMenu() {
        System.out.println("*** \tMenu main\t ***");
        System.out.println("Bienvenido a la Calculadora de IVA");
        System.out.println("Quién eres?");

        List<String> mainMenuOptions = Arrays.asList("Cliente", "Administrador");
        List<Runnable> mainMenuActions = Arrays.asList(
                UIMenu::showClientMenu,
                UIMenu::selectUserMenu
        );
        runMenuWithOptions(mainMenuOptions, mainMenuActions, "(X) Salir de la App");
    }
    private static void showClientMenu(){
        System.out.println("*** \tCliente\t ***");
        List<String> options = Arrays.asList("Calcular IVA","Consultar el IVA");
        List<Runnable> actions = Arrays.asList(
                UICalculator::showCalculator,
                UICalculator::getIVA
        );
        runMenuWithOptions(options, actions,"(X) Salir del modo Cliente");
    }
    private static void selectUserMenu(){
        Database<Admin> adminDb = new Database<>("./data/listUsers.txt", Admin.class);
        List<Admin> listAdmin = adminDb.getObjects();
        adminDb.readObjectFromFile ();
        Login login = new Login(listAdmin);
        if (login.verifyCredentials()){
            Admin user = getUser();
            if (user.getUserType().equals("admin")) {
                showAdminMenu();
            } else {
                System.out.println("no he podido encontrar \"" + user.getUserType() + "\" como tipo de usuario.");
                System.out.println("los tipos de usuarios son :");
                System.out.println("\t* client(no necesitas un registro)\n\t* admin\n");
            }
        }

    }
    private static void showAdminMenu(){
        System.out.println("*** \tAdministrador\t ***");
        List<String> options = Arrays.asList("Calcular IVA","Consultar el IVA","Cambiar IVA");
        List<Runnable> actions = Arrays.asList(
                UICalculator::showCalculator,
                UICalculator::getIVA,
                UICalculator::setIVA
        );
        runMenuWithOptions(options, actions,"(X) Salir del modo Administrador");
    }
}