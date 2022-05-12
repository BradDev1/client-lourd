/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacrud.model;

import java.sql.Connection; // entre la déclaration du package et de la classe
import java.sql.DriverManager;
import java.sql.PreparedStatement; // entre la déclaration du package et de la classe
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 *
 * @author r.bessede
 */
public class Utilisateur {

    private String ut_pseudo, ut_nom, ut_prenom, ut_mp, ut_mail, ut_phrase, ut_adr1, ut_adr2, ut_cdpost, ut_numpost, ut_nomCommune;

    public Utilisateur(String ut_pseudo, String ut_nom, String ut_mp, String ut_mail, String ut_phrase, String ut_adr1, String ut_adr2, String ut_cdpost, String ut_numpost, String nomCommune) {
        this.ut_pseudo = ut_pseudo;
        this.ut_nom = ut_nom;
        this.ut_mp = ut_mp;
        this.ut_mail = ut_mail;
        this.ut_phrase = ut_phrase;
        this.ut_adr1 = ut_adr1;
        this.ut_adr2 = ut_adr2;
        this.ut_cdpost = ut_cdpost;
        this.ut_numpost = ut_numpost;
        this.ut_nomCommune = nomCommune;
    }

    public Utilisateur() {
    }
    
    public String updateUtMp (String utMp){
        if(utMp == null ? this.ut_mp != null : !utMp.equals(this.ut_mp)){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2B, 12);
            this.ut_mp = utMp;
            this.ut_phrase = encoder.encode(ut_mp);
            
        }
        return this.ut_phrase;
    }

    public String getUt_pseudo() {
        return ut_pseudo;
    }

    public void setUt_pseudo(String ut_pseudo) {
        this.ut_pseudo = ut_pseudo;
    }

    public String getUt_nom() {
        return ut_nom;
    }

    public void setUt_nom(String ut_nom) {
        this.ut_nom = ut_nom;
    }

    public String getUt_prenom() {
        return ut_prenom;
    }

    public void setUt_prenom(String ut_prenom) {
        this.ut_prenom = ut_prenom;
    }

    public String getUt_mp() {
        return ut_mp;
    }

    public void setUt_mp(String ut_mp) {
        this.ut_mp = ut_mp;
    }

    public String getUt_mail() {
        return ut_mail;
    }

    public void setUt_mail(String ut_mail) {
        this.ut_mail = ut_mail;
    }

    public String getUt_phrase() {
        return ut_phrase;
    }

    public void setUt_phrase(String ut_phrase) {
        this.ut_phrase = ut_phrase;
    }

    public String getUt_adr1() {
        return ut_adr1;
    }

    public void setUt_adr1(String ut_adr1) {
        this.ut_adr1 = ut_adr1;
    }

    public String getUt_adr2() {
        return ut_adr2;
    }

    public void setUt_adr2(String ut_adr2) {
        this.ut_adr2 = ut_adr2;
    }

    public String getUt_cdpost() {
        return ut_cdpost;
    }

    public void setUt_cdpost(String ut_cdpost) {
        this.ut_cdpost = ut_cdpost;
    }

    public String getUt_numpost() {
        return ut_numpost;
    }

    public void setUt_numpost(String ut_numpost) {
        this.ut_numpost = ut_numpost;
    }

    public String getUt_nomCommune() {
        return ut_nomCommune;
    }

    public void setUt_nomCommune(String ut_nomCommune) {
        this.ut_nomCommune = ut_nomCommune;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "ut_pseudo=" + ut_pseudo + ", ut_nom=" + ut_nom + ", ut_prenom=" + ut_prenom + ", ut_mp=" + ut_mp + ", ut_mail=" + ut_mail + ", ut_phrase=" + ut_phrase + ", ut_adr1=" + ut_adr1 + ", ut_adr2=" + ut_adr2 + ", ut_cdpost=" + ut_cdpost + ", ut_numpost=" + ut_numpost + '}';
    }
/*
    public static void requete() {
        Connection con;
        String url = "jdbc:mysql://localhost:3306/gestion_utilisateur";
        String user = "root";
        String pass = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);

            String rqSql = "SELECT * FROM utilisateur";
            PreparedStatement ps = con.prepareStatement(rqSql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                System.out.print(result.getString("ut_pseudo") + " "
                        + result.getString("ut_nom") + " " + result.getString("ut_prenom") + "\n");
            }

        } catch (ClassNotFoundException | SQLException e) {
            
        }

    }*/

}
