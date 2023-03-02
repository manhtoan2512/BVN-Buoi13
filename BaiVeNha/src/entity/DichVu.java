package entity;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DichVu implements Inputable {

    private int idDichVu;
    private String name;
    private double price;
    private String unit;
    private static int AUTO_ID = 100;

    public int getIdDichVu() {
        return idDichVu;
    }

    public void setIdDichVu(int idDichVu) {
        this.idDichVu = idDichVu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "DichVu{" +
                "idDichVu=" + idDichVu +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        this.idDichVu = AUTO_ID;
        AUTO_ID++;
        System.out.println("Nhập tên dịch vụ: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập giá của dịch vụ: ");
        do {
            try {
                this.price = new Scanner(System.in).nextDouble();
                if(this.price > 0){
                    break;
                }
                System.out.println("Phải là số dương, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Nhập sai định dạng, nhập lại đê: ");
            }
        } while (true);
        System.out.println("Nhập đơn vị tính của dịch vụ: ");
        this.unit = new Scanner(System.in).nextLine();
    }

}
