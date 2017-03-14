/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientdatabase.BLL;

import java.util.List;
import patientdatabase.BE.Patient;
import patientdatabase.DAL.DALManager;

/**
 *
 * @author jeppjleemoritzled
 */
public class BLLManager
{

    private static BLLManager instance;

    public static BLLManager getInstance()
    {
        if (instance == null)
        {
            instance = new BLLManager();
        }
        
        return instance;
    }
    private BLLManager()
    {
    }
    
    public List<Patient> getAllPatients()
    {
        return DALManager.getInstance().getAllPatients();
    }
}
