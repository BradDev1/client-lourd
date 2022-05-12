/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacrud.control;
import javacrud.model.Utilisateur;
import javacrud.tech.UtilDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javacrud.model.Commune;
/**
 *
 * @author b.chesneau
 */
public class VilleDAOImp {
    public VilleDAOImp() {
    }
    
    public HashMap<Integer, Commune> lesVille(Integer codePostal) {
        HashMap<Integer, Commune> Ville = new HashMap<>();
        System.out.println(codePostal);
        try {
            Connection con = UtilDB.getConnect();
            String sql = "SELECT Num_Postal, Nom_Commune FROM codes_postaux WHERE Code_Postal=? ORDER BY Num_Postal";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,codePostal.toString());
            ResultSet rs = ps.executeQuery();
            //System.out.println(ps);
            
            while(rs.next()){
                Commune c = new Commune(codePostal.toString(), rs.getString("Num_Postal"),rs.getString("Nom_Commune"));
                Ville.put(rs.getInt("Num_Postal"), c);
                
            }
                    
        } catch (Exception ex) {
            System.out.println(ex);
            Logger.getLogger(VilleDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(Ville);
        return Ville;
    }
}
