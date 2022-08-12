package CatGenetics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Elements {
	public static String earth = "Earth";
	public static String fire="Fire";
	
	public static String air = "Air";
	public static String water = "Water";
	public static String light = "Light";
	public static String dark = "Dark";
	public static String wind = "Wind";
	public static String lightning = "Lightning";
	
	public static String blaze = "Blaze";
	public static String scorch = "Scorch";
	public static String ice = "Ice";
	public static String boil = "Boil";
	public static String lava = "Lava";
	public static String wood = "Wood";
	public static String storm = "Storm";
	public static String explosion = "Explosion";
	public static String poison = "Poison";
	public static String swift = "Swift";
	
	public static List<String> getCoreElementList(){
		List<String> elementList = new ArrayList<String>();
		
		elementList.add(fire);
		elementList.add(wind);
		elementList.add(lightning);
		elementList.add(earth);
		elementList.add(water);
		
		
		return elementList;
	}
	
	public static List<String> getCombinedElementList(){
		List<String> elementList = new ArrayList<String>();
		
		elementList.add(blaze);
		elementList.add(scorch);
		elementList.add(ice);
		elementList.add(boil);
		elementList.add(lava);
		elementList.add(wood);
		elementList.add(storm);
		elementList.add(explosion);
		elementList.add(poison);
		elementList.add(swift);
		
		return elementList;
	}
	
	public static String getRandomElement() {
		Random n = new Random();
		List<String> elementList = getCoreElementList();
		String element = elementList.get(n.nextInt(5));

		return element;
	}
	
	public static String getInheritedElement(String e1, String e2) {
		String element=Elements.getRandomElement();
		
		String e = getCombinedElement(e1, e2);
		
		if(e!=null)
			element=e;
		
		return element;
	}
	
	public static String getCombinedElement(String e1, String e2) {
		String element=null;
		if(e1.equals(fire)) {
			if(e2.equals(wind))
				element=scorch;
			else if(e2.equals(water))
				element=boil;
			else if(e2.equals(earth))
				element=lava;
			else if(e2.equals(lightning))
				element=blaze;
		}
		else if(e1.equals(wind)) {
			if(e2.equals(earth))
				element=poison;
			else if(e2.equals(lightning))
				element=swift;
			else if(e2.equals(fire))
				element=scorch;
			else if(e2.equals(water))
				element=ice;
		}
		else if(e1.equals(lightning)) {
			if(e2.equals(water))
				element=storm;
			else if(e2.equals(earth))
				element=explosion;
			else if(e2.equals(wind))
				element=swift;
			else if(e2.equals(fire))
				element=blaze;
		}
		else if(e1.equals(earth)) {
			if(e2.equals(fire))
				element=lava;
			else if(e2.equals(water))
				element=wood;
			else if(e2.equals(lightning))
				element=explosion;
			else if(e2.equals(wind))
				element=poison;
		}
		else if(e1.equals(water)) {
			if(e2.equals(wind))
				element=ice;
			else if(e2.equals(fire))
				element=boil;
			else if(e2.equals(earth))
				element=wood;
			else if(e2.equals(lightning))
				element=storm;
		}
		
		return element;
	}
}
