package ucu.edu.ua.task2;

import com.mailjet.client.*;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;

import ucu.edu.ua.DotenvConfig;

import org.json.JSONArray;
import org.json.JSONObject;

public class MailSender {

    private final MailjetClient client;

    public MailSender() {
        String apiKey = DotenvConfig.get("MAILJET_API_KEY");
        String apiSecret = DotenvConfig.get("MAILJET_API_SECRET");
        this.client = new MailjetClient(apiKey, apiSecret, new ClientOptions("v3.1"));
    }

    public void sendMail(MailInfo info)
            throws MailjetException, MailjetSocketTimeoutException {

        String toEmail = info.getClient().getEmail();
        String toName  = info.getClient().getName();
        String html    = info.generate();
        String subject = "Our awesome newsletter";

        MailjetRequest request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", "margo.paduchak@gmail.com")
                                        .put("Name", "Marharyta Paduchak"))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", toEmail)
                                                .put("Name", toName)))
                                .put(Emailv31.Message.SUBJECT, subject)
                                .put(Emailv31.Message.HTMLPART, html)));

        MailjetResponse response = client.post(request);
        System.out.println("Status: " + response.getStatus());
        System.out.println("Data: " + response.getData());
    }
}
