package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import business.Product;
import data.ProductIO;

/*
	UpdateProductServlet.java
	Chris Glock
	4/24/2007
	This servlet will either add a record to the product.txt file or update a current record, based upon the product code
*/

public class UpdateProductServlet extends HttpServlet
{
	private String productFile;
	public void init() throws ServletException
		{
			ServletConfig config = getServletConfig();
			ServletContext context = config.getServletContext();
			productFile = context.getInitParameter("fileName");
		}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String code = request.getParameter("pcode");
		String artist = request.getParameter("artist");
		String title = request.getParameter("album");
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		double price = Double.parseDouble(request.getParameter("price"));

		Product product = new Product();
		product = ProductIO.readRecord(code, productFile);
		if (product == null)
		{
			product = new Product(code, title, artist, category, description, price);
			ProductIO.addRecord(product, productFile);
		}
		else
		{
			product = new Product(code, title, artist, category, description, price);
			ProductIO.updateRecord(product, productFile);
		}


		product.setCode(code);
		product.setArtist(artist);
		product.setTitle(title);
		product.setCategory(category);
		product.setDescription(description);
		product.setPrice(price);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/servlet/servlets.ControllerServlet?View=fromUpdate");
		dispatcher.forward(request, response);
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
		return;
	}
}
