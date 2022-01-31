package cs544.aspect;

import cs544.domain.Post;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class ValidUserId {
//    @Before("execution(* cs544.controller.MainController.putPost(..))")
    public static void print(JoinPoint jp){
        Object[] args = jp.getArgs();
        Post p = (Post)args[1];
        System.out.println(args[0]);
        System.out.println("I am an advice: "+p);
    }
}
