package myProject.Organisms.Animals;

import myProject.Organisms.Zwierze;

import java.awt.*;
import java.util.Random;

public class Antylopa extends Zwierze {
    public Antylopa(int x, int y) {
        super(x, y);
        sila = 4;
        inicjatywa = 4;
        color = new Color(236, 113, 8);
    }

    @Override
    public void akcja(){
        swiat.setMessege(getTyp() + "(" + x + ", " + y + ") wyruszyła na ");
        int k = 0;
        Random rand = new Random();
        k = rand.nextInt(4);
        if (k == 0) {
            if (x == 0)
                x = def.size - 2;
            else if (x == 1)
                x = def.size - 1;
            else
                x -= 2;
        }
        else if (k == 1) {
            if (y == 0)
                y = def.size - 2;
            else if (y == 1)
                y = def.size - 1;
            else
                y -= 2;
        }
        else if (k == 2) {
            if (x == def.size - 2)
                x = 0;
            else if (x == def.size - 1)
                x = 1;
            else
                x += 2;
        }
        else if (k == 3) {
            if (y == def.size - 2)
                y = 0;
            else if (y == def.size - 1)
                y = 1;
            else
                y += 2;
        }
        swiat.setMessege("(" + x + ", " + y + ")\n");
    }

    @Override
    public void powielanie(){
        Antylopa zw;
        if(x + 1 == def.size)
            zw = new Antylopa(1, y);
        else
            zw = new Antylopa(x + 1, y);
        zw.setSwiat(swiat);
        swiat.setOrganizm(zw);
        zw.setMove(true);
        swiat.setMessege("Została stworzona nowa Antylopa na x: " + x + ", y: " + y + "\n");
    }

    @Override
    public void setDel(boolean del){
        Random rand = new Random();
        int k = 1 + rand.nextInt(100);
        if (k <= 50)
            isDel = del;
        else {
            isDel = false;
            akcja();
            swiat.setMessege("Antylopa uciekła na (" + x + ", " + y + ")\n");
            isMove = true;
        }
    }

    @Override
    public String getTyp(){
        return "Antylopa";
    }
}
