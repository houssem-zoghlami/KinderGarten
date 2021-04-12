package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Menu;

public interface IMenuService {
	
	public Menu saveMenu(Menu menu);
	public List<Menu> saveMenus(List<Menu> menu);
	
	public List<Menu> getMenu();
	public Menu getMenuById(int id);
	
	public Menu updateMenu(Menu menu);
	public String deleteMenu(int id);
	
	

}
