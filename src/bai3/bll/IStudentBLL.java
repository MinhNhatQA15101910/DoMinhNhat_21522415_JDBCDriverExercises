package bai3.bll;

import bai3.dto.models.SinhVienDTO;
import bai3.dto.responses.MessageDTO;

import java.util.List;

public interface IStudentBLL {
    MessageDTO deleteStudent(String maSV);
    List<SinhVienDTO> getAllStudents();
}
