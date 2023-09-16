package stepDefs;

import baseEntities.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProjectPage;
import utils.configuration.ReadProperties;

public class TooltipTest extends BaseTest {
    static Logger logger = LogManager.getLogger(TooltipTest.class);
    private BaseTest baseTest;
    protected LoginPage loginPage;
    protected ProjectPage projectPage;
    public TooltipTest (BaseTest baseTest){
        this.baseTest = baseTest;
    }

}
