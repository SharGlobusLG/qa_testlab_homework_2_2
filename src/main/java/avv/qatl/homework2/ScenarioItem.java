package avv.qatl.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class ScenarioItem {

    private  By locator;

    private boolean doSleep;
    private boolean doClick;
    private boolean doRefresh;
    private boolean doSendKeys;
    private String keys = "";
    private boolean doSubmit = false;

    private String msgErrLog = "";


    public ScenarioItem(By locator) {
        this.locator = locator;
    }

    public boolean execute(WebDriver drv){
        WebElement we;
        String currentURL = "";

        if (isDoRefresh()) {
            currentURL = drv.getCurrentUrl();
            System.out.println( drv.getTitle() );
        }

        if (isDoSleep()){
            pause();
        }

        try {
            we = drv.findElement( getLocator() );
        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println( getMsgErrLog() );
            return false;
        }

        if (isDoSendKeys() )
            we.sendKeys( getKeys());

        if (isDoClick()){

            we.click();
        }

        if (isDoSubmit() )
            we.submit();


        if (isDoRefresh()) {
            pause();

            drv.navigate().refresh();

            pause();

            String refreshedURL = drv.getCurrentUrl();

            if ( !refreshedURL.equals( currentURL )){
                System.out.println("Refresh wrong ! ! !");
            }else {
                System.out.println("Refresh Ok !");
            }
        }

        return  true;

    }

    private void pause(){
            try {
                Thread.sleep(5000 );
            }catch (InterruptedException e){
                e.printStackTrace();
            }
    }

    public  void setSendKeys(String k){
        this.keys = k;
        if (!this.keys.isEmpty()==true) doSendKeys=true;
    }

    public void setDoSubmit(boolean doSubmit) {
        this.doSubmit = doSubmit;
    }

    public void setDoSleep(boolean doSleep) {
        this.doSleep = doSleep;
    }

    public void setMsgErrLog(String msgErrLog) {
        this.msgErrLog = msgErrLog;
    }

    public boolean isDoSleep() {
        return doSleep;
    }

    public boolean isDoSubmit() {
        return doSubmit;
    }

    public boolean isDoSendKeys() {
        return doSendKeys;
    }

    public String getKeys() {
        return keys;
    }

    public String getMsgErrLog() {
        if ( !msgErrLog.isEmpty())
            return msgErrLog;
        else
            return "Unknown error !";
    }

    public By getLocator() {
        return locator;
    }

    public boolean isDoClick() {
        return doClick;
    }

    public void setDoClick(boolean doClick) {
        this.doClick = doClick;
    }

    public boolean isDoRefresh() {
        return doRefresh;
    }

    public void setDoRefresh(boolean doRefresh) {
        this.doRefresh = doRefresh;
    }
}
