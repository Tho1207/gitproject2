package humanResource;
import java.util.*;
public abstract class Staff implements Icalculator, Comparable<Staff>{
    static Scanner scanner = new Scanner(System.in);
    protected String maNhanVien, tenNhanVien, ngayVaoLam, boPhanLamViec;
    protected int tuoiNhanVien, heSoLuong, soNgayNghiPhep;
    public Staff() {
        super();
    }
    public Staff(String maNhanVien, String tenNhanVien, String ngayVaoLam, String boPhanLamViec, int tuoiNhanVien, int heSoLuong, int soNgayNghiPhep) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.ngayVaoLam = ngayVaoLam;
        this.boPhanLamViec = boPhanLamViec;
        this.tuoiNhanVien = tuoiNhanVien;
        this.heSoLuong = heSoLuong;
        this.soNgayNghiPhep = soNgayNghiPhep;
    }
    public String getMaNhanVen() {
        return maNhanVien;
    }
    public String getTenNhanVien() {
        return tenNhanVien;
    }
    public String getBoPhanLamViec(){
        return boPhanLamViec;
    }
    public int getHeSoLuong() {
        return heSoLuong;
    }
    public abstract int calculateSalary();
    public abstract String displayInformation();
    public abstract String displaySalary();
    public void input() {
        System.out.println("Nhap ma nhan vien: ");
        maNhanVien = scanner.nextLine();
        System.out.println("Nhap ten nhan vien: ");
        tenNhanVien = scanner.nextLine();
        System.out.println("Nhap ngay vao lam: ");
        ngayVaoLam = scanner.nextLine();
        System.out.println("Nhap bo phan lam viec: (ke toan, tai chinh, kinh doanh, marketing, hanh chinh, ki thuat)");
        boPhanLamViec = scanner.nextLine();
        System.out.println("Nhap tuoi nhan vien");
        tuoiNhanVien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhap he so luong: ");
        heSoLuong = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhap so ngay nghi phep: ");
        soNgayNghiPhep = scanner.nextInt();
        scanner.nextLine();
    }
    @Override
    public int compareTo(Staff staff) {
        int compareSalary = ((Staff)staff).calculateSalary();
        return this.calculateSalary() - compareSalary;
    }
    
}