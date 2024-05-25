package bai3.bll;

import bai3.dal.ClassDAL;
import bai3.dal.IClassDAL;
import bai3.dal.IStudentDAL;
import bai3.dal.StudentDAL;
import bai3.dto.models.LopDTO;
import bai3.dto.models.SinhVienDTO;
import bai3.dto.responses.MessageDTO;

import java.util.List;

public class ClassBLL implements IClassBLL {
    private final IClassDAL _classDAL = new ClassDAL();
    private final IStudentDAL _studentDAL = new StudentDAL();

    @Override
    public List<LopDTO> getAllClasses() {
        return _classDAL.getAllClasses();
    }

    @Override
    public MessageDTO deleteClass(String maLop) {
        List<SinhVienDTO> studentList = _studentDAL.getStudentsByClassId(maLop);
        if (!studentList.isEmpty()) {
            return new MessageDTO(400, "Không thể xóa lớp này vì có sinh viên đang thuộc lớp.");
        }

        return _classDAL.deleteClass(maLop);
    }
}
