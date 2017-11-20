package avv.qatl.homework2;

import org.openqa.selenium.By;

public class TestAdmin extends TestBase {


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

        si = new ScenarioItem(By.className("employee_avatar_small"));
        si.setMsgErrLog("UserPic not found !");
        si.setDoSleep(true);
        si.setDoClick(true);
        scenario.add(si);

        si = new ScenarioItem(By.id("header_logout"));
        si.setMsgErrLog("UserPic not found !");
        si.setDoSleep(true);
        si.setDoClick(true);
        scenario.add(si);

    }
}
