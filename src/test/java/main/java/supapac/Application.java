package supapac;

import supapac.Game;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        Game game = new Game();

        try{
            game.openMainMenu();
            //game.run();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}