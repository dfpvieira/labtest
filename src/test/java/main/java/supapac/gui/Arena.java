package main.java.supapac.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import main.java.supapac.Position;
import main.java.supapac.elements.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;


public class Arena {

    private int height;
    private int width;
    private int lives =3;
    private int portnumber = 10;
    private boolean dead= false;
    private Player player;
    private List<walls> Walls;
    private List<Monster> monsters;
    private List<Material>materials;
    private List<Portals>portals;
    private List<Bomb>bombs;
    private int level = 0;
    private boolean verified;
    String filePath = new File("").getAbsolutePath();

    private List<String> maps = new ArrayList<>(Arrays.asList("files/level3.txt")); //mudar consoante o nivel

    public Arena(int width, int height) {
        this.height = height;
        this.width = width;
        this.player = new Player(30,15);
        this.Walls = new ArrayList<>();
        this.monsters = new ArrayList<>();
        this.materials = new ArrayList<>();
        this.portals = new ArrayList<>();
        this.bombs = new ArrayList<>();
        loadLevel(maps.get(level++));
    }

    private void loadLevel(String map){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(map));
            String line = reader.readLine();
            int y = 0;
            while(line!=null){
                for(int x = 0; x < line.length(); x++){
                    switch (line.charAt(x)){
                        case 'W':
                            this.Walls.add(new walls(x,y));
                            break;
                        case 'B':
                            this.materials.add(new Material(x,y));
                            break;
                        case 'M':
                            this.monsters.add(new Monster(x,y));
                            break;
                        case 'P':
                            this.portals.add(new Portals(x,y));
                            break;
                        case 'D':
                            this.bombs.add(new Bomb(x,y));
                            break;
                        default:
                            break;
                    }
                }
                y++;
                line = reader.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void processKey(KeyStroke key, Screen screen) throws IOException {
        if(key == null) return;
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') screen.close();
        if (key.getKeyType() == KeyType.ArrowLeft) movePlayer(player.moveLeft());
        if (key.getKeyType() == KeyType.ArrowRight) movePlayer(player.moveRight());
        if (key.getKeyType() == KeyType.ArrowUp) movePlayer(player.moveUp());
        if (key.getKeyType() == KeyType.ArrowDown) movePlayer(player.moveDown());
        moveMonsters();
        moveBombs();
        verifyWin();
        verifyBombCollisions();
        verifyMonsterCollisions();
    }

    private boolean canPlayerMove(Position position) {
        for (Material material : materials) {
            if (material.getPosition().equals(position)) {
                materials.remove(material);
                break;
            }
        }

        for (walls wall : Walls)
            if (wall.getPosition().equals(position)) return false;
            return true;

    }

    private boolean canMonsterMove(Position position) {
        for (walls wall : Walls) {
            if (wall.getPosition().equals(position)) return false;
        }
        for (Portals portal: portals) {
            if (portal.getPosition().equals(position)) return false;
        }
        return true;
    }

    private boolean canBombMove(Position position) {
        for (walls wall : Walls) {
            if (wall.getPosition().equals(position)) return false;
        }
        for (Portals portal: portals) {
            if (portal.getPosition().equals(position)) return false;
        }
        return true;
    }

    public void movePlayer(Position position) {
        if (canPlayerMove(position))
            player.setPosition(position);
        for (Portals portal : portals) {
            if (portal.getPosition().equals(position)) {
                for (int i = 1; i <= portals.size()-1; i++)
                    player.setPosition(portals.get(i).getPosition());
                break;
            }

        }
    }

    public void moveMonsters() {
        for (Monster monster : monsters){
            Position position = monster.move();
            if (canMonsterMove(position)) monster.setPosition(position);
        }
    }

    public void moveBombs() {
        for (Bomb bombdead : bombs){
            Position position = bombdead.move();
            if (canBombMove(position)) bombdead.setPosition(position);
        }
    }
    public void verifyMonsterCollisions() {
        for (Monster monster : monsters){
            if(monster.getPosition().equals(player.getPosition())){
                lives--;
                System.out.println("Lives = " + lives);
                if(lives<= 0) dead = true;
            }
        }
    }

    public int getLives() {
        verifyMonsterCollisions();
        return lives;
    }

    public void verifyBombCollisions() {
        for (Bomb bombdead : bombs){
            if(bombdead.getPosition().equals(player.getPosition())){
                dead=true;
            }
        }
    }

    public boolean getDead(){
        return dead;
    }

    private void LostGame(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FE5959"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width * 2, height * 2 + 3), ' ');
        graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
        graphics.putString(new TerminalPosition(19, 14), "YOU LOST ;(");
    }

    public void verifyWin(){
        for (Material material: materials) {
            if (materials.size() == 0)
                System.out.println("you won! :D");
                List<String> maps = new ArrayList<>(Arrays.asList("files/level2.txt"));//n sei se funciona
                boolean verified = true;
        }
    }

    public boolean getVerified() {
        verifyWin();
        return verified;
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000")); //cor do background
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height ), ' ');

        for (Material material : materials)
            material.draw(graphics);

        player.draw(graphics);

        for (walls wall : Walls)
            wall.draw(graphics);

        for (Monster monster : monsters)
            monster.draw(graphics);

        for (Portals portal: portals)
            portal.draw(graphics);

        for (Bomb bombdead: bombs)
            bombdead.draw(graphics);

        if (dead==true) LostGame(graphics);
    }

    public void setPlayer(Player p) {
        this.player = p;
    }

    public Player getPlayer() {
        return player;
    }
}