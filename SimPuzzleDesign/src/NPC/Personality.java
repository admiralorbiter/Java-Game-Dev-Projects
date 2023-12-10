package NPC;

import java.io.Serializable;

import Text.ConversationNode;
import Text.ConversationParser;

abstract class Personality implements Serializable{

	protected int relationship;
	protected ConversationNode startingConversation=null;
	
	public Personality() {
		relationship=10;
		//startingConversation = ConversationParser.ConversationParser("src/Application/test.txt");
	}

	public int getRelationship() {return relationship;}
	public ConversationNode loadConversation() {return startingConversation;}
	
}
