package com.rainbow.packge.hello;

import com.rainbow.packge.model.User;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述:
 * Created by Admin on 2016-07-19 22:03.
 */
@WebService(endpointInterface = "com.rainbow.packge.hello.HelloWorld", serviceName="HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    Map<Integer, User> userList = new LinkedHashMap<Integer, User>();

    public String sayHi(@WebParam(name = "text") String text) {
        return "Hello:" + text;
    }

    public String sayHiToUser(User user) {
        userList.put(userList.size()+1, user);
        return "Hello:" + user.getName();
    }

    public String[] SayHiToUserList(List<User> userList1) {
        String[] result = new String[userList1.size()];
        int i = 0;
        for(User u:userList1){
            result[i] = "Hello " + u.getName();
            i++;
        }
        return result;
    }
}
