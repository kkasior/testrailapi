package testingUtills;

import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import org.json.simple.JSONArray;
import org.junit.jupiter.api.Test;
import testRailApi.TestRailService;
import testRailApiBinding.APIException;

import java.io.IOException;

public class ScenarioData {

    public static String scenarioName;
    public static Status scenarioStatus;

    public static Integer scenarioResultId;
    public static String scenarioComment;


    public static void setScenarioResultAndComment() {
        String testResult = scenarioStatus.toString();

        if(testResult == "PASSED"){
            scenarioResultId = 1;
            scenarioComment = "All good";
        }
        else if (testResult == "FAILED"){
            scenarioResultId = 5;
            scenarioComment = "All wrong";
        }
        else
        {
            scenarioResultId = 2;
            scenarioComment = "dunno";
        }


        TestRailDataResolver testRailDataResolver = new TestRailDataResolver();
        testRailDataResolver.updateTestCaseInTestRail();
    }

}
