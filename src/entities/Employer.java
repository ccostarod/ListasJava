package entities;

public class Employer {
    private String name;
    private int id;

    private double salary;

    public int getId() {
        return id;
    }



    public Employer(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void increaseSalary(double percentage){
        salary += salary * percentage/100;
    }

    @Override
    public String toString() {
        return name + ", " + id + ", " + salary;

    }
}
