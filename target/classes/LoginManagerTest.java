import com.github.rccookie.common.util.Console;
import com.github.rccookie.greenfoot.event.LoginManager;
import com.github.rccookie.greenfoot.event.User;

public class LoginManagerTest {
    public static LoginManager m = new LoginManager();

    public static User loginUser(String username, String password) throws Exception {
        return m.loginUser(username, password);
    }

    public static User loginGuestUser() {
        return m.loginGuest();
    }

    public static User getUser() {
        return m.getUser();
    }

    public static LoginManager.UserState getUserState() {
        return m.getUserState();
    }

    public static boolean isGuest() {
        return m.isGuest();
    }

    public static void logout() {
        m.logout();
    }

    public static boolean register(String password0, String password1) throws Exception {
        return m.register(password0, password1);
    }

    public static boolean resetPassword(String password0, String password1) throws Exception {
        return m.resetPassword(password0, password1);
    }

    public static boolean isLoggedIn() {
        return m.isLoggedIn();
    }

    public static void runTest() throws Exception {
        Console.Config.coloredOutput = false;
        Console.Config.manualConsoleWidth = 100;
        LoginManager l = new LoginManager();
        Console.map("User state", l.getUserState());
        Console.map("Logged in", l.isLoggedIn());
        Console.split("Login");
        Console.map("Logged in user", l.loginUser(Console.input("Username:"), Console.input("Password:")));
        Console.map("Is guest", l.isGuest());
        Console.map("Logged in", l.isLoggedIn());
        //Console.info("Storing something");
        //l.getUser().store();
        Console.split("Reset password");
        Console.info(l.resetPassword(Console.input("Enter a new password:"), Console.input("Enter the password again:")));
        Console.info("Logging out");
        l.logout();
        Console.map("Logged in", l.isLoggedIn());
        Console.split("Guest login");
        Console.map("Logged in user", l.loginGuest());
        Console.map("Is guest", l.isGuest());
        Console.map("Logged in", l.isLoggedIn());
        Console.info("Storing something");
        l.getUser().store();
        Console.info("Logging out");
        l.logout();
        Console.split("Code password reset");
        l.resetPassword("123456", "123456");
    }
}
