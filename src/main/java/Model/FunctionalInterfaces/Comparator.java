package Model.FunctionalInterfaces;

import Model.Classes.Person;

public interface Comparator<T extends Person> {
    int compare(T patient1, T patient2);
}