package com.chubb.rest.adapter;

import com.chubb.rest.adapter.client.RestJsonClient;
import com.chubb.rest.adapter.connection.Connection;
import com.chubb.rest.adapter.connection.ConnectionFactory;
import com.chubb.rest.adapter.request.Request;
import com.chubb.rest.adapter.request.RequestFactory;
import com.chubb.rest.adapter.response.Response;
import com.chubb.rest.adapter.util.FileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by ichistruga on 10/11/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTest {

    @Autowired
    private RestJsonClient restJsonClient;


    @Test
    public void sendRequestTest() throws IOException {
        String jsonReq = FileUtil.readFileToString("/request/req_tmpl_edit_user.json");
        Connection connection = ConnectionFactory.getConnection("http://localhost:8080");
        Request req = RequestFactory.create(connection, jsonReq);
        Response response = restJsonClient.sendRequest(req);

        assertThat(response.getHttpStatus(), is(HttpStatus.OK));
    }


}
