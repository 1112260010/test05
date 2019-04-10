package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.HelloSpring;

public class Test05 {
    @Test
    public void testSpring01(){
        ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*HelloSpring helloSpring = (HelloSpring) cxt.getBean("helloSpring");*/
        HelloSpring helloSpring = cxt.getBean("helloSpring", HelloSpring.class);
        System.out.println(helloSpring);
    }
}
