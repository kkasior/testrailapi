import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testingUtills.ScenarioData;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepsDefinitions {

    @Before
    public void setUp(Scenario scenario){
        ScenarioData.scenarioName = scenario.getName();
    }
    @Given("I am on the main page")
    public void i_am_on_the_main_page() {
    }
    @When("I click the podcasts button")
    public void i_click_the_podcasts_button() {
    }
    @Given("X")
    public void x() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("Y")
    public void y() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("I should be redirected to podcast list page")
    public void i_should_be_redirected_to_podcast_list_page() {
        assertTrue("asd".equals("qwe"), "values aren't the same");
    }
    @After
    public void tearDown(Scenario scenario){
        ScenarioData.scenarioStatus = scenario.getStatus();
        ScenarioData.setScenarioResultAndComment();
    }
}
