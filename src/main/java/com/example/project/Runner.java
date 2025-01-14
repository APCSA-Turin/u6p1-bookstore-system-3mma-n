package com.example.project;

public class Runner {
    public static void main(String[] args) {
        System.out.println(IdGenerate.getCurrentId());
        IdGenerate.generateID();
        IdGenerate.generateID();
        IdGenerate.generateID();
        System.out.println(IdGenerate.getCurrentId());
    }
}