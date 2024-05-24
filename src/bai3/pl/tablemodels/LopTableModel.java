package bai3.pl.tablemodels;

import bai3.dto.LopDTO;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class LopTableModel extends DefaultTableModel {
    private final String[] columnNames = {"MaLop", "TenLop", "CVHT"};
    private final List<LopDTO> classes;

    public LopTableModel(List<LopDTO> classes) {
        super();
        this.classes = classes;
        loadClassesToModel();
    }

    private void loadClassesToModel() {
        setColumnIdentifiers(columnNames);
        for (LopDTO classObj : classes) {
            Object[] row = {classObj.getMaLop(), classObj.getTenLop(), classObj.getCvht()};
            addRow(row);
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
