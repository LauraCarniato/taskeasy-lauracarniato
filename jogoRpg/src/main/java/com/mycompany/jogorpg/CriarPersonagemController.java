/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogorpg;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CriarPersonagemController {
    
     @FXML
    private TextField campoNome;

    @FXML
    private ChoiceBox<String> escolhaClasse;

    @FXML
    private ImageView imagemAparencia1;

    @FXML
    private ImageView imagemAparencia2;

    private String aparenciaSelecionada;

    @FXML
    private void initialize() {
        escolhaClasse.getItems().addAll("Druida", "Bardo", "Bárbaro", "Mago");

        escolhaClasse.setOnAction(event -> {
            mostrarAparencias();
        });
    }

    private void mostrarAparencias() {
        String classe = escolhaClasse.getValue();

        if (classe == null) {
            return;
        }

        String nome1 = "";
        String nome2 = "";

        if (classe.equals("Bardo")) {
            nome1 = "bardo";
            nome2 = "bardo2";
        } else if (classe.equals("Mago")) {
            nome1 = "mago";
            nome2 = "mago2";
        } else if (classe.equals("Druida")) {
            nome1 = "druida";
            nome2 = "druida2";
        } else if (classe.equals("Bárbaro")) {
            nome1 = "barbaro";
            nome2 = "barbaro2";
        }

        imagemAparencia1.setImage(
            new Image(getClass().getResourceAsStream("/com/mycompany/jogorpg/" + nome1 + ".png"))
        );

        imagemAparencia2.setImage(
            new Image(getClass().getResourceAsStream("/com/mycompany/jogorpg/" + nome2 + ".png"))
        );

        aparenciaSelecionada = null;
    }

    @FXML
    private void selecionarAparencia1() {
        String classe = escolhaClasse.getValue();

        if (classe == null) {
            return;
        }

        if (classe.equals("Bardo")) {
            aparenciaSelecionada = "bardo";
        } else if (classe.equals("Mago")) {
            aparenciaSelecionada = "mago";
        } else if (classe.equals("Druida")) {
            aparenciaSelecionada = "druida";
        } else if (classe.equals("Bárbaro")) {
            aparenciaSelecionada = "barbaro";
        }
    }

    @FXML
    private void selecionarAparencia2() {
        String classe = escolhaClasse.getValue();

        if (classe == null) {
            return;
        }

        if (classe.equals("Bardo")) {
            aparenciaSelecionada = "bardo2";
        } else if (classe.equals("Mago")) {
            aparenciaSelecionada = "mago2";
        } else if (classe.equals("Druida")) {
            aparenciaSelecionada = "druida2";
        } else if (classe.equals("Bárbaro")) {
            aparenciaSelecionada = "barbaro2";
        }
    }

    @FXML
    private void salvarPersonagem() throws IOException {
        String nome = campoNome.getText();
        String classe = escolhaClasse.getValue();
        String aparencia = aparenciaSelecionada;

        if (nome.isEmpty() || classe == null || aparencia == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText("Preencha todos os campos e escolha uma aparência!");
            alert.showAndWait();
            return;
        }

        Personagem personagem = new Personagem(nome, classe, aparencia);
        GerenciadorPersonagens.adicionarPersonagem(personagem);

        System.out.println("Personagem criado: " + personagem.getNome());

        App.setRoot("secondary");
    }

    @FXML
    private void voltar() throws IOException {
        App.setRoot("secondary");
    }
    
}
