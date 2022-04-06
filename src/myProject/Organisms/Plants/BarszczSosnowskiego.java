package myProject.Organisms.Plants;

import myProject.Organisms.Organizm;
import myProject.Organisms.Roslina;

import java.awt.*;

public class BarszczSosnowskiego extends Roslina {
    public BarszczSosnowskiego(int x, int y) {
        super(x, y);
        sila = 0;
        inicjatywa = 0;
        color = new Color(25, 94, 31);
    }

    public void sprawdz(Organizm org){
        if (org != null && org.getTyp() != "CyberOwca") {
            if (org.getRodzic() == "Zwierze") {
                swiat.setMessege(org.getTyp() + "(" + org.getX() + ", " + org.getY() + ")" + " został zabity przez " + getTyp() + "(" + x + ", " + y + ")\n");
                org.setDel(true);
            }
        }
        else
            ;
    }

    @Override
    public void akcja() {
        super.akcja();
        if (x == 0) {
            Organizm org = swiat.czyJestKtos(this, def.size - 1, y);
            sprawdz(org);
        }
        else {
            Organizm org = swiat.czyJestKtos(this, x - 1, y);
            sprawdz(org);
        }

        if (x == def.size - 1) {
            Organizm org = swiat.czyJestKtos(this, 0, y);
            sprawdz(org);
        }
        else {
            Organizm org = swiat.czyJestKtos(this, x + 1, y);
            sprawdz(org);
        }

        if (y == 0) {
            Organizm org = swiat.czyJestKtos(this, x, def.size - 1);
            sprawdz(org);
        }
        else {
            Organizm org = swiat.czyJestKtos(this, x, y - 1);
            sprawdz(org);
        }

        if (y == def.size - 1) {
            Organizm org = swiat.czyJestKtos(this, x, 0);
            sprawdz(org);
        }
        else {
            Organizm org = swiat.czyJestKtos(this, x, y + 1);
            sprawdz(org);
        }
    }

    @Override
    public void powielanie() {
        BarszczSosnowskiego rl = new BarszczSosnowskiego(x, y);
        int q  = 0;
        rl.setSwiat(swiat);
        while (true) {
            rl.akcja();
            Organizm org = swiat.czyJestKtos(this, x, y);
            if(org == null)
                break;
            q++;
            if (q == 20)
                break;
        }
        swiat.setOrganizm(rl);
        rl.setMove(true);
        swiat.setMessege("Został stworzony nowy Barszcz Sosnowskiego na x: " + x + ", y: " + y + "\n");
    }

    @Override
    public String getTyp() {
        return "BarszczSosnowskiego";
    }
}
