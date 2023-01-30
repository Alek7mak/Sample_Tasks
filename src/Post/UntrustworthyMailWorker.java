package Post;

public class UntrustworthyMailWorker implements MailService {

    private static MailService[] workers;
    private static RealMailService realWorker = new RealMailService();

    @Override
    public Sendable processMail(Sendable mail) {
        Sendable sendable = mail;

        for (MailService worker : workers) {
            sendable = worker.processMail(sendable);
        }
        return realWorker.processMail(mail);
    }

    public UntrustworthyMailWorker(MailService[] w) {
        workers = w;
    }

    public MailService getRealMailService() {
        return realWorker;
    }
}