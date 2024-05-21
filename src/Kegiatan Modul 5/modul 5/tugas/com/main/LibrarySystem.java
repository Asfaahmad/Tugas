package modul5.tugas.com.main;

import modul5.tugas.books.*;
import modul5.tugas.data.Admin;
import modul5.tugas.data.Student;
import modul5.tugas.exception.custom.illegalAdminAccess;

import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {
    public static ArrayList<Book> daftarBuku = new ArrayList<>();
    public static ArrayList<Student> daftarSiswa = new ArrayList<>();
    public static int i = 0;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        daftarBuku.add(new TextBook("AF164", "Indahnya Negeriku", 4, "Text", "Fiersa"));
        daftarBuku.add(new HistoryBook("KO03F", "Sejarah berdirinya kerajaan majapahit", 2, "History", "Raden"));
        daftarBuku.add(new StoryBook("LF413", "Habibie Ainun", 17, "Story", "Eric"));
        daftarBuku.add(new HistoryBook("BI09P", "February", 2, "History", "Asfa"));

        // Mengisi daftar mahasiswa
        daftarSiswa.add(new Student("202310370311203", "Asfa ahmad", "Teknik", "Informatika"));
        daftarSiswa.add(new Student("202310370311123", "Muhammad Alfarisi", "Teknik", "Informatika"));
        daftarSiswa.add(new Student("202310370311124", "Noval", "Teknik", "Informatika"));
        menu();

    }

    public static void menu() {
        boolean isRunning = true;
        while (isRunning) {

            try {
                System.out.println("===== Library System =====");
                System.out.println("1. Login sebagai Mahasiswa");
                System.out.println("2. Login sebagai Admin");
                System.out.println("3. Keluar");
                System.out.print("Pilih antara (1-3): ");

                if (!scanner.hasNextInt()) {
                    scanner.next();
                    throw new illegalAdminAccess("Invalid Credentials");
                }


                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Masukkan NIM : ");
                        String nimStudent = scanner.next();
                        scanner.nextLine();
                        while (true) {
                            if (nimStudent.length() != 15) {
                                System.out.print("Nim Harus 15 Digit!!!\n");
                                System.out.print("Masukkan NIM : ");
                                nimStudent = scanner.nextLine();
                            } else if (checkNim(nimStudent)) {
                                Student student = new Student(nimStudent);
                                student.login();
                                break;
                            } else {
                                System.out.println("Nim tidak terdaftar!");
                                break;
                            }
                        }
                        break;
                    case 2:
                        Admin admin = new Admin();
                        admin.login();
                        break;
                    case 3:
                        System.out.println("Terima kasih semoga puas dengan pelayanan kami");
                        isRunning = false;
                        break;
                    default:
                        throw new illegalAdminAccess("Invalid credentials");
                }
            } catch (illegalAdminAccess e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                scanner.nextLine(); // Membersihkan inputan agar tidak terjadi loop
            }
        }
    }

    public static boolean checkNim(String nim) {
        for (Student student : daftarSiswa) {
            if (student.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }
}
