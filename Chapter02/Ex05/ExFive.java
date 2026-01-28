interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Email được gửi: " + message);
    }
}

class SMSService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS được gửi: " + message);
    }
}

public class ExFive {
    static class Notification {
        private MessageService messageService;
        
        public void setMessageService(MessageService messageService) {
            this.messageService = messageService;
        }
        
        public void notify(String message) {
            if (messageService == null) {
                System.out.println("Lỗi: Chưa chọn dịch vụ gửi tin!");
                return;
            }
            messageService.sendMessage(message);
        }
    }
    public static void main(String[] args) {
        Notification notification = new Notification();
        
        System.out.println("=== Gửi thông báo qua Email ===");
        MessageService emailService = new EmailService();
        notification.setMessageService(emailService);
        notification.notify("Chào bạn! Đây là email thông báo.");
        
        System.out.println("\n=== Gửi thông báo qua SMS ===");
        MessageService smsService = new SMSService();
        notification.setMessageService(smsService);
        notification.notify("Chào bạn! Đây là tin nhắn SMS.");
        
        System.out.println("\n=== Chuyển lại sang Email ===");
        notification.setMessageService(emailService);
        notification.notify("Bạn có một tin nhắn mới từ hệ thống.");
    }
}
