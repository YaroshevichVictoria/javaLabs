package main.java;

import main.java.employees.Engineer;
import main.java.employees.Supervisor;

public class Main {
    public static void main(String[] args) {
        Engineer engineer = new Engineer(2, "Ivan", "Ivanov", "pipes", "copper pipes");
        Supervisor supervisor = new Supervisor(1, "Vasya", "Vasil'ev", "pipes", "copper pipes", 10);
        engineer.show();
        supervisor.show();
    }
}