package calculator;
import java.io.*;

public class IVACalculator {
    private final String file = "./data/info.txt";
    float productCost = 0;
    public IVACalculator(float productCost){
        this.productCost = productCost;
    }
    public static float calculateProductIVA(float productCost, float ivaPercentage){
        return (productCost * (ivaPercentage/100));
    }
    public static float calculateFinalCost(float productCost,float productIVA){
        return productCost+productIVA;
    }
    public float calculateProductIVA(){
        return calculateProductIVA(this.productCost,this.getIvaPercentage());
    }
    public float calculateFinalCost(){
        return  calculateFinalCost(this.productCost,calculateProductIVA());
    }
    public float getIvaPercentage() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String property = parts[0].trim();
                    String value = parts[1].trim();
                    if (property.equals("ivaPercentage")) {
                        return Float.parseFloat(value);
                    } else {
                        System.out.println("Propiedad desconocida: " + property);
                    }
                } else {
                    System.out.println("Formato de línea incorrecto: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("no puedo leer el archivo:"+file);
            System.out.println(""+e);
        }
        return 19f;
    }
    public void setIvaPercentage(float newIvaPercentage) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea = br.readLine();
            String[] partes = linea.split(":");
            if (partes.length == 2) {
                String propiedad = partes[0].trim();
                String valor = partes[1].trim();
                if (propiedad.equals("ivaPercentage")) {
                    String nuevaLinea = "ivaPercentage:" + newIvaPercentage;
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                        bw.write(nuevaLinea);
                        System.out.println("El porcentaje de IVA a cambiado exitosamente en el archivo.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Propiedad desconocida: " + propiedad);
                }
            } else {
                System.out.println("Formato de línea incorrecto: " + linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public float getProductCost() {
        return productCost;
    }
    public void setProductCost(float productCost) {
        this.productCost = productCost;
    }

}
