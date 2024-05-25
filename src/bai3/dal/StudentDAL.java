package bai3.dal;

import bai3.dto.models.SinhVienDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAL implements IStudentDAL {
    @Override
    public List<SinhVienDTO> getAllStudents() {
        List<SinhVienDTO> studentList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(Utils.CONNECTION_URL)) {
            Statement stmt = conn.createStatement();
            ResultSet rsData = stmt.executeQuery("SELECT * FROM SinhVien");

            while (rsData.next()) {
                studentList.add(
                        new SinhVienDTO(
                                rsData.getString("MaSV"),
                                rsData.getString("HoTen"),
                                rsData.getString("Lop"),
                                rsData.getFloat("DiemTB")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    @Override
    public List<SinhVienDTO> getStudentsByClassId(String maLop) {
        List<SinhVienDTO> studentList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(Utils.CONNECTION_URL)) {
            try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM SinhVien WHERE Lop = ?")) {
                pstmt.setString(1, maLop);

                ResultSet rsData = pstmt.executeQuery();

                while (rsData.next()) {
                    studentList.add(
                            new SinhVienDTO(
                                    rsData.getString("MaSV"),
                                    rsData.getString("HoTen"),
                                    rsData.getString("Lop"),
                                    rsData.getFloat("DiemTB")
                            )
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }
}
