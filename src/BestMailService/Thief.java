package BestMailService;

public class Thief implements MailService {
    int minCostOfPackage;
    private static int stolenValue = 0;

    public Thief(int minCostOfPackage) {
        this.minCostOfPackage = minCostOfPackage;
    }

    public int getStolenValue() {
        return stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage tempMail = (MailPackage) mail;
            if (tempMail.getContent().getPrice() >= minCostOfPackage) {
                Package tempPackage = new Package("stones instead of " + tempMail.getContent().getContent(), 0);
                stolenValue = stolenValue + tempMail.getContent().getPrice();
                return new MailPackage(tempMail.from, tempMail.to, tempPackage);
            }
        }
        return mail;
    }
}
