package humanResource;
import java.util.*;
public class Employee extends Staff implements Icalculator{
    private int soGioLamThem;
    public Employee(){
        super();
    }
    public Employee(int soGioLamThem) {
        super();
        this.soGioLamThem = soGioLamThem;
    }
    public String displayInformation(){
        return "Mã Nhân Viên: "+ this.maNhanVien+", Tên nhân viên: " + this.tenNhanVien + ", Tuổi nhân viên: " + this.tuoiNhanVien + ", Bộ phận làm việc: " + this.boPhanLamViec + ", Ngày vào làm : " + this.ngayVaoLam;
    }
    public void input(){
        super.input();
        System.out.println("Nhap so gio lam them: ");
        soGioLamThem = scanner.nextInt();
        scanner.nextLine();

    }
    public String displaySalary() {
        return "Mã nhân viên: " + this.maNhanVien + ", Tên nhân viên: " + this.tenNhanVien + ", Bộ phận làm việc: " + this.boPhanLamViec + ", Ngày vào làm : " + this.ngayVaoLam + ", Lương: " + this.calculateSalary();
    }
    @Override
    public String toString() {
        return "\n" + String.format("(Mã nhân viên: %s , Tên nhân viên: %s, Tuổi nhân viên : %d)", this.maNhanVien, this.tenNhanVien, this.tuoiNhanVien);
    }
    @Override
    public int calculateSalary() {
        return this.heSoLuong * 3000000 + this.soGioLamThem*200000;
    }

   
    
   
    
   
}