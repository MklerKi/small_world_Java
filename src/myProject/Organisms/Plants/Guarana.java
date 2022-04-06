package myProject.Organisms.Plants;

import myProject.Organisms.Organizm;
import myProject.Organisms.Roslina;

import java.awt.*;

public class Guarana extends Roslina {
    public Guarana(int x, int y) {
        super(x, y);
        sila = 0;
        inicjatywa = 0;
        color = new Color(158, 144, 63);
    }

    @Override
    public void powielanie(){
        Guarana rl = new Guarana(x, y);
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
        swiat.setMessege("Została stworzona nowa Guarana na x: " + x + ", y: " + y + "\n");
    }

    @Override
    public void setDel(boolean del, Organizm org){
        isDel = del;
        org.setSila(org.getSila() + 3);
        swiat.setMessege(org.getTyp() + "(" + x + ", " + y + ") powiększył swoją silę, sila: " + org.getSila() + "\n");
    }

    @Override
    public String getTyp(){
        return "Guarana";
    }
}
