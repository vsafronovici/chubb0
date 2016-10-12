package com.chubb.rest.adapter.test;

import com.chubb.rest.adapter.connection.Connection;
import com.chubb.rest.adapter.connection.ConnectionFactory;
import com.chubb.rest.adapter.request.Request;
import com.chubb.rest.adapter.request.RequestFactory;
import com.chubb.rest.adapter.util.JsonUtil;
import java.io.IOException;

/**
 * Created by vsafronovici on 10/11/2016.
 */
public class Test1 {

    public static void main(String[] args) throws IOException {

        /*byte[] encoded = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        Object jsonReq = new String(encoded);
        System.out.println(jsonReq);*/

        String jsonReq = JsonUtil.readFileToString("/request/req_tmpl_get_user.json");
        System.out.println(jsonReq);


        Connection connection = ConnectionFactory.getConnection("http://localhost:8080");
        Request req = RequestFactory.create(connection, jsonReq);



    }


}
