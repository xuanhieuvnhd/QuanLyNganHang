import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Account {
    private long number;
    private String name;
    private double money;

    public Account() {
    }

    public Account(long number, String name, double money) {
        this.number = number;
        this.name = name;
        this.money = money;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getInstance(locale);
        return "Tai khoan{" +
                "So tai khoan: " + number +
                ", Ten tai khoan'" + name + '\'' +
                ", So tien: " + numberFormat.format(money) +" VND"+
                '}';
    }
    public double recharge(Scanner scanner){
      double load;
        System.out.print("Nhap so tien can nap: ");
        load = scanner.nextDouble();
        if (load >0){
            money+=load;
            System.out.println("Ban vua nap "+ load + " vao tai khoan");
        }else {
            System.out.println("So tien nap vao khong hop le!");
        }
        return load;
    }
    public double withdrawMoney(Scanner scanner){
        double fee = 5;
        double withdraw;
        System.out.print("Nhap so tien muon rut: ");
        withdraw = scanner.nextDouble();
        if (withdraw <= (money - fee)){
            money = money - (withdraw+fee);
            System.out.println("Ban vua rut "+ withdraw + "VND tu tai khoan");
        }else {
            System.out.println("So tien muon rut khong hop le!");
            return withdrawMoney(scanner);
        }
        return withdraw;
    }
    public double expire(){
        double interest = 0.065;
        money = money+money*interest;
        System.out.println("Ban vua nhan duoc "+money + " tu dao han 1 thang");
        return money;
    }
    public void displayAccount(){
        String account = String.valueOf(money);
        System.out.printf("%-10d %-20s %-20s \n", number, name, account);
    }
}


