/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientdatabase.DAL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import patientdatabase.BE.Patient;

/**
 *
 * @author jeppjleemoritzled
 */
public class DALManager
{
    private static DALManager instance = null;
    
    public static DALManager getInstance()
    {
        if(instance == null)
        {
            instance = new DALManager();
        }
        
        return instance;
    }
    
    private DALManager()
    {
    }
    
    public List<Patient> getAllPatients()
    {
        List<Patient> returnList = new ArrayList<>();
        
        try(BufferedReader CSVFile = new BufferedReader(
            new FileReader("patients.csv")))
        {
            CSVFile.readLine(); // SKIP FIRST LINE HEADER
            String line = CSVFile.readLine();
            while(line!=null)
            {
                String[] dataArray = line.split(",");
                returnList.add(new Patient(
                                Integer.parseInt(dataArray[0]), 
                                dataArray[1], 
                                dataArray[2], 
                                dataArray[3]));
                
                line = CSVFile.readLine(); // Read next line
            }
        }
        catch(IOException ioe)
        {
            System.out.println(ioe);
            return null;
        }
        return returnList;
        
    }
}
