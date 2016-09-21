package com.niit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Controller
public class CategoryController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String listCategories(Model model) {

		model.addAttribute("category", category);
		model.addAttribute("categoryList", this.categoryDAO.list());
		for(Category c:categoryDAO.list())
		{
			System.out.println(c.getId());
			
		}

		return "category";
	}

	// For Add and Update Category
	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category) {

		categoryDAO.saveOrUpdate(category);

		return "redirect:/category";

	}

	// For Delete Category
	@RequestMapping("category/remove/{id}")
	public String deleteCategory(@PathVariable("id") String id, ModelMap model) throws Exception {

		try {
			categoryDAO.delete(id);
			model.addAttribute("message", "Successfully Deleted");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}

		return "redirect:/category";
	}

	// For Edit Category
	@RequestMapping("category/edit/{id}")
	public String editCategory(@PathVariable("id") String id, Model model) {
		System.out.println(id);
		System.out.println("editCategory");
		model.addAttribute("category", this.categoryDAO.get(id));
		model.addAttribute("listCategory", this.categoryDAO.list());
		return "redirect:/category";

	}

}
