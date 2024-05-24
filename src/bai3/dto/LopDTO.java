package bai3.dto;

public class LopDTO {
    private String maLop;
    private String tenLop;
    private String cvht;

    public LopDTO() {
    }

    public LopDTO(String maLop, String tenLop, String cvht) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.cvht = cvht;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getCvht() {
        return cvht;
    }

    public void setCvht(String cvht) {
        this.cvht = cvht;
    }
}
