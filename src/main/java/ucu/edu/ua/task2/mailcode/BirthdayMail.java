package ucu.edu.ua.task2.mailcode;

import ucu.edu.ua.task2.Client;

public class BirthdayMail implements MailCode {
    @Override
    public String generate(Client client) {
        return "Happy birthday, " + client.getName();
    }
}
