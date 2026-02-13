package Locations;

import Exceptions.DelFromLocationException;
import People.*;

import java.util.ArrayList;
import java.util.Objects;

public final class Hospital extends Location {
    private ArrayList<MiniGuy> population;
    private Doctor doctor;

    public Hospital(String name) {
        super(name);
        this.population = new ArrayList<>();
    }

    public static Hospital hospitalCreation(City city) {
        Hospital hospital = new Hospital("Больничка");
        Doctor doc = new Doctor("Медуница", 15, hospital);
        hospital.setDoctor(doc);
        ArrayList<MiniGuy> population = city.getPopulation();
        ((CityGuy) population.get(population.size() - 1)).moveTo(hospital);
        ((CityGuy) population.get(population.size() - 1)).moveTo(hospital);
        System.out.println();
        return hospital;
    }

    @Override
    public void add(Object obj) {
        MiniGuy citizen = (MiniGuy) obj;
        population.add(citizen);
    }

    @Override
    public void del(Object obj) {
        MiniGuy citizen = (MiniGuy) obj;
        if (!population.remove(citizen)) {
            throw new DelFromLocationException("Такого коротышки в больнице нет");
        }
    }

    public void setDoctor(Doctor doctor) {this.doctor = doctor;}
    public Doctor getDoctor() {return doctor;}
    public ArrayList<MiniGuy> getPopulation() {return population;}

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) {return false;}
        Hospital that = (Hospital) obj;
        return Objects.equals(that.name, name) && Objects.equals(that.population, population) && Objects.equals(that.doctor, doctor);
    }

    @Override
    public int hashCode() {return Objects.hash(name, population, doctor);}

    @Override
    public String toString() {
        return String.format("Hospital{name='%s', population='%s', doctor='%s'}", name, population, doctor.getName());
    }
}
