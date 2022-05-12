/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacrud.control;


import java.io.InputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javacrud.tech.UtilDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javacrud.tech.GestionImage;
import javax.swing.JOptionPane;

/**
 *
 * @author b.chesneau
 */
public class ImageDAO {

    public static ImageIcon getUtIcon(String pseudo) {
        BufferedImage image = null;
        ImageIcon avatar = null;
        try {
            Connection con = UtilDB.getConnect();
            String sql = "SELECT * FROM util_avatar WHERE ut_pseudo=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pseudo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                InputStream img = rs.getBinaryStream("utAvatar");
                image = ImageIO.read(img);
                //affiche((BufferedImage) image);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Image : Erreur à la lecture de l'image \n " + ex);

        }
        if (image != null) {
            avatar = new ImageIcon(image);
        }
        return avatar;
    }

    public static ImageIcon importImage(String path, int largeur, int hauteur) throws IOException {
        File file = new File(path);
        BufferedImage img = ImageIO.read(file);
        ImageIcon resized = new ImageIcon(GestionImage.reziseImg(img, largeur, hauteur));
        return resized;
        
    }

    public static void setUtImage(String pseudo, ImageIcon image) {
        try {
            ByteArrayOutputStream img = new ByteArrayOutputStream();
            ImageIO.write((BufferedImage) image.getImage(), "jpg", img);
            InputStream outImg = new ByteArrayInputStream(img.toByteArray());
            Connection con = UtilDB.getConnect();
            String sql = "UPDATE utilisateur SET ut_avatar=? WHERE ut_pseudo=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBinaryStream(1, outImg);
            ps.setString(2, pseudo);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Image : Erreur à la modification de l'image\n" + ex);

        }
    }
}
