package CatGenetics;

public final class Mate {
	public static Cat getOffspring(Cat c1, Cat c2) {
		
		if(CatTest.checkForCatDeath(c1.getElement(), c2.getElement())) {
			c1=null;
			c2=null;
			return null;
		}else {
			String offspringElement = Elements.getInheritedElement(c1.getElement(), c2.getElement());
			
			return new Cat("Kitten", offspringElement);
		}
	}
}
