/*package com.niit.Controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

@Controller
public class UserController {

	Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserDAO userDAO;

	@Autowired
	User user;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Category category;
	
	@Autowired
	Product product;
	
		
	@RequestMapping(value="/loggedIn", method=RequestMethod.GET)
	public ModelAndView login(Principal principal,HttpServletRequest request,Model model)
	{
		ModelAndView mv;
		String name=principal.getName();
		System.out.println("name");
		String user= userDAO.getUsername(name);
		System.out.println("username");
		
		if(request.isUserInRole("ROLE_ADMIN"))
		{
			
			mv=new ModelAndView("adminHome");
			mv.addObject("loggedInUser",true );
			System.out.println("adminhome");
			mv.addObject("username",name);
			
			log.debug("Ending of the method login");
			return mv;
					
		}
			
		else
		{
			mv=new ModelAndView("userHome");
			model.addAttribute("product", new Product());
			model.addAttribute("category", new Category());
			model.addAttribute("supplier", new Supplier());
			model.addAttribute("productList", this.productDAO.list());
			model.addAttribute("categoryList", this.categoryDAO.list());
			model.addAttribute("supplierList", this.supplierDAO.list());
			mv.addObject("username",name);
			mv.addObject("loggedInUser",true );
			
			
			log.debug("Ending of the method login");
			return mv;
		}
	
	}
		
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user") User user) {
		ModelAndView mv;
		System.out.println(user.getEmail());
		System.out.println(user.getId());
		
		String message = null;
		if (user.getPassword().equals(user.getRepassword())) {
			user.setAdmin(false);
			System.out.println(user.getEmail());
			System.out.println(user.getAddress());
			user.setRole("ROLE_USER");

			userDAO.saveOrUpdate(user);
			mv = new ModelAndView("redirect:/loginHere");
		} else {
			System.out.println("data not inserted");
			message = "Passwords does not match";
			mv = new ModelAndView("home");
			mv.addObject("InRegisterPage", "true");
			mv.addObject("message", message);
			
		}
		
		return mv;
	}

	 
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("/home");
		session.invalidate();
		session = request.getSession(true);
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.list());
	
		mv.addObject("logoutMessage", "You successfully logged out");
		mv.addObject("loggedOut", "true");
	
		return mv;
	 }

	@RequestMapping("/error")
	public String getError(Model model,HttpServletRequest request)
	{
		String name=request.getParameter("username");
		model.addAttribute("username", name);
		return "error";
	}
	
	@RequestMapping("/userHomePage")
	public ModelAndView showuser(Principal principal,HttpServletRequest request,Model model) 
	{
		
		ModelAndView mv;
		String name=principal.getName();
		System.out.println(name);
		String username= userDAO.getUsername(name);
		System.out.println(username);
		mv=new ModelAndView("home");
		model.addAttribute("product", new Product());
		model.addAttribute("category", new Category());
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("productList", this.productDAO.list());
		model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("supplierList", this.supplierDAO.list());
		mv.addObject("username",name);
		mv.addObject("loggedInUser",true );
		
	
		return mv;
	}
	
	
	
}
*/