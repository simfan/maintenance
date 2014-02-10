package tags;

import javax.servlet.jsp.tagext.*;

public class CategoryTEI extends TagExtraInfo
{
	public VariableInfo[] getVariableInfo(TagData data)
	{
		return new VariableInfo[]
		{
			new VariableInfo("cSelect", "String", true, VariableInfo.NESTED),
			new VariableInfo("fSelect", "String", true, VariableInfo.NESTED),
			new VariableInfo("rSelect", "String", true, VariableInfo.NESTED),
			new VariableInfo("oSelect", "String", true, VariableInfo.NESTED)
		};
	}
}