package ucu.edu.ua.task2;

import java.util.UUID;

import lombok.Getter;

@Getter
public class Client {
    private UUID id;
    private String name;
    private int age;
    private Gender sex;
    private String email;

    public Client(String name, int age, Gender sex, String email) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.id = UUID.randomUUID();
        this.email = email;
    }
    public String getEmail() { return email; }
    public String getName()  { return name; }
}
