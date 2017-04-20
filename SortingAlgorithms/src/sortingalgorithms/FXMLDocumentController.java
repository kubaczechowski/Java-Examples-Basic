/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithms;

import sortingalgorithms.Sorting.SortStrategy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import sortingalgorithms.Sorting.*;

/**
 *
 * @author Jeppe
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private ListView<Integer> lstUnsorted;
    @FXML
    private ComboBox<SortStrategy> comboAlgos;
    @FXML
    private ListView<Comparable> lstSorted;
    
    Sorter sorter;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        Integer[] randNumbers = lstUnsorted.getItems().toArray(new Integer[0]);
        sorter.setStrategy(comboAlgos.getValue());
        lstSorted.setItems(FXCollections.observableArrayList(sorter.sort(randNumbers)));
    }
    
    private void createNewRandomList()
    {
        Random r = new Random();
        Integer[] randNumbers = new Integer[20];
        for (int i = 0; i < randNumbers.length; i++) {
            randNumbers[i]=r.nextInt(randNumbers.length);            
        }
        lstUnsorted.setItems(FXCollections.observableArrayList(randNumbers));
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboAlgos.getItems().add(new Bubble(false));
        comboAlgos.getItems().add(new Selection(false));
        comboAlgos.getItems().add(new Insertion(false));
        comboAlgos.getItems().add(new Merge(false));
        comboAlgos.getItems().add(new Quick(false));
        comboAlgos.getSelectionModel().selectFirst();
        sorter = new Sorter(comboAlgos.getSelectionModel().getSelectedItem());
        this.createNewRandomList();
    }    

    @FXML
    private void comboAction(ActionEvent event) {
    }

    @FXML
    private void createRandom(ActionEvent event) {
        this.createNewRandomList();
    }
    
}
