package com.fudian.controller;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * Created by andy on 7/27/14.
 */
@Controller
@RequestMapping("index")
public class IndexController {

    @Autowired
    private HttpClient httpClient;

    @RequestMapping("login")
    public String index(){
         System.out.println("一个连接建立。。。。");
        try{
            Thread.sleep(10000000);
        }catch(InterruptedException e){
        }
        return "index";
    }

    @RequestMapping("connect")
    public String testHttpClient(){
        try{
            int statusCode = httpClient.executeMethod(new GetMethod("http://localhost:8080/front/index/login"));
            if (statusCode != HttpStatus.SC_OK) {
                System.out.println("远程访问失败。");
            }
            System.out.println(statusCode);
        }catch(Exception e){
        }
        try{
            Thread.sleep(10000000);
        }catch(InterruptedException e){
        }
        return "";
    }


}
