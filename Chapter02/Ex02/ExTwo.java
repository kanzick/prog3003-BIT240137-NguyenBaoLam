interface Notification {
    void notifyUser();
}

class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Gửi thông báo qua SMS...");
    }
}

class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Gửi thông báo qua Email...");
    }
}

class PushNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Gửi thông báo Push...");
    }
}

class NotificationFactory {
    public static Notification createNotification(String channel) {
        if (channel == null) {
            return null;
        }

        if (channel.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        } else if (channel.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        } else if (channel.equalsIgnoreCase("PUSH")) {
            return new PushNotification();
        }

        return null;
    }
}

class ExTwo {
    public static void main(String[] args) {
        Notification sms = NotificationFactory.createNotification("SMS");
        sms.notifyUser();

        Notification email = NotificationFactory.createNotification("EMAIL");
        email.notifyUser();

        Notification push = NotificationFactory.createNotification("PUSH");
        push.notifyUser();
    }
}
