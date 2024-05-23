package bai2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Main extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;

    public Main() {
        setTitle("Database Tables");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLSV;user=sa;password=Hocsinhgioi3;trustServerCertificate=true;";
        try (Connection conn = DriverManager.getConnection(connectionUrl)) {
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet rsTables = metaData.getTables(null, null, "%", new String[]{"TABLE"});

            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Table Name");

            while (rsTables.next()) {
                String tableName = rsTables.getString("TABLE_NAME");
                tableModel.addRow(new Object[]{tableName});
            }

            table = new JTable(tableModel);
            scrollPane = new JScrollPane(table);
            add(scrollPane, BorderLayout.CENTER);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
