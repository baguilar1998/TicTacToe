public class gameChecker {
	public static int getPieces(){
		int count=0;
		for(int i=0;i<9;i++){
			if(gameGui.board[i]!=-1)++count;
		}
		return count;
	}
	public static int rowCheck(){
		for(int row=0;row<9;row=row+3){
				if(gameGui.board[row]==0 && gameGui.board[row+1]==0 && gameGui.board[row+2]==0)return 0;
				if(gameGui.board[row]==1 && gameGui.board[row+1]==1 && gameGui.board[row+2]==1)return 1;
			}
		return -1;
	}
	
	public static int verticalCheck(){
		for(int col=0;col<3;++col){
				if(gameGui.board[col]==0 && gameGui.board[col+3]==0 && gameGui.board[col+6]==0)return 0;
				if(gameGui.board[col]==1 && gameGui.board[col+3]==1 && gameGui.board[col+6]==1)return 1;
			}
		return -1;
	}
	
	
	public static int diagonalCheck1(){
		if(gameGui.board[0]==0 && gameGui.board[4]==0 && gameGui.board[8]==0)return 0;
		if(gameGui.board[0]==1 && gameGui.board[4]==1 && gameGui.board[8]==1)return 1;
		return -1;
	}
	
	public static int diagonalCheck2(){
		if(gameGui.board[2]==0 && gameGui.board[4]==0 && gameGui.board[6]==0)return 0;
		if(gameGui.board[2]==1 && gameGui.board[4]==1 && gameGui.board[6]==1)return 1;
		return -1;
	}
	
}