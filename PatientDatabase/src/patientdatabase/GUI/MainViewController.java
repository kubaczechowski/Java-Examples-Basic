/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientdatabase.GUI;

import java.io.IOException;
import patientdatabase.BE.Patient;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import patientdatabase.BLL.BLLManager;

/**
 *
 * @author jeppjleemoritzled
 */
public class MainViewController implements Initializable
{
    
    @FXML
    private Label label;
    @FXML
    private TableView<Patient> tablePatients;
    @FXML
    private TableColumn<Patient, String> columnName;
    @FXML
    private TableColumn<Patient, String> columnEmail;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        readDataIntoList();
    }    

    private void readDataIntoList()
    {
        ObservableList<Patient> patientList = 
                FXCollections.observableArrayList();
        
        BLLManager bllManager = BLLManager.getInstance();
        patientList.addAll(bllManager.getAllPatients());
        
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tablePatients.setItems(patientList);
    }

    private void loadPatientDataView(Patient patient) throws IOException
    {
        // Fetches primary stage and gets loader and loads FXML file to Parent
        Stage primStage = (Stage)tablePatients.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("PatientView.fxml"));
        Parent root = loader.load();
        
        // Fetches controller from patient view
        PatientViewController patientViewController =
                loader.getController();
        
        patientViewController.setPatient(patient);
        
        // Sets new stage as modal window
        Stage stagePatientView = new Stage();
        stagePatientView.setScene(new Scene(root));
        
        stagePatientView.initModality(Modality.WINDOW_MODAL);
        stagePatientView.initOwner(primStage);
        
        stagePatientView.show();
    }

    @FXML
    private void mousePressedOnTableView(MouseEvent event) throws IOException
    {
        // Check double-click left mouse button
        if(event.isPrimaryButtonDown() && event.getClickCount()==2)
        {
            Patient selectedPatient = tablePatients.getSelectionModel(
                            ).getSelectedItem();
            loadPatientDataView(selectedPatient);
            
        }
    }
    
}
