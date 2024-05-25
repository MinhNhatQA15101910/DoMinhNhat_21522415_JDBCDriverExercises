package bai3.dal;

import bai3.dto.models.SinhVienDTO;

import java.util.List;

public interface IStudentDAL {
    List<SinhVienDTO> getAllStudents();
    List<SinhVienDTO> getStudentsByClassId(String maLop);
}
