package myProject;

import myProject.Organisms.*;
import myProject.Organisms.Animals.Czlowiek;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Comparator;

public class Swiat extends JFrame {
    Define def = new Define();
    private List<Organizm> organizmy = new ArrayList<>();
    private List<Organizm> w_organizmy = new ArrayList<>();
    private JPanel panel = new JPanel();
    private JButton button = new JButton("Nowa Tura");
    private JButton up, down, left, right, umiejetnosc, zapis, odczyt;
    private TextArea text = new TextArea();
    private int bx, by;
    String messege;
    public Swiat(List<Organizm> org, List<Organizm> w_org)  {
        super("Nowy Swiat!");
        for(int i = 0; i < org.size(); i++){
            organizmy.add(org.get(i));
        }
        w_organizmy.addAll(w_org);
        this.setSize(600, 650);
        this.setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        text.setBounds(1, 2 + 400, 300, 100);
        stworzPrzyciski();

        this.add(button);
        this.add(up);
        this.add(down);
        this.add(left);
        this.add(right);
        this.add(umiejetnosc);
        this.add(zapis);
        this.add(odczyt);
        this.add(text);
        for(Organizm o : organizmy){
            this.add(o);
        }
    }

    public void setEn(boolean b){
        if(b == true) {
          left.setEnabled(false);
          up.setEnabled(false);
          right.setEnabled(false);
          down.setEnabled(false);
        }
        else {
            left.setEnabled(true);
            up.setEnabled(true);
            right.setEnabled(true);
            down.setEnabled(true);
        }
    }

