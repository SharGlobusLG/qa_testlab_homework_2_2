package avv.qatl.homework2;

import org.openqa.selenium.By;

public class TestMenu extends TestBase {

    @Override
    public void prepareScensroi() {
        ScenarioItem si;

        si = new ScenarioItem(By.id("email"));
        si.setSendKeys(Const.LOGIN);
        si.setMsgErrLog("Email not found !");
        scenario.add(si);


        si = new ScenarioItem(By.id("passwd"));
        si.setSendKeys(Const.PASSWORD);
        si.setMsgErrLog("Email not found !");
        si.setDoSubmit(true);
        scenario.add(si);


        si = new ScenarioItem(By.cssSelector("#subtab-AdminParentOrders > a"));
        si.setMsgErrLog("Menu Статистика not found !");
        si.setDoClick(true);
        si.setDoSleep(true);
        si.isDoRefresh();
        scenario.add(si);

        si = new ScenarioItem(By.cssSelector("#subtab-AdminCatalog > a"));
        si.setMsgErrLog("Menu Каталог not found !");
        si.setDoClick(true);
        si.setDoSleep(true);
        si.isDoRefresh();
        scenario.add(si);

        si = new ScenarioItem(By.cssSelector("body > nav > ul > li:nth-child(5) > a"));//body > nav > ul > li:nth-child(5) > a
        si.setMsgErrLog("Menu Клиенты not found !");
        si.setDoClick(true);
        si.setDoSleep(true);
        si.isDoRefresh();
        scenario.add(si);

        si = new ScenarioItem(By.cssSelector("#subtab-AdminParentCustomerThreads > a"));
        si.setMsgErrLog("Menu Служба поддержки not found !");
        si.setDoClick(true);
        si.setDoSleep(true);
        si.isDoRefresh();
        scenario.add(si);

    }
}
