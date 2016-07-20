package com.rainbow.packge.hello;

import com.rainbow.packge.model.User;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * 功能描述: 接口
 * Created by Admin on 2016-07-19 21:59.
 */
@WebService
public interface HelloWorld {

    String sayHi(@WebParam(name="text")String text);
    String sayHiToUser(User user);
    String[] SayHiToUserList(List<User> userList);
}
