package com.desafios.codeforces.logicaprogramacao.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

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
        System.out.println(frutas);
        System.out.println("---------------------------");


        // agora instanciamos nosso objeto e passamos como parametro no Collections no segundo parametro,
        // onde vamos pegar a nossa configuração de acordo com o criterio criado na classe

        Comparator<String> comparator = new ComparadorPorTamanho();
        Collections.sort(frutas, comparator);
        System.out.println(frutas);
        System.out.println("---------------------------");

        // só que dessa forma fica muito verboso, entretanto a propria List já nos fornece  o método sort,
        // onde passamos nosso comparator
        frutas.sort(comparator);
        System.out.println(frutas);
        System.out.println("---------------------------");

        // Podemos imprimir o array de varias formas

        //utilizando o for aprimorado

        for(String f : frutas) {
            System.out.println(f);
        }
        System.out.println("---------------------------");

        // utilizando o foreach e um consumidor
        Consumer<String> consumer = new ImprimeNaLinha();
        frutas.forEach(consumer);

    }
}

// Podemos ordenar nossas listas com outros criterios
// No nosso caso vamos comparar por Tamanho

// devemos implementar a interface comparator e implementar o metodo compare de acordo com nosso criterio
class ComparadorPorTamanho implements Comparator<String>{

    @Override
    public int compare(String s1, String s2) {
        if(s1.length() < s2.length())
            return -1;
        if(s1.length() > s2.length())
            return 1;

        return 0;
    }
}

class ImprimeNaLinha implements Consumer<String>{

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}



// Um método dentro de uma interface que queira ter um corpo, deve ter o modificador default
// Imagine o seguinte caso, sabemos que uma classe quando implementa uma interface, ela obrigatoriamente deve implementar seus métodos,
// se por ventura, acrescentarmos mais métodos que não sejam default methods, todas as outras classes que implementam essa interface vao quebrar,
// pelo motivo que nao implementou o novo método, agora quando utilizamos os default methods, eu posso usar em classes especificas quando desejar, sem quebrar
// o contrato das outras classes
