package constant;

public enum LoaiKhachHang {

    CN("Cá Nhân"),
    DDDVHC("Đại diện đơn vị hành chính"),

    DDDVKD("Đại diện đơn vị kinh doanh");

    private String value;

    LoaiKhachHang(String value) {
        this.value = value;
    }
}
