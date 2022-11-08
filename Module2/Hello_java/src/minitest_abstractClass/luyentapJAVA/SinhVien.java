package luyentapJAVA;

public class SinhVien {
    private int id;
    private String hoVaTen;
    private String lop;
    private String khoa;
    private int namSinh;
    private String queQuan;
    private float diemTrungBinh;
    private float diemToan;
    private float diemLy;
    private float diemHoa;

    public SinhVien() {
    }

    public SinhVien(int id, String hoVaTen, String lop, String khoa, int namSinh, String queQuan, float diemTrungBinh) {
        this.id = id;
        this.hoVaTen = hoVaTen;
        this.lop = lop;
        this.khoa = khoa;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
        this.diemTrungBinh = diemTrungBinh;

    }

    public SinhVien(int id, String hoVaTen, String lop, String khoa, String namSinh, String queQuan) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

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

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public float getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(float diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    public float getDiemToan() {
        return diemToan;
    }

    public void setDiemToan(float diemToan) {
        this.diemToan = diemToan;
    }

    public float getDiemLy() {
        return diemLy;
    }

    public void setDiemLy(float diemLy) {
        this.diemLy = diemLy;
    }

    public float getDiemHoa() {
        return diemHoa;
    }

    public void setDiemHoa(float diemHoa) {
        this.diemHoa = diemHoa;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "id=" + id +
                ", hoVaTen='" + hoVaTen + '\'' +
                ", lop='" + lop + '\'' +
                ", khoa='" + khoa + '\'' +
                ", namSinh=" + namSinh +
                ", queQuan='" + queQuan + '\'' +
                '}';
    }
}
