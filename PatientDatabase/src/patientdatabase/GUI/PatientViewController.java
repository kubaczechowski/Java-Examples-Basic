/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientdatabase.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import patientdatabase.BE.Patient;

/**
 * FXML Controller class
 *
 * @author jeppjleemoritzled
 */
public class PatientViewController implements Initializable
{

    @FXML
    private Label lblId;
    @FXML
    private Label lblName;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblDiagnosis;

    private Patient currentPatient;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
    
    public void setPatient(Patient patient)
    {
        currentPatient = patient;
        fillLabels();
    }
    
    private void fillLabels()
    {
        lblId.setText(currentPatient.getId()+"");
        lblName.setText(currentPatient.getName());
        lblEmail.setText(currentPatient.getEmail());
        lblDiagnosis.setText(currentPatient.getDiagnosis());
    }
    
}
