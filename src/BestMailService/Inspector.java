package BestMailService;

public class Inspector implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage tempMailPackage = (MailPackage) mail;
            if (tempMailPackage.getContent().getContent().contains("weapons") ||
                    tempMailPackage.getContent().getContent().contains("banned substance")) {
                throw new IllegalPackageException();
            } else if (tempMailPackage.getContent().getContent().contains("stones")) {
                throw new StolenPackageException();
            }
        }
        return mail;
    }
}
