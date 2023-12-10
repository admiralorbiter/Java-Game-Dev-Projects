package Gamepanels;

public class PanelTrigger {

	private boolean panelTransition=false;
	private Panel nextPanel=null;
	private String filename = null;
	
	public PanelTrigger(boolean panelTransition, Panel nextPanel) {
		this.panelTransition=panelTransition;
		this.nextPanel=nextPanel;
	}
	
	
	public Panel getNextPanel() {return nextPanel;}
	public void setNetPanel(Panel panel) {this.nextPanel=panel;}
	public boolean isPanelTransition() {return panelTransition;}
	public String getFilename() {return filename;}

}
