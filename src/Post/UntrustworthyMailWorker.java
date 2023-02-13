package Post;

public class UntrustworthyMailWorker implements MailService {

    private final MailService[] workers;
    private final RealMailService realWorker;


    public UntrustworthyMailWorker(MailService[] workers) {
        this.workers = workers;
        this.realWorker = new RealMailService();
    }

    @Override
    public Sendable processMail(Sendable mail) {

        for (MailService worker : workers) {
            mail = worker.processMail(mail);
        }

        return realWorker.processMail(mail);
    }

    public RealMailService getRealMailService() {
        return realWorker;
    }
}

/*
1) UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты, который вместо того,
чтобы передать почтовый объект непосредственно в сервис почты, последовательно передает этот объект набору третьих лиц,
а затем, в конце концов, передает получившийся объект непосредственно экземпляру RealMailService.
У UntrustworthyMailWorker должен быть конструктор от массива MailService
(результат вызова processMail первого элемента массива передается на вход processMail второго элемента, и т. д.)
и метод getRealMailService, который возвращает ссылку на внутренний экземпляр RealMailService.
 */