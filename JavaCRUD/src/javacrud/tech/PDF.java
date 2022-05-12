/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacrud.tech;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import javax.swing.filechooser.FileSystemView;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


/**
 *
 * @author b.chesneau
 */
public class PDF {

    public PDF() {
    }
    
    public void createPDF(String nom, String prenom, String user, String mail, String Adresse, String Adresse2, String Cp, String ville) throws IOException{
        float interligne = 1.5f;
        int taillePolice = 36;
        File home = FileSystemView.getFileSystemView().getHomeDirectory();
        try ( PDDocument document = new PDDocument()) {
            PDDocumentInformation info = new PDDocumentInformation();
            info.setAuthor(user);
            info.setTitle("Recap Client");
            info.setCreationDate(Calendar.getInstance());
            document.setDocumentInformation(info);

            PDPage page = new PDPage(PDRectangle.A4);

            document.addPage(page);

            //Begin the Content stream
            try ( //Retrieving the pages of the document
                     PDPageContentStream contentStream = new PDPageContentStream(document, page)) {

                contentStream.beginText();
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 25);
                contentStream.moveTextPositionByAmount(240, 750);
                contentStream.drawString("Fiche client :");
                contentStream.endText();
                
                
                
                contentStream.beginText();
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                contentStream.moveTextPositionByAmount(75, 700);
                contentStream.drawString("Nom :");
                contentStream.endText();
                
                contentStream.beginText();
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                contentStream.moveTextPositionByAmount(75, 680);
                contentStream.drawString(nom);
                contentStream.endText();
                
                contentStream.beginText();
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                contentStream.moveTextPositionByAmount(75, 640);
                contentStream.drawString("Prénom :");
                contentStream.endText();
                
                contentStream.beginText();
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                contentStream.moveTextPositionByAmount(75, 620);
                contentStream.drawString(prenom);
                contentStream.endText();
                
                contentStream.beginText();
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                contentStream.moveTextPositionByAmount(75, 580);
                contentStream.drawString("Nom d'utilisateur :");
                contentStream.endText();
                
                contentStream.beginText();
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                contentStream.moveTextPositionByAmount(75, 560);
                contentStream.drawString(user);
                contentStream.endText();
                
                contentStream.beginText();
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                contentStream.moveTextPositionByAmount(75, 520);
                contentStream.drawString("Adresse Mail :");
                contentStream.endText();
                
                contentStream.beginText();
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                contentStream.moveTextPositionByAmount(75, 500);
                contentStream.drawString(mail);
                contentStream.endText();
                
                contentStream.beginText();
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                contentStream.moveTextPositionByAmount(75, 460);
                contentStream.drawString("Adresse N°1  :");
                contentStream.endText();
                
                contentStream.beginText();
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                contentStream.moveTextPositionByAmount(75, 440);
                contentStream.drawString(Adresse);
                contentStream.endText();
                
                contentStream.beginText();
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                contentStream.moveTextPositionByAmount(75, 400);
                contentStream.drawString("Code Postal  :");
                contentStream.endText();
                
                contentStream.beginText();
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                contentStream.moveTextPositionByAmount(75, 380);
                contentStream.drawString(Cp);
                contentStream.endText();
                
                contentStream.beginText();
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                contentStream.moveTextPositionByAmount(75, 340);
                contentStream.drawString("Ville  :");
                contentStream.endText();
                
                contentStream.beginText();
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                contentStream.moveTextPositionByAmount(75, 320);
                contentStream.drawString(ville);
                contentStream.endText();
                
                
                contentStream.beginText();
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                contentStream.moveTextPositionByAmount(75, 320);
                contentStream.drawString(ville);
                contentStream.endText();
                
                
                
                System.out.println("Content added");
                //Closing the content stream
                contentStream.close();
            }
            //Saving the document
            document.save(home.getPath() + "/recap Client de "+nom+".pdf");
            System.out.println("PDF created");
            document.close();
        }

    }

    }

