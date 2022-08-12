package Application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Conversation.ConversationNode;
import Text.Text;

public class ConversationParser {

	public static List<Text> getCurrentConversationText(ConversationNode conversation){
		List<Text> currentConversation = new ArrayList<Text>();
		
		currentConversation.add(conversation.getData());
		for(ConversationNode children : conversation.getChildren())
			currentConversation.add(children.getData());
		
		return currentConversation;
	}
	
	public static ConversationNode ConversationParser(String fileLocation) {
		int layer=0;
		int conversationID=0;
		
		ConversationNode previousNode = null;
		
		File file = new File(fileLocation);
		
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String line =sc.nextLine();
		
		int index=line.indexOf('/');
    	Text text=new Text(line.substring(0, index));
    	line=line.substring(index+1);
    	while(line.indexOf('/')!=-1) {
    		index=line.indexOf('/');
    		System.out.println(line.substring(0, index));
    		text.addText(line.substring(0, index));
    		line=line.substring(index+1);
    	}
		
		ConversationNode conversation = new ConversationNode(conversationID, layer, text);
		previousNode = conversation;
		layer++;
		
		while(sc.hasNextLine()) {
			/*
			String line = sc.nextLine();
	    	int num = Character.getNumericValue(line.charAt(0));
	    	if(layer==num) {
	    		previousNode.addChild(line.substring(2));
	    		currentNode = previousNode.getChildren().get(previousNode.getChildren().size()-1);
	    		conversationID++;
	    		System.out.println("1: "+layer+"  "+previousNode.getData());
	    	}else if(layer<num) {
	    		layer=num;
	    		currentNode.addChild(line.substring(2));
	    		currentNode = previousNode.getChildren().get(previousNode.getChildren().size()-1);
	    		conversationID++;
	    		System.out.println("2: "+layer+"  "+currentNode.getData());
	    	}else if(layer>num) {
	    		layer=num;
	    		currentNode=conversation.findLast(layer, conversation);
	    		currentNode.addChild(line.substring(2));
	    		System.out.println("3: "+layer+"  "+previousNode.getData());
	    		conversationID++;
	    	}*/
			
			line = sc.nextLine();
	    	int num = Character.getNumericValue(line.charAt(0));
	    	
	    	index=line.indexOf('/');
	    	text=new Text(line.substring(0, index));
	    	line=line.substring(index+1);
	    	while(line.indexOf('/')!=-1) {
	    		index=line.indexOf('/');
	    		System.out.println(line.substring(0, index));
	    		text.addText(line.substring(0, index));
	    		line=line.substring(index+1);
	    	}
			
	    	
	    	/*
	    	if(layer<num) {
	    		previousNode=previousNode.getChildren().get(previousNode.getChildren().size()-1);
	    	}else if(layer>num) {
	    		previousNode=conversation.findLast(layer--, conversation);
	    	}
	    	
	    	layer=num;
	    	System.out.println(previousNode.getLayer()+"   "+previousNode.getData());
	    	previousNode.addChild(line.substring(2));
	    	conversationID++;
	    	*/
	    		
	    	layer=num;
	    	int layerSearch=layer-1;
	    	previousNode=conversation.findLast(layerSearch, conversation);
	    	if(previousNode==null)
	    		conversation.addChild(text);
	    	else
	    		previousNode.addChild(text);
	    	
	    	conversationID++;
	    	
		}
		
		return conversation;
	}
}
