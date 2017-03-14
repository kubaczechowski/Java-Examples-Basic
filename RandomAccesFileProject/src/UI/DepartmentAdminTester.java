/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BE.Department;
import BLL.DepartmentManager;
import java.util.Scanner;

/**
 *
 * @author bhp
 */
public class DepartmentAdminTester
{

    private DepartmentManager mgr;

    public DepartmentAdminTester()
    {
        mgr = new DepartmentManager();
    }

    public void run()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter department id: ");
        int id = sc.nextInt();

        sc.skip("\n");

        System.out.print("Enter department name: ");
        String name = sc.nextLine();

        mgr.addDepartment(new Department(id, name));

        System.out.println("All Departments: ");
        System.out.println("ID   NAME");
        for (Department d : mgr.getAll())
        {
            System.out.println(d);
        }

        System.out.print("Enter department id: ");
        id = sc.nextInt();

        Department d = mgr.getById(id);
        if (d != null)
        {
            System.out.println(d);
        }
        else
        {
            System.out.println("Not found");
        }
    }
}
