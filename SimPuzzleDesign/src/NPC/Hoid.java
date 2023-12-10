package NPC;

import Text.ConversationParser;

public class Hoid extends Personality{
	
	public Hoid() {
		relationship=100;
		startingConversation = ConversationParser.ConversationParser("src/Text/test.txt");
	}
}
