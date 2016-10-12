package com.chubb.rest.adapter.test;

import com.chubb.rest.adapter.request.Connection;
import com.chubb.rest.adapter.request.ConnectionFactory;
import com.chubb.rest.adapter.request.Request;
import com.chubb.rest.adapter.request.RequestFactory;
import com.chubb.rest.adapter.util.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

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
