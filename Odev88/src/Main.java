import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static IndividualAccount account;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- HGS Uygulaması ---");
            System.out.println("1. Hesap Oluştur");
            System.out.println("2. Bakiyeyi Görüntüle");
            System.out.println("3. Bakiyeye Ekle");
            System.out.println("4. Geçiş Ekle");
            System.out.println("5. Geçişleri Görüntüle");
            System.out.println("6. Çıkış");
            System.out.print("Seçiminizi yapın (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Yni satırı temizle

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    displayBalance();
                    break;
                case 3:
                    addBalance();
                    break;
                case 4:
                    addPassage();
                    break;
                case 5:
                    displayPassages();
                    break;
                case 6:
                    System.out.println("Çıkış yapılıyor...");
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
    }

    // Hesap oluşturma metodu
    private static void createAccount() {
        System.out.print("Kimlik Numarası: ");
        String idNumber = scanner.nextLine();

        System.out.print("Ad: ");
        String firstName = scanner.nextLine();

        System.out.print("Soyad: ");
        String lastName = scanner.nextLine();

        System.out.print("Araç Sınıfı: ");
        String vehicleClass = scanner.nextLine();

        System.out.print("Başlangıç Bakiyesi: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // Yeni satırı temizle

        account = new IndividualAccount(idNumber, firstName, lastName, vehicleClass, balance);
        System.out.println("Hesap oluşturuldu: " + firstName + " " + lastName);
    }

    // Bakiyeyi görüntüleme metodu
    private static void displayBalance() {
        if (account != null) {
            account.displayableDeposite();
        } else {
            System.out.println("Önce bir hesap oluşturmalısınız.");
        }
    }

    // Bakiyeye ekleme metodu
    private static void addBalance() {
        if (account != null) {
            System.out.print("Eklenecek Tutar: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Yeni satırı temizle
            account.addBalance(amount);
            System.out.println("Yeni bakiye: " + account.balance);
        } else {
            System.out.println("Önce bir hesap oluşturmalısınız.");
        }
    }

    // Geçiş ekleme metodu
    private static void addPassage() {
        if (account != null) {
            System.out.print("Geçiş Tarihi: ");
            String date = scanner.nextLine();

            System.out.print("Giriş Gişesi: ");
            String entryGate = scanner.nextLine();

            System.out.print("Çıkış Gişesi: ");
            String exitGate = scanner.nextLine();

            System.out.print("Ücret: ");
            double fee = scanner.nextDouble();
            scanner.nextLine(); // Yeni satırı temizle

            if (fee <= account.balance) {
                Passage passage = new Passage(date, exitGate, entryGate, fee);
                account.addPassage(passage);
                account.deductBalance(fee);
                System.out.println("Geçiş eklendi.");
            } else {
                System.out.println("Yetersiz bakiye. Geçişe izin verilmiyor.");
            }
        } else {
            System.out.println("Önce bir hesap oluşturmalısınız.");
        }
    }

    // Geçişleri görüntüleme metodu
    private static void displayPassages() {
        if (account != null) {
            account.displayableRoutes();
        } else {
            System.out.println("Önce bir hesap oluşturmalısınız.");
        }
    }
}
