package CatGenetics;

import java.util.ArrayList;
import java.util.List;

public final class CatTest {
	
	public static boolean checkTotalCats(int totalCats, List<Cat> cats) {
		if(totalCats<(cats.size()-1))
			return true;
		
		return false;
	}
	
	public static boolean checkCatElements(List<Cat> cats) {
		
		List<String> catElements = new ArrayList<String>();
		
		//Create list of elements
		for(int i=0; i<cats.size(); i++) {
			if(!catElements.contains(cats.get(i).getElement())) {
				catElements.add(cats.get(i).getElement());
			}
		}
		
		List<String> elementList = Elements.getCombinedElementList();
		if(catElements.size()>elementList.size()) {
			for(int i=0; i<elementList.size(); i++) {
				if(!catElements.contains(elementList.get(i)))
					return false;
			}
		}else {
			return false;
		}
		
		return true;
	}
	
	public static String element(Cat cat, String element) {
		String result="No Result";
		
		if(checkForCatDeath(cat.getElement(), element)){
				cat=null;
				result="You killed the cat.";
		}
		
		if(cat!=null) {
			String combinedElement=Elements.getCombinedElement(cat.getElement(), element);
			
			if(combinedElement!=null)
				return combinedElement;
		}

		return result;
	}
	
	public static boolean checkForCatDeath(String catElement, String element) {
		
		
		if(catElement.equals(Elements.fire) && element.equals(Elements.water)) {
			return true;
		}
		else if(catElement.equals(Elements.water) && element.equals(Elements.earth)) {
			return true;
		}
		else if(catElement.equals(Elements.earth) && element.equals(Elements.lightning)) {
			return true;
		}
		else if(catElement.equals(Elements.lightning) && element.equals(Elements.wind)) {
			return true;
		}
		else if(catElement.equals(Elements.wind) && element.equals(Elements.fire)) {
			return true;
		}
		else if(catElement.equals(Elements.ice) && element.equals(Elements.scorch)) {
			return true;
		}
		else if(catElement.equals(Elements.scorch) && element.equals(Elements.blaze)) {
			return true;
		}
		else if(catElement.equals(Elements.blaze) && element.equals(Elements.swift)) {
			return true;
		}
		else if(catElement.equals(Elements.swift) && element.equals(Elements.poison)) {
			return true;
		}
		else if(catElement.equals(Elements.poison) && element.equals(Elements.explosion)) {
			return true;
		}
		else if(catElement.equals(Elements.explosion) && element.equals(Elements.storm)) {
			return true;
		}
		else if(catElement.equals(Elements.storm) && element.equals(Elements.wood)) {
			return true;
		}
		else if(catElement.equals(Elements.wood) && element.equals(Elements.lava)) {
			return true;
		}
		else if(catElement.equals(Elements.boil) && element.equals(Elements.lava)) {
			return true;
		}
		else if(catElement.equals(Elements.lava) && element.equals(Elements.ice)) {
			return true;
		}
		
		return false;
	}
}
