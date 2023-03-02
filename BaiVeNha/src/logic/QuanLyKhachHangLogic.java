package logic;

import entity.DichVu;
import entity.KhachHang;
import entity.QuanLyKhachHang;
import entity.QuanLyKhachHangChiTiet;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLyKhachHangLogic {

    private QuanLyKhachHang[] quanLyKhachHangs;
    private KhachHangLogic khachHangLogic;
    private DichVuLogic dichVuLogic;

    public QuanLyKhachHangLogic(QuanLyKhachHang[] quanLyKhachHangs, KhachHangLogic khachHangLogic, DichVuLogic dichVuLogic) {
        this.quanLyKhachHangs = quanLyKhachHangs;
        this.khachHangLogic = khachHangLogic;
        this.dichVuLogic = dichVuLogic;
    }

    public void lapHoaDon() {
        if (!coDuLieuHayChua()) {
            System.out.println("Chưa có thông tin khách hàng hoặc dịch vụ, vui lòng nhập danh sách khách hàng và dịch vụ trước");
            return;
        }
        System.out.println("Lập hóa đơn cho bao nhiêu khách hàng: ");
        int soLuongKhachHang;
        do {
            try {
                soLuongKhachHang = new Scanner(System.in).nextInt();
                if (soLuongKhachHang > 0 && soLuongKhachHang <= khachHangLogic.getTongKhachHang()) {
                    break;
                }
                System.out.println("Số lượng khách hàng phải là số dương và nhỏ hơn lượng khách hàng đã có: ");
            }catch (InputMismatchException ex){
                System.out.println("Nhập sai định dạng, mời nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < soLuongKhachHang; i++) {
            System.out.println("Nhập id của khách hàng thứ " + (i + 1) + " là: ");
            KhachHang khachHang = nhapKhachHang();
            System.out.println("Lập hóa đơn cho bao nhiêu dịch vụ: ");
            int soLoaiDichVu;
            do {
                try {
                    soLoaiDichVu = new Scanner(System.in).nextInt();
                    if(soLoaiDichVu > 0 && soLoaiDichVu <= dichVuLogic.getTongDichVu() && soLoaiDichVu <=5){
                        break;
                    }
                    System.out.println("Số loại dịch vụ phải là số dương, nhỏ hơn số loai dịch vụ đã có và phải nhỏ hơn bằng 5, vui lòng nhập lại: ");
                }catch (InputMismatchException ex){
                    System.out.println("Nhập sai định dạng, mời nhập lại: ");
                }
            }while (true);
            QuanLyKhachHangChiTiet[] danhSachDichVu = nhapDanhSachDichVu(soLoaiDichVu);
            QuanLyKhachHang lapHoaDon = new QuanLyKhachHang(khachHang, danhSachDichVu);
            saveQuanLyKhachHang(lapHoaDon);
        }
        showQuanLyKhachHang();
    }

    private void showQuanLyKhachHang() {
        for (int i = 0; i < quanLyKhachHangs.length; i++) {
            if(quanLyKhachHangs[i] != null){
                System.out.println(quanLyKhachHangs[i]);
            }
        }
    }

    private void saveQuanLyKhachHang(QuanLyKhachHang lapHoaDon) {
        for (int i = 0; i < quanLyKhachHangs.length; i++) {
            if(quanLyKhachHangs[i] == null){
                quanLyKhachHangs[i] = lapHoaDon;
                break;
            }
        }
    }

    private QuanLyKhachHangChiTiet[] nhapDanhSachDichVu(int soLoaiDichVu) {
        QuanLyKhachHangChiTiet[] danhSachLoaiDichVu = new QuanLyKhachHangChiTiet[soLoaiDichVu];
        for (int i = 0; i < soLoaiDichVu; i++) {
            System.out.println("Nhập id cho loại dịch vụ thứ "+(i+1)+" là: ");
            int idDichVu;
            DichVu dichVu;
            do {
                try {
                    idDichVu = new Scanner(System.in).nextInt();
                    if(idDichVu <=0){
                        System.out.println("Mã dịch vụ phải là số dương, vui lòng nhập lại: ");
                        continue;
                    }
                    dichVu = dichVuLogic.searchById(idDichVu);
                    if(dichVu!=null){
                        break;
                    }
                    System.out.println("Không tìm thấy loại dịch vụ có mã "+(idDichVu)+", vui lòng nhập lại: ");
                }catch (InputMismatchException ex){
                    System.out.println("Nhập sai định dạng, mời nhập lại: ");
                }
            }while (true);
            System.out.println("Nhập số lượng sử dụng của dịch vụ: ");
            int soLuongSuDung;
            do{
                try {
                    soLuongSuDung = new Scanner(System.in).nextInt();
                    if(soLuongSuDung>0){
                        break;
                    }
                    System.out.println("Số lượng phải là số dương, vui lòng nhập lại: ");
                }catch (InputMismatchException ex){
                    System.out.println("Nhập sai định dạng, nhập lại đê: ");
                }
            }while (true);
            QuanLyKhachHangChiTiet detail = new QuanLyKhachHangChiTiet(dichVu, soLuongSuDung);
            saveLoaiDichVuChiTiet(detail, danhSachLoaiDichVu);
        }
        return danhSachLoaiDichVu;
    }

    private void saveLoaiDichVuChiTiet(QuanLyKhachHangChiTiet detail, QuanLyKhachHangChiTiet[] danhSachLoaiDichVu) {
        for (int i = 0; i < danhSachLoaiDichVu.length; i++) {
            if(danhSachLoaiDichVu[i] == null){
                danhSachLoaiDichVu[i] = detail;
                break;
            }
        }
    }

    private KhachHang nhapKhachHang() {
        int idKhachHang;
        KhachHang khachHang;
        do {
            try {
                idKhachHang = new Scanner(System.in).nextInt();
                if(idKhachHang <= 0){
                    System.out.println("Mã khách hàng phải là số dương, nhập lại đi: ");
                    continue;
                }
                khachHang = khachHangLogic.searchById(idKhachHang);
                if (khachHang != null) {
                    break;
                }
                System.out.println("Không tìm thấy khách hàng có mã "+(idKhachHang)+", vui lòng nhập lại: ");
            }catch (InputMismatchException ex){
                System.out.println("Nhập sai định dạng, mời nhập lại: ");
            }
        }while (true);
        return khachHang;
    }
    public void sapXepTenKhangHang() {
        if (!coDuLieuHayChua()) {
            System.out.println("Chưa có thông tin khách hàng hoặc dịch vụ, vui lòng nhập danh sách khách hàng và dịch vụ trước");
            return;
        }
        for (int i = 0; i < quanLyKhachHangs.length - 1; i++) {
            for (int j = i + 1; j < quanLyKhachHangs.length; j++) {
                if(quanLyKhachHangs[i] != null && quanLyKhachHangs[j] != null){
                    if (quanLyKhachHangs[i].getKhachHang().getName().trim().compareToIgnoreCase(quanLyKhachHangs[j].getKhachHang().getName().trim()) > 0) {
                        QuanLyKhachHang temp = quanLyKhachHangs[i];
                        quanLyKhachHangs[i] = quanLyKhachHangs[j];
                        quanLyKhachHangs[j] = temp;
                    }
                }
            }
        }
        showQuanLyKhachHang();
    }
    public void sortByPostNumber() {
        if (!coDuLieuHayChua()) {
            System.out.println("Chưa có thông tin khách hàng hoặc dịch vụ, vui lòng nhập danh sách khách hàng và dịch vụ trước");
            return;
        }
        for (int i = 0; i < quanLyKhachHangs.length - 1; i++) {
            for (int j = i + 1; j < quanLyKhachHangs.length; j++) {
                if(quanLyKhachHangs[i] != null && quanLyKhachHangs[j]!= null){
                    if (quanLyKhachHangs[i].getTongDichVu() < quanLyKhachHangs[j].getTongDichVu()) {
                        QuanLyKhachHang temp = quanLyKhachHangs[i];
                        quanLyKhachHangs[i] = quanLyKhachHangs[j];
                        quanLyKhachHangs[j] = temp;
                    }
                }
            }
        }
        showQuanLyKhachHang();
    }


    public void tinhThuNhap() {
        if (!coDuLieuHayChua()) {
            System.out.println("Chưa có thông tin khách hàng hoặc dịch vụ, vui lòng nhập danh sách khách hàng và dịch vụ trước");
            return;
        }
        for (int i = 0; i < quanLyKhachHangs.length; i++) {
            double tongThuNhap = 0;
            if(quanLyKhachHangs[i] != null){
                QuanLyKhachHang baoCaoDichVu = quanLyKhachHangs[i];
                QuanLyKhachHangChiTiet[] danhSachDichVu = baoCaoDichVu.getQuanLyKhachHangChiTiets();
                for (int j = 0; j < danhSachDichVu.length; j++) {

                    tongThuNhap += danhSachDichVu[j].getDichVu().getPrice() * danhSachDichVu[j].getSoluong();
                }
                System.out.println("Tổng thu nhập của  " + quanLyKhachHangs[i].getKhachHang().getName() + " là: " + tongThuNhap);
            }
        }
    }
    private boolean coDuLieuHayChua() {
        boolean coDuLieuKhachHang = false;
        for (int i = 0; i < khachHangLogic.getKhachHangs().length; i++) {
            if (khachHangLogic.getKhachHangs()[i] != null) {
                coDuLieuKhachHang = true;
                break;
            }
        }

        boolean coDuLieuDichVu = false;
        for (int i = 0; i < dichVuLogic.getDichVus().length; i++) {
            if (dichVuLogic.getDichVus()[i] != null) {
                coDuLieuDichVu = true;
                break;
            }
        }

        return coDuLieuKhachHang && coDuLieuDichVu;
    }
}
