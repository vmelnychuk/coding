package javagames.render;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RenderThreadExample extends JFrame implements Runnable {

    public static final int WIDTH = 320;
    public static final int HEIGHT = 240;
    public static final long SLEEP_TIME = 10;
    private volatile boolean running;
    private transient Thread gameThread;

    public RenderThreadExample() {
    }

    private  void createAndShowGui() {
        setSize(WIDTH, HEIGHT);
        setTitle("Render Thread");
        setVisible(true);
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    @Override
    public void run() {
        this.running = true;
        while (this.running) {
            System.out.println("Game Loop");
            sleep(SLEEP_TIME);
        }
    }

    private void sleep(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
        }
    }

    private void onWindowClosing() {
        try {
            System.out.println("Stopping Thread...");
            this.running = false;
            this.gameThread.join();
            System.out.println("Stopped.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        final RenderThreadExample app = new RenderThreadExample();
        app.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                app.onWindowClosing();
            }
        });
        SwingUtilities.invokeLater(app::createAndShowGui);
    }
}
