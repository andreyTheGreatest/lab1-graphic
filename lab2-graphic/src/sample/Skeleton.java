package sample;
import javafx.geometry.Rectangle2DBuilder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

@SuppressWarnings("serial")
public class Skeleton extends JPanel implements ActionListener {
    Timer timer;

    private float scale = 1;
    private float delta = 0.01f;

    private double dx = 1;
    private double tx = 1;
    private double ty = 116;
    private double dy = 1;
    private static int maxWidth;
    private static int maxHeight;

    private static final int imageHeight = 350;
    private static final int imageWidth = 350;

    public Skeleton() {
        timer = new Timer(10, this);
        timer.start();
    }


    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        g2d.setBackground(Color.red);
        g2d.clearRect(0, 0, maxWidth + 1, maxHeight + 1);
        paintImage(g);

        BasicStroke bs1 = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2d.setStroke(bs1);
        g2d.drawRect(maxWidth/2, 0,maxWidth / 2 - 1, maxHeight - 1);
        g2d.setStroke(new BasicStroke());
        g2d.translate(maxWidth * 5/ 8, maxHeight/ 4);

        g2d.translate(tx, ty);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, scale));
        paintImage(g);
        g2d.dispose();
    }

    public void paintImage(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int r1x = 60, r1y = 50, r1w = 70, r1h = 80;
        g2d.setColor(Color.GREEN);
        Rectangle r1 = drawRect(g, r1x, r1y, r1w, r1h, -10.9);

        Rectangle r2 = drawRect(g, r1x + r1w - 30, r1y + r1h + 5, 75, 60, 45.9);
        GradientPaint gp = new GradientPaint(5, 25,
                new Color(255,255,0), 20, 2, new Color(255,0,255), true);
        g2d.setPaint(gp);
        Rectangle r3 = drawRect(g, r1x + r1w + 10, r1y + 10, 75, 70, 10.9);
        BasicStroke bs = new BasicStroke(5, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs);
        g2d.setColor(Color.blue);
        drawCenteredTriangle(g, r1.getX() + r1.getWidth() / 2, r1.getY() + r1.getHeight() / 2, r2.getX() + r2.getWidth() / 2, r2.getY() + r2.getHeight() / 2, r3.getX() + r3.getWidth() / 2, r3.getY() + r3.getHeight() / 2);

    }

    public Rectangle drawRect(Graphics g, int rx, int ry, int rw, int rh, double angle) {
        Graphics2D g2d;
        // rotated 45 degrees about center of rect
        g2d = (Graphics2D)g.create();
        g2d.rotate(Math.toRadians(angle), rx + rw / 2, ry + rh / 2);

        Rectangle r = new Rectangle(rx, ry, rw, rh);
        g2d.fill(r);
        return r;
    }

    public void drawCenteredTriangle(Graphics g, double p1x, double p1y, double p2x, double p2y, double p3x, double p3y) {
        double points[][] = {
                { p1x, p1y },
                { p2x, p2y },
                { p3x, p3y }
        };
        Graphics2D g2d;
        g2d = (Graphics2D)g.create();

        GeneralPath triangle = new GeneralPath();
        triangle.moveTo(points[0][0], points[0][1]);
        for (int k = 1; k < points.length; k++)
            triangle.lineTo(points[k][0], points[k][1]);
        triangle.closePath();
        g2d.draw(triangle);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Привіт, Java 2D!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(new Skeleton());
        frame.setVisible(true);

        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();
        maxWidth = size.width - insets.left - insets.right - 1;
        maxHeight = size.height - insets.top - insets.bottom - 1;

        System.out.println((-maxHeight + imageHeight) + " " + (maxHeight/4));

    }

    @Override
    @SuppressWarnings("all")
    public void actionPerformed(ActionEvent e) {
        if (scale < 0.01f || scale > 0.99f) {
            delta = -delta;
        }

        if (tx >= -maxWidth/7 && tx < maxWidth/7 && ty == maxHeight/4) {
            tx += dx;
        }
        else if (ty > -maxHeight/4 && ty <= maxHeight/4 && tx == maxWidth/7) {
            ty -= dy;
        }
        else if (tx > -maxWidth/7 && tx <= maxWidth/7 && ty == -maxHeight/4) {
            tx -= dx;
        }
        else if (ty >= -maxHeight/4 && ty < maxHeight/4 && tx == -maxWidth/7) {
            ty += dy;
        }

        scale += delta;
        repaint();
    }
}