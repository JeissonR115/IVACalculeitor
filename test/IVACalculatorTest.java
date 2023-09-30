import calculator.IVACalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IVACalculatorTest {
    @Test
    void calculateProductIVA() {
        // Prueba del método calculateProductIVA con valores conocidos.
        float productCost = 100.0f; // Costo base del producto
        float ivaPercentage = 19.0f; // Porcentaje de IVA

        // El valor esperado del IVA sería 19.0, ya que el 19% de 100 es 19.
        float expectedIVA = 19.0f;

        // Llama al método y verifica si el resultado coincide con el valor esperado.
        float actualIVA = IVACalculator.calculateProductIVA(productCost, ivaPercentage);
        assertEquals(expectedIVA, actualIVA, 0.01); // Usamos una tolerancia de 0.01 para considerar posibles errores de redondeo.
    }
    @Test
    void calculateFinalCost() {
        // Prueba del método calculateFinalCost con valores conocidos.
        float productCost = 100.0f; // Costo base del producto
        float ivaPercentage = 19.0f; // Porcentaje de IVA

        // El valor esperado del costo final sería 119.0, ya que el costo base más el IVA (19) es 119.
        float expectedFinalCost = 119.0f;

        // Llama al método y verifica si el resultado coincide con el valor esperado.
        float actualFinalCost = IVACalculator.calculateFinalCost(productCost, ivaPercentage);
        assertEquals(expectedFinalCost, actualFinalCost, 0.01); // Usamos una tolerancia de 0.01 para considerar posibles errores de redondeo.
    }

}