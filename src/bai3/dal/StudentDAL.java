package bai3.dal;

import bai3.dto.models.SinhVienDTO;
import bai3.dto.responses.MessageDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAL implements IStudentDAL {
    @Override
    public MessageDTO deleteStudent(String maSV) {
        try (Connection conn = DriverManager.getConnection(Utils.CONNECTION_URL)) {
            try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM SinhVien WHERE MaSV = ?")) {
                pstmt.setString(1, maSV);

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    return new MessageDTO(200, "Xóa sinh viên thành công.");
                }

                return new MessageDTO(500, "Đã có lỗi xảy ra.");
            }
        } catch (SQLException e) {
            return new MessageDTO(500, e.getMessage());
        }
    }

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

    @Override
    public MessageDTO updateStudent(SinhVienDTO student) {
        try (Connection conn = DriverManager.getConnection(Utils.CONNECTION_URL)) {
            try (PreparedStatement pstmt = conn.prepareStatement("UPDATE SinhVien SET HoTen = ?, Lop = ?, DiemTB = ? WHERE MaSV = ?")) {
                pstmt.setString(1, student.hoTen());
                pstmt.setString(2, student.lop());
                pstmt.setFloat(3, student.diemTB());
                pstmt.setString(4, student.maSV());

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    return new MessageDTO(200, "Cập nhật sinh viên thành công.");
                }

                return new MessageDTO(500, "Đã có lỗi xảy ra.");
            }
        } catch (SQLException e) {
            return new MessageDTO(500, e.getMessage());
        }
    }
}
