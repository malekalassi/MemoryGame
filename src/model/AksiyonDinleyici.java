/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.OyunYonetici;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;

/**
 *
 * @author Malek
 */
public class AksiyonDinleyici implements ActionListener {

    JToggleButton befor, current;
    OyunYonetici yonetici = new OyunYonetici();

    @Override
    public void actionPerformed(ActionEvent e) {

        current = (JToggleButton) e.getSource(); //basılan tuşu değişkene atar
        String name = current.getName();
        current.setText(name);

        if (yonetici.checkIf(Integer.parseInt(name))) {
            current.setEnabled(false); // tuşu kilitler
            current.setForeground(Color.darkGray);

        } else {
            current.setSelected(false);
            current.setText(" ");
            befor.setSelected(false);
            befor.setEnabled(true); //onceki tus basılabilir hale getir
            befor.setText(" ");
        }
        befor = (JToggleButton) e.getSource(); // onceki tuşu kaydet
    }

}
