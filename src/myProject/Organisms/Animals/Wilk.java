package myProject.Organisms.Animals;
import myProject.Define;
import myProject.Organisms.*;

import java.awt.*;

public class Wilk extends Zwierze {
    public Wilk(int x, int y) {
        super(x, y);
        sila = 9;
        inicjatywa = 5;
        color = Color.GRAY;
    }

    @Override
    public void powielanie(){
        Wilk zw;
        if(x + 1 == def.size)
            zw = new Wilk(1, y);
        else
            zw = new Wilk(x + 1, y);
        zw.setSwiat(swiat);
        swiat.setOrganizm(zw);
        zw.setMove(true);
        swiat.setMessege("Został stworzony nowy Wilk na x: " + x + ", y: " + y + "\n");
    }

    @Override
    public String getTyp(){
        return "Wilk";
    }
}
