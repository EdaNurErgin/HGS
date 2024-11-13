public  abstract class HGSAccounts {

    String idNumber ;
    String firstName;
    String lastName;
    String vehicleClass;
    double balance;

    public HGSAccounts(String idNumber , String firstName,String  lastName,String vehicleClass, double balance){
        this.idNumber=idNumber;
        this.firstName=firstName;
        this.lastName=lastName;
        this.vehicleClass=vehicleClass;
        this.balance=balance;
    }


    public void displayAccountsInfo(){
        System.out.println("ID Number: " + idNumber);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Vehicle Class: " + vehicleClass);
        System.out.println("Balance: " + balance);

    }

    //BAKİYE DUSUR
    public void deductBalance(double amount){
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Deducted " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Insufficient balance ");
        }

    }

    //BAKİYE ARTTR
    public void addBalance(double amount){
        balance += amount;
        System.out.println("Added " + amount + ". New balance: " + balance);

    }

}
