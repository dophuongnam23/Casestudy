package CaseStady;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Main implements Serializable {
    static ArrayList<SinhVien> arr = new ArrayList<>();
    static ArrayList<Diem> listDiem = new ArrayList<>();
    private static String giaiTich;
    private static String vatLy;
    private static String hoaCong;

    public static void writeFie() {
        try {
            File path = new File("src/CaseStady/data.txt");
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listDiem);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void themSinhVien() {
        Pattern p = Pattern.compile("[a-z\\sA-Z]+");
        Pattern s = Pattern.compile("[0-9]{4,6}");
        Pattern g = Pattern.compile("[a-zA-Z][a-zA-Z0-9]*(@nuce\\.edu\\.vn)");
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhập thông tin sinh viên: ");
        String id;
        while (true) {
            System.out.println("Nhập mã sinh viên (bắt buộc):");
            id = sc.nextLine();
            int count = 0;
            if (id.matches(String.valueOf(s)) && !id.equals(" ")) {
                for (int i = 0; i < listDiem.size(); i++) {
                    if (id.equals(listDiem.get(i).getSinhvien().getId())) {
                        count++;
                        break;
                    }
                }
                if (count == 0) {
                    break;
                } else {
                    System.out.println("Mã sinh viên dã tồn tại. Vui lòng nhập lại");
                }

            } else {
                System.out.println("Mã sinh viên bắt buộc là số , không được để trống và (4-6) kí tự  !");
            }

        }
        String hoVaTen;
        while (true) {
            System.out.println("Nhập họ tên sinh viên (bắt buộc):");
            hoVaTen = sc.nextLine();
            if (hoVaTen.matches(String.valueOf(p)) && hoVaTen != " ") {
                break;
            } else {
                System.out.println("Họ và tên bắt buộc là chữ và không được để trống !");
            }
        }
        System.out.println("Nhập lớp (bắt buộc):");
        String lop = sc.nextLine();
        System.out.println("Nhập khoa (bắt buộc):");
        String khoa = sc.nextLine();
        String email;
        while (true) {
            System.out.println("Nhập email (bắt buộc):");
            email = sc.nextLine();
            if (g.matcher(email).find() && email != "") {
                break;
            } else {
                System.out.println("Email có dạng examp@nuce.edu.vn và không được để trống !");
            }
        }
        String namSinh;
        while (true) {
            System.out.println("Nhập năm sinh (bắt buộc):");
            namSinh = sc.nextLine();
            if (namSinh.matches(String.valueOf(s)) && namSinh != " ") {
                break;
            } else {
                System.out.println("Năm sinh bắt buộc là số , không được để trống và (4-6) kí tự  !");
            }
        }
        String queQuan;
        while (true) {
            System.out.println("Nhập quê quán sinh viên (bắt buộc):");
            queQuan = sc.nextLine();
            if (queQuan.matches(String.valueOf(p)) && queQuan != " ") {
                break;
            } else {
                System.out.println("Quê quán bắt buộc là chữ và không được để trống !");
            }
        }
//        writeFie("src/CaseStady/data.txt");
        SinhVien sv = new SinhVien(id, hoVaTen, lop, khoa, email, namSinh, queQuan);
        listDiem.add(new Diem(sv));

    }

    public static int checkExit(String id) {
        for (Diem p : listDiem
        ) {
            if (p.getSinhvien().getId().equals(id)) {
                return listDiem.indexOf(p);
            }
        }
        return -1;
    }

    public static void suaSinhVien() {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Nhập mã sinh viên muốn sửa: ");
            String ids = scanner.nextLine();
            int index = 0;
            if ((index = checkExit(ids)) != -1) {
                for (int i = 0; i < listDiem.size(); i++) {
                    if (ids.equals(listDiem.get(i).getSinhvien().getId())) {
                        System.out.println(listDiem.get(i).toString());
                        index = i;
                    }
                }
                System.out.println("Nhập tên mới: ");
                String hoVaTens = scanner.nextLine();
                if (!hoVaTens.equals("")) {
                    listDiem.get(index).getSinhvien().setHoVaTen(hoVaTens);
                }
                System.out.println("Nhập lớp mới: ");
                String lops = scanner.nextLine();
                if (!lops.equals("")) {
                    listDiem.get(index).getSinhvien().setLop(lops);
                }
                System.out.println("Nhập khoa mới: ");
                String khoas = scanner.nextLine();
                if (!khoas.equals("")) {
                    listDiem.get(index).getSinhvien().setKhoa(khoas);
                }
                System.out.println("Nhập email mới: ");
                String emails = scanner.nextLine();
                if (!emails.equals("")) {
                    listDiem.get(index).getSinhvien().setEmail(emails);
                }
                System.out.println("Nhập năm sinh mới: ");
                String namSinhs = scanner.nextLine();
                if (!namSinhs.equals("")) {
                    listDiem.get(index).getSinhvien().setNamSinh(namSinhs);
                }
                System.out.println("Nhập quê quán mới: ");
                String queQuans = scanner.nextLine();
                if (!queQuans.equals("")) {
                    listDiem.get(index).getSinhvien().setQueQuan(queQuans);
                }

            } else {
                System.err.println("Không có sinh viên nào");
            }
        } catch (Exception e) {
            System.out.println("Vui lòng nhập lại");
        }

    }

    public static void xoaSinhVien() {
        Scanner scanner = new Scanner(System.in);
        for (Diem a : listDiem) {
            System.out.println(a.toString());
        }
        try {
            System.out.println("Nhập mã của sinh viên muốn xóa: ");
            String ids = scanner.nextLine();
            Pattern p1 = Pattern.compile("(?:Y|N)");
            int index;
            if ((index = checkExit(ids)) != -1) {
                String answer;
                while (true) {
                    System.out.println("Bạn có chắc chắc muốn xóa ?");
                    System.out.println("ấn Y để đồng ý, N để từ chối !");
                    answer = scanner.nextLine();
                    if (answer.matches(String.valueOf(p1))) {
                        if (answer.equals("Y")) {
                            listDiem.remove(index);
                            break;
                        } else if (answer.equals("N")) {
                            break;
                        }
                    }
                }
            } else {
                System.out.println("Sinh viên không tồn tại!");
            }
        } catch (NumberFormatException e) {
            System.err.println("Thông tin bạn nhập chưa phù hợp! Mời nhập lại!");
        }
    }


//    public static void xapSepTen {
//        @Override
//        public int compare() {
//            return o1.getSinhvien().getHoVaTen().compareTo(o2.getSinhvien().getHoVaTen());
//        }
//    }

    public static void hienThi() {
        try {
            if (listDiem.isEmpty()) {
                System.out.println("Hiện không có sinh viên nào !");
            } else {
                for (Diem a : listDiem) {
                    System.out.println(a.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void thoat() {
        System.out.println("Hẹn gặp lại !");
        System.exit(0);
    }

    public static void timKiemSinhVien() {
        Scanner sc = new Scanner(System.in);
        if (listDiem.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên !");
        } else {
            System.out.println("Nhập mã hoặc tên sinh viên cần tìm:");
            String check = sc.nextLine();
            int count = 0;
            for (Diem p : listDiem) {
                if (p.getSinhvien().getId().equals(check) || p.getSinhvien().getHoVaTen().equals(check)) {
                    System.out.println(p);
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Không tìm thấy sinh viên ứng với mã vừa nhập ! ");

            }
        }
    }

    public static void themDiem() {
        Scanner scanner = new Scanner(System.in);
        Pattern d = Pattern.compile("[0-9]+$");
        SinhVien temp = null;

        try {
            String ids;
            while (true) {
                System.out.println("Nhập mã sinh viên:");
                ids = scanner.nextLine();
                if (ids.matches(String.valueOf(d)) && !ids.equals(" ")) {
                    break;
                } else {
                    System.out.println("Mã sinh viên bắt buộc là số , không được để trống và (4-6) kí tự  !");
                }
            }
            int count = 0;
            int index = 0;
            for (int i = 0; i < listDiem.size(); i++) {
                if (ids.equals(listDiem.get(i).getSinhvien().getId())) {
                    temp = listDiem.get(i).getSinhvien();
                    if (listDiem.get(i).getGiaiTich() == null) {
                        System.out.println(listDiem.get(i).toString());
                        count++;
                        index = i;
                        break;
                    }

                }
            }
            if (count == 0) {
                System.out.println("Sinh viên đã có điểm");
            } else {
                String giaiTich;
                while (true) {
                    System.out.println("Nhập điểm Giải tích (bắt buộc):");
                    giaiTich = scanner.nextLine();
                    if (giaiTich.matches(String.valueOf(d)) && !giaiTich.equals(" ")) {
                        break;
                    } else {
                        System.out.println("Điểm giải tích bắt buộc là số và không được để trống !");
                    }
                }
                String hoaCong;
                while (true) {
                    System.out.println("Nhập điểm Hóa công (bắt buộc):");
                    hoaCong = scanner.nextLine();
                    if (hoaCong.matches(String.valueOf(d)) && !hoaCong.equals(" ")) {
                        break;
                    } else {
                        System.out.println("Điểm hóa công bắt buộc là số và không được để trống !");
                    }
                }
                String vatLy;
                while (true) {
                    System.out.println("Nhập điểm Vật lý (bắt buộc):");
                    vatLy = scanner.nextLine();
                    if (vatLy.matches(String.valueOf(d)) && !vatLy.equals(" ")) {
                        break;
                    } else {
                        System.out.println("Điểm vật lý bắt buộc là số và không được để trống !");
                    }
                }
                double diemTB = (Double.parseDouble(giaiTich) + Double.parseDouble(hoaCong) + Double.parseDouble(vatLy)) / 3;
                listDiem.set(index, new Diem(temp, giaiTich, hoaCong, vatLy, String.valueOf(diemTB)));
                return;
            }

        } catch (
                Exception e) {
            System.out.println("Vui lòng nhập lại");
        }

    }


    public static void suaDiem() {
        SinhVien temp = null;
        int index = 0;
        int count = 0;
        Pattern d = Pattern.compile("[0-9]$");
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Nhập mã sinh viên muốn sửa điểm: ");
            String ids = scanner.nextLine();

            if ((index = checkExit(ids)) != -1) {
                double diemTB = 0;
                for (int i = 0; i < listDiem.size(); i++) {
                    if (ids.equals(listDiem.get(i).getSinhvien().getId())) {
                        System.out.println(listDiem.get(i).toString());
                        index = i;

                    }
                    if (count == 0) {
                        break;
                    } else {
                        System.out.println("Mã sinh viên bắt buộc là số , không được để trống và (4-6) kí tự  !");
                    }
                }
                while (true) {
                    System.out.println("Nhập điểm giải tích");
                    String giaiTichs = scanner.next();

//                    listDiem.get(index).setGiaiTich(giaiTichs);
                    if (giaiTichs.matches(String.valueOf(d)) && !giaiTichs.equals(" ")) {
                        listDiem.get(index).setGiaiTich(giaiTichs);
                        diemTB += Double.parseDouble(giaiTichs);
                        break;
                    } else {
                        System.out.println("Điểm giải tích bắt buộc là số từ (0-10) và không được để trống !");
                    }
                }
                while (true) {
                    System.out.println("Nhập điểm hóa công");
                    String hoaCongs = scanner.next();
                    if (!hoaCongs.equals("") && hoaCongs.matches(String.valueOf(d))) {
                        listDiem.get(index).setHoaCong(hoaCongs);
                        diemTB += Double.parseDouble(hoaCongs);
                        break;
                    }
                }
                while (true) {
                    System.out.println("Nhập điểm vật lý");
                    String vatLys = scanner.next();
                    if (!vatLys.equals("") && vatLys.matches(String.valueOf(d))) {
                        listDiem.get(index).setVatLy(vatLys);
                        diemTB += Double.parseDouble(vatLys);
                        break;
                    }
                }
                diemTB = diemTB / 3;
                listDiem.get(index).setDiemTB(String.valueOf(diemTB));
            }
        } catch (Exception e) {
            System.out.println("Vui lòng nhập lại");
        }
//        double diemTB = (Double.parseDouble(giaiTich) + Double.parseDouble(hoaCong) + Double.parseDouble(vatLy)) / 3;
//        listDiem.set(index, new Diem(temp, giaiTich, hoaCong, vatLy, String.valueOf(diemTB)));
    }


    public static void readFile() {
        File path = new File("src/CaseStady/data.txt");
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            listDiem = (ArrayList<Diem>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            System.out.println("Không có cơ sở dữ liệu");
        }
    }

    public static void hocBong() {
        Collections.sort(listDiem, new Comparator<Diem>() {
            @Override
            public int compare(Diem o1, Diem o2) {
                return Double.parseDouble(o1.getDiemTB()) >= Double.parseDouble(o2.getDiemTB()) ? 1 : 1;
            }
        });
        int count = 0;
        for (int i = 0; i < listDiem.size(); i++) {
            if (listDiem.get(i).checkHocBong()) {
                count++;
                System.out.println(listDiem.get(i).toString());
            }
        }
        if (count == 0) {
            System.out.println("Không có sinh viên nào đạt học bổng !");
        }

    }

    public static void canhCao() {
        Collections.sort(listDiem, new Comparator<Diem>() {
            @Override
            public int compare(Diem o1, Diem o2) {
                return Double.parseDouble(o1.getDiemTB()) >= Double.parseDouble(o2.getDiemTB()) ? 1 : 1;
            }
        });
        int count = 0;
        for (int i = 0; i < listDiem.size(); i++) {
            if (listDiem.get(i).checkCanhCao()) {
                count++;
                System.out.println(listDiem.get(i).toString());
            }
        }
        if (count == 0) {
            System.out.println("Không có sinh viên nào bị cảnh cáo !");
        }

    }


    public static void xapSepTen() {
        Collections.sort(listDiem);
        for (Diem p : listDiem
        ) {
            System.out.println(p);
        }
    }

    public static void xapSepDTB() {
        listDiem.sort(Comparator.comparing(Diem::getDiemTB));
        for (Diem p : listDiem
        ) {
            System.out.println(p);

        }
    }
    public static void main(String[] args) {

        int luaChon = -1;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Tài khoản :");
            String id = sc.nextLine();
            System.out.println("Mật khẩu");
            String pass = sc.nextLine();
            if (id.equals("admin") && pass.equals("9999")) {
                do {
                    System.out.println("Bạn đang truy cập với tư cách Quản trị viên: ");
                    System.out.println("MENU: ");
                    System.out.println(" Mời user chọn: ");
                    System.out.println("1.  Thêm sinh viên:");
                    System.out.println("2.  Sửa sinh viên:");
                    System.out.println("3.  Xóa sinh viên:");
                    System.out.println("4.  Sắp sếp sinh viên tăng dần theo DTB:");
                    System.out.println("5.  Sắp xếp sinh viên theo tên từ A-Z:");
                    System.out.println("6.  Tìm kiếm sinh viên:");
                    System.out.println("7.  Quản lí điểm:");
                    System.out.println("8.  Danh sách tạm thời:");
                    System.out.println("9.  Lưu thông tin !");
                    System.out.println("10. Danh sách có sẵn !");
                    System.out.println("11. Danh sách sinh viên đạt học bổng !");
                    System.out.println("12. Danh sách sinh viên bị cảnh cáo học tập !");
                    System.out.println("0.  Thoát");
                    try {
                        luaChon = Integer.parseInt(sc.next());
                    } catch (Exception e) {
                        System.out.println("Không được nhập chữ !");
                        sc.nextLine();
                    }
                    switch (luaChon) {
                        case 1:
                            themSinhVien();
                            break;
                        case 2:
                            suaSinhVien();
                            break;
                        case 3:
                            xoaSinhVien();
                            break;
                        case 4:
                            xapSepDTB();
                            break;
                        case 5:
                            xapSepTen();
                            break;
                        case 6:
                            timKiemSinhVien();
                            break;
                        case 7:
                            menuDiem();
                            break;
                        case 8:
                            hienThi();
                            break;
                        case 9:
                            writeFie();
                            break;
                        case 10:
                            readFile();
                            hienThi();
                            break;
                        case 11:
                            hocBong();
                            break;
                        case 12:
                            canhCao();
                            break;
                        case 0:
                            System.exit(0);
                        default:
                            System.out.println("Vui lòng nhập đúng số !");
                    }
                } while (true);
            } else if (id.equals("nam") && pass.equals("nam123")) {
                do {
                    System.out.println("Bạn đang truy cập với tư cách là sinh viên:");
                    System.out.println("MENU: ");
                    System.out.println("Mời user chọn: ");
                    System.out.println("1. Sắp sếp sinh viên theo DTB");
                    System.out.println("2. Sắp xếp sinh viên theo tên");
                    System.out.println("3. Tìm kiếm sinh viên:");
                    System.out.println("4. Danh sách có sẵn");
                    System.out.println("5. Danh sách sinh viên đạt học bổng !");
                    System.out.println("6. Danh sách sinh viên bị cảnh cáo học tập !");
                    System.out.println("0.Thoát");
                    try {
                        luaChon = Integer.parseInt(sc.next());
                    } catch (Exception e) {
                        System.out.println("Không được nhập chữ ! ");
                    }
                    switch (luaChon) {
                        case 1:
                            xapSepDTB();
                            break;
                        case 2:
                            xapSepTen();
                            break;
                        case 3:
                            timKiemSinhVien();
                            break;
                        case 4:
                            readFile();
                            hienThi();
                            break;
                        case 5:
                            hocBong();
                            break;
                        case 6:
                            canhCao();
                            break;
                        case 0:
                            System.exit(0);
                        default:
                            System.out.println("Vui lòng nhập đúng số!");
                    }
                } while (true);
            } else {
                System.out.println("Tài khoản hoặc mật khẩu không chính xác, vui lòng nhập lại !");
            }
        }

    }

    public static void menuDiem() {
        Scanner sc = new Scanner(System.in);
        int luaChon = -1;
        do {
            System.out.println("Bạn đang ở mục quản lí điểm !");
            System.out.println("1.Thêm điểm");
            System.out.println("2.Sửa điểm");
            System.out.println("3.lưu lại");
            System.out.println("0.Thoát");
            System.out.println("Mời nhập lựa chọn: ");
            try {
                luaChon = Integer.parseInt(sc.next());

            } catch (Exception e) {
                System.out.println("Không được nhập chữ!");
            }
            switch (luaChon) {
                case 1:
                    themDiem();
                    break;
                case 2:
                    suaDiem();
                    break;
                case 3:
                    writeFie();
                default:
                    System.out.println("Vui lòng nhập đúng số !");
            }
        } while (luaChon != 0);
    }
}
