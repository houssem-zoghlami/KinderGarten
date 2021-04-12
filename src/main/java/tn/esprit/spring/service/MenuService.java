package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Menu;
import tn.esprit.spring.repository.MenuRepository;

@Service
public class MenuService implements IMenuService{
	
	@Autowired
	MenuRepository menuRepository;

	@Override
	public Menu saveMenu(Menu menu) {
		return menuRepository.save(menu);	}

	@Override
	public List<Menu> saveMenus(List<Menu> menu) {
		return menuRepository.saveAll(menu);
	}

	@Override
	public List<Menu> getMenu() {
		return menuRepository.findAll();
	}

	@Override
	public Menu getMenuById(int id) {
		return menuRepository.findById(id).orElse(null);
	}

	@Override
	public Menu updateMenu(Menu menu) {
		Menu m=menuRepository.findById(menu.getId()).orElse(null);
		m.setName(menu.getName());
		m.setCalories(menu.getCalories());
		m.setDescription(menu.getDescription());
		
		return menuRepository.save(m) ;
	}

	@Override
	public String deleteMenu(int id) {
		menuRepository.deleteById(id);
		return "delete menu"+id;
	}
	

	

}
