package programming.school.adventure.ui;

import java.net.URL;

import programming.school.adventure.IAdventureGame;
import programming.school.adventure.IOutput;
import programming.school.adventure.Player;

/**
 * The purpose of this class is to provide unit testing interface to the
 * Adventure engine.
 * 
 * @author timotej
 *
 */
public class GameTest implements IOutput {

    private IAdventureGame game;
    private Player player;
    private String output;
    private URL lastSound;
    private URL lastImage;

    public GameTest(IAdventureGame game) {
        this.game = game;
    }

    @Override
    public void image(URL resource) {
        this.lastImage = resource;
    }

    @Override
    public void println() {
    }

    @Override
    public void setWindowTitle(String title) {
    }

    @Override
    public void println(String message) {
        this.output = message;
    }

    @Override
    public void sound(URL resource) {
        this.lastSound = resource;
    }

    @Override
    public boolean supportsImages() {
        return true;
    }

    @Override
    public boolean supportsSound() {
        return true;
    }

    public void start() {
        player = new Player(this, game);
        player.intro();
        player.describeCurrentPlace();
    }

    public void command(String text) {
        player.newCommand(text);
        player.describeCurrentPlace();
    }

    public Player player() {
        return player;
    }

    public String lastOutput() {
        return output;
    }

    public URL lastImage() {
        return lastImage;
    }

    public URL lastSound() {
        return lastSound;
    }
}
