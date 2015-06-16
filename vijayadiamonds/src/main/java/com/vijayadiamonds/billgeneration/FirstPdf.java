package com.vijayadiamonds.billgeneration;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
/**
 * Created by Janardhan on 14-06-2015.
 */
public class FirstPdf {

    private static String FILE = "D:/New folder/Bills/FirstPdf.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 7,
            Font.BOLD);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 5,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 6,
            Font.BOLD);
    private static Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 7,
            Font.NORMAL);

    public static void main(String[] args) {
        try {
            Rectangle rect = new Rectangle(270, 240);
            rect.setBorder(Rectangle.BOX);
            rect.setBorderWidth(2);
            Document document = new Document(rect, 10, 10, 10, 10);
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();

            Chunk estimate = new Chunk("ESTIMATE",smallBold);
            //document.add(estimate);

            Chunk cell = new Chunk("Cell :",normalFont);
            Chunk contactOne = new Chunk("9290896562,",normalFont);
            Chunk contactTwo = new Chunk("9550024166",normalFont);
            Chunk title = new Chunk(" VIJAYA DIAMONDS" , catFont);
            /*Paragraph title = new Paragraph("VIJAYA DIAMONDS",catFont);
            title.setAlignment(50);
            title.setIndentationRight(50);*/

            Chunk location = new Chunk("Secundarabad" , subFont);
            location.setTextRise(-5f);

            Chunk mrTitle = new Chunk("M/s    :",normalFont);
            Chunk name = new Chunk("Janardhana rao ravada",normalFont);
            name.setUnderline(0.1f, -2f);

            Chunk dateTitle = new Chunk("Date   :",normalFont);
            Chunk dateValue = new Chunk(new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(),normalFont);
            dateValue.setUnderline(0.1f, -2f);


            document.add(cell);
            document.add(contactOne);
            document.add(contactTwo);
            document.add(new Paragraph());
            document.add(title);
            document.add(location);
            document.add(new Paragraph());
            document.add(new Paragraph());
            document.add(new Paragraph());
            document.add(new Paragraph());
            document.add(new Paragraph());
            document.add(new Paragraph());
            document.add(mrTitle);
            document.add(name);
            document.add(new Paragraph());
            document.add(dateTitle);
            document.add(dateValue);

            PdfPTable table = new PdfPTable(4); // 3 columns.

            table.setWidthPercentage(90);
            float[] columnWidths = {3f, 1f, 1f,2f};
            table.setWidths(columnWidths);

            PdfPCell cell1 = new PdfPCell(new Paragraph("Particulars",redFont));
            PdfPCell cell2 = new PdfPCell(new Paragraph("Qty",redFont));
            PdfPCell cell3 = new PdfPCell(new Paragraph("Rate",redFont));
            PdfPCell cell4 = new PdfPCell(new Paragraph("Amount",redFont));


            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);

            PdfPCell cell5 = new PdfPCell(new Paragraph("Ruby",normalFont));
            PdfPCell cell6 = new PdfPCell(new Paragraph("2",normalFont));
            PdfPCell cell7 = new PdfPCell(new Paragraph("200",normalFont));
            PdfPCell cell8 = new PdfPCell(new Paragraph("400",normalFont));

            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);

            PdfPCell cell9 = new PdfPCell(new Paragraph("Emerald",normalFont));
            PdfPCell cell10 = new PdfPCell(new Paragraph("2",normalFont));
            PdfPCell cell11 = new PdfPCell(new Paragraph("200",normalFont));
            PdfPCell cell12 = new PdfPCell(new Paragraph("400",normalFont));

            table.addCell(cell9);
            table.addCell(cell10);
            table.addCell(cell11);
            table.addCell(cell12);

            PdfPCell cell13 = new PdfPCell(new Paragraph("Emerald",normalFont));
            PdfPCell cell14 = new PdfPCell(new Paragraph("2",normalFont));
            PdfPCell cell15 = new PdfPCell(new Paragraph("200",normalFont));
            PdfPCell cell16 = new PdfPCell(new Paragraph("400",normalFont));

            table.addCell(cell13);
            table.addCell(cell14);
            table.addCell(cell15);
            table.addCell(cell16);

            document.add(table);

            document.add(new Chunk("Total Amount:",normalFont));
            document.add(new Chunk("800",normalFont));
            document.add(new Paragraph());
            document.add(new Chunk("Signature :",normalFont));

            document.close();
           /* addMetaData(document);
            addTitlePage(document);
            addContent(document);*/
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // iText allows to add metadata to the PDF which can be viewed in your Adobe
    // Reader
    // under File -> Properties
    private static void addMetaData(Document document) {
        document.addTitle("My first PDF");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Lars Vogel");
        document.addCreator("Lars Vogel");
    }

    private static void addTitlePage(Document document)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        // We add one empty line
        addEmptyLine(preface, 1);
        // Lets write a big header
        preface.add(new Paragraph("Title of the document", catFont));

        addEmptyLine(preface, 1);
        // Will create: Report generated by: _name, _date
        preface.add(new Paragraph("Report generated by: " + System.getProperty("user.name") + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                smallBold));
        addEmptyLine(preface, 3);
        preface.add(new Paragraph("This document describes something which is very important ",
                smallBold));

        addEmptyLine(preface, 8);

        preface.add(new Paragraph("This document is a preliminary version and not subject to your license agreement or any other agreement with vogella.com ;-).",
                redFont));

        document.add(preface);
        // Start a new page
        document.newPage();
    }

    private static void addContent(Document document) throws DocumentException {
        Anchor anchor = new Anchor("First Chapter", catFont);
        anchor.setName("First Chapter");

        // Second parameter is the number of the chapter
        Chapter catPart = new Chapter(new Paragraph(anchor), 1);

        Paragraph subPara = new Paragraph("Subcategory 1", subFont);
        Section subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("Hello"));

        subPara = new Paragraph("Subcategory 2", subFont);
        subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("Paragraph 1"));
        subCatPart.add(new Paragraph("Paragraph 2"));
        subCatPart.add(new Paragraph("Paragraph 3"));

        // add a list
        createList(subCatPart);
        Paragraph paragraph = new Paragraph();
        addEmptyLine(paragraph, 5);
        subCatPart.add(paragraph);

        // add a table
        createTable(subCatPart);

        // now add all this to the document
        document.add(catPart);

        // Next section
        anchor = new Anchor("Second Chapter", catFont);
        anchor.setName("Second Chapter");

        // Second parameter is the number of the chapter
        catPart = new Chapter(new Paragraph(anchor), 1);

        subPara = new Paragraph("Subcategory", subFont);
        subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("This is a very important message"));

        // now add all this to the document
        document.add(catPart);

    }

    private static void createTable(Section subCatPart)
            throws BadElementException {
        PdfPTable table = new PdfPTable(3);

        // t.setBorderColor(BaseColor.GRAY);
        // t.setPadding(4);
        // t.setSpacing(4);
        // t.setBorderWidth(1);

        PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Table Header 2"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Table Header 3"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);

        table.addCell("1.0");
        table.addCell("1.1");
        table.addCell("1.2");
        table.addCell("2.1");
        table.addCell("2.2");
        table.addCell("2.3");

        subCatPart.add(table);

    }

    private static void createList(Section subCatPart) {
        List list = new List(true, false, 10);
        list.add(new ListItem("First point"));
        list.add(new ListItem("Second point"));
        list.add(new ListItem("Third point"));
        subCatPart.add(list);
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
