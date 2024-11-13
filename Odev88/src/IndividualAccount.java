import java.util.List;
import java.util.ArrayList;
public class IndividualAccount extends HGSAccounts implements DisplayableDeposite ,DisplayableRoutes {



    List<HGSPassages> passagesList;

    public IndividualAccount(String idNumber, String firstName, String lastName, String vehicleClass, double balance) {
        super(idNumber, firstName, lastName, vehicleClass, balance);
        this.passagesList = new ArrayList<>(); // passagesList'i başlat bunu yapmasak null hatasi alirdikkk
    }


    @Override
    public void deductBalance(double amount) {
        super.deductBalance(amount);
    }

    @Override
    public void addBalance(double amount) {
        super.addBalance(amount);
    }

    @Override
    public void displayableDeposite() {
        System.out.println("Current Balance: " + balance);
    }
    @Override
    public void displayableRoutes() {
        System.out.println("Passages: ");
        for (HGSPassages passage : passagesList) {
            System.out.println("Date: " + passage.date + ", Entry Gate: " + passage.entryGate + ", Exit Gate: " + passage.exitGate + ", Fee: " + passage.fee);
        }

    }

    public void addPassage(HGSPassages passage){
        passagesList.add(passage);
    }
}
