package org.gzqbest.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ApiTest {

    @Test
    public void queryUnAnswerQuestions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=1");
        httpGet.addHeader("cookie","sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%221950465cb5b582-0996ca697d81b88-26011a51-1296000-1950465cb5c57%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTk1MDQ2NWNiNWI1ODItMDk5NmNhNjk3ZDgxYjg4LTI2MDExYTUxLTEyOTYwMDAtMTk1MDQ2NWNiNWM1NyJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%221950465cb5b582-0996ca697d81b88-26011a51-1296000-1950465cb5c57%22%7D; abtest_env=product; zsxq_access_token=A61CAA7E-6867-4C73-8FDA-EA87A9D55604_8457955A4262E863");
        httpGet.addHeader("Content-Type","application/json;charset=utf-8");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());

        }
    }

    @Test
    public void answerQuestions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/4845185582444188/comments");
        post.addHeader("cookie","sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%221950465cb5b582-0996ca697d81b88-26011a51-1296000-1950465cb5c57%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTk1MDQ2NWNiNWI1ODItMDk5NmNhNjk3ZDgxYjg4LTI2MDExYTUxLTEyOTYwMDAtMTk1MDQ2NWNiNWM1NyJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%221950465cb5b582-0996ca697d81b88-26011a51-1296000-1950465cb5c57%22%7D; abtest_env=product; zsxq_access_token=A61CAA7E-6867-4C73-8FDA-EA87A9D55604_8457955A4262E863");
        post.addHeader("Content-Type","application/json;charset=utf-8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"广东靠近沿海\\n\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", StandardCharsets.UTF_8));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());

        }
    }
}
