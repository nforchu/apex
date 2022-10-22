package com.apex.controllers;

import com.apex.util.MenuMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = "category")
public class CategoryController {


    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("title" , "Products specific title ");
        model.addAttribute("menu", buildMenu());
        return "category-form";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("menu", buildMenu());
        return "category-list";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String addOrUpdate(Model model) {
        model.addAttribute("menu", buildMenu());
        return "category";
    }

    private Map<String, String> buildMenu(){
        MenuMap menuMap = new MenuMap();
        return menuMap
                .addPair("New Category", "category/form")
                .addPair("All Categories", "category/list")
                .get();

    }
}
