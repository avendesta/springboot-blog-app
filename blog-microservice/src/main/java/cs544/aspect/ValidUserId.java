package cs544.aspect;

import cs544.domain.Comment;
import cs544.domain.Post;
import cs544.service.UserService;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidUserId {
	
	@Autowired
	private UserService userService;
	
	@Before("execution(* cs544.controller.MainController.setPost(..))")
    public void validSetPost(JoinPoint jp) throws Exception{
        Object[] args = jp.getArgs();
        Post p = (Post)args[0];
        
        if(userService.isUser(p.getUserId()) == null) {
        	throw new Exception("User does not exists!");
        }
        
        if(!userService.isAdmin(p.getUserId())) {
        	if(!userService.isPoster(p.getUserId())) {
            	throw new Exception("User does not have permition to Post!");
            }
        }
        
        System.out.println(args[0]);
        System.out.println("I am an advice: "+p);
    }
	
    @Before("execution(* cs544.controller.MainController.putPost(..))")
    public void validUserPost(JoinPoint jp) throws Exception{
        Object[] args = jp.getArgs();
        Post p = (Post)args[1];
        
        if(userService.isUser(p.getUserId()) == null) {
        	throw new Exception("User does not exists!");
        }
        
        if(userService.isAdmin(p.getUserId()) || userService.isPoster(p.getUserId())) {
        	throw new Exception("User does not have permition to Post!");
        }
        
        System.out.println(args[0]);
        System.out.println("I am an advice: "+p);
    }
    
    @Before("execution(* cs544.controller.MainController.setCommentToPost(..))")
    public void validUserComment(JoinPoint jp) throws Exception{
        Object[] args = jp.getArgs();
        Comment c = (Comment)args[1];
        
        if(userService.isUser(c.getUserId()) == null) {
        	throw new Exception("User does not exists!");
        }
        
        System.out.println(args[0]);
        System.out.println("I am an advice: "+c);
    }
}
