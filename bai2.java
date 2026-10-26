class TamGiac {
    private Diem A;
    private Diem B;
    private Diem C;

    public TamGiac(Diem a, Diem b, Diem c) {
        A = a;
        B = b;
        C = c;
    }

    public double chuVi() {
        double AB = Math.sqrt(Math.pow(B.getX() - A.getX(), 2) + Math.pow(B.getY() - A.getY(), 2));
        double BC = Math.sqrt(Math.pow(C.getX() - B.getX(), 2) + Math.pow(C.getY() - B.getY(), 2));
        double CA = Math.sqrt(Math.pow(A.getX() - C.getX(), 2) + Math.pow(A.getY() - C.getY(), 2));
        return AB + BC + CA;
    }
    public double dienTich() {
        double AB = Math.sqrt(Math.pow(B.getX() - A.getX(), 2) + Math.pow(B.getY() - A.getY(), 2));
        double BC = Math.sqrt(Math.pow(C.getX() - B.getX(), 2) + Math.pow(C.getY() - B.getY(), 2));
        double CA = Math.sqrt(Math.pow(A.getX() - C.getX(), 2) + Math.pow(A.getY() - C.getY(), 2));
        double p = (AB + BC + CA) / 2;
        return Math.sqrt(p * (p - AB) * (p - BC) * (p - CA));
    }
}
class ChuNhat {
    private Diem x;
    private Diem y;
    public ChuNhat(Diem x, Diem y) {
        this.x = x;
        this.y = y;
    }
    public double dienTich() {
        double width = Math.abs(y.getX() - x.getX());
        double height = Math.abs(y.getY() - x.getY());
        return width * height;
    }
    public double chuVi() {
        double width = Math.abs(y.getX() - x.getX());
        double height = Math.abs(y.getY() - x.getY());
        return 2 * (width + height);
    }
}
class HinhTron {
    private Diem center;
    private double radius;

    public HinhTron(Diem center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public double dienTich() {
        return Math.PI * radius * radius;
    }

    public double chuVi() {
        return 2 * Math.PI * radius;
    }
}
// viết phương trình khởi tạo 2 tam giác 2 hình chữ nhật 2 hình tròn và in ra chu vi và diện tích của chúng.
class Main {
    public static void main(String[] args) {
        // Khởi tạo 2 tam giác
        Diem A1 = new Diem(0, 0);
        Diem B1 = new Diem(3, 0);
        Diem C1 = new Diem(0, 4);
        TamGiac tamGiac1 = new TamGiac(A1, B1, C1);

        Diem A2 = new Diem(1, 1);
        Diem B2 = new Diem(4, 1);
        Diem C2 = new Diem(1, 5);
        TamGiac tamGiac2 = new TamGiac(A2, B2, C2);

        Diem x1 = new Diem(0, 0);
        Diem y1 = new Diem(4, 3);
        ChuNhat chuNhat1 = new ChuNhat(x1, y1);

        Diem x2 = new Diem(1, 1);
        Diem y2 = new Diem(5, 4);
        ChuNhat chuNhat2 = new ChuNhat(x2, y2);

        Diem center1 = new Diem(0, 0);
        HinhTron hinhTron1 = new HinhTron(center1, 3);

        Diem center2 = new Diem(2, 2);
        HinhTron hinhTron2 = new HinhTron(center2, 5);

        System.out.println("Chu vi tam giác 1: " + tamGiac1.chuVi());
        System.out.println("Chu vi tam giác 2: " + tamGiac2.chuVi());
        
        System.out.println("Diện tích tam giác 1: " + tamGiac1.dienTich());
        System.out.println("Diện tích tam giác 2: " + tamGiac2.dienTich());

        System.out.println("Chu vi hình chữ nhật 1: " + chuNhat1.chuVi());
        System.out.println("Chu vi hình chữ nhật 2: " + chuNhat2.chuVi());

        System.out.println("Diện tích hình chữ nhật 1: " + chuNhat1.dienTich());
        System.out.println("Diện tích hình chữ nhật 2: " + chuNhat2.dienTich());

        System.out.println("Diện tích hình tròn 1: " + hinhTron1.dienTich());
        System.out.println("Diện tích hình tròn 2: " + hinhTron2.dienTich());
        
        System.out.println("Chu vi hình tròn 1: " + hinhTron1.chuVi());
        System.out.println("Chu vi hình tròn 2: " + hinhTron2.chuVi());

    }
}
