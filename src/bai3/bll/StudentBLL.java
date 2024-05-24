package bai3.bll;

import bai3.dal.IStudentDAL;
import bai3.dal.StudentDAL;
import bai3.dto.SinhVienDTO;

import java.util.List;

public class StudentBLL implements IStudentBLL {
    private final IStudentDAL _studentDAL = new StudentDAL();

    @Override
    public List<SinhVienDTO> getAllStudents() {
        return _studentDAL.getAllStudents();
    }
}
