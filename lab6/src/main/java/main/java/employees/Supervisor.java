package main.java.employees;

public class Supervisor extends Engineer {
    private int subordinateCount;

    public Supervisor(int id, String name, String surname, String department, String currentProject, int subordinateCount) {
        super(id, name, surname, department, currentProject);
        this.subordinateCount = subordinateCount;
    }

    @Override
    public String toString() {
        return "Supervisor:\n" + super.toString() + "Subordinate count: " + this.subordinateCount + '\n';
    }

    @Override
    public void show() {
        System.out.println(this.toString());
    }
}
