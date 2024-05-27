package bai4.bll;

import bai4.dto.models.SinhVienDTO;
import bai4.dto.responses.MessageDTO;

import java.util.List;

public interface IStudentBLL {
    MessageDTO addStudent(SinhVienDTO student, String avgScore);
    MessageDTO deleteStudent(String maSV);
    List<SinhVienDTO> getAllStudents();
    MessageDTO updateStudent(SinhVienDTO student, String avgScore);
}
