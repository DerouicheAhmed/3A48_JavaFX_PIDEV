/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.utis;
import edu.pisprintjava.entities.Evenement;
import edu.pisprintjava.services.Evenement_service;
import edu.pisprintjava.entities.Participant;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import edu.pisprintjava.services.Participant_service;
import edu.pisprintjava.gui.AfficherevenementController;

/**
 *
 * @author mahdi
 */
public class QRCodeGenerator {
    
    public static void main() throws Exception{
//Reservation r = new Reservation();
//            reservation_service rs  = new reservation_service();          
Evenement a = new Evenement();
      
       String details =AfficherevenementController.EvenementStatic.getDestination();
           // String details = String.valueOf(ws.Affichertout());
           
             
    ByteArrayOutputStream out = QRCode.from(details).to(ImageType.JPG).stream();
    
    File f = new File ("C:\\Users\\mahdi\\Documents\\NetBeansProjects\\PIdesktop\\src\\Images\\MyChannel.jpg");
    FileOutputStream fos = new FileOutputStream(f);
    
    fos.write(out.toByteArray());
    fos.flush();
    
}

    
}
