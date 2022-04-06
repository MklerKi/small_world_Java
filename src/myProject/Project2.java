package myProject;

import myProject.Organisms.*;
import myProject.Organisms.Animals.*;
import myProject.Organisms.Plants.*;
import myProject.Organisms.Animals.Czlowiek;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Project2 {

    public static List<Organizm> odczytanieZPliku(List<Organizm> organizmy){
        try {
            FileInputStream fileIn = new FileInputStream("objects.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            organizmy = (List<Organizm>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return organizmy;
        } catch (ClassNotFoundException c) {
            System.out.println("Organizms class not found");
            c.printStackTrace();
            return organizmy;
        }
        return organizmy;
    }

    public static void main(String[] args) {
        List<Organizm> organizmy =  new ArrayList<>();
        List<Organizm> wszystkie_organizmy =  new ArrayList<>();

        //organizmy = odczytanieZPliku(organizmy);
        int x = 0, y = 0;
        Czlowiek czl = new Czlowiek(x, y);
        organizmy.add(czl);
        for(int i = 0; i < 3; i++) {
            Wilk wilk = new Wilk(x, y);
            organizmy.add(wilk);
            Owca owca = new Owca(x, y);
            organizmy.add(owca);
            Lis lis = new Lis(x, y);
            organizmy.add(lis);
            Zolw zolw = new Zolw(x, y);
            organizmy.add(zolw);
            Antylopa antylopa = new Antylopa(x, y);
            organizmy.add(antylopa);
            CyberOwca cb = new CyberOwca(x, y);
            organizmy.add(cb);
            Trawa trawa = new Trawa(x, y);
            organizmy.add(trawa);
            Mlecz mlecz = new Mlecz(x, y);
            organizmy.add(mlecz);
            Guarana guarana = new Guarana(x, y);
            organizmy.add(guarana);
            WilczeJagody wj = new WilczeJagody(x, y);
            organizmy.add(wj);
            BarszczSosnowskiego bs = new BarszczSosnowskiego(x, y);
            organizmy.add(bs);
            if (i == 0) {
                wszystkie_organizmy.addAll(organizmy);
            }
        }
        Swiat swiat = new Swiat(organizmy, wszystkie_organizmy);

        for(int i = 0; i < organizmy.size(); i++) {
            while(true){
                int k = 1;
                Random rand = new Random();
                x = rand.nextInt(20);
                y = rand.nextInt(20);
                for(Organizm org : organizmy){
                    if(organizmy.get(i) != org && x == org.getX() && y == org.getY()){
                        k = 0;
                        break;
                    }
                }
                if(k == 1)
                    break;
            }
            organizmy.get(i).setX(x);
            organizmy.get(i).setY(y);
            organizmy.get(i).setSwiat(swiat);
        }

        swiat.setVisible(true);
    }
}
