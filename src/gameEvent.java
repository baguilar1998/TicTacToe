import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class gameEvent implements MouseListener {
	public static boolean enabled=true;
	public void mouseClicked(MouseEvent e){};
	public void mousePressed(MouseEvent e){
		if(!enabled)return;
		for(int i=0;i<9;i++){
			if(gameGui.board[i]!=-1)continue;
			if(e.getSource()==gameGui.s[i]){
				if(gameGui.XorO==0){ 
					gameGui.s[i].setIcon(gameGui.X);
					gameGui.board[i]=0;
					++gameGui.XorO;
					break;
				}else{
					gameGui.s[i].setIcon(gameGui.O);
					gameGui.board[i]=1;
					--gameGui.XorO;
					break;
				}
			}
		}
		gameGui.checkGame();
	}
	

	public void mouseReleased(MouseEvent e){};
	public void mouseEntered(MouseEvent e){};
	public void mouseExited(MouseEvent e){};

}
