package CatGenetics;

public class Cat extends Entity {

	public String element;
	
	public Cat(String characterID) {
		super(characterID);
		element=Elements.getRandomElement();
	}
	
	public Cat(String characterID, String element) {
		super(characterID);
		this.element = element;
	}
	
	//Getters and SEtters
	public String getElement() {return element;}
	
	public void rerollElement() {element=Elements.getRandomElement();}

}
