package bai3.dto.models;

import java.util.Objects;

public record LopDTO(String maLop, String tenLop, String cvht) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LopDTO lopDTO = (LopDTO) o;
        return Objects.equals(cvht, lopDTO.cvht) &&
                Objects.equals(maLop, lopDTO.maLop) &&
                Objects.equals(tenLop, lopDTO.tenLop);
    }
}
