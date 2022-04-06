package myProject.Organisms;
import myProject.Define;
import myProject.Swiat;
import myProject.Swiat;

import javax.swing.*;
import java.awt.*;

public abstract class Organizm extends JPanel implements java.io.Serializable {
    protected int x, y, k;
    protected int sila;
    protected int inicjatywa;
    protected int rok = 0;
    protected int pow = 0;
    protected Color color;
    protected Boolean isMove = false, isDel = false;
    protected Swiat swiat;
    protected Define def = new Define();
    Organizm(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public abstract void akcja();
    public abstract void kolizja(Organizm org, int x, int y);
    public abstract void powielanie();
    //get-ery
    public boolean czyOdbilAtak(int s) { return false; }
    public abstract String getRodzic();
    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public Color getColor() { return this.color; }
    public boolean getMove() { return this.isMove; }
    public int getSila() {	return sila; }
    public int getInicjatywa() { return inicjatywa; }
    public Swiat getSwiat() {	return swiat; }
    public int getRok() { return rok; }
    public boolean getDel() { return this.isDel; }
    public abstract String getTyp();
    //set-ery
    public void setX(int x) { this.x = x;	}
    public void setY(int y) { this.y = y;	}
    public void setSwiat(Swiat sw) { this.swiat = sw; }
    public void setMove(Boolean mv) {	this.isMove = mv; }
    public void setRok(int r) { this.rok = r; }
    public void setSila(int s) { this.sila = s; }

    public abstract void setDel(boolean del);
    public abstract void setDel(boolean del, Organizm org);

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.fillRect(10 + x * def.size, 30 + y * def.size, def.size, def.size);
    }
}
