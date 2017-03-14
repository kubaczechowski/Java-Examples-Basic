/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptionsandfiles.BLL;

import exceptionsandfiles.BE.Customer;
import exceptionsandfiles.BE.FileType;
import exceptionsandfiles.DAL.FileManager;
import exceptionsandfiles.DAL.SerialFileHandler;
import exceptionsandfiles.DAL.TextFileHandler;
import java.util.List;

/**
 *
 * @author jeppjleemoritzled
 */
public class CustomerManager
{
    private FileManager fileManager = 
            new TextFileHandler();

    private static CustomerManager instance;
    
    private CustomerManager()
    {
    }
    
    public static CustomerManager getInstance()
    {
        if(instance==null)
            instance = new CustomerManager();
        
        return instance;
    }
    
    
    
    public void saveAll(List<Customer> custList)
    {
        fileManager.saveAll(custList);
    }
    
    public List<Customer> getAll()
    {
        return fileManager.getAll();
    }
    
    public void setFileType(FileType type)
    {
        switch(type)
        {
            case TEXTFILE:
                fileManager = new TextFileHandler();
                break;
            case SERIALFILE:
                fileManager = new SerialFileHandler();
                break;
        }
    }
}
