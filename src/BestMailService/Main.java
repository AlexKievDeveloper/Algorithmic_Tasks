package BestMailService;

import java.util.logging.Logger;
//SHORT VERSION ONLY MAIN CLASSES WITH EXCEPTIONS

/*public static class UntrustworthyMailWorker implements MailService {
    private MailService[] mailServices;
    private RealMailService realMailService = new RealMailService();

    public UntrustworthyMailWorker(MailService[] mailServicesArray) {
        mailServices = mailServicesArray;
    }

    public RealMailService getRealMailService () {
        return realMailService;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        Sendable m = mail;

        for (MailService service:mailServices) {
            m = service.processMail(m);
        }
        return getRealMailService().processMail(m);
    }
}

public static class Spy implements MailService {
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
                        new Object[] {temp.getFrom(), temp.getTo(), temp.getMessage()});
            }
            else {
                spyLogger.log(Level.INFO, "Usual correspondence: from {0} to {1}", new Object[] {temp.from, temp.to});
            }
        }
        return mail;
    }
}

public static class Thief implements MailService {
    int minCostOfPackage;
    private static int stolenValue = 0;

    public Thief (int minCostOfPackage) {
        this.minCostOfPackage = minCostOfPackage;
    }

    public int getStolenValue(){
        return stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage){
            MailPackage tempMail = (MailPackage) mail;
            if (tempMail.getContent().getPrice() >= minCostOfPackage){
                Package tempPackage = new Package("stones instead of " + tempMail.getContent().getContent(), 0);
                stolenValue = stolenValue + tempMail.getContent().getPrice();
                return new MailPackage(tempMail.from, tempMail.to, tempPackage);
            }
        }
        return mail;
    }
}

public static class Inspector implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage){
            MailPackage tempMailPackage = (MailPackage) mail;
            if (tempMailPackage.getContent().getContent().contains("weapons") ||
                    tempMailPackage.getContent().getContent().contains("banned substance")){
                throw new IllegalPackageException();
            }
            else if (tempMailPackage.getContent().getContent().contains("stones")){
                throw new StolenPackageException();
            }
        }
        return mail;
    }
}

public static class IllegalPackageException extends RuntimeException {
    public IllegalPackageException() {
    }
}

public static class StolenPackageException extends RuntimeException {
    public StolenPackageException() {
    }
}*/

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getLogger(MailMessage.class.getName());
        Spy spy1 = new Spy(logger1);
        Inspector inspector1 = new Inspector();
        Thief thief1 = new Thief(20);
        MailService[] array = new MailService[]{spy1, inspector1, thief1};
        UntrustworthyMailWorker worker1 = new UntrustworthyMailWorker(array);
        MailMessage message1 = new MailMessage("Alex", "Polly", "Hello, dear");
        System.out.println(worker1.processMail(message1));
    }
}


