package tags;

import javax.servlet.jsp.tagext.*;

public class ProductListTEI extends TagExtraInfo
{
	public VariableInfo[] getVariableInfo(TagData data)
	{
		return new VariableInfo[]
		{
			new VariableInfo("code", "String", true, VariableInfo.NESTED),
			new VariableInfo("artist", "String", true, VariableInfo.NESTED),
			new VariableInfo("title", "String", true, VariableInfo.NESTED),
			new VariableInfo("priceCurrency", "String", true, VariableInfo.NESTED)
		};
	}
}