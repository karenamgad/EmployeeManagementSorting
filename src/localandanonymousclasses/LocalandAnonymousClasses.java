/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package localandanonymousclasses;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Karen Amgad
 */
public class LocalandAnonymousClasses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Employee e1 = new Employee ("Minne" , "Mouse" ,"11/2/2001");
      Employee e2 = new Employee ("Tom" , "Thomas" ,"31/12/1999");
       Employee e3 = new Employee ("Mickey" , "Mouse" ,"3/1/2012");
        Employee e4 = new Employee ("Jerry" , "Mouse" ,"6/4/2024");
         Employee e5 = new Employee ("Cindrella" , "Princess" ,"23/2/2000");
         List<Employee> list = new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5));
           printOrderedList(list, "name");
        System.out.println();
        printOrderedList(list, "year");

    
         
     
    }
    
    public static void printOrderedList (List<Employee> eList , String sortField) {
        int currentYear = LocalDate.now().getYear();
        
        class MyEmployee {

            Employee containedEmployee;
            int yearsWorked;
            String fullName;

            public MyEmployee(Employee containedEmployee) {
                this.containedEmployee = containedEmployee;
                yearsWorked = currentYear - Integer.parseInt(
                        containedEmployee.hireDate().split("/")[2]);
                fullName = String.join(" ",
                        containedEmployee.firstname() , containedEmployee.lastname());
            }

            @Override
            public String toString() {
                return "%s has been an employee for %d years".formatted(
                        fullName, yearsWorked);
            }
        }
        
      List<MyEmployee> list = new ArrayList<>();
        for (Employee employee : eList) {
            list.add(new MyEmployee(employee));
        }

        var comparator = new Comparator<MyEmployee>() {

            @Override
            public int compare(MyEmployee o1, MyEmployee o2) {

                if (sortField.equals("name")) {
                    return o1.fullName.compareTo(o2.fullName);
                }
                return o1.yearsWorked - o2.yearsWorked;
            }
        };

        list.sort(comparator);

        for (MyEmployee myEmployee : list) {
            System.out.println(myEmployee);
        }
    }
}
