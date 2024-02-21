import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class DataDiri {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inputan nama orang
        System.out.print("Masukkan nama : ");
        String nama = scanner.nextLine();

        // Inputan jenis kelamin
        System.out.print("Masukkan jenis kelamin (P/L): ");
        char jenisKelamin = scanner.nextLine().toUpperCase().charAt(0);
        String jenisKelaminLengkap = (jenisKelamin == 'L') ? "Laki-laki" : "Perempuan";

        // Inputan tanggal lahir
        System.out.print("Masukkan tanggal lahir (format: YYYY-MM-DD): ");
        String tanggalLahirStr = scanner.nextLine();
        LocalDate tanggalLahir = LocalDate.parse(tanggalLahirStr);

        // Untuk menghitung umur
        LocalDate tanggalSekarang = LocalDate.now();
        Period periode = Period.between(tanggalLahir, tanggalSekarang);
        int umur = periode.getYears();
        int bulan = periode.getMonths();

        // Output nya
        System.out.println("\nData Diri:");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelaminLengkap);
        System.out.println("Tanggal Lahir: " + tanggalLahir);
        System.out.println("Umur: " + umur + " tahun " + bulan + " bulan");

        scanner.close();
    }
}
