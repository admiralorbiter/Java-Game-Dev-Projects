package Checkers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class fileManager {
	BufferedWriter writer;
	public fileManager() {
		try {
			writer = new BufferedWriter(new FileWriter("code.txt"));
		}
		catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	void generate(Board board) {
		try {
			for(int x=0; x<8; x++) {
				for(int y=0; y<8; y++) {
					System.out.print(board.getPiece(x, y).getPlayer());
					System.out.print(" ");
					writer.write(board.getPiece(x, y).getPlayer());
				}
				System.out.println();
				writer.newLine();
			}
		}
		catch (IOException e) {

			e.printStackTrace();
		}
	}
}
