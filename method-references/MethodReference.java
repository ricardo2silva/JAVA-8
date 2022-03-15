package com.desafios.codeforces.logicaprogramacao.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class MethodReference {

    public static void main(String[] args) {

        // vamos ordenar do jeito antigo, para posteriormente usar os recursos do Java 8

        List<String> frutas = new ArrayList<>();
        frutas.add("banana");
        frutas.add("morango");
        frutas.add("uva");
        frutas.add("abacate");
        frutas.add("caju");

        // dado uma string pega o seu tamanho e compare entre elas
        frutas.sort(Comparator.comparingInt(f -> f.length()));
        System.out.println(frutas);
        System.out.println("------------------------");

        //podemos utilizar de outra forma lambda,deixando o codigo mais enxuto, mesma coisa de cima
        frutas.sort(Comparator.comparingInt(String::length));
        System.out.println(frutas);
        System.out.println("------------------------");

        // usando method reference para imprimir
        frutas.forEach(System.out::println);

    }
}






