package Post;

import java.util.logging.Logger;

public class Spy implements MailService {

    private final Logger LOGGER;

    public Spy(Logger logger) {
         LOGGER = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail.getClass() == MailMessage.class) {
            MailMessage mailMessage = (MailMessage) mail;
            String from = mailMessage.getFrom();
            String to = mailMessage.getTo();

            if (from.equals("AUSTIN_POWERS") || to.equals("AUSTIN_POWERS")) {
                LOGGER.warning("Detected target mail correspondence: from " + from + " to " + to + " \""
                        + mailMessage.getMessage() + "\"");
            } else {
                LOGGER.info("Usual correspondence: from " + from + " to " + to + "");
            }
        }
        return mail;
    }
}
