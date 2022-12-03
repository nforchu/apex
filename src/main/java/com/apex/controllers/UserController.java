package com.apex.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apex.jpa.User;
import com.apex.services.UserService;
import com.apex.util.MenuMap;

@Controller
@RequestMapping("console/user")
public class UserController {
	
	UserService userService;
	
	
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String get(Model model, @PathVariable long id) {
    	User user = userService.findById(id);
        model.addAttribute("title" , user.getName());
        model.addAttribute("user", user);
        model.addAttribute("menu", buildMenu());
        return "user";
    }
   
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("menu", buildMenu());
        model.addAttribute("users", userService.findAll());
        return "user-list";
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String newForm(Model model) {
        model.addAttribute("title" , "Add a new user");
        model.addAttribute("user", new User());
        model.addAttribute("menu", buildMenu());
        return "user-form";
    }
    
    @RequestMapping(value = "form/{id}", method = RequestMethod.GET)
    public String editForm(Model model, @PathVariable long id) {
    	User user = userService.findById(id);
        model.addAttribute("title" , String.format("Edit user: %s", user.getName()));
        model.addAttribute("user", user);
        model.addAttribute("menu", buildMenu());
        return "user-form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addOrUpdate(Model model, @RequestBody MultiValueMap<String, String> formData) {    	
    	
		long id = Long.parseLong(formData.get("id").get(0));
		User user = new User()
				.setId(id)
				.setPassword(formData.get("password").get(0))
				.setName(formData.get("name").get(0))
				.setEmail(formData.get("email").get(0));    	
    	user = id > 0 ? update(user) : add(user);
    	
        model.addAttribute("menu", buildMenu());
        model.addAttribute("user", user);
        return String.format("redirect:/user/%s", user.getId());
    }
    
    @RequestMapping(value = "{id}/delete",  method = RequestMethod.GET)
    public String confirmDelete(Model model, @PathVariable long id) {
    	User user = userService.findById(id);
        model.addAttribute("title" , String.format("Delete user %s", user.getName()));
        model.addAttribute("user", user);
        model.addAttribute("menu", buildMenu());
        return "user-delete";
    }
    
    @RequestMapping(value = "{id}/delete",  method = RequestMethod.POST)
    public String delete(Model model , @PathVariable long id) {
    	userService.delete(id);
    	return "redirect:/user/list";
    }
    
    
    private User add(User user) {
    	return userService.add(user);
    }
    
    private User update(User user) {
    	return userService.update(user);
    }

    private MenuMap buildMenu(){
        MenuMap menuMap = new MenuMap();
        return menuMap.setTitle("Users")                
                .addPair("List Users", "/user/list")
                .addPair("New User", "/user/form");
    }

}
