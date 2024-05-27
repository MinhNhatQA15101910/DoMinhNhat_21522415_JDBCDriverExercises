package bai3.pl.forms;

import bai3.dto.models.SinhVienDTO;
import bai3.pl.interfaces.IAddUpdateStudentRequester;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUpdateStudentForm extends JFrame {
    private IAddUpdateStudentRequester _addUpdateStudentRequester;
    private SinhVienDTO _student = null;

    private JTextField maSVTextField;
    private JTextField hoTenTextField;
    private JTextField lopTextField;
    private JTextField diemTBField;
    private JButton featureBtn;

    public AddUpdateStudentForm(IAddUpdateStudentRequester requester) {
        _addUpdateStudentRequester = requester;

        setTitle("Thêm sinh viên");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        maSVTextField = new JTextField();
        hoTenTextField = new JTextField();
        lopTextField = new JTextField();
        diemTBField = new JTextField();
        featureBtn = new JButton("Thêm");

        // Setup layout
        setLayout(new BorderLayout(10, 10));

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(4, 2, 10, 10));
        infoPanel.add(new JLabel("MSSV:"));
        infoPanel.add(maSVTextField);
        infoPanel.add(new JLabel("Họ tên"));
        infoPanel.add(hoTenTextField);
        infoPanel.add(new JLabel("Lớp:"));
        infoPanel.add(lopTextField);
        infoPanel.add(new JLabel("Điểm TB:"));
        infoPanel.add(diemTBField);
        add(infoPanel, BorderLayout.CENTER);

        JPanel featurePanel = new JPanel();
        featurePanel.setLayout(new BorderLayout(10, 10));
        featurePanel.add(featureBtn, BorderLayout.CENTER);
        add(featurePanel, BorderLayout.SOUTH);

        // Add action listeners
        featureBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });
    }

    public AddUpdateStudentForm(IAddUpdateStudentRequester requester, SinhVienDTO student) {
        _addUpdateStudentRequester = requester;
        _student = student;

        setTitle("Cập nhật sinh viên");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        maSVTextField = new JTextField();
        maSVTextField.setText(student.getMaSV());
        hoTenTextField = new JTextField();
        hoTenTextField.setText(student.getHoTen());
        lopTextField = new JTextField();
        lopTextField.setText(student.getLop());
        diemTBField = new JTextField();
        diemTBField.setText(Float.toString(student.getDiemTB()));
        featureBtn = new JButton("Thêm");

        // Setup layout
        setLayout(new BorderLayout(10, 10));

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(4, 2, 10, 10));
        infoPanel.add(new JLabel("MSSV:"));
        infoPanel.add(maSVTextField);
        infoPanel.add(new JLabel("Họ tên"));
        infoPanel.add(hoTenTextField);
        infoPanel.add(new JLabel("Lớp:"));
        infoPanel.add(lopTextField);
        infoPanel.add(new JLabel("Điểm TB:"));
        infoPanel.add(diemTBField);
        add(infoPanel, BorderLayout.CENTER);

        JPanel featurePanel = new JPanel();
        featurePanel.setLayout(new BorderLayout(10, 10));
        featurePanel.add(featureBtn, BorderLayout.CENTER);
        add(featurePanel, BorderLayout.SOUTH);

        // Add action listeners
        featureBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });
    }

    private void addStudent() {
//        String studentId = studentIdField.getText();
//        String name = nameField.getText();
//        String className = classField.getText();
//        String averageScore = averageScoreField.getText();
//
//        JOptionPane.showMessageDialog(this, "Student added:\n" +
//                "ID: " + studentId + "\nName: " + name + "\nClass: " + className + "\nAverage Score: " + averageScore);
    }

    private void updateStudent() {
//        String studentId = studentIdField.getText();
//        String name = nameField.getText();
//        String className = classField.getText();
//        String averageScore = averageScoreField.getText();
//
//        JOptionPane.showMessageDialog(this, "Student updated:\n" +
//                "ID: " + studentId + "\nName: " + name + "\nClass: " + className + "\nAverage Score: " + averageScore);
    }
}
