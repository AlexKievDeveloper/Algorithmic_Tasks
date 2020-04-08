package BestMailService;

public class UntrustworthyMailWorker implements MailService {

    private MailService[] mailServices;
    private RealMailService realMailService = new RealMailService();

    public UntrustworthyMailWorker(MailService[] mailServicesArray) {
        mailServices = mailServicesArray;
    }

    public RealMailService getRealMailService() {
        return realMailService;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        Sendable m = mail;
        for (MailService service : mailServices) {
            m = service.processMail(m);
            System.out.println(m);
        }
        System.out.println();
        return getRealMailService().processMail(m);
    }
}
