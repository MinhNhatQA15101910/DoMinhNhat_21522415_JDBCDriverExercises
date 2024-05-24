package bai3.dal;

import bai3.dto.SinhVienDTO;

import java.util.List;

public interface IStudentDAL {
    List<SinhVienDTO> getAllStudents();
}
