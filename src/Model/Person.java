package Model;

public abstract class Person {
    protected String name;  // Protected modifier
    protected int age;      // Protected modifier

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Abstract method to be implemented by subclasses
    public abstract void performDuties();

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Override toString() method from Object class
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }

    // Override hashCode() method from Object class
    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    // Override equals() method from Object class
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }
}