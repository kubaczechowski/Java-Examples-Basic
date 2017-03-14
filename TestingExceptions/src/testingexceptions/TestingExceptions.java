/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingexceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeppjleemoritzled
 */
public class TestingExceptions
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        
            //testStackOverflow();
            //testOutOfMemory();
            
            //testIndexOutOfBounds();
            //testArrayIndexOutOfBounds();
            
            //testArithmeticException();
            
            //testTypeCastException();
            //testNumberFormatException();
            textFileNotFoundException();
        
        System.out.println("Weeee!");
        
    }
    
    private static void testStackOverflow()
    {
        while(true)
                testStackOverflow();
    }
    
    private static void testOutOfMemory()
    {
        ArrayList<String> arList = new ArrayList();
        while(true)
                arList.add("hi");
    }
    
    private static void testIndexOutOfBounds()
    {
        ArrayList<String> arList = new ArrayList();
        arList.add("Hisdkmfldsf");
        int index = 1;
        arList.get(index);
    }
       
    private static void testArrayIndexOutOfBounds()
    {
        String[] arList = new String[10];
        for (int i = 0; i <= arList.length; i++)
        {
            String string = arList[i];
        }
    }
    
    private static void testNumberFormatException()
    {
        String x = "Rhello!";
        int y = Integer.parseInt(x);
    }
    
    private static void testTypeCastException()
    {
        Collection c = new LinkedList<String>();
        ArrayList<String> list = (ArrayList)c;
    }
    
    private static void testArithmeticException()
    {
        int zero = 0;
        int x = 5/zero; 
    }
    
    private static void textFileNotFoundException() throws FileNotFoundException
    {
        
            FileReader fr = new FileReader("");
        
    }
    
    private static void testNullPointerException()
    {
        String myString=null;
        System.out.println(myString.toUpperCase());
    }
}
