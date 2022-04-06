package myProject.Organisms.Plants;

import myProject.Organisms.Organizm;
import myProject.Organisms.Roslina;

import java.awt.*;

public class WilczeJagody extends Roslina {
    public WilczeJagody(int x, int y) {
        super(x, y);
        sila = 99;
        inicjatywa = 0;
        color = new Color(10, 41, 0);
    }

    @Override
    public void powielanie(){
        WilczeJagody rl = new WilczeJagody(x, y);
        int q  = 0;
        while (true) {
            rl.akcja();
            Organizm org = swiat.czyJestKtos(this, x, y);
            if(org == null)
                break;
            q++;
            if (q == 20)
                break;
        }
        rl.setSwiat(swiat);
        swiat.setOrganizm(rl);
        rl.setMove(true);
        swiat.setMessege("Zostały stworzone nowe Wilcze Jagode na x: " + x + ", y: " + y + "\n");
    }

    @Override
    public void setDel(boolean del, Organizm org){
        org.setDel(del);
        isDel = false;
    }

    @Override
    public String getTyp(){
        return "WilczeJagody";
    }
}
