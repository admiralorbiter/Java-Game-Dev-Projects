package Checkers;

public class Selector {
	int x;
	int y;
	
	Piece pieces[];
	int piecesInList;
	int listIndex;
	
	Piece moveList[];
	Piece delete;
	int moveListTotal;
	int moveListIndex;
	
	int jumps;
	public Selector() {
		x=0;
		y=0;
		moveList = new Piece[3];
		for(int i=0; i<3; i++)
			moveList[i]=new Piece("error", 0, 0);
		pieces=new Piece[12];
		for(int i=0; i<12; i++)
			pieces[i]=new Piece("error", 0, 0);
		piecesInList=0;
		listIndex=0;
		
	}
	
	int getX() {return x;}
	int getY() {return y;}
	int getXList() { return pieces[listIndex].getX();}
	int getYList() { return pieces[listIndex].getY();}
	
	void moveSelector() {
		
	}
	void setListIndex(int index) {listIndex=index;}
	void moveLeft() {
		if(x>0)
			x=x-1;
	}
	
	void leftList() {
		if(listIndex>0)
			listIndex=listIndex-1;
		else
			listIndex=piecesInList-1;
	}
	
	void leftMoveList() {
		if(moveListTotal==2) {
			if(moveListIndex==1)
				moveListIndex=0;
			else
				moveListIndex=1;
		}
		this.x=moveList[moveListIndex].getX();
		this.y=moveList[moveListIndex].getY();
	}
	
	void rightMoveList() {
		if(moveListTotal==2) {
			if(moveListIndex==1)
				moveListIndex=0;
			else
				moveListIndex=1;
		}
		this.x=moveList[moveListIndex].getX();
		this.y=moveList[moveListIndex].getY();
	}
	
	void moveRight() {
		if(x<7)
			x=x+1;
	}
	
	void rightList() {
		if(listIndex<piecesInList-1)
			listIndex=listIndex+1;
		else
			listIndex=0;
	}
	
	void moveDown() {
		if(y<7)
			y=y+1;
	}
	
	void moveUp() {
		if(y>0)
			y=y-1;
	}
	//experimental
	void upList() {
		int num=listIndex/2;
		if(listIndex+num<piecesInList)
			listIndex=(listIndex+num);
		else
			listIndex=(listIndex+num)%piecesInList;
	}
	
	
	Boolean red(Board board) 
	{
		int c=0;
		int r=0;
		
		try {
			//reset();
			jumps=0;
			piecesInList=0;
			for(int row=0; row<7; row++)
				for(int col=0; col<8; col++)
				{
					Boolean filled=false;
					c=col;
					r=row;
					if(board.getPiece(col, row).getPlayer()=="red")
					{
						if(col!=7) {
							if(board.getPiece(col+1, row+1).getPlayer()=="empty") {
								//System.out.println(col+","+ row +" - "+board.getName(col, row));
								pieces[piecesInList]=new Piece("red", col, row);
								//System.out.println(pieces[piecesInList].getX()+ " - "+pieces[piecesInList].getY());
								piecesInList++;
								filled=true;
							}
							else if(board.getPiece(col+1, row+1).getPlayer()=="black"){
								if(col<6 && row<6) {
									if(board.getPiece(col+2, row+2).getPlayer()=="empty") {
										delete = new Piece("empty", col+1, row+1);
										jumps++;
										x=col+2;
										y=row+2;
										
										piecesInList++;
										listIndex=0;
										pieces[0]=new Piece("black", col, row);
										filled=true;
									}
								}
							}
						}
						if(col!=0 && filled==false) {
							if(board.getPiece(col-1, row+1).getPlayer()=="empty") {
								//System.out.println(col+","+ row +" - "+board.getName(col, row));
								pieces[piecesInList]=new Piece("red", col, row);
								//System.out.println(pieces[piecesInList].getX()+ " - "+pieces[piecesInList].getY());
								piecesInList++;
							}
							else if(board.getPiece(col-1, row+1).getPlayer()=="black"){
								if(col!=1 && row<6) {
									if(board.getPiece(col-2, row+2).getPlayer()=="empty") {
										delete = new Piece("empty", col-1, row+1);
										jumps++;
										x=col-2;
										y=row+2;
		
										piecesInList++;
										listIndex=0;
										pieces[0]=new Piece("black", col, row);
									}
								}
							}
						}
					}
				}
			}
			catch(ArrayIndexOutOfBoundsException exception) {
			    System.out.println(c+","+r+"   "+exception);
			}
			if(jumps==1) {
				return true;
			}
			else {
				listIndex=0;
				x=pieces[0].getX();
				y=pieces[0].getY();
				return false;
			}
			//System.out.println(x+" - "+y);
				//printList();
			//printList();
	}
	
	void setCoord(int x, int y) {
		this.x=x;
		this.y=y;
	}
	int getListIndex() {return listIndex;}
	
