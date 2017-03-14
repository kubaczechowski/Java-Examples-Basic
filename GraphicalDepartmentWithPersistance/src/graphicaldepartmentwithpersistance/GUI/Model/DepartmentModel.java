/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicaldepartmentwithpersistance.GUI.Model;

import graphicaldepartmentwithpersistance.BE.Department;
import graphicaldepartmentwithpersistance.BLL.DepartmentManager;
import graphicaldepartmentwithpersistance.util.DepartmentException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author jeppjleemoritzled
 */
public class DepartmentModel
{
    private final ObservableList<Department> deptList;
private final DepartmentManager manager = new DepartmentManager();
    public DepartmentModel()
    {
        this.deptList = FXCollections.observableArrayList();
    }

    public ObservableList<Department> getDepartmentList()
    {
        return deptList;
    }
    
    private void setDepartments(List<Department> depts)
    {
        deptList.clear();
        deptList.addAll(depts);
    }
    
    public void loadDepartments() throws DepartmentException
    {
        setDepartments(manager.getAll());
    }
}
