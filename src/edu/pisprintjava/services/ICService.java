/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.services;

import edu.pisprintjava.entities.Categorie;
import java.util.List;

/**
 *
 * @author Ahmed
 */
public interface ICService <T> {
      public void ajouter(Categorie c);
    public void supprimer(int id );
    public void modifier(Categorie c);
    public List<T> getAllCategories();
}
