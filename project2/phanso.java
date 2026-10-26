package project2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class phanso {
    private int tuSo;
    private int mauSo;

    public phanso() {
        this(0, 1);
    }

    public phanso(int tuSo, int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mau so khong duoc bang 0.");
        }
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }

    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mau so khong duoc bang 0.");
        }
        this.mauSo = mauSo;
    }

    @Override
    public String toString() {
        return tuSo + "/" + mauSo;
    }

    public phanso cong(phanso other) {
        BigInteger tu = BigInteger.valueOf(tuSo).multiply(BigInteger.valueOf(other.mauSo))
                .add(BigInteger.valueOf(other.tuSo).multiply(BigInteger.valueOf(mauSo)));
        BigInteger mau = BigInteger.valueOf(mauSo).multiply(BigInteger.valueOf(other.mauSo));
        return taoPhanSoRutGon(tu, mau);
    }

    public phanso tru(phanso other) {
        BigInteger tu = BigInteger.valueOf(tuSo).multiply(BigInteger.valueOf(other.mauSo))
                .subtract(BigInteger.valueOf(other.tuSo).multiply(BigInteger.valueOf(mauSo)));
        BigInteger mau = BigInteger.valueOf(mauSo).multiply(BigInteger.valueOf(other.mauSo));
        return taoPhanSoRutGon(tu, mau);
    }

    public phanso nhan(phanso other) {
        BigInteger tu = BigInteger.valueOf(tuSo).multiply(BigInteger.valueOf(other.tuSo));
        BigInteger mau = BigInteger.valueOf(mauSo).multiply(BigInteger.valueOf(other.mauSo));
        return taoPhanSoRutGon(tu, mau);
    }

    public phanso chia(phanso other) {
        if (other.tuSo == 0) {
            throw new ArithmeticException("Khong the chia cho phan so 0.");
        }
        BigInteger tu = BigInteger.valueOf(tuSo).multiply(BigInteger.valueOf(other.mauSo));
        BigInteger mau = BigInteger.valueOf(mauSo).multiply(BigInteger.valueOf(other.tuSo));
        return taoPhanSoRutGon(tu, mau);
    }

    public int soSanh(phanso other) {
        BigInteger trai = BigInteger.valueOf(tuSo).multiply(BigInteger.valueOf(other.mauSo));
        BigInteger phai = BigInteger.valueOf(other.tuSo).multiply(BigInteger.valueOf(mauSo));
        int ketQua = trai.compareTo(phai);
        return mauSo < 0 ^ other.mauSo < 0 ? -ketQua : ketQua;
    }

    public void rutGon() {
        phanso rutGon = taoPhanSoRutGon(BigInteger.valueOf(tuSo), BigInteger.valueOf(mauSo));
        tuSo = rutGon.tuSo;
        mauSo = rutGon.mauSo;
    }

    private static phanso taoPhanSoRutGon(BigInteger tu, BigInteger mau) {
        if (mau.signum() == 0) {
            throw new ArithmeticException("Mau so khong duoc bang 0.");
        }
        if (mau.signum() < 0) {
            tu = tu.negate();
            mau = mau.negate();
        }
        BigInteger uocChung = tu.gcd(mau);
        tu = tu.divide(uocChung);
        mau = mau.divide(uocChung);
        return new phanso(tu.intValueExact(), mau.intValueExact());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong phan so: ");
        int n = scanner.nextInt();

        if (n < 0) {
            throw new IllegalArgumentException("So luong phan so khong duoc am.");
        }

        List<phanso> danhSach = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap tu so va mau so cua phan so thu " + (i + 1) + ": ");
            danhSach.add(new phanso(scanner.nextInt(), scanner.nextInt()));
        }

        phanso tong = new phanso();
        phanso lonNhat = null;
        int soPhanSoKhongNguyen = 0;
        for (phanso p : danhSach) {
            tong = tong.cong(p);
            if (lonNhat == null || p.soSanh(lonNhat) > 0) {
                lonNhat = p;
            }
            if (BigInteger.valueOf(p.getTuSo()).remainder(BigInteger.valueOf(p.getMauSo())).signum() != 0) {
                soPhanSoKhongNguyen++;
            }
        }

        System.out.println("Phan so lon nhat: " + (lonNhat == null ? "khong co" : lonNhat));
        System.out.println("Tong cac phan so: " + tong);
        System.out.println("So phan so khong phai so nguyen: " + soPhanSoKhongNguyen);
    }
}
