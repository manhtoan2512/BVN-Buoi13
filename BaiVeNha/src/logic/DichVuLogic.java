package logic;

import entity.DichVu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DichVuLogic {

    private DichVu[] dichVus;
    private int tongDichVu;

    public DichVuLogic(DichVu[] dichVus) {
        this.dichVus = dichVus;
    }

    public DichVuLogic(int tongDichVu) {
        this.tongDichVu = tongDichVu;
    }

    public DichVu[] getDichVus() {
        return dichVus;
    }

    public void setDichVus(DichVu[] dichVus) {
        this.dichVus = dichVus;
    }

    public int getTongDichVu() {
        return tongDichVu;
    }

    public void setTongDichVu(int tongDichVu) {
        this.tongDichVu = tongDichVu;
    }

    public void inputDichVu() {
        System.out.println("Nhập số lượng loại dịch vụ: ");
        int soLuongDichVu;
        do {
            try {
                soLuongDichVu = new Scanner(System.in).nextInt();
                if (soLuongDichVu > 0) {
                    break;
                }
                System.out.println("Số lượng loại dịch vụ phải là số dương, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < soLuongDichVu; i++) {
            System.out.println("Nhập thông tin loại dịch vụ thứ: " + (i + 1));
            DichVu dichVu = new DichVu();
            dichVu.inputInfo();
            saveDichVu(dichVu);
            System.out.println("-----------------------");
        }
        tongDichVu += soLuongDichVu;
    }

    private void saveDichVu(DichVu dichVu) {
        for (int i = 0; i < dichVus.length; i++) {
            if (dichVus[i] == null) {
                dichVus[i] = dichVu;
                break;
            }
        }
    }

    public void showDichVu() {
        for (int i = 0; i < dichVus.length; i++) {
            if (dichVus[i] != null) {
                System.out.println(dichVus[i]);
            }
        }
    }

    public DichVu searchById(int id) {
        DichVu kq = null;
        for (int i = 0; i < dichVus.length; i++) {
            if (dichVus[i] != null && dichVus[i].getIdDichVu() == id) {
                kq = dichVus[i];
                break;
            }
        }
        return kq;
    }
}
