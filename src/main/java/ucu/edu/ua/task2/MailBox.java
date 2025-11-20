package ucu.edu.ua.task2;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;

import java.util.ArrayList;
import java.util.List;

public class MailBox {
    private List<MailInfo> infos = new ArrayList<>();

    public void addMailInfo(MailInfo info) {
        infos.add(info);
    }

    public void sendAll() throws MailjetException, MailjetSocketTimeoutException {
        MailSender sender = new MailSender();
        for (MailInfo info : infos) {
            sender.sendMail(info);
        }
        infos.clear();
    }
}

