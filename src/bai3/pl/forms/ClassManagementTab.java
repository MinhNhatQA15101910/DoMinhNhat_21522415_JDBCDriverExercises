package bai3.pl.forms;

import bai3.bll.ClassBLL;
import bai3.bll.IClassBLL;
import bai3.dto.LopDTO;
import bai3.pl.tablemodels.LopTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ClassManagementTab extends JPanel {
    final IClassBLL _classBLL = new ClassBLL();

    private final JTable classTable;
    private final JScrollPane classScrollPane;

    public ClassManagementTab() {
        setLayout(new BorderLayout());

        // Load classes
        List<LopDTO> classList = _classBLL.getAllClasses();
        LopTableModel classTableModel = new LopTableModel(classList);
        classTable = new JTable(classTableModel);
        classScrollPane = new JScrollPane(classTable);
        add(classScrollPane, BorderLayout.CENTER);
    }
}
