package bai3.bll;

import bai3.dal.ClassDAL;
import bai3.dal.IClassDAL;
import bai3.dto.LopDTO;

import java.util.List;

public class ClassBLL implements IClassBLL {
    private final IClassDAL _classDAL = new ClassDAL();

    @Override
    public List<LopDTO> getAllClasses() {
        return _classDAL.getAllClasses();
    }
}
