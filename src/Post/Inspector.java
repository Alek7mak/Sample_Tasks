package Post;

public class Inspector implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail.getClass() == MailPackage.class) {
            if (((MailPackage) mail).getContent().getContent().equals("weapons") ||
                    ((MailPackage) mail).getContent().getContent().equals("banned substance")) {
                throw new IllegalPackageException();
            } else if (((MailPackage) mail).getContent().getContent().contains("stones")) {
                throw new StolenPackageException();
            }
        }
        return mail;
    }
}