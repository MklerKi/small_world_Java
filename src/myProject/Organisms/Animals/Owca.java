package myProject.Organisms.Animals;

import myProject.Organisms.Zwierze;

import java.awt.*;

public class Owca extends Zwierze {
    public Owca(int x, int y) {
        super(x, y);
        sila = 4;
        inicjatywa = 4;
        color = Color.WHITE;
    }

    @Override
    public void powielanie(){
        Owca zw;
        if(x + 1 == def.size)
            zw = new Owca(1, y);
        else
            zw = new Owca(x + 1, y);
        zw.setSwiat(swiat);
        swiat.setOrganizm(zw);
        zw.setMove(true);
        swiat.setMessege("Została stworzona nowa Owca na x: " + x + ", y: " + y + "\n");
    }

    @Override
    public String getTyp(){
        return "Owca";
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
