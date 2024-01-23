package com.myjewel.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.myjewel.beans.Category;
import com.myjewel.beans.Message;
import com.myjewel.beans.Product;
import com.myjewel.service.CategoryService;
import com.myjewel.service.ProductService;
import com.myjewel.utility.Factory;

@MultipartConfig
public class OperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CategoryService categoryService;
	ProductService productService;

	public OperationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		categoryService = Factory.getCategoryService();
		productService = Factory.getProductService();
		if (request.getParameter("operation").equals("add_category")) {
			String categoryTitle = request.getParameter("category_title");
			String categoryDescription = request.getParameter("category_description");
			Category category = new Category(categoryTitle, categoryDescription, new ArrayList<Product>());
			Integer id = categoryService.addCategory(category);

			HttpSession httpSession = request.getSession();
			if (id != null) {
				httpSession.setAttribute("messageObject",
						new Message(true, "Category added successfully with ID : " + id));
			} else {
				httpSession.setAttribute("messageObject", new Message(true, "Failed to add category!"));
			}
			response.sendRedirect("admin.jsp");
		} else if (request.getParameter("operation").equals("add_product")) {
			String productName = request.getParameter("product_name");
			String productDescription = request.getParameter("product_description");
			Double productPrice = Double.parseDouble(request.getParameter("product_price"));
			Double productDiscount = Double.parseDouble(request.getParameter("product_discount"));
			Integer productQuantity = Integer.parseInt(request.getParameter("product_quantity"));
			Integer productCategoryId = Integer.parseInt(request.getParameter("product_category"));
			Part part = request.getPart("product_picture");
			Category productCategory = categoryService.getCategoryById(productCategoryId);
			
			Product product = new Product();
			product.setProductName(productName);
			product.setProductDescription(productDescription);
			product.setProductPrice(productPrice);
			product.setProductDiscount(productDiscount);
			product.setProductQuantity(productQuantity);
			product.setProductPic(part.getSubmittedFileName());
			product.setCategory(categoryService.getCategoryById(productCategoryId));
			Integer id = productService.addProduct(product);
			
			//uploading picture
			ServletContext servletContext = request.getServletContext();
			
			String path = servletContext.getRealPath("img") + File.separator + "products" 
					+ File.separator + part.getSubmittedFileName();
			System.out.print("path:  "+path);
			
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			InputStream inputStream = part.getInputStream();
			byte[] data = new byte[inputStream.available()];
			inputStream.read(data);
			fileOutputStream.write(data);
			fileOutputStream.close();
			
			
			HttpSession httpSession = request.getSession();
			if (id != null) {
				httpSession.setAttribute("messageObject",
						new Message(true, "Product added successfully with ID : " + id));
			} else {
				httpSession.setAttribute("messageObject", new Message(true, "Failed to add product!"));
			}
			response.sendRedirect("admin.jsp");
		}

	}
}
