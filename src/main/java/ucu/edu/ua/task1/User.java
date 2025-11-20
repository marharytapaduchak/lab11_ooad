package ucu.edu.ua.task1;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

enum Gender {
    MALE, FEMALE
}

@SuperBuilder
@ToString(callSuper = true)
public class User extends Human{
    private String name;
    private int age;
    private Gender gender;
    private double weight;
    private double height;

    // через те що у нас є Builder можемо це не писати

    // public User(String name, int age, Gender gender, double weight, double height) {
    //     this.name = name;
    //     this.gender = gender;
    //     this.age = age;
    //     this.weight = weight;
    //     this.height = height;
    // }

    // public User(String name, int age, Gender gender) {
    //     this.name = name;
    //     this.gender = gender;
    //     this.age = age;
    //     this.weight = 0;
    //     this.height = 0;
    // }

    // public User(String name, Gender gender) {
    //     this.name = name;
    //     this.gender = gender;
    //     this.age = 0;
    //     this.weight = 0;
    //     this.height = 0;
    // }

    // public User(String name) {
    //     this.name = name;
    //     this.gender = null;
    //     this.age = 0;
    //     this.weight = 0;
    //     this.height = 0;
    // }
}