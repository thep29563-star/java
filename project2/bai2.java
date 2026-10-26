package project2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Diem2D {
    private double x;
    private double y;

    public Diem2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double khoangCach(Diem2D other) {
        Objects.requireNonNull(other, "Diem khong duoc null.");
        return Math.hypot(x - other.x, y - other.y);
    }

    public Diem2D doiXungQuaGoc() {
        return new Diem2D(-x, -y);
    }

    public void tinhTien(double deltaX, double deltaY) {
        x += deltaX;
        y += deltaY;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class Diem3D extends Diem2D {
    private double z;

    public Diem3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public double khoangCach(Diem2D other) {
        Objects.requireNonNull(other, "Diem khong duoc null.");
        double khoangCachXY = super.khoangCach(other);
        if (other instanceof Diem3D) {
            return Math.hypot(khoangCachXY, z - ((Diem3D) other).z);
        }
        return khoangCachXY;
    }

    public double khoangCach(Diem3D other) {
        return khoangCach((Diem2D) other);
    }

    @Override
    public Diem3D doiXungQuaGoc() {
        return new Diem3D(-getX(), -getY(), -z);
    }

    public void tinhTien(double deltaX, double deltaY, double deltaZ) {
        super.tinhTien(deltaX, deltaY);
        z += deltaZ;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }
}

public class bai2 {
    public static void main(String[] args) {
        List<Diem2D> danhSach = new ArrayList<>();
        danhSach.add(new Diem2D(0, 0));
        danhSach.add(new Diem3D(1, 2, 2));
        danhSach.add(new Diem2D(3, 4));
        danhSach.add(new Diem3D(4, 6, 5));
        danhSach.add(new Diem2D(-1, 2));
        danhSach.add(new Diem3D(-2, 1, 3));

        List<Diem2D> cacDiem2D = new ArrayList<>();
        List<Diem3D> cacDiem3D = new ArrayList<>();
        for (Diem2D diem : danhSach) {
            if (diem instanceof Diem3D) {
                cacDiem3D.add((Diem3D) diem);
            } else {
                cacDiem2D.add(diem);
            }
        }

        double tongKhoangCach2D = tinhTongKhoangCach(cacDiem2D);
        double tongKhoangCach3D = tinhTongKhoangCach(cacDiem3D);
        System.out.println("Tong khoang cach giua cac diem 2D lien tiep: " + tongKhoangCach2D);
        System.out.println("Tong khoang cach giua cac diem 3D lien tiep: " + tongKhoangCach3D);

        List<Diem2D> cacDiemDoiXung = new ArrayList<>();
        for (Diem2D diem : danhSach) {
            cacDiemDoiXung.add(diem.doiXungQuaGoc());
        }
        danhSach.addAll(cacDiemDoiXung);

        System.out.println("Danh sach diem sau khi them cac diem doi xung:");
        for (Diem2D diem : danhSach) {
            System.out.println(diem);
        }
    }

    private static double tinhTongKhoangCach(List<? extends Diem2D> cacDiem) {
        double tong = 0;
        for (int i = 1; i < cacDiem.size(); i++) {
            tong += cacDiem.get(i - 1).khoangCach(cacDiem.get(i));
        }
        return tong;
    }
}
