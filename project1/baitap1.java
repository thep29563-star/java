class Diem {
     private double x;
    private double y;

    public Diem(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

class DuongThang {
    private Diem A;
    private Diem B;

    public Diem getA() {
        return A;
    }

    public Diem getB() {
        return B;
    }

    public DuongThang(Diem a, Diem b) {
        A = a;
        B = b;
    }

    public double doDai() {
        double dx = B.getX() - A.getX();
        double dy = B.getY() - A.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}

public class baitap1 {
    public static void main(String[] args) {
        Diem A = new Diem(1, 2);
        Diem B = new Diem(4, 6);
        DuongThang line = new DuongThang(A, B);
        System.out.println("Do dai duong thang AB: " + line.doDai());
    }
}
