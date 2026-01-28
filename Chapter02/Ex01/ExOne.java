public class ExOne {
    static class DatabaseConnection {
        private static DatabaseConnection instance;

        private DatabaseConnection() {
            System.out.println("Tạo kết nối cơ sở dữ liệu...");
        }

        public static DatabaseConnection getInstance() {
            if (instance == null) {
                instance = new DatabaseConnection();
            }
            return instance;
        }

        public void connect() {
            System.out.println("Kết nối đến cơ sở dữ liệu thành công!");
        }

        public void disconnect() {
            System.out.println("Ngắt kết nối cơ sở dữ liệu.");
        }
    }

    class test {
        public static void main(String[] args) {
            DatabaseConnection db1 = DatabaseConnection.getInstance();
            db1.connect();
            DatabaseConnection db2 = DatabaseConnection.getInstance();
            db2.connect();
            if (db1 == db2) {
                System.out.println("Database 1 và Database 2 cùng 1 instance");
            } else {
                System.out.println("Database 1 và Database 2 là những instance khác nhau");
            }
            db1.disconnect();
        }
    }
}