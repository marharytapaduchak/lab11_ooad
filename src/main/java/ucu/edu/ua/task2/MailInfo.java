package ucu.edu.ua.task2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ucu.edu.ua.task2.mailcode.MailCode;

@Getter
@AllArgsConstructor
public class MailInfo {
    private Client client;
    private MailCode mailCode;

    public String generate() {
        return mailCode.generate(client);
    }
}
