package com.phuongnam.controller;


import com.phuongnam.model.Ingredient;
import com.phuongnam.model.Taco;
import com.phuongnam.service.IngredientService;
import com.phuongnam.service.TacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/design")
public class DesignTacoController {

	@Autowired
	private TacoService tacoService;
	@Autowired
	private IngredientService ingredientService;
	@ModelAttribute("types")
	public List<Ingredient> ingredients(){
		return ingredientService.findAll();
	}
	
	@GetMapping
	public ModelAndView showDesignForm(Model model) {
		List<Ingredient> ingredients = new ArrayList<>();
		ingredientService.findAll().forEach(ingredients::add);
		Ingredient.Type[] types = Ingredient.Type.values();
		for (Ingredient.Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
		}
		ModelAndView modelAndView = new ModelAndView("design");
		modelAndView.addObject("taco", new Taco());
		return modelAndView;
	}

	@PostMapping
	public ModelAndView processDesign(@ModelAttribute("taco") Taco taco) {
		LocalDateTime now = LocalDateTime.now();
		taco.setCreatedAt(now);
		tacoService.save(taco);
		ModelAndView modelAndView = new ModelAndView("redirect:/orders/current");
		modelAndView.addObject("taco", new Taco());
		return modelAndView;
	}

	
	private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
		List<Ingredient> ingrList = new ArrayList<Ingredient>();
		for (Ingredient ingredient: ingredients) {
			if (ingredient.getType().equals(type)) ingrList.add(ingredient);
		}
		return ingrList;

	}
}