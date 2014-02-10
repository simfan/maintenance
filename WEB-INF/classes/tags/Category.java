package tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import business.Product;


public class Category extends TagSupport
{
	private String folkSelect;
	private String countrySelect;
	private String rockSelect;
	private String otherSelect;

	String code = request.getParameter("code");
	Product product = new Product();

	String productFile = application.getInitParameter("fileName");
	product = ProductIO.readRecord(code, "../webapps/maintenance/WEB-INF/etc/products.txt");
 	public void setFolk(String f)
	{
		folkSelect = f;
	}

	public void setCountry(String c)
	{
		countrySelect = c;
	}

	public void setRock(String r)
	{
		rockSelect = r;
	}

	public void setOther(String o)
	{
		otherSelect = o;
	}

	public int doStartTag()
	{
		if (product.getCategory().equalsIgnoreCase("Country"))
		{
			//pagecontext.setAttribute("cSelect", product.getCategory());
			pagecontext.setAttribute("cSelect", "selected");

		}

		else if(product.getCategory().equalsIgnoreCase("Folk"))
		{
			//pagecontext.setAttribute("fSelect", product.getCategory());
			pagecontext.setAttribute("fSelect", "selected");

		}

		else if (product.getCategory().equalsIgnoreCase("Rock"))
		{
   	 		//pagecontext.setAttribute("rSelect", product.getCategory());
			pagecontext.setAttribute("rSelect", "selected");

   		}
		else if (product.getCategory().equalsIgnoreCase("Other"))
		{
			//pagecontext.setAttribute("oSelect", product.getCategory());
			pagecontext.setAttribute("oSelect", "selected");

		}
		else
		{
   	 		//pagecontext.setAttribute("rSelect", product.getCategory());
			pagecontext.setAttribute("rSelect", "selected");

   	 	}
		return SKIP_BODY;

	}
}