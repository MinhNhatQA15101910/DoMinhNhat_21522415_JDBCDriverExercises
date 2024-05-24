package bai3.pl.forms;

import bai3.bll.IStudentBLL;
import bai3.bll.StudentBLL;
import bai3.dto.SinhVienDTO;
import bai3.pl.tablemodels.SinhVienTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StudentManagementTab extends JPanel {
    final IStudentBLL _studentBLL = new StudentBLL();

    private final JTable studentTable;
    private final JScrollPane studentScrollPane;

    public StudentManagementTab() {
        setLayout(new BorderLayout());

        // Load students
        List<SinhVienDTO> studentList = _studentBLL.getAllStudents();
        SinhVienTableModel classTableModel = new SinhVienTableModel(studentList);
        studentTable = new JTable(classTableModel);
        studentScrollPane = new JScrollPane(studentTable);
        add(studentScrollPane, BorderLayout.CENTER);
    }
}
