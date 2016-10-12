package com.chubb.rest.adapter.client;

import com.chubb.rest.adapter.connection.Connection;
import com.chubb.rest.adapter.request.Request;
import com.chubb.rest.adapter.response.Response;
import org.springframework.stereotype.Service;

/**
 * Created by vsafronovici on 10/12/2016.
 */
public interface RestJsonClient {

    Response sendRequest(Request request);
}
