package com.desafios.codeforces.logicaprogramacao.java8;


import java.util.*;
import java.util.stream.Collectors;

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
        System.out.println("--------------------");

        // o Optional permite que trabalhemos com referencias null, onde nao precisamos perguntar se aquela referencia é igual a null (if(algumaCoisa === null))
        Optional<Curso> cursoOpt = cursos.stream().filter(c -> c.getAlunos() >= 100).findAny();

        // devolva um curso ou retorne um null
        Curso curso = cursoOpt.orElse(null);
        System.out.println(curso.getNome());
        System.out.println("---------------------");

        cursos.stream().filter(c -> c.getAlunos() > 100).findAny().ifPresent(c -> System.out.println(c.getNome()));
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&");

        // dado uma lista filtra por alunos menor ou igual a 100 e guarda em uma nova collection
        List<Curso> novaLista = cursos.stream().filter(c -> c.getAlunos() <= 100).collect(Collectors.toList());
        novaLista.forEach(c -> System.out.println(c.getNome()));


        // dado uma lista filtra por alunos menor ou igual a 100 e guarda em uma nova collection
        Map<String, Integer> map = cursos.stream().filter(c -> c.getAlunos() <= 100).collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
        System.out.println(map);
        System.out.println("-----------------------------");

        cursos.stream().filter(c -> c.getAlunos() <= 100).collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
                .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));

        System.out.println("----------------------------");
        Optional<Curso> first = cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .findFirst();

        Curso primeiro = first.orElse(null);
        System.out.println(primeiro.getNome());

        System.out.println("----------------------------");
        //dado uma lista de curso tire a média
        OptionalDouble average = cursos.stream()
                .mapToInt(c -> c.getAlunos())
                .average();

        System.out.println(average);
    }
}
