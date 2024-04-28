import java.sql.SQLException;
import java.util.Scanner;

import static java.awt.SystemColor.menu;

public class TestDBContext {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Controller ctrl = new Controller();
        Menu.menu();
        int choose = sc.nextInt();
        switch (choose) {
            case 1:
                ctrl.getAllCustomer();
                break;
            case 2:
                ctrl.createCustomer();
                break;
            case 3:
                ctrl.updateCustomer();
                break;
            case 4:
                ctrl.deleteCustomer();
                break;
            case 5:
                sc.close();
                System.exit(0);
                break;
        }
    }
}

