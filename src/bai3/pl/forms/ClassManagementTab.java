package bai3.pl.forms;

import bai3.bll.ClassBLL;
import bai3.bll.IClassBLL;
import bai3.dto.LopDTO;
import bai3.pl.tablemodels.LopTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ClassManagementTab extends JPanel {
    private final IClassBLL _classBLL = new ClassBLL();

    private JTable classTable;
    private JScrollPane classScrollPane;
    private JPanel controlPanel;
    private JTextField maLopTextField;
    private JTextField tenLopTextField;
    private JTextField cvhtTextField;
    private JButton addBtn;
    private JButton updateBtn;
    private JButton deleteBtn;

    public ClassManagementTab() {
        setLayout(new BorderLayout());

        // Load classes
        loadClasses();
        add(classScrollPane, BorderLayout.CENTER);

        // Control panel
        createControlPanel();
        add(controlPanel, BorderLayout.SOUTH);
    }

    private void loadClasses() {
        List<LopDTO> classList = _classBLL.getAllClasses();
        LopTableModel classTableModel = new LopTableModel(classList);
        classTable = new JTable(classTableModel);
        classScrollPane = new JScrollPane(classTable);
    }

    private void createControlPanel() {
        controlPanel = new JPanel(new GridLayout(2, 1, 10, 10));

        // Info panel
        JPanel infoPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        infoPanel.add(new JLabel("MaLop:"));
        maLopTextField = new JTextField();
        maLopTextField.setEditable(false);
        infoPanel.add(maLopTextField);
        infoPanel.add(new JLabel("TenLop:"));
        tenLopTextField = new JTextField();
        tenLopTextField.setEditable(false);
        infoPanel.add(tenLopTextField);
        infoPanel.add(new JLabel("CVHT:"));
        cvhtTextField = new JTextField();
        cvhtTextField.setEditable(false);
        infoPanel.add(cvhtTextField);
        infoPanel.add(new JLabel(""));
        infoPanel.add(new JLabel(""));
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