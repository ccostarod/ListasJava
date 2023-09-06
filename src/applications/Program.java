package applications;


import entities.Employer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;

        System.out.print("How many employees will be registered? ");
        size = sc.nextInt();
        List<Employer> employers = new ArrayList<>();
        int cont = 1;

        while(employers.size() < size){
            String name;
            int id;
            double salary;
            System.out.println("Emplyoee #" + cont + ": ");

            System.out.print("ID: ");
            id = sc.nextInt();
            while (hasId(employers, id)){
                System.out.println("This ID already exists, Try another ID!");
                System.out.print("ID: ");
                id = sc.nextInt();
            }
            System.out.print("Name: ");
            name = sc.next();
            sc.nextLine();
            System.out.print("Salary: ");
            salary = sc.nextDouble();
            Employer emp = new Employer(name, id, salary);

            employers.add(emp);
            cont++;
            System.out.println();
        }


        System.out.print("Enter the employee id that will have salary increase: ");
        int escolhaId = sc.nextInt();
        Employer emp = employers.stream().filter(x -> x.getId() == escolhaId).findFirst().orElse(null);

        if (emp == null){
            System.out.println("The id does not exist!");
        }
        else {
            System.out.print("Enter the percentage: ");
            double escolhaPercentage = sc.nextDouble();
            emp.increaseSalary(escolhaPercentage);
        }

        System.out.println();
        System.out.println("List of Employees (Name, Id, Salary): ");
        for (Employer e : employers){
            System.out.println(e);
        }
        sc.close();

    }

    public static boolean hasId(List<Employer> list, int id) {
        Employer emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }

}
