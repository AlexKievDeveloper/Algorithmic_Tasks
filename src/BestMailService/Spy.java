package BestMailService;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Spy implements MailService {
    Logger spyLogger;

    public Spy(Logger logger) {
        spyLogger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {

        if (mail instanceof MailMessage) {
            MailMessage temp = (MailMessage) mail;
            spyLogger = Logger.getLogger(MailMessage.class.getName());
            if (temp.from.equals("Austin Powers") || temp.to.equals("Austin Powers")) {
                spyLogger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                        new Object[]{temp.getFrom(), temp.getTo(), temp.getMessage()});
            } else {
                spyLogger.log(Level.INFO, "Usual correspondence: from {0} to {1}", new Object[]{temp.from, temp.to});
            }
        }
        return mail;
    }
}