	Boolean black(Board board)
	{	
		int c=0;
		int r=0;
		try {
			jumps=0;
			moveListIndex=0;
			//reset();
			piecesInList=0;
			for(int row=1; row<8; row++)
				for(int col=0; col<8; col++)
				{
					Boolean filled=false;
					r=row;
					c=col;
					if(board.getPiece(col, row).getPlayer()=="black")
					{
						//System.out.println(col+","+row);
						if(col!=7) {
							if(board.getPiece(col+1, row-1).getPlayer()=="empty") {
								//System.out.println(col+","+ row +" - "+board.getName(col, row));
								pieces[piecesInList]=new Piece("black", col, row); //board.getPiece(col, row);
								//System.out.println(pieces[piecesInList].getX()+ " - "+pieces[piecesInList].getY());
								piecesInList++;
								filled=true;
							}
							else if(board.getPiece(col+1, row-1).getPlayer()=="red"){
								if(col!=6 && row>1) {
									if(board.getPiece(col+2, row-2).getPlayer()=="empty") {
										delete = new Piece("empty", col+1, row-1);
										jumps++;
										
										//x=col;
										//y=row;
										x=col+2;
										y=row-2;
										
										/*
										 * Truly a bad workaround to this problem.
										 * The selection is weird, so when I force a move it needs to store the new coord in the list?
										 */
										piecesInList++;
										listIndex=0;
										pieces[0]=new Piece("black", col, row);
										filled=true;
									}
								}
							}
						}
						if(col!=0 && filled==false) {
							if(board.getPiece(col-1, row-1).getPlayer()=="empty") {
								//System.out.println(col+","+ row +" - "+board.getName(col, row));
								pieces[piecesInList]=new Piece("black", col, row); //board.getPiece(col, row);
								//System.out.println(pieces[piecesInList].getX()+ " - "+pieces[piecesInList].getY());
								piecesInList++;
							}
							else if(board.getPiece(col-1, row-1).getPlayer()=="red"){
								if(col!=1 && row>1) {
									if(board.getPiece(col-2, row-2).getPlayer()=="empty") {
										delete = new Piece("empty", col-1, row-1);
										jumps++;
										x=col-2;
										y=row-2;
										/*
										 * Truly a bad workaround to this problem.
										 * The selection is weird, so when I force a move it needs to store the new coord in the list?
										 */
										piecesInList++;
										listIndex=0;
										pieces[0]=new Piece("black", col, row);
									}
								}
							}
						}
						
					}
				}
			}
			catch(ArrayIndexOutOfBoundsException exception) {
				System.out.println(c+","+r);
			}
			//System.out.println(jumps+" - "+x+","+y);
			if(jumps==1) {
				return true;
			}
			else {
				listIndex=0;
				x=pieces[0].getX();
				y=pieces[0].getY();
				return false;
			}
	}
	
	//test
	void printList() {
		System.out.println("List of Pieces: ");
		for(int i=0; i<piecesInList; i++) {
			System.out.println(pieces[i].getName()+" x: "+pieces[i].getX()+" y: "+pieces[i].getY());
		}
	}
	
	void test() {
		System.out.println("Test");
	}
	
	void reset() {
		for(int i=0; i<piecesInList; i++)
			pieces[i]=new Piece("emtpy", 0, 0);
	}
	
	int forceJump(Board board, int x, int y) {
		Boolean jump=false;
		
		if(board.getPiece(x, y).getPlayer()=="red") {
			if(x!=0) {
				if(board.getPiece(x-1, y+1).getPlayer()=="black") {
					if(board.getPiece(x-2, y+2).getPlayer()=="empty")
						this.x=(x-2);
						this.y=(y+2);
						jump=true;
				}
			}
			if(x!=7) {
				if(board.getPiece(x+1, y+1).getPlayer()=="black") {
					if(board.getPiece(x+2, y+2).getPlayer()=="empty") {
						if(jump==false) {
							this.x=(x+2);
							this.y=(y+2);
							return 1;
						}
						else
							return 2;
					}
						
				}
			}
		}
		else {
			System.out.println(board.getPiece(x+1, y-1).getPlayer()+", "+board.getPiece(x+2, y-2).getPlayer());
			if(x!=0) {
				if(board.getPiece(x-1, y-1).getPlayer()=="red") {
					if(board.getPiece(x-2, y-2).getPlayer()=="empty")
						this.x=(x-2);
						this.y=(y-2);
						jump=true;
				}
			}
			if(x!=7)
			{
				if(board.getPiece(x+1, y-1).getPlayer()=="red") {
					if(board.getPiece(x+2, y-2).getPlayer()=="empty") {
						if(jump==false) {
							this.x=(x+2);
							this.y=(y-2);
							return 1;
						}
						else
							return 2;
					}
						
				}
			}
		}
		
		if(jump) {
			return 1;
		}
		else
			return 0;
	}
	
	void createMoveList(Board board, int x, int y) {
		moveListTotal=0;
		moveListIndex=0;
		//System.out.println("S 359: "+x+","+y);
		if(board.getPiece(x, y).getPlayer()=="red") {
			//need to do a boundary check first
			if(x!=0) {
				if(board.getPiece(x-1, y+1).getPlayer()=="empty") {
					//System.out.println(x+","+y+"   -   "+(x-1)+","+(y+1));
					
					moveList[moveListTotal]=new Piece("empty", (x-1), (y+1));
					moveListTotal++;
				}
			}
			if(x!=7) {
				if(board.getPiece(x+1, y+1).getPlayer()=="empty") {
					moveList[moveListTotal]=new Piece("empty", x+1, y+1);
					moveListTotal++;
				}
			}
		}
		else {
			if(x!=0) {
				if(board.getPiece(x-1, y-1).getPlayer()=="empty") {
					moveList[moveListTotal]=new Piece("empty", x-1, y-1);
					moveListTotal++;
				}
			}
			if(x!=7)
			{
				if(board.getPiece(x+1, y-1).getPlayer()=="empty") {
					moveList[moveListTotal]=new Piece("empty", x+1, y-1);
					moveListTotal++;
				}
			}
		}
		if(moveListTotal>0) {
			this.x=moveList[0].getX();
			this.y=moveList[0].getY();
			//System.out.println(moveList[0].getX()+","+moveList[0].getY());
			//System.out.println("1: "+this.x+","+this.y);
		}
	}
}
