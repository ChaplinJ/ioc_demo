package controller;

import annotation.Autowired;
import annotation.Controller;
import annotation.RequestMapping;
import service.HelloService;
import service.HelloService;

/**
 * @author Created by gongchengping on 2018/07/29
 * @Description
 */
@Controller
public class HelloController {


    @Autowired
    private HelloService helloService;


    @RequestMapping("/")
    public void sayHello() {
        helloService.sayHello();
    }
}
