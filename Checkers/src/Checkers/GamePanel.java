package Checkers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {
	
	static int scale=99;
	
	Board board;
	Selector s = new Selector();
	Boolean redToMove;
	Boolean running;
	Boolean next;
	Boolean pickPiece;

	fileManager file;
	int draw;
	AI ai;
	Boolean pressSpaceToControl=false;

	public GamePanel() {


		ai = new AI();
		file = new fileManager();
		board = new Board();
		addKeyListener(this);
		setBackground(new Color(64, 64, 64));
		setDoubleBuffered(true);
		setFocusable(true);
		initGame();
	}
	
	void initGame() {
		board.scaleBoard(scale);
		redToMove=true;
		//s.red(board);
		running=true;
		next=true;
		pickPiece=false;
		draw=0;
	}
	
	void playGame() {
		
		if(board.piecesLeft==1 || draw==10)
			System.exit(0);
		//file.generate(board);
		if(redToMove) {
			//System.out.println("Red");
			if(s.red(board)) {
				board.deletePiece(s.delete.getX(), s.delete.getY());
				board.piecesLeft--;
				movePiece();
				repaint();
			}
			else {
				//next=false;
				ai.randomMove(s);
				s.createMoveList(board, s.getXList(), s.getYList());
				movePiece();
				repaint();
			}
		}
		else {
			//System.out.println("Black");
			if(s.black(board)) {
				board.deletePiece(s.delete.getX(), s.delete.getY());
				board.piecesLeft--;
				movePiece();
				repaint();
			}
			else {
				//next=false;
				ai.randomMove(s);
				s.createMoveList(board, s.getXList(), s.getYList());
				movePiece();
				repaint();
			}
		}
		if(s.piecesInList==0)
			draw++;
		
		if(pressSpaceToControl)
			next=false;
		//s.printList();
		//System.out.println("51: "+s.jumps);
		/*
		System.out.println(s.forceJump(board, s.getXList(), s.getYList()));
		if(s.forceJump(board, s.getXList(), s.getYList())==1){
			movePiece();
		}
		else if(s.forceJump(board, s.getXList(), s.getYList())==2){
			s.createMoveList(board, s.getXList(), s.getYList());
		}
		else
			s.createMoveList(board, s.getXList(), s.getYList());
		*/
		//redToMove=!redToMove;
		//System.out.println(redToMove);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(next)
			playGame();
		drawBoard(g);
	}
	
	void drawBoard(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g.setColor(Color.black);
		
		for(int x=0; x<8; x++) {
			for(int y=0; y<8; y++) {
				g.drawRect(x*scale, y*scale, scale, scale);
				g.drawImage(board.getImage(x, y), x*scale, y*scale, null);
				String temp=x+","+y;
				g.setColor(Color.BLUE);
				g.drawString(temp, x*scale+scale/2-10, y*scale+scale/2+5);
			}
		}
		
		g.setColor(Color.MAGENTA);
		//System.out.println(pickPiece);
		if(pickPiece) {
			//System.out.println(s.moveListTotal);
			if(s.moveListTotal>0) {
				g.drawRect(s.getX()*scale, s.getY()*scale, scale+1, scale+1);
				//System.out.println(s.getX()+","+s.getY());
			}
			//System.out.println("Test: "+s.getXList()+","+s.getYList());
		}
		else {
			g.drawRect(s.getXList()*scale, s.getYList()*scale, scale+1, scale+1);
		}	
		
		for(int i=0; i<s.piecesInList; i++) {
			g.setColor(Color.blue);
			g.drawRect(s.pieces[i].getX()*scale, s.pieces[i].getY()*scale, scale+1, scale+1);
		}
	}

	void switchMove() {
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
	    if (key == KeyEvent.VK_LEFT) {
	        //s.moveLeft();
	    	if(pickPiece)
	    		s.leftMoveList();
	    	else
	    		s.leftList();
	    }
	    if(key==KeyEvent.VK_RIGHT)
	    {
	    		//s.moveRight();
	    	if(pickPiece)
	    		s.rightMoveList();
	    	else
	    		s.rightList();
	    }
	    if(key==KeyEvent.VK_UP) {
	    		s.moveUp();
	    		//s.upList();
	    }
	    if(key==KeyEvent.VK_DOWN) {
	    		s.moveDown();
	    }
	    if(key==KeyEvent.VK_SPACE) {
	    		//move whatever space is highlighted
	    		//System.out.println("Test");
	    		//moveTest(s.getXList(), s.getYList());
	    	/*if(pickPiece)
	    		movePiece();
	    	else if(pickPiece==false)
	    		select();*/
	    	next=true;
	    	/*
	    	if(pickPiece==false)
	    		select();
	    	else if(pickPiece==true)
	    		movePiece();*/
	    }
	    //System.out.println(s.listIndex);
	    //System.out.println(s.piecesInList);
	    repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	
	void select() {
		/*
		pickPiece=true;
		System.out.println(s.forceJump(board, s.getXList(), s.getYList()));
		if(s.forceJump(board, s.getXList(), s.getYList())==1){
			movePiece();
		}
		else if(s.forceJump(board, s.getXList(), s.getYList())==2){
			s.createMoveList(board, s.getXList(), s.getYList());
		}
		else
			s.createMoveList(board, s.getXList(), s.getYList());
		*/
		pickPiece=true;
		s.createMoveList(board, s.getXList(), s.getYList());
	}
	
	void movePiece() {
		//System.out.println("Old:"+s.getXList()+","+ s.getYList()+" - New:"+s.getX()+","+ s.getY());
		board.movePiece(s.getX(), s.getY(), s.getXList(), s.getYList());
    	board.scaleBoard(scale);
    	redToMove=!redToMove;
    	next=true;
    	pickPiece=false;
	}
}
