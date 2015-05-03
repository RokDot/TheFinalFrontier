package com.softpontaj.www;


import java.awt.Desktop;
import java.io.File;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import com.healthmarketscience.jackcess.*;

import java.io.*;
import java.util.*;
import java.sql.*;
import java.nio.*;
import java.lang.*;
/*import org.apache.commons.*;
import org.apache.commons.lang3.builder.*;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;*/

/**
 *
 * @author usr
 */
public class SoftPontajMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button openFile = new Button();
        Button data = new Button();
        Button ora = new Button();
        Button departament = new Button();
        Button utilizator = new Button();
        Button eveniment = new Button();
        openFile.setText("Deschide fisierul");
        
        openFile.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				FileChooser fileChooser = new FileChooser();
				File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                	 try {
                         Desktop.getDesktop().open(file);
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                }
				
			}
			
        });
       
        data.setText("DATA");
        ora.setText("ORA");
        departament.setText("DEPARTAMENT");
        utilizator.setText("UTILIZATOR");
        eveniment.setText("EVENIMENT");
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_LEFT);
        root.getChildren().add(openFile);
        HBox columns = new HBox();
        HBox.setHgrow(data, Priority.ALWAYS);
        HBox.setHgrow(ora, Priority.ALWAYS);
        HBox.setHgrow(departament, Priority.ALWAYS);
        HBox.setHgrow(utilizator, Priority.ALWAYS);
        HBox.setHgrow(eveniment, Priority.ALWAYS);
        
        
        data.setMaxWidth(Double.MAX_VALUE);
        ora.setMaxWidth(Double.MAX_VALUE);
        departament.setMaxWidth(Double.MAX_VALUE);
        utilizator.setMaxWidth(Double.MAX_VALUE);
        eveniment.setMaxWidth(Double.MAX_VALUE);
        columns.setAlignment(Pos.CENTER);
        columns.getChildren().add(data);
        columns.getChildren().add(ora);
        columns.getChildren().add(departament);
        columns.getChildren().add(utilizator);
        columns.getChildren().add(eveniment);
        root.getChildren().add(columns);
        Scene scene = new Scene(root, 900, 600);
        
        primaryStage.setTitle("Soft Pontaj v2.0");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}