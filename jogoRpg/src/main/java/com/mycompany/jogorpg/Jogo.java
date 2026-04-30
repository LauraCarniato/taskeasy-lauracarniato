/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogorpg;

/**
 *
 * @author aluno
 */
public class Jogo {
    
    private static Personagem personagemAtual;

    public static void setPersonagemAtual(Personagem p) {
        personagemAtual = p;
    }

    public static Personagem getPersonagemAtual() {
        return personagemAtual;
    }
    
}
