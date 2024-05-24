package bai3.pl.forms;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    private final JTabbedPane tabbedPane;

    public App() {
        setTitle("Quản lý sinh viên và lớp học");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Sinh Viên", new StudentManagementTab());
        tabbedPane.addTab("Lớp", new ClassManagementTab());

        add(tabbedPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::new);
    }
}