import uz.pdp.frontend.utils.MenuUtils;
import uz.pdp.frontend.utils.ScanUtil;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Welcome to our TELEGRAM app!!!");
        while (true) {
            String login = MenuUtils.LOGIN;
            switch (ScanUtil.scanInt("Choose action: ")) {
                case 1 -> signIn();
                case 2 -> SignUp();
                case 3 -> {
                    System.out.println("Come again. Bye bye!");
                    return;
                }
            }
        }
    }

    private static void SignUp() {
    }

    private static void signIn() {

    }
}