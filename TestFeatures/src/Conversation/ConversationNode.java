package Conversation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Text.Text;

public class ConversationNode implements Comparable<ConversationNode>{
	private List<ConversationNode> children = new ArrayList<ConversationNode>();
	private ConversationNode parent=null;
	private Text data=null;
	private int id;
	//private List<ConversationNode> nodeSearchList = null;
	private int layer;
	
	public ConversationNode(int id, int layer, Text data) {
		this.data = data;
		this.id=id;
		this.layer=layer;
	}
	
	public ConversationNode(int id, int layer, String data, ConversationNode parent) {
		this.data = new Text(data);
		this.parent=parent;
		this.id=id;
		this.layer=layer;
	}
	
	public ConversationNode(int id, int layer, Text data, ConversationNode parent) {
		this.data=data;
		this.parent=parent;
		this.id=id;
		this.layer=layer;
	}
	
	public void addChild(String data) {
		ConversationNode child = new ConversationNode(id+children.size()+1, layer+1, data, this);
		this.children.add(child);
		
	}
	
	public void addChild(Text data) {
		ConversationNode child = new ConversationNode(id+children.size()+1, layer+1, data, this);
		this.children.add(child);
		
	}
	
	public List<ConversationNode> getChildren(){return children;}
	public Text getData() {return data;}
	public int getLayer() {return layer;}
	public int getID() {return id;}
	public boolean isLeaf() {
		if(children.size()==0)
			return true;
		
		return false;
	}
	
	public boolean isRoot() {
		if(parent==null)
			return true;
		
		return false;
	}
	
	public ConversationNode findLast(int layer, ConversationNode obj) {
		List<ConversationNode> nodeSearchList = new ArrayList<ConversationNode>();
		
		traverse(nodeSearchList, obj, layer);
		
		Collections.sort(nodeSearchList);
		
		if(nodeSearchList.size()!=0)
			return nodeSearchList.get(nodeSearchList.size()-1);
		
		return null;
		
	}
	
	private static void traverse(List<ConversationNode> nodeSearchList, ConversationNode obj, int layer) {
        if (obj != null) {
            for (int i = 0; i < obj.getChildren().size(); i++) {
            	if(obj.getChildren().get(i).getLayer()==layer)
            		nodeSearchList.add(obj.getChildren().get(i));
            	
                traverse(nodeSearchList, obj.getChildren().get(i), layer);
            }
        }
        return;
	}
	
	public static void printList(ConversationNode obj) {
        if (obj != null) {
        	for(int i=0; i<obj.getData().getText().size(); i++)
        		System.out.println(obj.getLayer()+", "+obj.getData().getText().get(i));
            for (int i = 0; i < obj.getChildren().size(); i++) {
                printList(obj.getChildren().get(i));
            }
        }
        return;
	}

	//--
	public void setParent(ConversationNode parent) {
		parent.addChild(this);
		this.parent=parent;
	}
	
	public void addChild(ConversationNode child) {
		child.setParent(this);
		this.children.add(child);
	}
	
	public void removeParent() {this.parent=null;}

	@Override
	public int compareTo(ConversationNode node) {
		return this.id-node.getID();
	}
}
