package cs544.aspect;

import cs544.domain.Comment;
import cs544.domain.Post;
import cs544.exception.UnauthorizedUserException;
import cs544.exception.UserDoesNotExistException;
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

    // added for logging purpose, prints to console when a get request is sent
    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void GetMessageLog() {
        System.out.println("GetMessage invoked");
    }

	@Before("execution(* cs544.controller.MainController.setPost(..))")
    public void validSetPost(JoinPoint jp) throws Exception{
        Object[] args = jp.getArgs();
        Post p = (Post)args[0];
        
        if(userService.isUser(p.getUserId()) == null) {
        	throw new UserDoesNotExistException("User does not exists!");
        }
        
        if(!userService.isAdmin(p.getUserId())) {
        	if(!userService.isPoster(p.getUserId())) {
            	throw new UnauthorizedUserException("User does not have permission to Post!");
            }
        }

    }
	
    @Before("execution(* cs544.controller.MainController.putPost(..))")
    public void validUserPost(JoinPoint jp) throws Exception{
        Object[] args = jp.getArgs();
        Post p = (Post)args[1];
        
        if(userService.isUser(p.getUserId()) == null) {
        	throw new UserDoesNotExistException("User does not exists!");
        }
        
        if(userService.isAdmin(p.getUserId()) || userService.isPoster(p.getUserId())) {
        	throw new UnauthorizedUserException("User does not have permission to Post!");
        }
    }
    
    @Before("execution(* cs544.controller.MainController.setCommentToPost(..))")
    public void validUserComment(JoinPoint jp) throws Exception{
        Object[] args = jp.getArgs();
        Comment c = (Comment)args[1];
        
        if(userService.isUser(c.getUserId()) == null) {
        	throw new UserDoesNotExistException("User does not exists!");
        }
    }
}
