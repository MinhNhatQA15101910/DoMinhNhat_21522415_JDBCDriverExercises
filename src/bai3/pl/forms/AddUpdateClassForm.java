package bai3.pl.forms;

import bai3.dto.LopDTO;
import bai3.dto.SinhVienDTO;
import bai3.pl.interfaces.IAddUpdateClassRequester;
import bai3.pl.interfaces.IAddUpdateStudentRequester;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUpdateClassForm extends JFrame {
    private IAddUpdateClassRequester _addUpdateClassRequester;
    private LopDTO _class = null;

    private JTextField maLopTextField;
    private JTextField tenLopTextField;
    private JTextField cvhtTextField;
    private JButton featureBtn;

    public AddUpdateClassForm(IAddUpdateClassRequester requester) {
        _addUpdateClassRequester = requester;

        setTitle("Thêm lớp");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        maLopTextField = new JTextField();
        tenLopTextField = new JTextField();
        cvhtTextField = new JTextField();
        featureBtn = new JButton("Thêm");

        // Setup layout
        setLayout(new BorderLayout(10, 10));

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(3, 2, 10, 10));
        infoPanel.add(new JLabel("Mã lớp:"));
        infoPanel.add(maLopTextField);
        infoPanel.add(new JLabel("Tên lớp"));
        infoPanel.add(tenLopTextField);
        infoPanel.add(new JLabel("CVHT:"));
        infoPanel.add(cvhtTextField);
        add(infoPanel, BorderLayout.CENTER);

        JPanel featurePanel = new JPanel();
        featurePanel.setLayout(new BorderLayout(10, 10));
        featureBtn = new JButton("Thêm");
        featurePanel.add(featureBtn, BorderLayout.CENTER);
        add(featurePanel, BorderLayout.SOUTH);


        // Add action listeners
        featureBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClass();
            }
        });
    }

    public AddUpdateClassForm(IAddUpdateStudentRequester requester, SinhVienDTO student) {
//        _addUpdateStudentRequester = requester;
//        _student = student;
//
//        setTitle("Student Form");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        // Initialize components
//        studentIdField = new JTextField(20);
//        nameField = new JTextField(20);
//        classField = new JTextField(20);
//        averageScoreField = new JTextField(20);
//        addButton = new JButton("Add");
//        updateButton = new JButton("Update");
//
//        // Setup layout
//        setLayout(new GridLayout(6, 2));
//
//        // Add components to the frame
//        add(new JLabel("Student ID:"));
//        add(studentIdField);
//        add(new JLabel("Name:"));
//        add(nameField);
//        add(new JLabel("Class:"));
//        add(classField);
//        add(new JLabel("Average Score:"));
//        add(averageScoreField);
//        add(addButton);
//        add(updateButton);
//
//        // Add action listeners
//        addButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                addStudent();
//            }
//        });
//
//        updateButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                updateStudent();
//            }
//        });
    }

    private void addClass() {
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
