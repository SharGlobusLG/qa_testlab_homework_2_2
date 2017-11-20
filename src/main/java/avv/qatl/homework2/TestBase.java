package avv.qatl.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class TestBase {
    public static final class Const{
        public static final String URL = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
        public static final String LOGIN = "webinar.test@gmail.com";
        public static final String PASSWORD = "Xcg7299bnSmMuRLp9ITw";
    }

    private WebDriver drv = null;
    ArrayList<ScenarioItem> scenario;

    public TestBase() {
        drv = getDriver();
        scenario = new ArrayList<ScenarioItem>();
        prepareScensroi();
    }


    public boolean Execute() {
        if (drv == null )
            return  false;

        boolean success = true;

        drv.get(Const.URL);

        for ( ScenarioItem si: scenario){
             if (! si.execute(drv) ){
                 success = false;
                 break;
             }
        }

        return success;
    }



    public void prepareScensroi(){

    }

    private WebDriver getDriver() {
        try {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
            return new ChromeDriver();
        }catch (Exception e) {
            return null;
        }


    }
}
