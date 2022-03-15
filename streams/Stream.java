package com.desafios.codeforces.logicaprogramacao.java8;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Curso {

    private String nome;
    private int alunos;

    public Curso(String nome, int alunos){
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
}


public class Stream {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("matematica", 100));
        cursos.add(new Curso("portugues", 130));
        cursos.add(new Curso("ingles", 150));
        cursos.add(new Curso("espanhol", 80));
        cursos.add(new Curso("geografia", 10));


        // ordenar os cursos pela quantidade de alunos
        cursos.sort(Comparator.comparing(Curso::getAlunos));

        //imprimir os cursos pelo nome
        cursos.forEach( c-> System.out.println(c.getNome()));
        System.out.println("---------------");

        // o stream devolve um fluxo, vamos usar este exemplo
        cursos.stream().filter(c -> c.getAlunos() > 90);

        // o stream ele nao impacta na lista original, por isso imprimiu os mesmos objetos
        cursos.forEach(c-> System.out.println(c.getNome()));
        System.out.println("---------------");

        // entao devemos usa-lo dessa forma
        cursos.stream().filter(c-> c.getAlunos() > 90).forEach(c-> System.out.println(c.getNome()));

        // dado uma lista de cursos pega alunos > 90 e some
        int sum = cursos.stream().filter(c-> c.getAlunos() > 90).mapToInt(Curso::getAlunos).sum();
        System.out.println(sum);
        System.out.println("---------------");

        //TODO - transformar um Stream de Curso em um Stream de String
        List<String> cursos2 = new ArrayList<>();
        cursos.stream().forEach(c -> cursos2.add(c.getNome()));
        cursos2.forEach(System.out::println);

        cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .map(c -> c.getAlunos())
                .forEach(x -> System.out.println(x));

        cursos.stream().filter(c -> c.getAlunos() > 50).map(Curso::getAlunos).forEach(System.out::println);
    }
}
