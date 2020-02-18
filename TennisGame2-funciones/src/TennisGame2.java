
public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int player2Points = 0;
    
    private String player1Name;
    private String player2Name;
    String score;
    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        score = "";
    }

    public String getScore(){
    	score = normal();
        score = tie(score);
	
		if (isDouce())
		score = "Deuce";
        
		if (isAdvantage(player1Points,player2Points))
		    score = "Advantage player1";
		if (isAdvantage(player2Points,player1Points))
		    score = "Advantage player2";
      
        score = win(score);
        return score;
    }
//local para evitar efectos colaterales encapsulamiento
//ctlr alt i subir metodo
    
	private String normal() {
		String result="";
		if (player2Points!=player1Points)
      
            result = getLiteral(player1Points) + "-" + getLiteral(player2Points);
        
		return result;
	}
	private boolean isDouce() {
		return player1Points==player2Points && player1Points>=3;
	}

	private boolean isAdvantage(int fistPlayerPoint,int secondPlayerPoint) {
		return fistPlayerPoint > secondPlayerPoint && secondPlayerPoint >= 3;
	}

	private String win(String score) {
		if (player1Points>=4 && player2Points>=0 && (player1Points-player2Points)>=2)
        {
            score = "Win for player1";
        }
        if (player2Points>=4 && player1Points>=0 && (player2Points-player1Points)>=2)
        {
            score = "Win for player2";
        }
		return score;
	}

	private String tie(String score) {
		 
		if (player1Points == player2Points && player1Points < 4)
        {   score = getLiteral(player1Points);
            score += "-All";
        }
		return score;
	}
	private String getLiteral(int playerPoints) {
		String result="";
		if (playerPoints==0)
			result = "Love";
		if (playerPoints==1)
			result = "Fifteen";
		if (playerPoints==2)
			result = "Thirty";
		if (playerPoints==3)
			result = "Forty";
		return result;
	}
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        player1Points++;
    }
    
    public void P2Score(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}