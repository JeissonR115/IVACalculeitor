package other;

import java.util.Scanner;
public class DataHandler {

    private static float  data = 0;
    public static Scanner sc = new Scanner(System.in);
    public static float get(){
        try {
            String dataSrc = sc.next();
            System.out.println( Float.parseFloat(dataSrc));
            return Float.parseFloat(dataSrc);
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingresa un número válido.");
            return 0f;
        }
    }
    public static float get(String message){
        System.out.print(message);
        return get();
    }
    public static void show(String message,float num){
        System.out.println(message +" "+ num + '$');
    }

    public static float getData() {
        return data;
    }
}
