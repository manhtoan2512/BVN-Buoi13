package entity;

import constant.LoaiKhachHang;

import java.util.InputMismatchException;
import java.util.Scanner;

public class KhachHang implements Inputable {

    private int idKhachHang;
    private String name;
    private String address;
    private String phone;
    private LoaiKhachHang loaiKhachHang;
    private static int AUTO_ID = 10000;

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LoaiKhachHang getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(LoaiKhachHang loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "idKhachHang=" + idKhachHang +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", loaiKhachHang=" + loaiKhachHang +
                '}';
    }

    @Override
    public void inputInfo() {
        this.idKhachHang = AUTO_ID;
        AUTO_ID++;
        System.out.println("Nhập tên khách hàng: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ khách hàng: ");
        this.address = new Scanner(System.in).nextLine();
        System.out.println("Nhập sdt khách hàng: ");
        this.phone = new Scanner(System.in).nextLine();
        System.out.println("chọn loại khách hàng: ");
        System.out.println("1. Cá Nhân");
        System.out.println("2. Đại diện đơn vị hành chính");
        System.out.println("3. Đại diện đơn vị kinh doanh");
        int choice;
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if(choice >= 1 && choice <=3){
                    break;
                }
                System.out.println("Nhập số dương và phải nhỏ hơn bằng 3, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
            }
        } while (true);
        switch (choice) {
            case 1:
                this.loaiKhachHang = LoaiKhachHang.CN;
                break;
            case 2:
                this.loaiKhachHang = LoaiKhachHang.DDDVHC;
                break;
            case 3:
                this.loaiKhachHang = LoaiKhachHang.DDDVKD;
                break;
        }
    }

}
