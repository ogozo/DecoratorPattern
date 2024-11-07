public class Main {
    public static void main(String[] args) throws InterruptedException {
        Notifier notifier = new EmailNotifier();
        System.out.println("Basic Email Notification:");
        notifier.send("System update completed");
        Thread.sleep(1000);

        notifier = new SMSNotifierDecorator(notifier);
        System.out.println("\nEmail + SMS Notification:");
        notifier.send("System update completed");
        Thread.sleep(1000);


        notifier = new FacebookNotifierDecorator(notifier);
        System.out.println("\nEmail + SMS + Facebook Notification:");
        notifier.send("Critical system alert");
        Thread.sleep(1000);

        notifier = new SMSNotifierDecorator(new EmailNotifier());
        System.out.println("\nJust Email + SMS Notification:");
        notifier.send("Scheduled maintenance will begin soon");
        Thread.sleep(1000);

        notifier = new SMSNotifierDecorator(new FacebookNotifierDecorator(new EmailNotifier()));
        System.out.println("\nEmail + Facebook + SMS Notification (different order):");
        notifier.send("Service outage detected!");
    }
}