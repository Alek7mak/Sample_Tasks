package Post;

public class Thief implements MailService {

    private int minPrice;
    private int stolenValue;

    public Thief(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getStolenValue() {
        return stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            Package aPackage = ((MailPackage) mail).getContent();

            if (aPackage.getPrice() >= minPrice) {
                stolenValue += aPackage.getPrice();
                return new MailPackage(
                        mail.getFrom(),
                        mail.getTo(),
                        new Package("stones instead of " + aPackage.getContent() + "", 0));
            }
        }
        return mail;
    }
}

/*
public static final String AUSTIN_POWERS = "Austin Powers";
public static final String WEAPONS = "weapons";
public static final String BANNED_SUBSTANCE = "banned substance";

 Thief – вор, который ворует самые ценные посылки и игнорирует все остальное.
 Вор принимает в конструкторе переменную int – минимальную стоимость посылки, которую он будет воровать.
 Также, в данном классе должен присутствовать метод getStolenValue, который возвращает суммарную стоимость всех посылок, которые он своровал.
  Воровство происходит следующим образом: вместо посылки, которая пришла вору, он отдает новую, такую же,
  только с нулевой ценностью и содержимым посылки "stones instead of {content}".
 */