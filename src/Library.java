import java.util.Scanner;

public class Library {
    void Mahasiswa(long identitas){
        long[] Nim = {202310370311203L, 202310370311153L, 202310370311174L};
        for (long i : Nim){
            if (i == identitas){
                System.out.println("\nSuccesful login as Student.");
                break;
            } else {
                System.out.println("\nUser not found.");
                break;
            }
        }
    }

    void Admin(String user, String password){
        String adm = "admin";
        String pw = "admin";

        if (user.equals(adm) && password.equals(pw)){
            System.out.println("\nSuccesful login as Admin.");
        } else {
            System.out.println("\nUser not found.");
        }
    }

    public static void main(String[] args){
        Library lb = new Library();
        Scanner inp = new Scanner(System.in);

        System.out.println("====== Library System ======");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Exit");
        System.out.print("Choose option (1-3): ");
        int pilih = inp.nextInt();

        if ( pilih == 1){

            System.out.print("Enter your NIM: ");
            long nim = inp.nextLong();
            lb.Mahasiswa(nim);

        } else if (pilih == 2){

            System.out.print("Enter your username: ");
            String user = inp.next();
            System.out.print("Enter your password: ");
            String password = inp.next();
            lb.Admin(user,password);

        } else if (pilih == 3){

            System.exit(0);

        } else {

            System.out.println("Inputan salah ");

        }


    }
}
