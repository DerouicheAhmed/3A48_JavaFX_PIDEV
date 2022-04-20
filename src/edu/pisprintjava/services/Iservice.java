/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.services;

import edu.pisprintjava.entities.Produit;
import java.util.List;

/**
 *
 * @author Ahmed
 */
public interface Iservice <T>{
     public void ajouter(Produit p);
    public void supprimer(int id );
    public void modifier(Produit p);
    public List<T> getAll();
    
   
    
    
}
