package entity;

import java.util.Arrays;

public class QuanLyKhachHang{

    private KhachHang khachHang;
    private QuanLyKhachHangChiTiet[] quanLyKhachHangChiTiets;
    private int tongDichVu;

    public QuanLyKhachHang(KhachHang khachHang, QuanLyKhachHangChiTiet[] quanLyKhachHangChiTiets) {
        this.khachHang = khachHang;
        this.quanLyKhachHangChiTiets = quanLyKhachHangChiTiets;
        int temp = 0;
        for (int i = 0; i < quanLyKhachHangChiTiets.length; i++) {
            temp += quanLyKhachHangChiTiets[i].getSoluong();
        }
        this.tongDichVu = temp;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public QuanLyKhachHangChiTiet[] getQuanLyKhachHangChiTiets() {
        return quanLyKhachHangChiTiets;
    }

    public void setQuanLyKhachHangChiTiets(QuanLyKhachHangChiTiet[] quanLyKhachHangChiTiets) {
        this.quanLyKhachHangChiTiets = quanLyKhachHangChiTiets;
    }

    public int getTongDichVu() {
        return tongDichVu;
    }

    public void setTongDichVu(int tongDichVu) {
        this.tongDichVu = tongDichVu;
    }

    @Override
    public String toString() {
        return "QuanLyKhachHang{" +
                "khachHang=" + khachHang +
                ", quanLyKhachHangChiTiets=" + Arrays.toString(quanLyKhachHangChiTiets) +
                '}';
    }
}
