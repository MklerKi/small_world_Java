package myProject.Organisms.Animals;

import myProject.Organisms.Organizm;
import myProject.Organisms.Zwierze;

import java.awt.*;

public class CyberOwca extends Zwierze {
    private boolean isTrajektoria = false;
    private boolean isZwyklaOwca = false;
    private Organizm bs;
    public CyberOwca(int x, int y) {
        super(x, y);
        sila = 11;
        inicjatywa = 4;
        color = Color.BLUE;
    }

    @Override
    public void akcja() {
        if (isTrajektoria) {
            swiat.setMessege(getTyp() + "(" + x + ", " + y + ") wyruszył na ");
            int i = 0;
            if(x != bs.getX()) {
                x += (bs.getX() - x) / Math.abs(bs.getX() - x);
            }
            else if(y != bs.getY()) {
                y += (bs.getY() - y) / Math.abs(bs.getY() - y);
            }
            else {
                isTrajektoria = false;
            }
            swiat.setMessege("(" + x + ", " + y + ")\n");
        }
        else if (isZwyklaOwca) {
            super.akcja();
        }
        else {
            int trajektoria, i;
            Organizm org = swiat.znajdzOrganizm(0, "BarszczSosnowskiego");
            i = swiat.getNumerOrganizmu(org);
            if (org != null) {
                trajektoria = (int) Math.sqrt(org.getX() * org.getX() + org.getY() * org.getY());
                while(true) {
                    Organizm org2 = swiat.znajdzOrganizm(i + 1, "BarszczSosnowskiego");
                    if (org2 == null)
                        break;
                    else {
                        i = swiat.getNumerOrganizmu(org2);
                        int trajektoria2 = (int) Math.sqrt(org2.getX() * org2.getX() + org2.getY() * org2.getY());
                        if(trajektoria2 < trajektoria) {
                            trajektoria = trajektoria2;
                            org = org2;
                        }
                    }
                }
                bs = org;
                isTrajektoria = true;
            }
            else {
                isZwyklaOwca = true;
            }
        }
    }

    @Override
    public void kolizja(Organizm org, int pop_x, int pop_y) {
        if(x == org.getX() && y == org.getY() && org.getTyp() == "BarszczSosnowskiego") {
            isTrajektoria = false;
        }
        super.kolizja(org, pop_x, pop_y);
    }

    public void setV(boolean isT, boolean isZw, Organizm o){
        isTrajektoria = isT;
        isZwyklaOwca = isZw;
        bs = o;
    }

    @Override
    public String getTyp() {
        return "CyberOwca";
    }
}
