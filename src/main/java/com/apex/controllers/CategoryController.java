package com.apex.controllers;

import com.apex.jpa.Category;
import com.apex.services.CategoryService;
import com.apex.util.MenuMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = "category")
public class CategoryController {

    CategoryService categoryService;
    
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String get(Model model, @PathVariable long id) {
    	Category category = categoryService.get(id);
        model.addAttribute("title" , category.getTitle());
        model.addAttribute("category", category);
        model.addAttribute("menu", buildMenu());
        return "category";
    }
    
    @RequestMapping(value = "{id}/products", method = RequestMethod.GET)
    public String getProducts(Model model, @PathVariable long id) {
    	Category category = categoryService.get(id);
        model.addAttribute("title" , String.format("%s : Products",category.getTitle()));
        model.addAttribute("category", category);
        System.out.println(category.getProducts().size());
        model.addAttribute("menu", buildMenu());
        return "category-products";
    }
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("menu", buildMenu());
        model.addAttribute("categories", categoryService.getCategories());
        return "category-list";
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String newForm(Model model) {
        model.addAttribute("title" , "Add a new category");
        model.addAttribute("category", new Category());
        model.addAttribute("menu", buildMenu());
        return "category-form";
    }
    
    @RequestMapping(value = "form/{id}", method = RequestMethod.GET)
    public String editForm(Model model, @PathVariable long id) {
    	Category category = categoryService.get(id);
        model.addAttribute("title" , String.format("Edit category: %s", category.getTitle()));
        model.addAttribute("category", category);
        model.addAttribute("menu", buildMenu());
        return "category-form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addOrUpdate(Model model, @RequestBody MultiValueMap<String, String> formData) {    	
    	
		long id = Long.parseLong(formData.get("id").get(0));
		Category category = new Category()
				.setId(id)
				.setTitle(formData.get("title").get(0))
				.setDescription(formData.get("description").get(0));    	
    	category = id > 0 ? update(category) : add(category);
    	
        model.addAttribute("menu", buildMenu());
        model.addAttribute("category", category);
        return "category"; 
    }
    
    private Category add(Category category) {
    	return categoryService.add(category);
    }
    
    private Category update(Category category) {
    	return categoryService.update(category);
    }

    private MenuMap buildMenu(){
        MenuMap menuMap = new MenuMap();
        return menuMap.setTitle("Categories")                
                .addPair("List Categories", "/category/list")
                .addPair("New Category", "/category/form");
    }
}
