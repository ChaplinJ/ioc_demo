package controller;

import annotation.Autowired;
import annotation.Controller;
import annotation.RequestMapping;
import service.HelloService;

/**
 * @author Created by gongchengping on 2018/07/29
 * @Description
 */
@Controller
public class Hello2Controller {


    @Autowired
    private HelloService helloService;


    @RequestMapping("/sayHello")
    public void sayHello() {
        helloService.sayHello();
    }
}
