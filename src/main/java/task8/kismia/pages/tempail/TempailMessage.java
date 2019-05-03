package task8.kismia.pages.tempail;

public class TempailMessage {
    public TempailMessage(String sender, String subject, String link) {
        this.sender = sender;
        this.subject = subject;
        this.link = link;
    }

    private String sender;
    private String subject;
    private String link;

    public String getSender() {
        return sender;
    }

    public String getSubject() {
        return subject;
    }

    public String getLink() {
        return link;
    }
}
