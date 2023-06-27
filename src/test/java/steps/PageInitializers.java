package steps;

import pages.DashBoardPage;
import pages.LoginPage;

public class PageInitializers {
    public static LoginPage loginPage;
    public static DashBoardPage dash;


//    initalize all the page objects
    public static void initializePageObjects() {
        loginPage = new LoginPage();
        dash=new DashBoardPage();
    }
}
