package myProject.Organisms.Animals;

import myProject.Organisms.Zwierze;

import java.awt.*;
import java.util.Random;

public class Zolw extends Zwierze {
    public Zolw(int x, int y) {
        super(x, y);
        sila = 2;
        inicjatywa = 1;
        color = Color.CYAN;
    }

    @Override
    public void akcja(){
        int max = 100;
        Random rand = new Random();
        int number = rand.nextInt(max) + 1;
        if (number <= max * 0.75)
            ;
        else {
            super.akcja();
        }
    }

    @Override
    public void powielanie(){
        Zolw zw;
        if(x + 1 == def.size)
            zw = new Zolw(1, y);
        else
            zw = new Zolw(x + 1, y);
        zw.setSwiat(swiat);
        swiat.setOrganizm(zw);
        zw.setMove(true);
        swiat.setMessege("Został stworzony nowy Żółw na x: " + x + ", y: " + y + "\n");
    }

    @Override
    public boolean czyOdbilAtak(int s){
        if (s < 5)
            return true;
        else
            return false;
    }

    @Override
    public String getTyp(){
        return "Zolw";
    }
}
