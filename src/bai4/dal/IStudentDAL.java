package bai4.dal;

import bai4.dto.models.SinhVienDTO;
import bai4.dto.responses.MessageDTO;

import java.util.List;

public interface IStudentDAL {
    MessageDTO addStudent(SinhVienDTO student);
    MessageDTO deleteStudent(String maSV);
    List<SinhVienDTO> getAllStudents();
    List<SinhVienDTO> getStudentsByClassId(String maLop);
    List<SinhVienDTO> getStudentsFilteredById(String maSVFilter);
    SinhVienDTO getStudentById(String maSV);
    MessageDTO updateStudent(SinhVienDTO student);
}
