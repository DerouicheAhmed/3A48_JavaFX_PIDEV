/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.services;

import edu.pisprintjava.entities.Commande;
import edu.pisprintjava.entities.Facture;



/**
 *
 * @author Mortadha
 */
public interface MyListener {
    
    public void onClickListener(Commande c);
    public void onClickListener2(Facture p);
}
