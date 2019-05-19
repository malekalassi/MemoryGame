/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.AksiyonDinleyici;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import view.OyunScreen;

/**
 *
 * @author Malek
 */
public final class Toggles extends JToggleButton {

    RandomRakam db = new RandomRakam(); //gönderilen adet kadar random değerler gönderiyor
    OyunScreen screen;

    private int miktar;
    private JPanel panel;
    private String layout;
    public static JToggleButton buttons[];

    public Toggles(String rakam, JPanel panel, String layout) {

        OyunYonetici oy = new OyunYonetici();
        AksiyonDinleyici listener = new AksiyonDinleyici();

        int miktar = Integer.parseInt(rakam);
        if (miktar <= 0) {
            JOptionPane.showMessageDialog(screen, "Lutfen pazitif sayi girin.", "Uyarı", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (miktar % 2 != 0) {
            miktar++;
        }
        oy.setAdet(miktar);

         buttons = new JToggleButton[miktar];
        int degerler[] = db.randomRakam(miktar);

        this.miktar = miktar;
        this.panel = panel;
        this.layout = layout;

        panel.removeAll(); //onceki kutuları siliyor
        panel.repaint();

        for (int i = 0; i < buttons.length; ++i) {

            buttons[i] = new JToggleButton();

            buttons[i].addActionListener(listener);

            panel.add(buttons[i]);
            buttons[i].setText(Integer.toString(degerler[i]));
            System.out.print(degerler[i] + "  ");//output

            buttons[i].setName(Integer.toString(degerler[i]));//değerler yedek olarak isme atandı

        }
        if (layout == "FlowLayout") {
            panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        } else {
            panel.setLayout(new GridLayout(4, 4));
        }
        //Gizleme(miktar, buttons);//kutuların kıymetini gizler
    }
     public void Gizleme(int miktar, JToggleButton[] buttons) {
        for (int i = 0; i < miktar; ++i) {
            buttons[i].setText(" ");//değerler görünmesin diye
        }
    }

   
}
