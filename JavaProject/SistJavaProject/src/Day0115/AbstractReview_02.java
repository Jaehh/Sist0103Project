package Day0115;

abstract class Game{
	abstract public void play();
	abstract public void stop();
}

class Kim extends Game{

	@Override
	public void play() {
		System.out.println("Kim 게임시작");
		
	}

	@Override
	public void stop() {
		System.out.println("Kim 게임중단");
		
	}
	
}

class Lee extends Game{

	@Override
	public void play() {
		System.out.println("Lee 게임시작");
		
	}

	@Override
	public void stop() {
		System.out.println("Lee 게임중단");
		
	}
	
}

class Choi extends Game{

	@Override
	public void play() {
		System.out.println("Choi 게임시작");
		
	}

	@Override
	public void stop() {
		System.out.println("Choi 게임중단");
		
	}
	
}

public class AbstractReview_02 {

	public static void main(String[] args) {
		
//		Game game = null;
//		
//		game = new Kim();
//		game.play();
//		game.stop();
//		
//		game = new Lee();
//		game.play();
//		game.stop();
//		
//		game = new Choi();
//		game.play();
//		game.stop();
		
		Game[] game = new Game[3];
		game[0] = new Kim();
		game[1] = new Lee();
		game[2] = new Choi();
		
		for(int i= 0;i<game.length;i++) {
			game[i].play();
		}
		System.out.println("==========================");
		for(int i=game.length-1;i>=0;i--) {
			game[i].stop();
		}
		
	}
}
