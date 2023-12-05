
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import polinom.OPERATII;
import polinom.POLYNOM;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class OPERATIITest {

    @Test
    public void testAdunare()
    {
        POLYNOM polinom1= new POLYNOM();
        polinom1.regex("4x^2+3x^0");
        POLYNOM polinom2= new POLYNOM();
        polinom2.regex("3x^2+2x^1");
        POLYNOM polinom3= new POLYNOM();
        polinom3.regex("7x^2+2x^1+3x^0");
        Assert.assertEquals(OPERATII.adunare(polinom1,polinom2).afisare(OPERATII.adunare(polinom1,polinom2)),polinom3.afisare(polinom3));
    }
    @Test
    public void testScadere()
    {
        POLYNOM polinom1= new POLYNOM();
        polinom1.regex("4x^2+3x^0");
        POLYNOM polinom2= new POLYNOM();
        polinom2.regex("3x^2+2x^1");
        POLYNOM polinom3= new POLYNOM();
        polinom3.regex("1x^2-2x^1+3x^0");
        Assert.assertEquals(OPERATII.scadere(polinom1,polinom2).afisare(OPERATII.scadere(polinom1,polinom2)),polinom3.afisare(polinom3));
    }
    @Test
    public void testInmultire()
    {
        POLYNOM polinom1= new POLYNOM();
        polinom1.regex("4x^2+3x^0");
        POLYNOM polinom2= new POLYNOM();
        polinom2.regex("3x^2+2x^1");
        POLYNOM polinom3= new POLYNOM();
        polinom3.regex("12x^4+8x^3+9x^2+6x^1");
        Assert.assertEquals(OPERATII.inmultire(polinom1,polinom2).afisare(OPERATII.inmultire(polinom1,polinom2)),polinom3.afisare(polinom3));
    }
    @Test
    public void testDerivare()
    {
        POLYNOM polinom1= new POLYNOM();
        polinom1.regex("4x^2+3x^0");
        POLYNOM polinom2= new POLYNOM();
        polinom2.regex("8x^1");
        Assert.assertEquals(OPERATII.derivare(polinom1).afisare(OPERATII.derivare(polinom1)),polinom2.afisare(polinom2));
    }
    @Test
    public void testIntegrare()
    {
        POLYNOM polinom1= new POLYNOM();
        polinom1.regex("2x^2+4x^1");
        POLYNOM polinom2= new POLYNOM();
        polinom2.regex("1x^3+2x^2");
        Assert.assertEquals(OPERATII.integrare(polinom1).afisare(OPERATII.integrare(polinom1)),polinom2.afisare(polinom2));
    }
    @Test
    public void testincorectIntegrare()
    {
        POLYNOM polinom1= new POLYNOM();
        polinom1.regex("3x^2");
        POLYNOM polinom2= new POLYNOM();
        polinom2.regex("1x^3");
        Assert.assertNotEquals(OPERATII.integrare(polinom1).afisare(OPERATII.integrare(polinom1)),polinom2.afisare(polinom2));
    }

}

