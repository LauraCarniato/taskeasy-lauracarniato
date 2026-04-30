/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogorpg;

/**
 *
 * @author aluno
 */
public class Personagem {
    
     private String nome;
    private String classe;
    private int nivel;
    private String aparencia;

    public Personagem(String nome, String classe, String aparencia) {
        this.nome = nome;
        this.classe = classe;
        this.aparencia = aparencia;
        this.nivel = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getClasse() {
        return classe;
    }

    public int getNivel() {
        return nivel;
    }

    public String getAparencia() {
        return aparencia;
    }

    public void subirNivel() {
        nivel++;
    }
    
}
