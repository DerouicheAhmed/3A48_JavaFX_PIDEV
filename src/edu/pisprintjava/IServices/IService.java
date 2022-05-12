/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.IServices;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Boughnimi
 */
public interface IService  <T>{
    public void ajouter(T p) throws SQLException;
    public void modifier(T p) throws SQLException;
    public void supprimer(int id) throws SQLException;
    public List<T> getAll() throws SQLException;
    public List<T> ListClasse();
}
