package uz.pdp.frontend.utils;

public interface MenuUtils {
    String LOGIN  = "Login Menu: \n1.Login \n2.Sign Up \n0.Exit";
    String USER = "User Menu: \n1.Show my chats  \n2.Show my groups  \n3.Show my contact \n0.Exit";
    String CHAT = "Chat Menu: \n1.Sent message  \n2.Show messages  \n3.Delete chat  \n4.Settings \n0.Exit";
    String GROUP = "Group Menu: \n1.Create group  \n2.Show my groups  \n3.Add users  \n4.Send message \n5.Delete group \n6.Settings \n0.Exit";
    String MESSAGE = "Messade Menu: \n1.Show my message \n2.Edit messages \n3.Delete message \n0.Exit";

    static int menu(String menu){
        System.out.println(menu);
        return ScanUtil.scanInt("Choose: ");
    }
}
