/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogorpg;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class GameController {
    
     @FXML
    private AnchorPane paneJogo;

    @FXML
    private ImageView player;

    private double destinoX = 100;
    private double destinoY = 100;
    private double velocidade = 2;

    @FXML
    private void initialize() {

        // pega o personagem escolhido
        Personagem p = Jogo.getPersonagemAtual();

        if (p != null) {
            String aparencia = p.getAparencia();

            player.setImage(
                new Image(
                    getClass().getResourceAsStream(
                        "/com/mycompany/jogorpg/" + aparencia + ".png"
                    )
                )
            );
        }

        // clique no mapa
        paneJogo.setOnMouseClicked(event -> {
            destinoX = event.getX();
            destinoY = event.getY();
        });

        // movimento suave
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                double dx = destinoX - player.getLayoutX();
                double dy = destinoY - player.getLayoutY();

                double distancia = Math.sqrt(dx * dx + dy * dy);

                if (distancia > 2) {
                    player.setLayoutX(
                        player.getLayoutX() + (dx / distancia) * velocidade
                    );

                    player.setLayoutY(
                        player.getLayoutY() + (dy / distancia) * velocidade
                    );
                }
            }
        };

        timer.start();
    }
}
