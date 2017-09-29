/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tenprint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author waterbucket
 */
public class TenPrint {

    private JFrame frame;
    private PrintWindow print;

    public TenPrint() {
        this.frame = new JFrame();
        this.frame.setTitle("TenPrint");
        this.print = new PrintWindow();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.add(print);
        this.frame.pack();
        this.frame.setVisible(true);
    }

    public static void main(String[] args) {
        TenPrint tp = new TenPrint();
    }

    private class PrintWindow extends JPanel {

        private int x;
        private int y;
        private float hue;
        private final int SCALE_FACTOR = 10;
        private final float saturation = 1f;
        private final float brightness = 1f;

        public PrintWindow() {
            this.setBackground(Color.BLACK);
            this.setVisible(true);
            this.x = 0;
            this.y = 0;
            this.hue = 0f;
        }

        @Override
        protected void paintComponent(Graphics grphcs) {
            super.paintComponent(grphcs);
            Graphics2D g2d = (Graphics2D) grphcs;
            g2d.setColor(Color.getHSBColor(0, this.saturation, this.brightness));
            while (y < this.getHeight()) {
                if (Math.random() > 0.5) {
                    g2d.drawLine(this.x, this.y, this.x + this.SCALE_FACTOR, this.y + this.SCALE_FACTOR);
                } else {
                    g2d.drawLine(this.x, this.y + this.SCALE_FACTOR, this.x +this.SCALE_FACTOR, this.y);
                }
                this.x = this.x + this.SCALE_FACTOR;
                if (this.x > this.getWidth()) {
                    this.x = 0;
                    this.y = this.y + this.SCALE_FACTOR;
                    this.hue = this.hue + 0.025f;
                    g2d.setColor(Color.getHSBColor(this.hue, this.saturation, this.brightness));
                }
            }
        }
    }
}
