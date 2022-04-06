package myProject.Organisms.Plants;

import myProject.Organisms.Organizm;
import myProject.Organisms.Roslina;

import java.awt.*;

public class Trawa extends Roslina {
    public Trawa(int x, int y) {
        super(x, y);
        sila = 0;
        inicjatywa = 0;
        color = Color.GREEN;
    }

    @Override
    public void powielanie(){
        Trawa rl = new Trawa(x, y);
        int q  = 0;
        while (true) {
            rl.akcja();
            Organizm org = swiat.czyJestKtos(this, x, y);
            if(org == null)
                break;
            q++;
            if (q == 10)
                break;
        }
        rl.setSwiat(swiat);
        swiat.setOrganizm(rl);
        rl.setMove(true);
        swiat.setMessege("Została stworzona nowa Trawa na x: " + x + ", y: " + y + "\n");
    }

    @Override
    public String getTyp(){
        return "Trawa";
    }
}
