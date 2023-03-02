package entity;

public class QuanLyKhachHangChiTiet {

    private DichVu dichVu;
    private int Soluong;

    public QuanLyKhachHangChiTiet(DichVu dichVu, int quantity) {
        this.dichVu = dichVu;
        this.Soluong = quantity;
    }

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int soluong) {
        this.Soluong = soluong;
    }

    @Override
    public String toString() {
        return "QuanLyKhachHangChiTiet{" +
                "dichVu=" + dichVu +
                ", Soluong=" + Soluong +
                '}';
    }
}
