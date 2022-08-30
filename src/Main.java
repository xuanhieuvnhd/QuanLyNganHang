import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void enterAccount(Account account) {
        System.out.print("Nhap so tai khoan: ");
        account.setNumber(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Nhap ten tai khoan: ");
        account.setName(scanner.nextLine());
        account.setMoney(50);
    }

    public static void main(String[] args) {
        Account a[] = null;
        int k, b, n = 0;
        long s, d, c, f;
        boolean flag = true;
        do {
            System.out.println("Chon chuc nang: ");
            System.out.println("1.Nhap thong tin khach hang\n"
                    + "2.Xuat danh sach thong tin khach hang\n"
                    + "3.Nap tien\n" + "4.Rut tien\n"
                    + "5.Dao han\n" + "6.Chuyen khoan\n"
                    + "0.Thoat chuong tỉnh");
            b = scanner.nextInt();
            switch (b) {
                case 1 -> {
                    System.out.println("Nhap so luong khach hang: ");
                    n = scanner.nextInt();
                    a = new Account[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("Khach hang so: " + (i + 1));
                        a[i] = new Account();
                        enterAccount(a[i]);
                    }
                }
                case 2 -> {
                    System.out.printf("%-10s %-20s %-20s\n", "So tai khoan", "Ten tai khoan", "So tien trong tai khoan");
                    for (int i = 0; i < n; i++) {
                        a[i].displayAccount();
                    }
                }
                case 3 -> {
                    System.out.println("Nhập số tài khoản khách hàng cần nạp tiền: ");
                    s = scanner.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getNumber();
                        if (s == d) {
                            System.out.println("Bạn chọn tài khoản: " + d);
                            a[i].recharge(scanner);
                        } else {
                            System.out.println("");
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Nhập số tài khoản khách hàng cần rút tiền: ");
                    s = scanner.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getNumber();
                        if (s == d) {
                            System.out.println("Bạn chọn tài khoản: " + d);
                            a[i].withdrawMoney(scanner);
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Nhập số tài khoản khách hàng cần đáo hạn: ");
                    s = scanner.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getNumber();
                        if (s == d) {
                            System.out.println("Bạn chọn tài khoản: " + d);
                            a[i].expire();
                        } else {
                            System.out.println("");
                        }
                    }
                }
                case 6 -> {
                    double transfer,take, moneyTransfer;
                    System.out.print("Nhập số tài khoản khách hàng chuyển tiền: ");
                    s = scanner.nextLong();
                    System.out.print("Nhập số tài khoản khách hàng nhận tiền: ");
                    c = scanner.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getNumber();
                        if (s == d) {
                            transfer = a[i].getMoney();
                            for (int j = 0; j < n; j++) {
                                f = a[j].getNumber();
                                if (c == f) {
                                    take = a[j].getMoney();
                                    System.out.println("Nhập số tiền cần chuyển");
                                    moneyTransfer = scanner.nextDouble();
                                    if (moneyTransfer <= transfer) {
                                        transfer = transfer - moneyTransfer;
                                        take = take + moneyTransfer;
                                        a[i].setMoney(transfer);
                                        a[j].setMoney(take);
                                        System.out.println("Tài khoản số " + d + " vừa chuyển: $" + moneyTransfer);
                                        System.out.println("Tài khoản số " + f + " vừa nhận: $" + moneyTransfer);
                                    } else {
                                        System.out.println("Số tiền nhập không hợp lệ!");
                                    }
                                } else {
                                    System.out.println("");
                                }
                            }
                        } else {
                            System.out.println("");
                        }
                    }
                }
                default -> {
                    System.out.println("Bye!!");
                    flag = false;
                }
            }
        } while (flag);
    }
}
