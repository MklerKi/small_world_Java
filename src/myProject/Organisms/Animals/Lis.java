package myProject.Organisms.Animals;

import myProject.Organisms.Organizm;
import myProject.Organisms.Zwierze;

import java.awt.*;

public class Lis extends Zwierze {
    public Lis(int x, int y) {
        super(x, y);
        sila = 3;
        inicjatywa = 7;
        color = Color.RED;
    }

    @Override
    public void akcja(){
        int n = 0, k = x, l = y;
        while(true){
            super.akcja();
            Organizm org = swiat.czyJestKtos(this, x, y);
            if(org != null){
                if(sila >= org.getSila())
                    break;
                else{
                    x = k; y = l;
                }
            }
            else
                break;
            if(n == 10)
                break;
            n++;
        }
    }

    @Override
    public void powielanie(){
        Lis zw;
        if(x + 1 == def.size)
            zw = new Lis(1, y);
        else
            zw = new Lis(x + 1, y);
        zw.setSwiat(swiat);
        swiat.setOrganizm(zw);
        zw.setMove(true);
        swiat.setMessege("Został stworzony nowy Lis na x: " + x + ", y: " + y + "\n");
    }

    @Override
    public String getTyp(){
        return "Lis";
    }


}
