//package luyentapJAVA;
//
//
//
//import java.util.Scanner;
//
//
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        DanhSachSinhVien dssv = new DanhSachSinhVien();
//        int luaChon = 0;
//        do{
//            System.out.println("MENU: ");
//            System.out.println("Mời user chọn: ");
//            System.out.println("1. Thêm sinh viên");
//            System.out.println("2. Sửa sinh viên");
//            System.out.println("3. Xóa sinh viên");
//            System.out.println("4. Tìm kiếm sinh viên");
//            System.out.println("5. Hiển thị danh sách");
//            System.out.println("0. Thoát");
//            luaChon = Integer.parseInt(sc.nextLine());
//            sc.nextLine();
//            switch (luaChon){
//                case 1:
//
//                    System.out.println("Nhập mã sinh viên");
//                    int id = sc.nextInt();
//                    System.out.println("Nhập họ tên sinh viên");
//                    sc.nextLine();
//                    String hoVaTen = sc.nextLine();
//                    System.out.println("Nhập lớp");
//                    String lop = sc.nextLine();
//                    System.out.println("Nhập khoa");
//                    String khoa= sc.nextLine();
//                    System.out.println("Nhập nam sinh");
//                    String namSinh = sc.nextLine();
//                    System.out.println("Nhập quê quán");
//                    String queQuan = sc.nextLine();
//                    sc.nextLine();
//                    SinhVien sv = new SinhVien(id, hoVaTen, lop, khoa, namSinh, queQuan);
//                    dssv.themSinhVien(sv);
//                    break;
//                case 5:
//                    dssv.inDanhSachSinhVien();
//            }
//        }while (luaChon != 0);
//    }
//
//}
