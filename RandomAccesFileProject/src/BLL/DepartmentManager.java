/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Department;
import DAL.DepartmentPersistensManager;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author bhp
 */
public class DepartmentManager
{

    private static final String FILE_NAME = "Departments.dat";

    private DepartmentPersistensManager dpm;

    public DepartmentManager()
    {
        dpm = new DepartmentPersistensManager(FILE_NAME);
    }

    public void addDepartment(Department d)
    {
        try
        {
            dpm.addDepartment(d);
        } catch (IOException ex)
        {
            throw new RuntimeException("Unable to save department");
        }
    }

    public List<Department> getAll()
    {
        try
        {
            return dpm.getAll();
        } catch (IOException ex)
        {
            throw new RuntimeException("Unable to read departments");
        }
    }

    public Department getById(int departmentId)
    {
        try
        {
            return dpm.getById(departmentId);
        } catch (IOException ex)
        {
            throw new RuntimeException("Unable to read department");
        }
    }

    public void delete(Department d)
    {

        try
        {
            dpm.deleteById(d.getId());
        } catch (IOException ex)
        {
            throw new RuntimeException("Unable to delete department");
        }

    }

}
