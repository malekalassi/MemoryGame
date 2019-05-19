/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Malek
 */
public class SureHesaplayici implements Runnable{
    Date ilkzaman=new Date();
    SimpleDateFormat sdf;
    JLabel label;
     static Timer timer;

    public SureHesaplayici(JLabel suredeger) {
        this.label=suredeger;
    }
    

    @Override
    public void run() {
        
       timer =new Timer(1000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date simdi=new Date();
                sdf=new SimpleDateFormat("00:mm:ss");
                label.setText(sdf.format(new Date(simdi.getTime()-ilkzaman.getTime())));
                
                
            }
        });
        timer.start();
    }
    
    
    
    
    
}
