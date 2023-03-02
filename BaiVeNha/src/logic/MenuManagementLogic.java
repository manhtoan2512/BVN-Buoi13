package logic;

import entity.KhachHang;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManagementLogic {

    private KhachHangLogic khachHangLogic;
    private DichVuLogic dichVuLogic;
    private QuanLyKhachHangLogic quanLyKhachHangLogic;
    public MenuManagementLogic() {

        KhachHang[] khachHangs = new KhachHang[1000];
        khachHangLogic = new KhachHangLogic(khachHangs);


    }
    public void menu(){
        while (true){
            printMenu();
            int choice = choice();
            switch (choice){
                case 1:
                    khachHangLogic.inputKhachHang();
                    break;
                case 2:
                    khachHangLogic.showKhachHang();
                    break;
                case 3:
                    dichVuLogic.inputDichVu();
                    break;
                case 4:
                    dichVuLogic.showDichVu();
                    break;
                case 5:
                    quanLyKhachHangLogic.lapHoaDon();
                    break;
                case 6:
                    showShortMenu();
                    break;
                case 7:
                    quanLyKhachHangLogic.tinhThuNhap();
                    break;
                case 8:
                    return;
            }
        }
    }

    private void showShortMenu() {
        System.out.println("Chọn chức năng bạn mong muốn: ");
        System.out.println("1. Sắp xếp theo họ tên khách hàng.");
        System.out.println("2. Sắp xếp theo số lượng dịch vụ.");
        int choice = 0;
        System.out.println("Xin mời chọn: ");
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if(choice==1 || choice == 2) {
                    break;
                }
                System.out.println("Lựa chọn sai, mời chọn lại: ");
            }catch (InputMismatchException ex) {
                System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
            }
        }while (true);
        if(choice==1){
            quanLyKhachHangLogic.sapXepTenKhangHang();
        }else {
            quanLyKhachHangLogic.sortByPostNumber();
        }
    }

    private int choice() {
        System.out.print("Mời bạn nhập lựa chọn: ");
        int temp;
        do {
            try {
                temp = new Scanner(System.in).nextInt();
                if (temp >= 1 && temp <= 8) {
                    break;
                }
                System.out.print("Nhập sai, hãy nhập lại: ");
            }catch (InputMismatchException ex){
                System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
            }
        } while (true);
        return temp;
    }

    private void printMenu() {
        System.out.println("Quản lý dịch vụ khách hàng");
        System.out.println("1. Nhập danh sách khách hàng.");
        System.out.println("2. In ra danh sách khách hàng.");
        System.out.println("3. Nhập danh sách kiểu dịch vụ.");
        System.out.println("4. In ra danh sách kiểu dịch vụ.");
        System.out.println("5. Lập hóa đơn dịch vụ.");
        System.out.println("6. Sắp xếp danh sách hóa đơn.");
        System.out.println("7. Lập bảng kê số tiền phải trả của khách hàng.");
        System.out.println("8. Thoát.");
    }

}
