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
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class SupplierController {
	

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;

	@RequestMapping(value = "/supplier", method = RequestMethod.GET)
	public String listSuppliers(Model model) {

			model.addAttribute("supplier", new Supplier());
			model.addAttribute("supplierList", this.supplierDAO.list());
			return "supplier";
		}

	//For Add and Update supplier
		@RequestMapping(value= "/supplier/add", method = RequestMethod.POST)
		public String addSupplier(@ModelAttribute("supplier") Supplier supplier){
			
		
				supplierDAO.saveOrUpdate(supplier);
			
			return "redirect:/supplier";
			
		}
		
		//For Remove Supplier
		@RequestMapping("supplier/remove/{id}")
	    public String removeSupplier(@PathVariable("id") String id,ModelMap model) throws Exception{
			
	       try {
			supplierDAO.delete(id);
			model.addAttribute("message","Successfully Deleted");
		} catch (Exception e) {
			model.addAttribute("message",e.getMessage());
			e.printStackTrace();
		}
	        return "redirect:/supplier";
	    }
	 
		
		// For Edit Supplier
	    @RequestMapping("supplier/edit/{id}")
	    public String editSupplier(@PathVariable("id") String id, Model model){
	    	System.out.println("editSupplier");
	        model.addAttribute("supplier", this.supplierDAO.get(id));
	        model.addAttribute("listSuppliers", this.supplierDAO.list());
	        return "supplier";
	    }
}
