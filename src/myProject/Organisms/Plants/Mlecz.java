package myProject.Organisms.Plants;

import myProject.Organisms.Organizm;
import myProject.Organisms.Roslina;

import java.awt.*;

public class Mlecz extends Roslina {
    public Mlecz(int x, int y) {
        super(x, y);
        sila = 0;
        inicjatywa = 0;
        color = Color.YELLOW;
    }

    @Override
    public void akcja(){
        if(!isMove)
            super.akcja();
        else {
            for (int i = 0; i < 3; i++)
                super.akcja();
        }
    }

    @Override
    public void powielanie(){
        if(rok < 10) {
            Mlecz rl = new Mlecz(x, y);
            int q = 0;
            while (true) {
                rl.akcja();
                Organizm org = swiat.czyJestKtos(this, x, y);
                if (org == null)
                    break;
                q++;
                if (q == 10)
                    break;
            }
            rl.setSwiat(swiat);
            swiat.setOrganizm(rl);
            rl.setMove(true);
            swiat.setMessege("Została stworzona nowa Mlecz na x: " + x + ", y: " + y + "\n");
        }
    }

    @Override
    public String getTyp(){
        return "Mlecz";
    }
}
