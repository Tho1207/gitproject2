package humanResource;

public class Manager extends Staff implements Icalculator{
    private String chucDanh;
    private int luongTrachNhiem;
    public Manager() {
        super();
    }
    public Manager(String chucDanh, int luongTrachNhiem) {
        super();
        this.chucDanh = chucDanh;
        this.luongTrachNhiem = luongTrachNhiem;
    }
    public String displayInformation(){
        return "Mã Nhân Viên: "+ this.maNhanVien+", Tên nhân viên: " + this.tenNhanVien + ", Tuổi nhân viên: " + this.tuoiNhanVien + ", Bộ phận làm việc: " + this.boPhanLamViec + ", Ngày vào làm : " + this.ngayVaoLam + ", Chức danh: "+ this.chucDanh;
    }
    public String displaySalary() {
        return "Mã nhân viên" + this.maNhanVien + ", Tên nhân viên: " + this.tenNhanVien + ", Bộ phận làm việc: " + this.boPhanLamViec + ", Ngày vào làm : " + this.ngayVaoLam + ", Chức danh: "+ this.chucDanh + ", Lương: " + this.calculateSalary();
    }
    public void input() {
        super.input();
        System.out.println("Nhập chức danh: (Business Leader, Project Leader, Technical Leader)");
        chucDanh = scanner.nextLine();
    }
    public int luongTN (String chucDanh) {
        int luongTN = 0;
        switch(chucDanh) {
            case "business leader":
                luongTN = 8000000;
                break;
            case "project leader":
                luongTN = 5000000;
                break;
            case "technical leader":
                luongTN = 6000000;
                break;
        }
        return luongTN;
    }
    @Override
    public String toString() {
        return "\n" + String.format("(Mã nhân viên: %s , Tên nhân viên: %s, Tuổi nhân viên : %d)", this.maNhanVien, this.tenNhanVien, this.tuoiNhanVien);
    }
    @Override
    public int calculateSalary() {
        luongTrachNhiem = luongTN(chucDanh.toLowerCase());
        return this.heSoLuong * 5000000 + this.luongTrachNhiem;
    }
    
   
}