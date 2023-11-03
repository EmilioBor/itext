/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package emilio.probando2itext;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;
import java.io.File;
import java.util.random.RandomGenerator;
import javax.swing.text.StyleConstants.FontConstants;

/**
 *
 * @author emili
 */
public class Probando2iText {

    public static final String DEST = "./target/sandbox/tables/simple_table.pdf";

    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new Probando2iText().manipulatePdf(DEST);
        
        
        
    }

    protected void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        try (Document doc = new Document(pdfDoc)) {
            Table table = new Table(UnitValue.createPercentArray(8)).useAllAvailableWidth();
            
            for (int i = 0; i < 16; i++) {
                
                table.addCell("hi");
            }
            Paragraph parrafo2 = new Paragraph("Holaa Como estas");
            doc.add(parrafo2);
            doc.add(table);
        // Create a PdfFont
        PdfFont font = PdfFontFactory.createFont();
        // Add a Paragraph
                doc.add(new Paragraph("iText is:").setFont(font));
        // Create a List
        List list = new List()
            .setSymbolIndent(12)
            .setListSymbol("\u2022")
            .setFont(font);
        // Add ListItem objects
        list.add(new ListItem("Never gonna give you up"))
            .add(new ListItem("Never gonna let you down"))
            .add(new ListItem("Never gonna run around and desert you"))
            .add(new ListItem("Never gonna make you cry"))
            .add(new ListItem("Never gonna say goodbye"))
            .add(new ListItem("Never gonna tell a lie and hurt you"));
        // Add the list
        doc.add(list);
        
        Image dog = new Image(ImageDataFactory.create("dog"));
        Paragraph p = new Paragraph("The quick brown ")
                    
                    .add(" jumps over the lazy ")
                    .add(dog);
        doc.add(p);
        }
        
    }
}
