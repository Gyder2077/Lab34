package Locations;

import Exceptions.DelFromLocationException;
import People.*;

import java.util.ArrayList;
import java.util.Objects;

public final class Hospital extends Location {
    private ArrayList<MiniPEKKA> population;
    private Doctor doctor;

    public Hospital(String name) {
        super(name);
        this.population = new ArrayList<>();
    }

    @Override
    public void add(Object obj) {
        MiniPEKKA citizen = (MiniPEKKA) obj;
        population.add(citizen);
    }

    @Override
    public void del(Object obj) {
        MiniPEKKA citizen = (MiniPEKKA) obj;
        if (!population.remove(citizen)) {
            throw new DelFromLocationException("Такого коротышки в больнице нет");
        }
    }

    public void setDoctor(Doctor doctor) {this.doctor = doctor;}
    public Doctor getDoctor() {return doctor;}
    public ArrayList<MiniPEKKA> getPopulation() {return population;}
    public void setPopulation(ArrayList<MiniPEKKA> population) {this.population = population;}

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
