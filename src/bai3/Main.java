package bai3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Main extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel sinhVienPanel;
    private JPanel lopPanel;

    private JTable sinhVienTable;
    private JTable lopTable;

    private DefaultTableModel sinhVienTableModel;
    private DefaultTableModel lopTableModel;

    private Connection connection;

    public Main() {
        setTitle("Quản lý sinh viên và lớp học");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize tabbed pane
        tabbedPane = new JTabbedPane();

        // Initialize panels
        sinhVienPanel = new JPanel();
        sinhVienPanel = new JPanel(new BorderLayout());
        lopPanel = new JPanel(new BorderLayout());

        // Initialize tables
        sinhVienTableModel = new DefaultTableModel(new String[]{"MaSV", "HoTen", "Lop", "DiemTB"}, 0);
        sinhVienTable = new JTable(sinhVienTableModel);

        lopTableModel = new DefaultTableModel(new String[]{"MaLop", "TenLop", "CVHT"}, 0);
        lopTable = new JTable(lopTableModel);

        // Add tables to panels
        sinhVienPanel.add(new JScrollPane(sinhVienTable), BorderLayout.CENTER);
        lopPanel.add(new JScrollPane(lopTable), BorderLayout.CENTER);

        // Add control panels
        sinhVienPanel.add(createSinhVienControlPanel(), BorderLayout.SOUTH);
        lopPanel.add(createLopControlPanel(), BorderLayout.SOUTH);

        // Add panels to tabbed pane
        tabbedPane.addTab("Sinh Viên", sinhVienPanel);
        tabbedPane.addTab("Lớp", lopPanel);

        // Add tabbed pane to frame
        add(tabbedPane, BorderLayout.CENTER);

        // Establish database connection
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSV;user=sa;password=Hocsinhgioi3;trustServerCertificate=true;";
        try {
            connection = DriverManager.getConnection(url);
            loadSinhVienData();
            loadLopData();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    private JPanel createSinhVienControlPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 4));

        JTextField maSVField = new JTextField();
        JTextField hoTenField = new JTextField();
        JTextField lopField = new JTextField();
        JTextField diemTBField = new JTextField();

        panel.add(new JLabel("MaSV:"));
        panel.add(maSVField);
        panel.add(new JLabel("HoTen:"));
        panel.add(hoTenField, 1);
        panel.add(new JLabel("Lop:"));
        panel.add(lopField);
        panel.add(new JLabel("DiemTB:"));
        panel.add(diemTBField);

        JButton addButton = new JButton("Thêm");
        JButton updateButton = new JButton("Sửa");
        JButton deleteButton = new JButton("Xóa");

        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String sql = "INSERT INTO SinhVien (MaSV, HoTen, Lop, DiemTB) VALUES (?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, Integer.parseInt(maSVField.getText()));
                    statement.setString(2, hoTenField.getText());
                    statement.setString(3, lopField.getText());
                    statement.setFloat(4, Float.parseFloat(diemTBField.getText()));
                    statement.executeUpdate();
                    loadSinhVienData();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String sql = "UPDATE SinhVien SET HoTen = ?, Lop = ?, DiemTB = ? WHERE MaSV = ?";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, hoTenField.getText());
                    statement.setString(2, lopField.getText());
                    statement.setFloat(3, Float.parseFloat(diemTBField.getText()));
                    statement.setInt(4, Integer.parseInt(maSVField.getText()));
                    statement.executeUpdate();
                    loadSinhVienData();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String sql = "DELETE FROM SinhVien WHERE MaSV = ?";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, Integer.parseInt(maSVField.getText()));
                    statement.executeUpdate();
                    loadSinhVienData();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        return panel;
    }

    private JPanel createLopControlPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 3));

        JTextField maLopField = new JTextField();
        JTextField tenLopField = new JTextField();
        JTextField cvhtField = new JTextField();

        panel.add(new JLabel("MaLop:"));
        panel.add(maLopField);
        panel.add(new JLabel("TenLop:"));
        panel.add(tenLopField);
        panel.add(new JLabel("CVHT:"));
        panel.add(cvhtField);

        JButton addButton = new JButton("Thêm");
        JButton updateButton = new JButton("Sửa");
        JButton deleteButton = new JButton("Xóa");

        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String sql = "INSERT INTO Lop (MaLop, TenLop, CVHT) VALUES (?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, Integer.parseInt(maLopField.getText()));
                    statement.setString(2, tenLopField.getText());
                    statement.setString(3, cvhtField.getText());
                    statement.executeUpdate();
                    loadLopData();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String sql = "UPDATE Lop SET TenLop = ?, CVHT = ? WHERE MaLop = ?";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, tenLopField.getText());
                    statement.setString(2, cvhtField.getText());
                    statement.setInt(3, Integer.parseInt(maLopField.getText()));
                    statement.executeUpdate();
                    loadLopData();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String sql = "DELETE FROM Lop WHERE MaLop = ?";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, Integer.parseInt(maLopField.getText()));
                    statement.executeUpdate();
                    loadLopData();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        return panel;
    }

    private void loadSinhVienData() {
        try {
            String sql = "SELECT * FROM SinhVien";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            sinhVienTableModel.setRowCount(0);
            while (rs.next()) {
                sinhVienTableModel.addRow(new Object[]{
                        rs.getInt("MaSV"),
                        rs.getString("HoTen"),
                        rs.getString("Lop"),
                        rs.getFloat("DiemTB")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadLopData() {
        try {
            String sql = "SELECT * FROM Lop";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            lopTableModel.setRowCount(0);
            while (rs.next()) {
                lopTableModel.addRow(new Object[]{
                        rs.getString("MaLop"),
                        rs.getString("TenLop"),
                        rs.getString("CVHT")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}

