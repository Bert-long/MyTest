package com.cn.webSercer.core;

public interface Servlet {
    void service(Request request,Response response);

    void doGET();
}
