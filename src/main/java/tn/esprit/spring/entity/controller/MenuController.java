package tn.esprit.spring.entity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Menu;
import tn.esprit.spring.service.MenuService;

@RestController
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	//post
	@PostMapping("/postmenu")
	public Menu saveMenuu(@RequestBody Menu menu){
		return menuService.saveMenu(menu);
	}
	@PostMapping("/postmenus")

	public List<Menu> savemenuus(@RequestBody List<Menu> menu){
		return menuService.saveMenus(menu);
	}
	
	//get
	@GetMapping("/getmenus")
	public List<Menu> getmenu(){
		return menuService.getMenu();
	}
	@GetMapping("/getmenu/{id}")

	public Menu getmenubyid(@PathVariable int id){
		return menuService.getMenuById(id);
			
	}
	@PutMapping("/putmenu")
	public Menu updateMenu(@RequestBody Menu m){
		return menuService.updateMenu(m);
	}
	@DeleteMapping("/deletemenu/{id}")
	public String deleteMenu(@PathVariable int id){
		return menuService.deleteMenu(id);
	}
}
