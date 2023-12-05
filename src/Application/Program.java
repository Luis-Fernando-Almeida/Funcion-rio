package Application;

import Entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();

        List<Employee> list = new ArrayList<>();

        for (int i=0; i<n; i++){
            System.out.println();
            System.out.printf("Employee #%d:\n", i + 1);

            System.out.print("Id: ");
            int id = sc.nextInt();
            while (hasId(list, id)){
                System.out.println("Id already taken! Try again:");
                System.out.print("Id: ");
                id = sc.nextInt();
            }
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            Employee emp = new Employee(id, name, salary);
            list.add(emp);
        }

        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        int idsalary = sc.nextInt();

        //Integer pos = position(list,idsalary); As linhas comentadas representam outra forma de resolver a questão.

        Employee emp = list.stream().filter(x-> x.getId() == idsalary).findFirst().orElse(null);

        //if (pos == null){
        if (emp == null){
            System.out.println("This id does not exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percent = sc.nextDouble();
            //list.get(pos).increaseSalary(percent);
            emp.increaseSalary(percent);
        }

        System.out.println();
        System.out.println("List of employees:");
        for (Employee x : list){
            System.out.println(x);
        }

        sc.close();
    }
    public static Integer position(List<Employee> list, int id){
        for (int i=0; i< list.size(); i++){
            if (list.get(i).getId() == id){
                return i;
            }
        }
        return null;
    }
    public static boolean hasId(List<Employee> list, int id){
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}
