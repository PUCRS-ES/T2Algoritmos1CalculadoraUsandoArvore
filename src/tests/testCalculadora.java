package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import source.Calculadora;

public class testCalculadora {

    Calculadora calc;

    @Before
    public void inicializa() {
        calc = new Calculadora();
        calc.setOperador1(3.0);
        calc.setOperador2(9.0);
    }

    @Test
    public void testaSoma() {
        assertEquals(12, calc.soma(), 0.000001);
    }

    @Test
    public void testaSubtracao() {
        assertEquals(-6, calc.subtracao(), 0.000001);
    }

    @Test
    public void testaMultiplicacao() {
        assertEquals(27, calc.produto(), 0.000001);
    }

    @Test
    public void testaDivisao() {
        assertEquals(1.0 / 3, calc.divisao(), 0.00001);
    }

    @Test
    public void testaPotencia() {
        assertEquals(19683, calc.potencia(), 0.000001);
    }

    @Test
    public void testaCalcula() {
        try {
            calc.setOperando('+');
            assertEquals(12, calc.calcula(), 0.000001);

            calc.setOperando('-');
            assertEquals(-6, calc.calcula(), 0.000001);

            calc.setOperando('*');
            assertEquals(27, calc.calcula(), 0.000001);

            calc.setOperando('/');
            assertEquals(1.0 / 3, calc.calcula(), 0.000001);

            calc.setOperando('^');
            assertEquals(19683, calc.potencia(), 0.000001);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
