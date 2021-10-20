package lab01;

public class CoinFlipExperiment {
	public static void main(String[] args) {
		
		int amount = coinFlipExperiment();
		System.out.println("Wins/loss amount: " + amount);
		
	}
	
	public static int coinFlipExperiment() {
		int earnings = 0;
		int i = 0;
		
		while(i<100) {	
			double flip = Math.random();
			if (flip < 0.505) {
				earnings++;
			}else {
				earnings--;
			}
			i++;
		}
		
		return(earnings);
	}
}
