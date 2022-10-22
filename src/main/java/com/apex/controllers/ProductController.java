package com.apex.controllers;

import com.apex.services.ProductService;
import com.apex.util.MenuMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController (ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String viewAll(Model model) {
        model.addAttribute("title" , "Products specific title ");
        model.addAttribute("menu", buildMenu());
        model.addAttribute("products", productService.getProducts());
        return "product-list";
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("menu", buildMenu());
        return "product-form";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String addOrUpdate(Model model) {
        model.addAttribute("menu", buildMenu());
        return "product";
    }

    private Map<String, String> buildMenu(){
        MenuMap menuMap = new MenuMap();
        return menuMap
                .addPair("New Product", "/product/form")
                .addPair("List Products", "/product/list")
                .get();

    }

}
