package xyz.pixelatedw.mineminenomi.api.json.models.item;

import xyz.pixelatedw.mineminenomi.api.json.models.JSONPredicateObject;

public class JSONModelSword extends JSONModelPredicates
{	
	public JSONModelSword(String itemName)
	{
		super(itemName, "sword");
	}
	
	public JSONModelSword(String itemName, JSONPredicateObject... predicate)
	{
		super(itemName, "sword", predicate);
	}

	@Override
	public String[] getModel()
	{	
		return super.getModel();
	}
	

}
