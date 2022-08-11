package Checkers;

import java.awt.Image;

public class Board {
	Piece pieces[][];
	int piecesLeft=24;
	
	public Board() {
		pieces=new Piece[8][8];
		
		//setup a clear board
		for(int x=0; x<8; x++) {
			for(int y=0; y<8; y++) {
				pieces[x][y]=new Piece("empty", x, y);
			}
		}
		
		for(int x=0; x<=6; x=x+2) {
			pieces[x+1][0]=new Piece("red", x+1, 0);
			pieces[x][1]=new Piece("red", x, 1);
			pieces[x+1][2]=new Piece("red", x+1, 2);
			pieces[x][5]=new Piece("black", x, 5);
			pieces[x+1][6]= new Piece("black", x+1, 6);
			pieces[x][7]= new Piece("black", x, 7);
		}
	}
	
	void scaleBoard(int scale) {
		for(int x=0; x<8; x++) {
			for(int y=0; y<8; y++) {
				pieces[x][y].scaleSprites(scale);
			}
		}
	}
	
	Image getImage(int x, int y) {return pieces[x][y].getImage();}
	
	Piece getPiece(int x, int y) {return pieces[x][y];}
	
	void movePiece(int x, int y, int oldX, int oldY) {
		/*if(pieces[x][y].getPlayer()=="red") {
			swap(x, y, x, y+1);
		}
		else
			swap(x, y, x, y-1);*/
		swap(oldX, oldY, x, y);
		if(y==0 || y==7) {
			pieces[x][y].kingMe();
		}
	}
	
	void swap(int x, int y, int newX, int newY) {
		pieces[newX][newY]=pieces[x][y];
		pieces[x][y]=new Piece("empty", x, y);
	}
	
	void deletePiece(int x, int y) {
		pieces[x][y]=new Piece("empty", x, y);
	}
	
}
