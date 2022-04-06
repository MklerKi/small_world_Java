package myProject.Organisms;

import myProject.Define;

import java.awt.*;
import java.util.Random;

public abstract class Roslina extends Organizm {
    public Roslina(int x, int y) {
        super(x, y);
    }

    @Override
    public void akcja() {
        Random rand = new Random();
        if (isMove == false) {
            int k = 0;
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
        }
        else {
            int max = 100;
            int number = rand.nextInt(max) + 1;
            if (number <= max * 0.05) {
                powielanie();
            }
        }
    }

    @Override
    public void kolizja(Organizm org, int x, int y) {

    }


    public abstract void powielanie();

    @Override
    public String getRodzic() {
        return "Roslina";
    }

    @Override
    public String getTyp() {
        return null;
    }

    @Override
    public void setDel(boolean del) {
        isDel = del;
    }

    @Override
    public void setDel(boolean del, Organizm org) {
        isDel = del;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
