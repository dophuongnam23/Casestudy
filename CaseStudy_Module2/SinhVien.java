package CaseStady;

import java.io.Serializable;

public class SinhVien implements Serializable, Comparable<SinhVien> {
    private String id;
    private String hoVaTen;
    private String lop;
    private String khoa;
    private String email;
    private String namSinh;
    private String queQuan;
    private double diemTrungBinh;

    public SinhVien() {
    }

    public SinhVien(String id, String hoVaTen, String lop, String khoa, String email,String namSinh,String queQuan ) {
        this.id = id;
        this.hoVaTen = hoVaTen;
        this.lop = lop;
        this.khoa = khoa;
        this.namSinh = namSinh;
        this.email = email;
        this.queQuan = queQuan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                " id= " + id + '\'' +
                ", hoVaTen= " + hoVaTen + '\'' +
                ", lop= " + lop + '\'' +
                ", khoa= " + khoa + '\'' +
                ", email= " + email + '\'' +
                ", namSinh= " + namSinh + '\'' +
                ", queQuan= " + queQuan + '\'' +
                '}';
    }

    public static <U extends Comparable<? super U>, T> U gethoVaTen(T t) {
        return gethoVaTen(t);
    }

    @Override
    public int compareTo(SinhVien o) {
        return this.hoVaTen.compareTo(o.hoVaTen);
    }
}
