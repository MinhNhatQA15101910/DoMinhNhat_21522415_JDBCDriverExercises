import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLSV;user=sa;password=Hocsinhgioi3;trustServerCertificate=true;";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(connectionUrl);

            statement = connection.createStatement();

            String sql = "SELECT * FROM SinhVien";

            // Execute the query and get the result set
            resultSet = statement.executeQuery(sql);

            // Process the result set
            while (resultSet.next()) {
                System.out.println("MaSV: " + resultSet.getString("MaSV"));
                System.out.println("HoTen: " + resultSet.getString("HoTen"));
                System.out.println("Lop: " + resultSet.getString("Lop"));
                System.out.println("DiemTB: " + resultSet.getFloat("DiemTB"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in reverse order of their creation
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
