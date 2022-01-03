package humanResource;
public class Department {
    private String tenBoPhan;
    private int maBoPhan, soLuongNhanVien;
    public Department() {}
    public Department(String tenBoPhan, int maBoPhan, int soLuongNhanVien) {
        this.tenBoPhan = tenBoPhan;
        this.maBoPhan = maBoPhan;
        this.soLuongNhanVien = soLuongNhanVien;
    }
    public void setMaBoPhan (String tenBoPhan) {
        switch(tenBoPhan) {
            case "ke toan":
                maBoPhan = 1;
                break;
            case "tai chinh" :
                maBoPhan = 2;
                break;
            case "kinh doanh":
                maBoPhan = 3;
                break;
            case "marketing":
                maBoPhan = 4;
                break;
            case "hanh chinh":
                maBoPhan = 5;
                break;
            case "ki thuat":
                maBoPhan = 6;
                break;
            default:
                maBoPhan = 7;
                break;
        }
    }
    public void setTenBoPhan (String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }
    public void setSoLuongNhanVien(int soLuongNhanVien) {
        this.soLuongNhanVien = soLuongNhanVien;
    }
    public String toString() {
        return "Tên bộ phận: " + this.tenBoPhan + ", mã bộ phận: " + this.maBoPhan + ", số lượng nhân viên: " + this.soLuongNhanVien;
    }
}
