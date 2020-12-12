package testRailApi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import testRailApiBinding.APIClient;
import testRailApiBinding.APIException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestRailService
{
    APIClient client;

    public TestRailService(){
        this.client = new APIClient("https://justrailsda.testrail.io/");
        client.setUser("karol.kasior@gmail.com");
        client.setPassword("Sda123$%");
    }

    public void updateTestResult(Integer testCaseResultId, String testCaseComment, Integer testCaseId){
        Map data = new HashMap();
        data.put("status_id", new Integer(testCaseResultId));
        data.put("comment",testCaseComment);
        try {
            JSONObject r = (JSONObject) this.client.sendPost("add_result_for_case/1/" + testCaseId,data);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }
    }

    public JSONArray getTestRailTestCases(){
        JSONArray c = null;
        try {
            c = (JSONArray) this.client.sendGet("get_cases/1&suite_id=1");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }
        return c;
    }
}