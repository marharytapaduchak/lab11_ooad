package ucu.edu.ua;

import ucu.edu.ua.task2.Client;
import ucu.edu.ua.task2.Gender;
import ucu.edu.ua.task2.MailBox;
import ucu.edu.ua.task2.MailInfo;
import ucu.edu.ua.task2.mailcode.BirthdayMail;
import ucu.edu.ua.task2.mailcode.MailCode;


public class Main {
    public static void main(String[] args) throws Exception {
    Client c1 = new Client("Margo", 18, Gender.FEMALE, "paduchak.pn@ucu.edu.ua");
    MailCode birthday = new BirthdayMail();

    MailInfo info = new MailInfo(c1, birthday);

    MailBox box = new MailBox();
    box.addMailInfo(info);
    box.sendAll();    // реально піде лист через Mailjet
}

}