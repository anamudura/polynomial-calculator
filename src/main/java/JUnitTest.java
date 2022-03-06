import static org.junit.Assert.*;

import org.junit.*;

import java.util.LinkedList;

public class JUnitTest {
    public static Polinom p1 = new Polinom();
    private static Polinom p2 = new Polinom();
    private static int nrTesteExecutate = 0;
    private static int nrTesteCuSucces = 0;

    public JUnitTest() {
        System.out.println("Constructor inaintea fiecarui test!");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Incepe un nou test!");
        nrTesteExecutate++;
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("S-a terminat testul curent!");
    }

    @Test
    public void TestAdunareSimpla() {
        p1.getPolinom().add(new Monom(3, 2));
        p1.getPolinom().add(new Monom(2, 1));
        p1.getPolinom().add(new Monom(5, 0));
        p2.getPolinom().add(new Monom(3, 2));
        p2.getPolinom().add(new Monom(-5, 1));
        p2.getPolinom().add(new Monom(10, 0));
        p1.add(p2);
        assertNotNull(p1);
        nrTesteCuSucces++;
    }

    @Test
    public void TestAdunareMonom() {
        p1.getPolinom().add(new Monom(3, 0));
        p2.getPolinom().add(new Monom(3, 0));
        p1.add(p2);
        assertTrue(p1.getPolinom().get(0).getCoeficient()==6);
        assertTrue(p1.getPolinom().get(0).getGrad()==0);
        assertNotNull(p1);
        nrTesteCuSucces++;
    }

    @Test
    public void TestScadereMonom() {
        p1.getPolinom().add(new Monom(3, 0));
        p2.getPolinom().add(new Monom(3, 0));
        p1.subtract(p2);
        assertTrue(p1.getPolinom().get(0).getCoeficient()==0);
        assertTrue(p1.getPolinom().get(0).getGrad()==0);
        nrTesteCuSucces++;
    }
    @Test
    public void TestScadereSimpla() {
        p1.getPolinom().add(new Monom(3, 2));
        p1.getPolinom().add(new Monom(7, 1));
        p1.getPolinom().add(new Monom(5, 0));
        p2.getPolinom().add(new Monom(2, 2));
        p2.getPolinom().add(new Monom(-5, 1));
        p2.getPolinom().add(new Monom(10, 0));
        p1.subtract(p2);
        assertNotNull(p1);
        nrTesteCuSucces++;
    }
    @Test
    public void TestInmultireMonom() {
        p1.getPolinom().add(new Monom(3, 0));
        p2.getPolinom().add(new Monom(3, 0));
        p1.multiply(p2);
        assertTrue(p1.getPolinom().get(0).getCoeficient()==9);
        nrTesteCuSucces++;
    }
    @Test
    public void TestDerivare() {
        p1.getPolinom().add(new Monom(3, 2));
        p1.getPolinom().add(new Monom(5, 1));
        p1.getPolinom().add(new Monom(7, 0));
        p1.derivation(p1);
        assertTrue(p1.getPolinom().get(0).getCoeficient()==6);
        assertTrue(p1.getPolinom().get(0).getGrad()==1);
        assertTrue(p1.getPolinom().get(1).getCoeficient()==5);
        assertTrue(p1.getPolinom().get(1).getGrad()==0);
        nrTesteCuSucces++;
    }
    @Test
    public void TestIntegrare() {
        p1.getPolinom().add(new Monom(3, 2));
        p1.getPolinom().add(new Monom(5, 1));
        p1.getPolinom().add(new Monom(7, 0));
        p1.integration(p1);
        assertTrue(p1.getPolinom().get(0).getCoeficient()==1);
        assertTrue(p1.getPolinom().get(0).getGrad()==3);
        assertTrue(p1.getPolinom().get(1).getCoeficient()==2);
        assertTrue(p1.getPolinom().get(1).getGrad()==2);
        assertTrue(p1.getPolinom().get(2).getCoeficient()==7);
        assertTrue(p1.getPolinom().get(2).getGrad()==1);
        nrTesteCuSucces++;
    }

    @Test
    public void testAlwaysFail() {
        fail("Esuat!"); // intotdeauna esueaza
        nrTesteCuSucces++;
    }



}
