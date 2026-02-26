import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DeleteUser {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String user = "your_username";
        String password = "your_password";

        int userIdToDelete = 5;

        try {

            Connection conn = DriverManager.getConnection(url, user, password);

            // 2. Tạo PreparedStatement để xóa user theo id
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userIdToDelete);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Đã xóa user với id = " + userIdToDelete);
            } else {
                System.out.println("Không tìm thấy user để xóa");
            }

            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
