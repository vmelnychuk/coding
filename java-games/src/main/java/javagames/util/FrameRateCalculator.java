package javagames.util;

public class FrameRateCalculator {

    private static final String FPS_FORMAT = "FPS %s";
    private String frameRate;
    private long lastTime;
    private long delta;
    private int frameCount;

    public void initialize() {
        this.lastTime = System.currentTimeMillis();
        this.frameRate = String.format(FPS_FORMAT, 0);
    }

    public void calculate() {
        long current = System.currentTimeMillis();
        this.delta += current - this.lastTime;
        this.lastTime = current;
        this.frameCount++;
        if (delta > 1000) {
            delta -= 1000;
            this.frameRate = String.format(FPS_FORMAT, frameCount);
            frameCount = 0;
        }
    }

    public String getFrameRate() {
        return this.frameRate;
    }
}
