package Model.FunctionalInterfaces;

import Model.Classes.Person;

public interface Transformer<T extends Person, R> {
    R transform(T patient);
}
