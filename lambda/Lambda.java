package com.desafios.codeforces.logicaprogramacao.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Lambda {

    public static void main(String[] args) {

        // vamos ordenar do jeito antigo, para posteriormente usar os recursos do Java 8

        List<String> frutas = new ArrayList<>();
        frutas.add("banana");
        frutas.add("morango");
        frutas.add("uva");
        frutas.add("abacate");
        frutas.add("caju");

        // vamos utilizar uma classe utilitaria do java util para ordenar nossa lista
        Collections.sort(frutas);

        //vamos imprimir a lista ordenada lexograficamente do A a Z
        System.out.println("imprimindo lexograficamente");
        System.out.println(frutas);
        System.out.println("---------------------------");

        // classe anonima que podemos passar como argumento para o sort
        frutas.sort( new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() < s2.length())
                    return -1;
                if(s1.length() > s2.length())
                    return 1;

                return 0;
            }
        });

        //podemos passar com lambda
        frutas.sort( (s1, s2) -> {
            if(s1.length() < s2.length())
                return -1;
            if(s1.length() > s2.length())
                return 1;

            return 0;
        });

        //podemos utilizar de outra forma lambda,deixando o codigo mais enxuto
        frutas.sort(Comparator.comparingInt(String::length));


        System.out.println(frutas);
        System.out.println("---------------------------");

        // só que dessa forma fica muito verboso, entretanto a propria List já nos fornece  o método sort,
        // onde passamos nosso comparator
        System.out.println(frutas);
        System.out.println("---------------------------");

        // Podemos imprimir o array de varias formas

        //utilizando o for aprimorado

        for(String f : frutas) {
            System.out.println(f);
        }
        System.out.println("---------------------------");

        // classe anonima que podemos passar como argumento para o foreach
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        //podemos passar com lambda
        //quando utilizamos lambda nao precisamos passar o tipo quando temos apenas um parametro
        Consumer<String> consumer2 = s -> System.out.println(s);


        frutas.forEach(consumer);
        System.out.println("---------------------------");

        frutas.forEach(consumer2);
        System.out.println("---------------------------");

        //podemos passar tambem direto do foreach, uma vez que ele espera um consumer, ele consegue inferir se é valido
        frutas.forEach(s -> System.out.println(s));

    }
}

// O lambda consegue ser convertido para uma interface funcional






