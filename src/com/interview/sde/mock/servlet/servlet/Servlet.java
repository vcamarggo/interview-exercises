package com.interview.sde.mock.servlet.servlet;

// A servlet to manage  requests with variable list of parameters
// A REST API that return JSON
// Started with plain fields (email / password)
// email (size, exists in database, using a third party service)
// password ( size, special char)

public interface Servlet {
    void doPost(Request request, Response response);
}


