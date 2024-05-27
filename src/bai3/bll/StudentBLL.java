package bai3.bll;

import bai3.dal.IStudentDAL;
import bai3.dal.StudentDAL;
import bai3.dto.models.SinhVienDTO;
import bai3.dto.responses.MessageDTO;

import java.util.List;

public class StudentBLL implements IStudentBLL {
    private final IStudentDAL _studentDAL = new StudentDAL();

    @Override
    public MessageDTO deleteStudent(String maSV) {
        return _studentDAL.deleteStudent(maSV);
    }

    @Override
    public List<SinhVienDTO> getAllStudents() {
        return _studentDAL.getAllStudents();
    }
}
