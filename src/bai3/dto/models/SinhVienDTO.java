package bai3.dto.models;

import java.util.Objects;

public record SinhVienDTO(String maSV, String hoTen, String lop, float diemTB) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinhVienDTO that = (SinhVienDTO) o;
        return Float.compare(diemTB, that.diemTB) == 0 &&
                Objects.equals(lop, that.lop) &&
                Objects.equals(maSV, that.maSV) &&
                Objects.equals(hoTen, that.hoTen);
    }
}
