package humanResource;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.regex.Matcher;
public class HumanResources{
    static Scanner scanner = new Scanner(System.in);
    static List<Staff> staffs = new ArrayList<>();
    static ArrayList<Staff> staffList = new ArrayList<>();
    static void welcome(){
        System.out.println("Welcome to the human resources program, please enter a number to continue: ");
        System.out.println("Hiển thị danh sách nhân viên hiện có trong công ty-1");
        System.out.println("Hiển thị các bộ phận trong công ty-2");
        System.out.println("Hiển thị các nhân viên theo từng bộ phận-3");
        System.out.println("Thêm nhân viên mới vào công ty - 4");
        System.out.println("Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên - 5");
        System.out.println("Hiển thị bảng lương của nhân viên toàn công ty-6");
        System.out.println("Hiển thị bảng lương của nhân viên theo thứ tự tăng dần-7");
        int choice = 0;
        boolean inputOK = false;
        do {
            try{
                choice = scanner.nextInt();
                if (choice < 1 || choice > 7) {
                    throw new Exception();
                }
                inputOK = true;
            } catch(Exception e) {
                System.out.println("Please enter a number from 1 to 7");
                scanner.nextLine();
            }

        } while(!inputOK);
        checkChoice(choice);
    }

    static void checkChoice(int choice) {
        switch (choice) {
            case 1:
                showEmployeeInfo();
                break;
            case 2:
                showDepartInfo();
                break;
            case 3:
                employeesInfoinEachDepartment();
                break;
            case 4:
                addEmployee();
                break;
            case 5:
                searchEmployee();
                break;
            case 6:
                showSalary();
                break;
            case 7:
                sortedSalary();
                break;
        }
    }

    static void addEmployee() {
        Staff staff;
        boolean inputOK = false;
        int choice = 0;
        do {
            try {
                System.out.println("Nếu là nhân viên vui lòng chọn 1. Quản lý vui lòng chọn 2");
                choice = scanner.nextInt();
                if (choice < 1 || choice > 2)  {
                    throw new Exception();
                }
                inputOK = true;
            }
            catch (Exception e) {
                System.out.println("Số nhập không hợp lệ");
                scanner.nextLine();
            }

        } while (!inputOK);
        
        if (choice == 1) {
            System.out.println("Bạn muốn nhập bao nhiêu nhân viên? ");
            int num = scanner.nextInt();
            for (int i =0; i<num; i++) {
                System.out.println("Nhập thông tin nhân viên thứ " + (i + 1) + ": ");
                staff = new Employee();
                staff.input();
                staffList.add(staff);
                staffs.add(staff);
            }
        } else {
            System.out.println("Bạn muốn nhập bao nhiêu quản lý? ");
            int num = scanner.nextInt();
            for (int i = 0; i<num; i++) {
                System.out.println("Nhập thông tin quản lý thứ " + (i + 1) + ": ");
                staff = new Manager();
                staff.input();
                staffList.add(staff);
                staffs.add(staff);
            }
        }
        
    }

    static void showEmployeeInfo() {
        for (Staff staff : staffList) {
            System.out.println(staff.displayInformation());
        }
    }

    static void showDepartInfo() {
        ArrayList<String> tenBP = new ArrayList<String>();
        ArrayList<Department> departInfo = new ArrayList<Department>();
        for (Staff staff : staffList) {
            tenBP.add(staff.getBoPhanLamViec());
        }
        Set<String> uniqueSet = new HashSet<String>(tenBP);
        for (String a : uniqueSet) {
            Department department = new Department();
            department.setTenBoPhan(a);
            department.setMaBoPhan(a.toLowerCase());
            department.setSoLuongNhanVien(Collections.frequency(tenBP, a));
            departInfo.add(department);
        }
        for (Department department : departInfo) {
            System.out.println(department.toString());
        }
    }

    static void employeesInfoinEachDepartment() {
        Map<String,List<Staff>> employeeByDepartment = new HashMap<>();
        employeeByDepartment = staffs.stream().collect(Collectors.groupingBy(Staff::getBoPhanLamViec));
        for (Map.Entry<String,List<Staff>> entry:employeeByDepartment.entrySet()){
            System.out.println("Nhân viên trong bộ phận " + entry.getKey() + " bao gồm " + entry.getValue());
        }
    }

    static void searchEmployee() {
        System.out.println("Nhập tên nhân viên hoặc mã nhân viên");
        String hint = scanner.next();
        Pattern pattern = Pattern.compile(hint, Pattern.CASE_INSENSITIVE);
        for (Staff sta : staffList) {
            Matcher matcher = pattern.matcher(sta.getMaNhanVen());
            Matcher matcher2 = pattern.matcher(sta.getTenNhanVien());
            boolean matchFound = matcher.find();
            boolean matchFound2 = matcher2.find();
            if (matchFound || matchFound2) {
                System.out.println(sta.displayInformation());
            } 
        }
        scanner.nextLine();
    }

    static void showSalary() {
        for (Staff staff:staffList) {
            System.out.println(staff.displaySalary());
        }
    }
    
    static void sortedSalary() {
        boolean inputOK = false;
        int choice = 0;
        do {
            try {
                System.out.println("Bạn muốn theo thứ tự giảm dần hay tăng dần? Tang dan - 1, Giam dan - 2");
                choice = scanner.nextInt();
                if (choice < 1 || choice > 2)  {
                    throw new Exception();
                }
                inputOK = true;
            }
            catch (Exception e) {
                System.out.println("Số nhập không hợp lệ");
                scanner.nextLine();
            }

        } while (!inputOK);
        if (choice == 1) {
            Collections.sort(staffList);
            for (Staff staff:staffList) {
                System.out.println(staff.displaySalary());
            }
        } else {
            Collections.sort(staffList);
            ArrayList<Staff> revStaffList = new ArrayList<Staff>();
            for (int i = staffList.size() - 1;  i>= 0 ; i--) {
                revStaffList.add(staffList.get(i));
            }
            for (Staff staff:revStaffList) {
                System.out.println(staff.displaySalary());
            }

        }

    }
    public static void main(String[] args){
        String tiepTuc = "y";
        do {
            welcome();
            System.out.println("Bạn có muốn tiếp tục không? (yes - no)");
            tiepTuc = scanner.next();
            tiepTuc.toLowerCase();
        } while (tiepTuc.equals("y") || tiepTuc.equals("yes"));
       

        

    }
}