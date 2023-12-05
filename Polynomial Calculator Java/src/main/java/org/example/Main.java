package org.example;

import gui.GUI;
import polinom.OPERATII;
import polinom.POLYNOM;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
      HashMap<Integer,Double> hashmap1=new HashMap<Integer,Double>();
      hashmap1.put(2,3.0);
      hashmap1.put(1,2.0);
        HashMap<Integer,Double> hashmap2=new HashMap<Integer,Double>();
        hashmap2.put(1,4.0);
        hashmap2.put(0,3.0);

        POLYNOM a=new POLYNOM(hashmap1);
        POLYNOM b=new POLYNOM(hashmap2);
        OPERATII adunare1=new OPERATII();
  POLYNOM rezadun=new POLYNOM();
  POLYNOM rezscad=new POLYNOM();
  POLYNOM rezinm=new POLYNOM();
        POLYNOM rezdev=new POLYNOM();
        POLYNOM rezint=new POLYNOM();
        POLYNOM rezregex=new POLYNOM();
    rezadun=adunare1.adunare(a,b);
    rezscad=adunare1.scadere(a,b);
    rezinm=adunare1.inmultire(a,b);
    rezdev=adunare1.derivare(a);
    rezint=adunare1.integrare(b);
        System.out.println(rezadun.polinom.toString());
        System.out.println(rezscad.polinom.toString());
        System.out.println(rezinm.polinom.toString());
        System.out.println(rezdev.polinom.toString());
        System.out.println(rezint.polinom.toString());
        rezregex=rezregex.regex("2.5x^2 - 3.2x^1 + 1.0x^0");
        System.out.println(rezregex.polinom.toString());
        new GUI();
    }

    }