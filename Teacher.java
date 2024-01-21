package oopSeminar5HW;

public class Teacher {
    private String name;
    private String surname;
    private int age;
    private String subgect;

    public Teacher(String name, String surname, int age, String subgect) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.subgect = subgect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSubgect() {
        return subgect;
    }

    public void setSubgect(String subgect) {
        this.subgect = subgect;
    }

    @Override
    public String toString() {
        return "Учитель: " + name + " " + surname +
                ". Возраст: " + age + ". Предмет: " + subgect;
    }
}
