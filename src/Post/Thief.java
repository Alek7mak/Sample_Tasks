package Post;

public class Thief implements MailService {

    private int minPrice;
    private int stolenPrice = 0;

    public Thief(int price) {
        minPrice = price;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail.getClass() == MailPackage.class) {
            Package pac = ((MailPackage) mail).getContent();

            if (pac.getPrice() >= minPrice) {
                stolenPrice += pac.getPrice();
                mail = new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of " + pac.getContent(), 0));
            }
        }
        return mail;
    }

    public int getStolenValue() {
        return stolenPrice;
    }
}