package bai3.pl.tablemodels;

import bai3.dto.models.LopDTO;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class LopTableModel extends AbstractTableModel {
    private final String[] columnNames = {"MaLop", "TenLop", "CVHT"};
    private List<LopDTO> classes;

    public LopTableModel(List<LopDTO> classes) {
        super();
        this.classes = classes;
    }

    public void setClasses(List<LopDTO> classes) {
        this.classes = classes;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return classes.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LopDTO classObj = classes.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> classObj.getMaLop();
            case 1 -> classObj.getTenLop();
            case 2 -> classObj.getCvht();
            default -> null;
        };
    }
}
