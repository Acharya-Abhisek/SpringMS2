
package com.abhisek.Third;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@EnableEurekaClient
@Controller
public class ThirdLoginController {

	@Autowired
	private RestTemplate template;
	
	
	@RequestMapping(value="/")
	public String tologin() {
		return "loginthird";
	}
	
	@RequestMapping(value="loginerror")
	public ModelAndView loginerror() {
		ModelAndView mv=new ModelAndView("usernotfound");
		return mv;
	}
	
	
	
	
	@RequestMapping("/register")
	public String ToRegistrationPage() {
		return "registerthird";
	}
	

	
	
	@PostMapping(value="/login")
	public String dashboard(@RequestParam("userId") int uid, @RequestParam("userName") String uname,@RequestParam("password") String password, ModelMap modelmap) {
		String URL="https://abhisekThirdR/validateLogin?uid="+uid+"&&uname="+uname+"&&password="+password;
		String[] response=template.postForEntity(URL,String.class,String[].class).getBody();
		if (response[0].equals("true")) {
			modelmap.addAttribute("UserName",response[1]);
			return "homePagethird";
		}
		else {
			
			return "redirect:/loginerror";
		}
	}
	
	
	
	
	@PostMapping("/set-user")
	public String ToRegistrationMicroService( @RequestParam("uId") Integer uid,
											  @RequestParam("userName") String uname,
			                                  @RequestParam("password1") String upassword,
			                                  @RequestParam("password2") String password2, ModelMap modelmap) {
	
		String URL1="https://abhisekThirdR/checkData?uid="+uid+"&&uname="+uname+"&&upassword="+upassword;
		Boolean response1=template.postForEntity(URL1,Boolean.class,Boolean.class).getBody();
		if(response1==true) {
		
		if(upassword.equals(password2)) {
			String URL="https://abhisekThirdR/addData?uid="+uid+"&&uname="+uname+"&&upassword="+upassword;
			Boolean response=template.postForEntity(URL,Boolean.class,Boolean.class).getBody();

			if (response==true) {
				
			modelmap.addAttribute("registrationsuccess","User Registered...Kindly Sign in.");	
				return "loginthird";
			}
			else {
				
				//modelmap.addAttribute("passworderror","Both passwords entered do not match....Kindly re-register.");
				modelmap.addAttribute("someerror","Some error occured....Kindly re-register.");
				
			}
			
		}
		else {
			modelmap.addAttribute("passworderror","Both passwords entered do not match....<br>Kindly re-register.");
		}
		return "loginthird";
	}
	//}
	
	else
	{
		modelmap.addAttribute("userIderror","User Id already exists<br> Kindly register with new unique User ID.");
	}	
	return "loginthird";
	}
}








//@PostMapping(value="/login")
//public String dashboard(@RequestParam("userId") int uid, @RequestParam("userName") String uname,@RequestParam("password") String password, ModelMap modelmap) {
//	String URL="https://abhisekThirdR/validateLogin?uid="+uid+"&&uname="+uname+"&&password="+password;
//	Boolean response=template.postForEntity(URL,Boolean.class,Boolean.class).getBody();
//	if (response==true) {
//		modelmap.addAttribute("UserName",uname);
//		return "homePagethird";
//	}
//	else {
//		
//		return "redirect:/loginerror";
//	}
//}

















/* Starts here
 * 
 * 
 * 

package com.abhisek.Third;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@EnableEurekaClient
@Controller
public class ThirdLoginController {

	@Autowired
	private RestTemplate template;
	
	
	@RequestMapping(value="/")
	public String tologin() {
		return "loginthird";
	}
	
	@RequestMapping(value="loginerror")
	public ModelAndView loginerror() {
		ModelAndView mv=new ModelAndView("usernotfound");
		return mv;
	}
	
	
	
	
	@RequestMapping("/register")
	public String ToRegistrationPage() {
		return "registerthird";
	}
	

	
	
	@PostMapping(value="/login")
	public String dashboard(@RequestParam("userId") int uid, @RequestParam("userName") String uname,@RequestParam("password") String password, ModelMap modelmap) {
		String URL="https://abhisekThirdR/validateLogin?uid="+uid+"&&uname="+uname+"&&password="+password;
		String[] response=template.postForEntity(URL,String.class,String[].class).getBody();
		if (response[0].equals("true")) {
			modelmap.addAttribute("UserName",response[1]);
			return "homePagethird";
		}
		else {
			
			return "redirect:/loginerror";
		}
	}
	
	
	
	
	@PostMapping("/set-user")
	public String ToRegistrationMicroService( @RequestParam("uId") Integer uid,
											  @RequestParam("userName") String uname,
			                                  @RequestParam("password1") String upassword,
			                                  @RequestParam("password2") String password2, ModelMap modelmap) {
	
		String URL1="https://abhisekThirdR/checkData?uid="+uid+"&&uname="+uname+"&&upassword="+upassword;
		Boolean response1=template.postForEntity(URL1,Boolean.class,Boolean.class).getBody();
		if(response1==true) {
		
		if(upassword.equals(password2)) {
			String URL="https://abhisekThirdR/addData?uid="+uid+"&&uname="+uname+"&&upassword="+upassword;
			Boolean response=template.postForEntity(URL,Boolean.class,Boolean.class).getBody();

			if (response==true) {
				
			modelmap.addAttribute("registrationsuccess","User Registered...Kindly Sign in.");	
				return "loginthird";
			}
			else {
				
				//modelmap.addAttribute("passworderror","Both passwords entered do not match....Kindly re-register.");
				modelmap.addAttribute("someerror","Some error occured....Kindly re-register.");
				
			}
			
		}
		else {
			modelmap.addAttribute("passworderror","Both passwords entered do not match....<br>Kindly re-register.");
		}
		return "loginthird";
	}
	//}
	
	else
	{
		modelmap.addAttribute("userIderror","User Id already exists<br> Kindly register with new unique User ID.");
	}	
	return "loginthird";
	}
}








//@PostMapping(value="/login")
//public String dashboard(@RequestParam("userId") int uid, @RequestParam("userName") String uname,@RequestParam("password") String password, ModelMap modelmap) {
//	String URL="https://abhisekThirdR/validateLogin?uid="+uid+"&&uname="+uname+"&&password="+password;
//	Boolean response=template.postForEntity(URL,Boolean.class,Boolean.class).getBody();
//	if (response==true) {
//		modelmap.addAttribute("UserName",uname);
//		return "homePagethird";
//	}
//	else {
//		
//		return "redirect:/loginerror";
//	}
//}





*
*
*
*
 */