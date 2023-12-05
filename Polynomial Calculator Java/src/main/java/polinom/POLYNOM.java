package polinom;
import java.util.HashMap;
import java.util.Map;

public class POLYNOM {
    public HashMap<Integer,Double> polinom=new HashMap<Integer,Double>();

    public POLYNOM(HashMap<Integer,Double> polinom) {
        this.polinom = polinom;
    }
    public POLYNOM() {
    }

    public void setPolinom(HashMap<Integer,Double> polinom) {
        this.polinom = polinom;
    }

    public HashMap<Integer, Double> getPolinom() {
        return polinom;
    }
    public POLYNOM regex(String polynomialString)
    {
        POLYNOM rezultat=new POLYNOM();
        HashMap<Integer, Double> polynomialMap = new HashMap<>();
        String[] terms = polynomialString.split("\\s*\\+\\s*|\\s*\\-\\s*");
        for (String term : terms) {
            int sign = 1;
            if (term.startsWith("-")) {
                sign = -1;
                term = term.substring(1);
            } else if (term.startsWith("+")) {
                term = term.substring(1);
            }
            String[] parts = term.split("x\\^?");
            double coefficient = 1.0;
            int exponent = 0;
            if (parts.length == 1) {
                coefficient = Double.parseDouble(parts[0]);
            } else if (parts.length == 2) {
                if (!parts[0].isEmpty()) {
                    coefficient = Double.parseDouble(parts[0]);
                }
                if (!parts[1].isEmpty()) {
                    exponent = Integer.parseInt(parts[1]);
                } else {
                    exponent = 1;
                }
            }
            polynomialMap.put(exponent, polynomialMap.getOrDefault(exponent, 0.0) + sign * coefficient);
        }
        for (Map.Entry<Integer,Double> elem2 :polynomialMap.entrySet())
        {
            rezultat.polinom.put(elem2.getKey(),elem2.getValue());
        }
        return rezultat;
    }


      public String afisare(POLYNOM a) {
        String rezultat=new String();
        for (Map.Entry<Integer,Double> elem2 :a.polinom.entrySet())
        {
            rezultat=rezultat+"+"+elem2.getValue()+"x^"+elem2.getKey();

        }
        return rezultat;

    }
    //x^3-2x^2+6x^1-5x^0



}
