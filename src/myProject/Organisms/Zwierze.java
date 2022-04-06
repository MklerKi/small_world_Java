package myProject.Organisms;

import myProject.Define;
import myProject.Organisms.Organizm;

import java.awt.*;
import java.util.Random;

public abstract class Zwierze extends Organizm {
    protected Define def = new Define();
    public Zwierze(int x, int y) {
        super(x, y);
    }

    @Override
    public void akcja() {
        swiat.setMessege(getTyp() + "(" + x + ", " + y + ") wyruszył na ");
        int k = 0;
        Random rand = new Random();
        k = rand.nextInt(4);
        if (k == 0) {
            if (x == 0)
                x = def.size - 1;
            else
                x--;
        }
        else if (k == 1) {
            if (y == 0)
                y = def.size - 1;
            else
                y--;
        }
        else if (k == 2) {
            if (x == def.size - 1)
                x = 0;
            else
                x++;
        }
        else if (k == 3) {
            if (y == def.size - 1)
                y = 0;
            else
                y++;
        }
        swiat.setMessege("(" + x + ", " + y + ")\n");
    }

    @Override
    public void kolizja(Organizm org, int pop_x, int pop_y) {
        if(x == org.getX() && y == org.getY()){
            if(this.getTyp() == org.getTyp()){
                x = pop_x; y = pop_y;
                if(rok > 10)
                    ;
                else if(pop_x < org.getX())
                    org.powielanie();
                else
                    this.powielanie();
                org.setMove(true);
                pow++;
            }
            else if(!org.czyOdbilAtak(sila)){
                if(sila < org.getSila()){
                    this.setDel(true);
                    org.setMove(true);
                    swiat.setMessege(getTyp() + "(" + x + ", " + y + ")" + " został zabity przez " + org.getTyp() + "(" + x + ", " + y + ")\n");
                }
                else{
                    org.setDel(true);
                    org.setDel(true, this);
                    org.setMove(true);
                    swiat.setMessege(org.getTyp() + "(" + x + ", " + y + ")" + " został zabity przez " + getTyp() + "(" + x + ", " + y + ")\n");
                }
            }
            else{
                swiat.setMessege(getTyp() + "(" + pop_x + ", " + pop_y + ")" + " został odstraszony przez " + org.getTyp() + "(" + org.getX() + ", " + org.getY() + ")\n");
                akcja();
            }
        }
    }

    @Override
    public void powielanie() {

    }

    @Override
    public String getRodzic() {
        return "Zwierze";
    }

    @Override
    public void setDel(boolean del) {	this.isDel = del; }

    @Override
    public void setDel(boolean del, Organizm org) { this.isDel = del; }

    @Override
    public String getTyp() {
        return null;
    }


}
