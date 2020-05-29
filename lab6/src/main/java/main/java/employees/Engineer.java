package main.java.employees;

public class Engineer implements Employee {
    protected int id;
    protected String name;
    protected String surname;
    protected String department;
    protected String currentProject;

    public Engineer(int id, String name, String surname, String department, String currentProject) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.currentProject = currentProject;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String getFullName() {
        return name + " " + surname;
    }

    @Override
    public String getDepartment() {
        return department;
    }

    @Override
    public String getCurrentProject() {
        return currentProject;
    }

    @Override
    public String toString() {
        return "Engineer №" + id + ":\n" +
                this.getFullName() + '\n' +
                "Department: " + department + '\n' +
                "Current project: " + currentProject + '\n';
    }

    @Override
    public void show() {
        System.out.println(this.toString());
    }
}
