/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.IServices;

import edu.pisprintjava.entities.User;
import edu.pisprintjava.utis.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Boughnimi
 */
public class ServiceUser implements IService<User> {
    
    private DataSource ds = DataSource.getInstance();
    
     @Override
    public void ajouter(User p) throws SQLException{
        String req = "INSERT INTO `user` (`nom`, `prenom`,`email`,`password`,`numerotelephone`,`role`) VALUES ('"+p.getNom()+"', '"+p.getPrenom()+"', '"+p.getEmail()+"', '"+p.getPassword()+"', '"+p.getNumerotelephone()+"','" +p.getRole()+ "')";
        Statement st = ds.getCnx().createStatement();
        st.executeUpdate(req);
    }
     public void ajouter2(User p) throws SQLException{
        String req = "INSERT INTO `user` (`nom`, `prenom`,`email`,`password`,`numerotelephone`,`role`) VALUES (?,?)";
        PreparedStatement st = ds.getCnx().prepareStatement(req);
        st.setString(1, p.getNom());
        st.setString(2, p.getPrenom());
        //st.setString(2, p.getEmail());
        //st.setString(2, p.getPassword());
       // st.setString(2, p.getNumerotelephone());
        st.executeUpdate();
    }
     
    @Override
    public void modifier(User p) throws SQLException{
        String req = "UPDATE `user` SET `nom` = '"+p.getNom()+"', `prenom` = '"+p.getPrenom()+"',`email` = '"+p.getEmail()+"' , `password` = '"+p.getPassword()+"',`numerotelephone` = '"+p.getNumerotelephone()+"'  WHERE `user`.`id` = "+p.getId();
        Statement st = ds.getCnx().createStatement();
        st.executeUpdate(req);
    }
    @Override
    public void supprimer(int id) throws SQLException{
        String req = "DELETE FROM `user` WHERE id ="+id;
        Statement st = ds.getCnx().createStatement();
        st.executeUpdate(req);
    }
    
     public List<User> getAll() throws SQLException{
        List<User> list = new ArrayList<>();
        
        String req = "Select * from user";
        Statement st = ds.getCnx().createStatement();
        ResultSet rs = st.executeQuery(req);
        while(rs.next()){
            User p = new User(rs.getInt("id"), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
            list.add(p);
        }
        
        return list;
    }

    @Override
    public List<User> ListClasse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
