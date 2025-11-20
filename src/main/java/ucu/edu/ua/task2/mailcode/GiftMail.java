package ucu.edu.ua.task2.mailcode;

import ucu.edu.ua.task2.Client;

public class GiftMail implements MailCode {
    @Override
    public String generate(Client client) {
        return "You have received a gift, " + client.getName() + "!";
    }
}
