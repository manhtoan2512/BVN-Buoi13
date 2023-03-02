package logic;

import entity.KhachHang;

import java.util.InputMismatchException;
import java.util.Scanner;

public class KhachHangLogic {

    private KhachHang[] khachHangs;
    private int tongKhachHang;

    public KhachHangLogic(KhachHang[] khachHangs) {
        this.khachHangs = khachHangs;
    }

    public KhachHangLogic(int tongKhachHang) {
        this.tongKhachHang = tongKhachHang;
    }

    public KhachHang[] getKhachHangs() {
        return khachHangs;
    }

    public void setKhachHangs(KhachHang[] khachHangs) {
        this.khachHangs = khachHangs;
    }

    public int getTongKhachHang() {
        return tongKhachHang;
    }

    public void setTongKhachHang(int tongKhachHang) {
        this.tongKhachHang = tongKhachHang;
    }
    public void inputKhachHang(){
        System.out.println("Nhập số lượng khách hàng: ");
        int soLuongKhachHang;
        do {
            try {
                soLuongKhachHang = new Scanner(System.in).nextInt();
                if(soLuongKhachHang > 0){
                    break;
                }
                System.out.println("Số lượng khách hàng phải là số dương, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < soLuongKhachHang; i++) {
            System.out.println("Nhập thông tin khách hàng thứ: "+(i+1));
            KhachHang khachHang = new KhachHang();
            khachHang.inputInfo();
            saveKhachHang(khachHang);
            System.out.println("-----------------------");
        }
        tongKhachHang +=soLuongKhachHang;
    }

    private void saveKhachHang(KhachHang khachHang) {
        for (int i = 0; i < khachHangs.length; i++) {
            if(khachHangs[i] == null){
                khachHangs[i] = khachHang;
                break;
            }
        }
    }
    public void showKhachHang(){
        for (int i = 0; i < khachHangs.length; i++) {
            if(khachHangs[i] != null){
                System.out.println(khachHangs[i]);
            }
        }
    }
    public KhachHang searchById(int id){
        KhachHang kq = null;
        for (int i = 0; i < khachHangs.length; i++) {
            if(khachHangs[i] != null && khachHangs[i].getIdKhachHang() == id){
                kq = khachHangs[i];
                break;
            }
        }
        return kq;
    }
}
