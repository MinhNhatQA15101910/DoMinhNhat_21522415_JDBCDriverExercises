package bai3.dal;

import bai3.dto.LopDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDAL implements IClassDAL {
    @Override
    public List<LopDTO> getAllClasses() {
        List<LopDTO> classList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(Utils.CONNECTION_URL)) {
            Statement stmt = conn.createStatement();
            ResultSet rsData = stmt.executeQuery("SELECT * FROM Lop");

            while (rsData.next()) {
                classList.add(
                        new LopDTO(
                                rsData.getString("MaLop"),
                                rsData.getString("TenLop"),
                                rsData.getString("CVHT")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classList;
    }
}
