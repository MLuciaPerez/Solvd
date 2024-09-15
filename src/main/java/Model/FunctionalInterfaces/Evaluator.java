package Model.FunctionalInterfaces;

import Model.Classes.Person;

public interface Evaluator< T extends Person, R> {
    R evaluate(T patient);
}
