package BestMailService;

public class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        return mail;
    }
}