public class NotificationWithoutDecorator {

    static class Notifier {
        public void send(String message) {
            System.out.println("Sending Email: " + message);
        }
    }

    static class EmailNotifier extends Notifier {
        @Override
        public void send(String message) {
            super.send(message);
        }
    }

    static class EmailAndSMSNotifier extends Notifier {
        @Override
        public void send(String message) {
            super.send(message);
            sendSMS(message);
        }

        private void sendSMS(String message) {
            System.out.println("Sending SMS: " + message);
        }
    }

    static class EmailAndSMSAndFacebookNotifier extends Notifier {
        @Override
        public void send(String message) {
            super.send(message);
            sendSMS(message);
            sendFacebook(message);
        }

        private void sendSMS(String message) {
            System.out.println("Sending SMS: " + message);
        }

        private void sendFacebook(String message) {
            System.out.println("Sending Facebook Notification: " + message);
        }
    }

    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        System.out.println("Email Notification:");
        notifier.send("System update completed");

        notifier = new EmailAndSMSNotifier();
        System.out.println("\nEmail + SMS Notification:");
        notifier.send("System update completed");

        notifier = new EmailAndSMSAndFacebookNotifier();
        System.out.println("\nEmail + SMS + Facebook Notification:");
        notifier.send("Critical system alert");

        // YA SADECE FACEBOOK VE SMS BİLDİRİMİ GÖNDERMEK İSTESEYDİM?
    }
}