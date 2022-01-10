package javagames.render;

import javagames.util.FrameRateCalculator;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;


public class FullScreenRenderingExample extends JFrame implements Runnable {

    private transient FrameRateCalculator frameRate;
    private transient BufferStrategy bufferStrategy;
    private volatile boolean running;
    private transient Thread gameThread;
    private transient GraphicsDevice graphicsDevice;
    private transient DisplayMode currentDisplayMode;

    public FullScreenRenderingExample() {
        this.frameRate = new FrameRateCalculator();
    }

    protected void createAndShowGUI() {

        setIgnoreRepaint(true);
        setUndecorated(true);
        setBackground(Color.BLACK);

        GraphicsEnvironment graphicsEnvironment =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();
        this.currentDisplayMode = this.graphicsDevice.getDisplayMode();
        if (!this.graphicsDevice.isFullScreenSupported()) {
            System.err.println("ERROR: Not Supported!!!");
            System.exit(0);
        }

        this.graphicsDevice.setFullScreenWindow(this);
        this.graphicsDevice.setDisplayMode(getDisplayMode());

        createBufferStrategy(2);
        this.bufferStrategy = getBufferStrategy();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    shutDown();
                }
            }
        });

        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    private DisplayMode getDisplayMode() {
        // Make sure to use a display mode for your system.
        // The DisplayMode.REFRESH_RATE_UNKNOWN and
        // DisplayMode.BIT_DEPTH_MULTI flags may be required.
        return new DisplayMode(
            800, 600, 32, DisplayMode.REFRESH_RATE_UNKNOWN);
    }

    public void run() {
        this.running = true;
        this.frameRate.initialize();
        while (this.running) {
            gameLoop();
        }
    }

    public void gameLoop() {
        do {
            do {
                Graphics graphics = null;
                try {
                    graphics = this.bufferStrategy.getDrawGraphics();
                    graphics.clearRect(0, 0, getWidth(), getHeight());
                    render(graphics);
                } finally {
                    if (graphics != null) {
                        graphics.dispose();
                    }
                }
            } while (this.bufferStrategy.contentsRestored());
            this.bufferStrategy.show();
        } while (this.bufferStrategy.contentsLost());
    }

    private void render(Graphics graphics) {
        this.frameRate.calculate();
        graphics.setColor(Color.GREEN);
        graphics.drawString(this.frameRate.getFrameRate(), 30, 30);
        graphics.drawString("Press ESC to exit...", 30, 60);
    }

    protected void shutDown() {
        try {
            this.running = false;
            this.gameThread.join();
            System.out.println("Game loop stopped!!!");
            this.graphicsDevice.setDisplayMode(this.currentDisplayMode);
            this.graphicsDevice.setFullScreenWindow(null);
            System.out.println("Display Restored...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        final FullScreenRenderingExample app = new FullScreenRenderingExample();
        SwingUtilities.invokeLater(app::createAndShowGUI);
    }

}
