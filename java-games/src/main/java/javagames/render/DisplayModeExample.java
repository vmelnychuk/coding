package javagames.render;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Container;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.Objects;

public class DisplayModeExample extends JFrame {

    class DisplayModeWrapper {

        private DisplayMode displayMode;

        public DisplayModeWrapper(DisplayMode displayMode) {
            this.displayMode = displayMode;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DisplayModeWrapper that = (DisplayModeWrapper) o;
            if (displayMode.getWidth() != that.displayMode.getWidth())
                return false;
            return displayMode.getHeight() == that.displayMode.getHeight();
        }

        @Override
        public int hashCode() {
            return Objects.hash(displayMode);
        }

        public String toString() {
            return "" + displayMode.getWidth() + " x " + displayMode.getHeight();
        }
    }

    private JComboBox<DisplayModeWrapper> displayModes;
    private transient GraphicsDevice graphicsDevice;
    private transient DisplayMode currentDisplayMode;

    public DisplayModeExample() {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();
        currentDisplayMode = graphicsDevice.getDisplayMode();
    }

    private JPanel getMainPanel() {
        JPanel panel = new JPanel();
        displayModes = new JComboBox<>(listDisplayModes());
        panel.add(displayModes);
        JButton enterButton = new JButton("Enter Full Screen");
        enterButton.addActionListener(e -> onEnterFullScreen());
        panel.add(enterButton);
        JButton exitButton = new JButton("Exit Full Screen");
        exitButton.addActionListener(e -> onExitFullScreen());
        panel.add(exitButton);
        return panel;
    }

    private DisplayModeWrapper[] listDisplayModes() {
        ArrayList<DisplayModeWrapper> list = new ArrayList<>();
        for (DisplayMode mode : graphicsDevice.getDisplayModes()) {
            if (mode.getBitDepth() == 32) {
                DisplayModeWrapper wrap = new DisplayModeWrapper(mode);
                if (!list.contains(wrap)) {
                    list.add(wrap);
                }
            }
        }
        return list.toArray(new DisplayModeWrapper[0]);
    }

    protected void createAndShowGui() {
        Container canvas = getContentPane();
        canvas.add(getMainPanel());
        canvas.setIgnoreRepaint(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Display Mode Test");
        pack();
        setVisible(true);
    }

    protected void onEnterFullScreen() {
        if (graphicsDevice.isFullScreenSupported()) {
            DisplayMode newMode = getSelectedMode();
            graphicsDevice.setFullScreenWindow(this);
            graphicsDevice.setDisplayMode(newMode);
        }
    }

    protected void onExitFullScreen() {
        graphicsDevice.setDisplayMode(currentDisplayMode);
        graphicsDevice.setFullScreenWindow(null);
    }

    protected DisplayMode getSelectedMode() {
        DisplayModeWrapper wrapper =
            (DisplayModeWrapper) displayModes.getSelectedItem();
        DisplayMode displayMode = wrapper.displayMode;
        int width = displayMode.getWidth();
        int height = displayMode.getHeight();
        int bit = displayMode.getBitDepth();
        int refresh = DisplayMode.REFRESH_RATE_UNKNOWN;
        return new DisplayMode(width, height, bit, refresh);
    }

    public static void main(String[] args) {
        final DisplayModeExample app = new DisplayModeExample();
        SwingUtilities.invokeLater(app::createAndShowGui);
    }
}
