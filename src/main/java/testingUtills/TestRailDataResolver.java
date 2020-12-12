package testingUtills;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import testRailApi.TestRailService;

public class TestRailDataResolver {
    public Integer getTestCaseIdFromTestRail(){
        TestRailService testRailService = new TestRailService();
        JSONArray testRailTestCases = testRailService.getTestRailTestCases();
        String scenarioName = ScenarioData.scenarioName;

        Integer testRailTestCaseId = null;
        Long testRailTestCaseIdLong = null;

        for (int i = 0; i < testRailTestCases.size(); i++) {
            JSONObject o = (JSONObject) testRailTestCases.get(i);
            String title = (String) o.get("title");
            title = title.trim();
            title = title.replace(" ","");
            scenarioName = scenarioName.trim();
            scenarioName = scenarioName.replace(" ", "");
            if(title.equals(scenarioName)){
                testRailTestCaseIdLong = (Long) o.get("id");
            }
        }

        testRailTestCaseId = testRailTestCaseIdLong.intValue();

        return testRailTestCaseId;
    }
    public void updateTestCaseInTestRail(){
        Integer testCaseId = getTestCaseIdFromTestRail();
        TestRailService testRailService = new TestRailService();
        testRailService.updateTestResult(ScenarioData.scenarioResultId, ScenarioData.scenarioComment, testCaseId);
    }
}
