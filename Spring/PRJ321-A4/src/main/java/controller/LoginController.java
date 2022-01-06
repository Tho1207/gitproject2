package controller;

import javax.servlet.http.HttpServletRequest;  
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
  
@Controller  
public class LoginController {  
  
    @RequestMapping("/login")  
    public String display(HttpServletRequest req,Model m)  
    {  
        //read the provided form data  
        String username=req.getParameter("username");  
        String password=req.getParameter("password");  
        if ( username!= null && password != null) {
    		if( username.equalsIgnoreCase("admin") && password.equals("admin")) {
    			m.addAttribute("name", username);
    			return "confirmation";
    		} else {
    			String error = "Username or password is invalid";
    			m.addAttribute("error",error);
    			return "errorpage";
    		}
    	}
    	String error = "Please enter username and password";
    	m.addAttribute("error",error);
		return "errorpage";
    	}
}
