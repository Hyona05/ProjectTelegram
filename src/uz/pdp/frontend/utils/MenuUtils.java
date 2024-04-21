package uz.pdp.frontend.utils;

public interface MenuUtils {
    String LOGIN  = "Login Menu: \n1.Login \n2.Sign Up \n0.Exit";
    String USER = "User Menu: \n1.Group \n2.Chat  \n0.Exit";
    String MESSAGE = "Message Menu: \n1.Sent message  \n2.Edit messages  \n3.Delete message \n0.Exit";
    String GROUP = "Group Menu: \n1.Create group  \n2.Show my groups  \n3.Join group \n4.Add users  \n5.Send message \n0.Exit";

    static int menu(String menu){
        System.out.println(menu);
        return ScanUtil.scanInt("Choose menu: ");
    }
}
