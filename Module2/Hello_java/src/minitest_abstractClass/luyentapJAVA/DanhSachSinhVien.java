//package luyentapJAVA;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class DanhSachSinhVien {
//    public static ArrayList<SinhVien> danhSach;
//
//    public DanhSachSinhVien() {
//        danhSach = new ArrayList<>();
//    }
//
//    public DanhSachSinhVien(ArrayList<SinhVien> danhSach) {
//        super();
//        this.danhSach = danhSach;
//    }
//   public void themSinhVien(SinhVien sv){
//        danhSach.add(sv);
//   }
//    public void inDanhSachSinhVien() {
//        for (SinhVien sinhVien : danhSach) {
//            System.out.println(sinhVien);
//        }
//    }
////    public static int checkExit(int id) {
////        for (SinhVien sinhVien: danhSach) {
////            if(sinhVien.getId().equals(id)){
////                return danhSach.indexOf(sinhVien);
////            }
////        }
////        return -1;
////    }
//
//    public void suaSinhVien(Scanner scanner){
//        try {
//            System.out.println("Nhập id sinh viên: ");
//            String id = scanner.nextLine();
//            int index;
////            if ((index = checkExit(id)) != -1) {
//                System.out.println("Nhập ID mới: ");
//                int ids = scanner.nextInt();
//                if (!id.equals("")) {
//                    danhSach.get(index).setId(ids);
//
//                System.out.println("Nhập họ và tên mới: ");
//                String hoVaTen = scanner.nextLine();
//                if (!hoVaTen.equals("")) {
//                    danhSach.get(index).setHoVaTen(hoVaTen);
//                }
//                System.out.println("Nhập lớp mới: ");
//                String lop = scanner.nextLine();
//                if (!lop.equals("")) {
//                    danhSach.get(index).setLop(lop);
//                }
//                System.out.println("Nhập khoa mới: ");
//                String khoa = scanner.nextLine();
//                if (!khoa.equals("")) {
//                    danhSach.get(index).setKhoa(khoa);
//                }
//                System.out.println("Nhập năm sinh mới: ");
//                String namSinh = scanner.nextLine();
//                if (!namSinh.equals("")) {
//                    danhSach.get(index).setKhoa(namSinh);
//                }
//                System.out.println("Nhập quê quán mới: ");
//                String queQuan = scanner.nextLine();
//                if (!queQuan.equals("")) {
//                    danhSach.get(index).setKhoa(queQuan);
//                }
//
//            } else {
//                System.err.println("không có sinh viên nào");
//            }
//
//        } catch (Exception e) {
//            System.out.println("Nhập sai!!! Vui lòng nhập lại");
//        }
//    }
//    public void display() {
//        if (danhSach.isEmpty()) {
//            System.out.println("Hiện không có sinh viên nào!");
//        } else {
//            for (SinhVien m : danhSach) {
//                System.out.println(m);
//            }
//        }
//    }
//    public void delete(Scanner scanner) {
//        try {
//            System.out.println("Nhập id sản phẩm bạn muốn xóa: ");
//            String idUpdate = scanner.nextLine();
//            int index;
//            if ((index = checkExit(idUpdate)) != -1) {
//                danhSach.remove(index);
////                writeFile();
//            } else {
//                System.out.println("Sinh viên không tồn tại!");
//            }
//        } catch (NumberFormatException e) {
//            System.err.println("Thông tin bạn nhập chưa phù hợp! Mời nhập lại!");
//        }
//    }
//
//
//
//
//}
