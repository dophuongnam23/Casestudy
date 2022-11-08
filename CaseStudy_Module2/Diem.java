package CaseStady;

import java.io.Serializable;

public class Diem implements Serializable, Comparable<Diem>  {
    private SinhVien sinhvien;
    private String giaiTich;
    private String hoaCong;
    private String vatLy;
    private String diemTB;

    public Diem() {
    }

    public Diem(SinhVien sinhvien) {
        this.sinhvien = sinhvien;
    }

    public Diem(SinhVien sinhvien, String giaiTich, String hoaCong, String vatLy, String diemTB) {
        this.sinhvien = sinhvien;
        this.giaiTich = giaiTich;
        this.hoaCong = hoaCong;
        this.vatLy = vatLy;
        this.diemTB = diemTB;
    }

    public Diem(SinhVien temp, String giaiTich, String hoaCong, String vatLy, double diemTB) {
    }


    public SinhVien getSinhvien() {
        return sinhvien;
    }

    public void setSinhvien(SinhVien sinhvien) {
        this.sinhvien = sinhvien;
    }

    public String getGiaiTich() {
        return giaiTich;
    }

    public void setGiaiTich(String giaiTich) {
        this.giaiTich = giaiTich;
    }

    public String getHoaCong() {
        return hoaCong;
    }

    public void setHoaCong(String hoaCong) {
        this.hoaCong = hoaCong;
    }

    public String getVatLy() {
        return vatLy;
    }

    public void setVatLy(String vatLy) {
        this.vatLy = vatLy;
    }

    public String getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(String diemTB) {
        this.diemTB = diemTB;
    }
    public boolean checkHocBong(){
          if(Double.parseDouble(diemTB) >= 8){
              return true;
          }
          return false;
    }
    public boolean checkCanhCao(){
        if(Double.parseDouble(diemTB) <= 2){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Diem{" +
                "sinhvien = " + sinhvien.toString() +
                ", giaiTich = " + giaiTich +
                ", hoaCong = " + hoaCong +
                ", vatLy = " + vatLy +
                ", diemTB = " + diemTB +
                '}';
    }
    public int compareto(Diem o){
       String tenThis = this.getSinhvien().getHoVaTen();
       String ten0 = o.getSinhvien().getHoVaTen();
       return tenThis.compareTo(ten0);
    }


    @Override
    public int compareTo(Diem o) {
        return this.sinhvien.getHoVaTen().compareTo(o.sinhvien.getHoVaTen());
    }

}

