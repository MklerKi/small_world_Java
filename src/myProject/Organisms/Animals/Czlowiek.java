package myProject.Organisms.Animals;

import myProject.Organisms.Zwierze;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Czlowiek extends Zwierze {
    boolean isUmiejetnosc = false;
    int i = 0;
    public Czlowiek(int x, int y) {
        super(x, y);
        sila = 5;
        inicjatywa = 4;
        color = Color.MAGENTA;
    }

    @Override
    public void akcja(){
        if (isUmiejetnosc == true && i < 1) {
            isUmiejetnosc = false;
            i = 5;
        }
        if (isUmiejetnosc == false && i < 1) {
            swiat.setMessege("Czy chcesz włączyć umiejętność Człowieka?\n");
        }
        else {
            if (isUmiejetnosc == true)
                swiat.setMessege("Umiejętność Człowieka jest włączona\n");
            else
                swiat.setMessege("Umiejętność Człowieka jest wyłączona i nie może być włączona\n");
            i--;
        }
    }

    public void left() {
        if (x == 0)
            x = def.size - 1;
        else
            x--;
    }

    public void up() {
        if (y == 0)
            y = def.size - 1;
        else
            y--;
    }
     public void right() {
         if (x == def.size - 1)
             x = 0;
         else
             x++;
     }

     public void down() {
         if (y == def.size - 1)
             y = 0;
         else
             y++;
     }

    public void wlaczenieUmiejetnosci() {
        isUmiejetnosc = true;
        i = 5;
    }

    public boolean czyJestWlaczonaUmiejetnosc() {
        if (isUmiejetnosc == false && i < 1)
            return true;
        else
            return false;
    }

    public void setUmiejetnosc(boolean b, int in) {
        isUmiejetnosc = b;
        i = in;
    }

    @Override
    public boolean czyOdbilAtak(int s) {
        if (isUmiejetnosc)
            return true;
        else
            return false;
    }

    @Override
    public String getTyp(){
        return "Czlowiek";
    }
}
