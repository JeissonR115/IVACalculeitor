package ui;

import other.DataHandler;

public class UICalculator {

    public static calculator.IVACalculator ivaC = new calculator.IVACalculator(0);

    static float sumProducts = 0;
    public static void  showCalculator(){
        System.out.println("Bienvenido a la calculadora de IVA");
        boolean isOn = true;
        while (isOn){
            float productPrice = DataHandler.get("Precio del producto: ");
            ivaC.setProductCost(productPrice);
            DataHandler.show("El precio del producto final (con IVA) es : ",ivaC.calculateFinalCost());
            sumProducts += ivaC.calculateFinalCost();
            DataHandler.show("El total suma de los productos (con IVA) : ",sumProducts);
            System.out.print("/*Si quieres salir cero(0) "
                    + "\n si quieres seguir oprime cualquier letra y oprime enter*/\n:");
            String key  = DataHandler.sc.next();
            if (key.equals("0")){
                isOn = false;
            }

        }
    }
    public static void getIVA(){
        System.out.println("El IVA actual es de "+ UICalculator.ivaC.getIvaPercentage()+"%");
    }
    public static void setIVA(){
        getIVA();
        ivaC.setIvaPercentage(DataHandler.get("nuevo IVA : "));
    }
}
