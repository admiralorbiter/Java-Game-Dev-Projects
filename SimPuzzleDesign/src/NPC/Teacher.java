package NPC;

import Text.ConversationParser;

public class Teacher extends Personality {
	public Teacher() {
		relationship=100;
		startingConversation = ConversationParser.ConversationParser("src/Text/test.txt");
	}
}
