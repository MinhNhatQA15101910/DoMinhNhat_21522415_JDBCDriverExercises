package bai3.dal;

import bai3.dto.models.LopDTO;
import bai3.dto.responses.MessageDTO;

import java.util.List;

public interface IClassDAL {
    MessageDTO deleteClass(String maLop);
    List<LopDTO> getAllClasses();
    LopDTO getClassById(String maLop);
}
