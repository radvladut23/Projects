package polinom;

import java.util.HashMap;
import java.util.Map;
public class OPERATII {
    public OPERATII() {
    }

    public static POLYNOM adunare(POLYNOM a, POLYNOM b) {
        HashMap<Integer,Double> excces=new HashMap<Integer,Double>();
        HashMap<Integer,Double> excces1=new HashMap<Integer,Double>();
        POLYNOM rezultat=new POLYNOM();
        for (Map.Entry<Integer, Double> elem1 : a.polinom.entrySet()) {
            for (Map.Entry<Integer,Double> elem2 : b.polinom.entrySet()) {
                if (elem1.getKey() == elem2.getKey()) {

                    excces1.put(elem2.getKey(), elem2.getValue()+elem1.getValue());
                } else {
                    if (a.polinom.containsKey(elem2.getKey()) == false) {
                        excces.put(elem2.getKey(), elem2.getValue());
                    }
                    if(b.polinom.containsKey(elem1.getKey()) == false) {
                        excces.put(elem1.getKey(), elem1.getValue());
                    }
                }

            }

        }
        for (Map.Entry<Integer,Double> elem2 :excces.entrySet())
        {
            rezultat.polinom.put(elem2.getKey(),elem2.getValue());
        }
        for (Map.Entry<Integer,Double> elem2 :excces1.entrySet())
        {
            rezultat.polinom.put(elem2.getKey(),elem2.getValue());
        }
        return rezultat;
    }
    public static POLYNOM scadere(POLYNOM a, POLYNOM b) {
        HashMap<Integer,Double> excces=new HashMap<Integer,Double>();
        HashMap<Integer,Double> excces1=new HashMap<Integer,Double>();
        POLYNOM rezultat=new POLYNOM();
        for (Map.Entry<Integer, Double> elem1 : a.polinom.entrySet()) {
            for (Map.Entry<Integer,Double> elem2 : b.polinom.entrySet()) {
                if (elem1.getKey() == elem2.getKey()) {

                    excces1.put(elem2.getKey(), elem1.getValue()-elem2.getValue());
                } else {
                    if (a.polinom.containsKey(elem2.getKey()) == false) {
                        excces.put(elem2.getKey(), -elem2.getValue());
                    }
                    if(b.polinom.containsKey(elem1.getKey()) == false) {
                        excces.put(elem1.getKey(), elem1.getValue());
                    }
                }

            }

        }
        for (Map.Entry<Integer,Double> elem2 :excces.entrySet())
        {
            rezultat.polinom.put(elem2.getKey(),elem2.getValue());
        }
        for (Map.Entry<Integer,Double> elem2 :excces1.entrySet())
        {
            rezultat.polinom.put(elem2.getKey(),elem2.getValue());
        }
        return rezultat;
    }
    public static POLYNOM inmultire(POLYNOM a, POLYNOM b) {
        HashMap<Integer,Double> excces=new HashMap<Integer,Double>();
        POLYNOM rezultat=new POLYNOM();

        for (Map.Entry<Integer, Double> elem1 : a.polinom.entrySet())
        {
            for (Map.Entry<Integer, Double> elem2 : b.polinom.entrySet())
            {
                if (excces.containsKey(elem1.getKey() + elem2.getKey()))
                {
                    Double cv= excces.get(elem1.getKey() + elem2.getKey());
                    cv=cv+elem1.getValue()*elem2.getValue();
                    excces.replace(elem1.getKey() + elem2.getKey(),cv);
                }
                else
                {
                    excces.put(elem1.getKey() + elem2.getKey(), elem1.getValue() * elem2.getValue());
                }
            }
        }
        for (Map.Entry<Integer, Double> elem1 :excces.entrySet()) {
            rezultat.polinom.put(elem1.getKey(),elem1.getValue());
        }

        return rezultat;
    }
    public static POLYNOM derivare(POLYNOM a) {
        HashMap<Integer,Double> excces=new HashMap<Integer,Double>();
        POLYNOM rezultat=new POLYNOM();
        for (Map.Entry<Integer, Double> elem1 : a.polinom.entrySet())
        {
             {
                   excces.put(elem1.getKey()-1,elem1.getValue()* elem1.getKey());
             }
        }
        for (Map.Entry<Integer, Double> elem1 :excces.entrySet())
        {
            rezultat.polinom.put(elem1.getKey(),elem1.getValue());
        }

        return rezultat;
    }
    public static POLYNOM integrare(POLYNOM a) {
        HashMap<Integer,Double> excces=new HashMap<Integer,Double>();
        POLYNOM rezultat=new POLYNOM();
        for (Map.Entry<Integer, Double> elem1 : a.polinom.entrySet())
        {
            {
                excces.put(elem1.getKey()+1,elem1.getValue()/(elem1.getKey()+1));
            }
        }
        for (Map.Entry<Integer, Double> elem1 :excces.entrySet())
        {
            rezultat.polinom.put(elem1.getKey(),elem1.getValue());
        }

        return rezultat;
    }
}