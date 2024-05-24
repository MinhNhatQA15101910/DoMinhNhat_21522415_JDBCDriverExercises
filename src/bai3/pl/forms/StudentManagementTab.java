package bai3.pl.forms;

import bai3.bll.IStudentBLL;
import bai3.bll.StudentBLL;
import bai3.dto.SinhVienDTO;
import bai3.pl.tablemodels.SinhVienTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StudentManagementTab extends JPanel {
    private final IStudentBLL _studentBLL = new StudentBLL();

    private JTable studentTable;
    private JScrollPane studentScrollPane;
    private JPanel controlPanel;
    private JTextField maSVTextField;
    private JTextField hoTenTextField;
    private JTextField lopTextField;
    private JTextField diemTBTextField;
    private JButton addBtn;
    private JButton updateBtn;
    private JButton deleteBtn;

    public StudentManagementTab() {
        setLayout(new BorderLayout());

        // Load students
        loadStudents();
        add(studentScrollPane, BorderLayout.CENTER);

        // Control panel
        createControlPanel();
        add(controlPanel, BorderLayout.SOUTH);
    }

    private void loadStudents() {
        List<SinhVienDTO> studentList = _studentBLL.getAllStudents();
        SinhVienTableModel classTableModel = new SinhVienTableModel(studentList);
        studentTable = new JTable(classTableModel);
        studentScrollPane = new JScrollPane(studentTable);
    }

    private void createControlPanel() {
        controlPanel = new JPanel(new GridLayout(2, 1, 10, 10));

        // Info panel
        JPanel infoPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        infoPanel.add(new JLabel("MaSV:"));
        maSVTextField = new JTextField();
        maSVTextField.setEditable(false);
        infoPanel.add(maSVTextField);
        infoPanel.add(new JLabel("HoTen:"));
        hoTenTextField = new JTextField();
        hoTenTextField.setEditable(false);
        infoPanel.add(hoTenTextField);
        infoPanel.add(new JLabel("Lop:"));
        lopTextField = new JTextField();
        lopTextField.setEditable(false);
        infoPanel.add(lopTextField);
        infoPanel.add(new JLabel("DiemTB:"));
        diemTBTextField = new JTextField();
        diemTBTextField.setEditable(false);
        infoPanel.add(diemTBTextField);
        controlPanel.add(infoPanel);

        // Buttons panel
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        addBtn = new JButton("Thêm");
        buttonsPanel.add(addBtn);
        updateBtn = new JButton("Cập nhật");
        buttonsPanel.add(updateBtn);
        deleteBtn = new JButton("Xóa");
        buttonsPanel.add(deleteBtn);
        controlPanel.add(buttonsPanel);
    }
}
