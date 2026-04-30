package com.mycompany.jogorpg;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.input.MouseEvent;

public class SecondaryController {

 @FXML
    private ListView<Personagem> listaPersonagens;

    @FXML
    private void initialize() {

        // Carrega a lista
        listaPersonagens.setItems(GerenciadorPersonagens.getPersonagens());

        // Duplo clique para entrar
        listaPersonagens.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 2) {
                try {
                    entrarNoJogo();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Personalização da linha + botão X
        listaPersonagens.setCellFactory(param -> new ListCell<Personagem>() {

            @Override
            protected void updateItem(Personagem p, boolean empty) {
                super.updateItem(p, empty);

                if (empty || p == null) {
                    setGraphic(null);
                } else {

                    Label nome = new Label(
                        p.getNome() + " - Nv " + p.getNivel() + " (" + p.getClasse() + ")"
                    );

                    Button excluir = new Button("X");

                    excluir.setOnAction(e -> {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Excluir");
                        alert.setHeaderText(null);
                        alert.setContentText("Tem certeza que deseja excluir esse mundo?");

                        alert.showAndWait().ifPresent(response -> {
                            if (response == javafx.scene.control.ButtonType.OK) {
                                GerenciadorPersonagens.removerPersonagem(p);
                            }
                        });
                    });

                    HBox linha = new HBox(10, nome, excluir);

                    setGraphic(linha);
                }
            }
        });
    }

    @FXML
    private void criarPersonagem() throws IOException {
        App.setRoot("criarPersonagem");
    }

    @FXML
    private void entrarNoJogo() throws IOException {
        Personagem selecionado = listaPersonagens.getSelectionModel().getSelectedItem();

        if (selecionado == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText("Selecione um personagem primeiro!");
            alert.showAndWait();
            return;
        }

        System.out.println("Entrando com: " + selecionado.getNome());

        Jogo.setPersonagemAtual(selecionado);
        App.setRoot("game");
    }

    @FXML
    private void voltar() throws IOException {
        App.setRoot("primary");
    }
    
    
}