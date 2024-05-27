package bai3.pl.forms;

import bai3.dto.models.LopDTO;
import bai3.pl.interfaces.IAddUpdateClassRequester;

import javax.swing.*;
import java.awt.*;

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
        featureBtn.addActionListener(e -> addClass());
    }

    public AddUpdateClassForm(IAddUpdateClassRequester requester, LopDTO classObj) {
        _addUpdateClassRequester = requester;
        _class = classObj;

        setTitle("Cập nhật lớp");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        maLopTextField = new JTextField();
        maLopTextField.setText(classObj.getMaLop());
        tenLopTextField = new JTextField();
        tenLopTextField.setText(classObj.getTenLop());
        cvhtTextField = new JTextField();
        cvhtTextField.setText(classObj.getCvht());
        featureBtn = new JButton("Cập nhật");

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
        featureBtn = new JButton("Cập nhật");
        featurePanel.add(featureBtn, BorderLayout.CENTER);
        add(featurePanel, BorderLayout.SOUTH);

        // Add action listeners
        featureBtn.addActionListener(e -> updateClass());
    }

    private void updateClass() {
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