    public void stworzPrzyciski() {
        bx = 1; by = 2 + 400 + 100;
        button.setBounds(bx, by, 100, 30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wykonajTure();
                repaint();
            }
        });

        int bwidth = 60, bheight = 30;
        Czlowiek czl = (Czlowiek) znajdzOrganizm(0, "Czlowiek");

        up = new JButton("up");
        up.setBounds(1 + button.getWidth() + bwidth, by, bwidth, bheight);

        down = new JButton("down");
        down.setBounds(1 + button.getWidth() + bwidth, by + bheight, bwidth, bheight);

        right = new JButton("right");
        right.setBounds(1 + button.getWidth() + 2 * bwidth, by, bwidth, bheight);

        left = new JButton("left");
        left.setBounds(1 + button.getWidth(), by, bwidth, bheight);

        umiejetnosc = new JButton("włącz umiejętność");
        umiejetnosc.setBounds(1 + button.getWidth() + 3 * bwidth, by, 150, bheight);

        zapis = new JButton("zapisz stan");
        zapis.setBounds(1 + button.getWidth() + 3 * bwidth, by + bheight, 150, bheight);
        zapis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileOutputStream fileOut = new FileOutputStream("objects.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    //for(Organizm o : organizmy)
                        out.writeObject(organizmy);
                    out.close();
                    fileOut.close();
                    messege += "Serialized data is saved in objects.ser";
                } catch (IOException i) {
                    i.printStackTrace();
                }
                repaint();
            }
        });

        odczyt = new JButton("odczytaj stan");
        odczyt.setBounds(1 + button.getWidth() + 3 * bwidth, by + 2 * bheight, 150, bheight);
        Swiat sw = this;
        odczyt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileInputStream fileIn = new FileInputStream("objects.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    organizmy = (List<Organizm>) in.readObject();
                    in.close();
                    fileIn.close();
                } catch (IOException i) {
                    i.printStackTrace();
                } catch (ClassNotFoundException c) {
                    System.out.println("Organizms class not found");
                    c.printStackTrace();
                }

                sprawdzCzlowieka();
                for (Organizm o : organizmy)
                    o.setSwiat(sw);
                repaint();
            }
        });

        if (czl != null) {
            up.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Czlowiek czl = (Czlowiek) znajdzOrganizm(0, "Czlowiek");
                    if(czl != null) {
                        czl.up();
                        setEn(true);
                    }
                }
            });
            down.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Czlowiek czl = (Czlowiek) znajdzOrganizm(0, "Czlowiek");
                    if(czl != null) {
                        czl.down();
                        setEn(true);
                    }
                }
            });
            right.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Czlowiek czl = (Czlowiek) znajdzOrganizm(0, "Czlowiek");
                    if(czl != null) {
                        czl.right();
                        setEn(true);
                    }
                }
            });
            left.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Czlowiek czl = (Czlowiek) znajdzOrganizm(0, "Czlowiek");
                    if(czl != null) {
                        czl.left();
                        setEn(true);
                    }
                }
            });
            umiejetnosc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Czlowiek czl = (Czlowiek) znajdzOrganizm(0, "Czlowiek");
                    if(czl != null) {
                        czl.wlaczenieUmiejetnosci();
                        umiejetnosc.setEnabled(false);
                    }
                }
            });
        }
    }

    public void sprawdzCzlowieka() {
        Czlowiek czl = (Czlowiek) znajdzOrganizm(0, "Czlowiek");
        if(czl == null){
            left.setVisible(false);
            right.setVisible(false);
            up.setVisible(false);
            down.setVisible(false);
            umiejetnosc.setVisible(false);
        }
        else if (czl.czyJestWlaczonaUmiejetnosc()) {
            umiejetnosc.setVisible(true);
            umiejetnosc.setEnabled(true);
        }
        else
            umiejetnosc.setVisible(false);
    }

    public void wykonajTure() {
        setEn(false);
        sprawdzCzlowieka();
        messege = "";
        Collections.sort(organizmy, new Comparator<Organizm>() {
            @Override
            public int compare(Organizm o2, Organizm o1) {
                if (o1.getInicjatywa() > o2.getInicjatywa())
                    return 1;
                else if (o1.getInicjatywa() == o2.getInicjatywa()) {
                    if (o1.getRok() < o2.getRok())
                        return -1;
                    else return 1;
                }
                else return -1;
            }
        });
        //główna akcja
        for(int i = 0; i < organizmy.size(); i++){
            Organizm org = organizmy.get(i);
            if(!org.getMove() && !org.getDel()){
                int k = org.getX(), l = org.getY();
                org.setMove(true);
                org.akcja();
                for(int j = 0; j < organizmy.size(); j++){
                    Organizm org2 = organizmy.get(j);
                    if(org != org2 && !org2.getDel()){
                        org.kolizja(org2, k, l);
                    }
                }
            }
        }

        //usuwanie elementów
        for(int i = 0; i < organizmy.size(); i++){
            if(organizmy.get(i).getDel())
                organizmy.remove(i--);
        }

        //
        for(Organizm o : organizmy){
            o.setMove(false);
            o.setRok(o.getRok() + 1);
        }
        text.setText(messege);
    }

    public void setMessege(String messege){
        this.messege += messege;
    }

    public void setOrganizm(Organizm org){
        organizmy.add(org);
    }

    public Organizm getOrganizm(int i) { return organizmy.get(i); }

    public Organizm czyJestKtos(Organizm org, int x, int y) {
        for(Organizm o : organizmy)
            if(o != org && o.getX() == x && o.getY() == y)
                return o;

        return null;
    }

    public Organizm znajdzOrganizm(int i, String typ){
        for(; i < organizmy.size(); i++){
            Organizm org = organizmy.get(i);
            if(org.getTyp() == typ)
                return org;
        }
        return null;
    }

    public int getNumerOrganizmu(Organizm org){
        for(int i = 0; i < organizmy.size(); i++) {
            if(organizmy.get(i) == org)
                return i;
        }
        return -1;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        int x = 10, y = 31;
        g2.drawRect(x, y, 400,400);
        x += 402;
        y -= def.size;
        for(Organizm org : w_organizmy){
            g2.setColor(org.getColor());
            y += def.size;
            g2.fillRect(x, y, def.size, def.size);
            g2.drawString(org.getTyp(), x + def.size + 5, y + def.size);
        }
        for(Organizm org : organizmy) {
            org.paintComponent(g);
        }
    }
}
