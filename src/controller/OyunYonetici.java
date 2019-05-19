/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import view.OyunScreen;

/**
 *
 * @author Malek
 */
public class OyunYonetici {

   OyunScreen screen;

    static int sayac = 0;
    static int bitis = 0;
    int onceki = 0;
    static int adet ;
    public static int puan;

   

    public boolean checkIf(int value) {
        if (onceki == 0) { // oyunun baslangicinda bir tusun gösterilmesi icin
            onceki = value;
            return true;
        } else if (onceki == value) {
            onceki = 0;
            sayac++;
            puan+=50;
            
            oyunBittiMi();
            return true;
        } else {
            onceki = 0;
            puan-=20;
            return false;
        }
    }
  
    
    public void oyunBittiMi(){
        if(sayac == bitis){
            SureHesaplayici.timer.stop();
            screen.puandeger.setText(String.valueOf(puan*adet));
            JOptionPane.showMessageDialog(screen, "Oyun bitti.", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
    
     public void setAdet(int adet) {
        bitis = adet / 2;
        this.adet=adet;
        
    }
     
     
   
}
