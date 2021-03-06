package com.vijayadiamonds.billgeneration;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.vijayadiamonds.model.Sale;
import com.vijayadiamonds.model.Transaction;

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

            Chunk estimate = new Chunk("ESTIMATE", smallBold);
            // document.add(estimate);

            // document.close();
            /*
             * addMetaData(document); addTitlePage(document);
             * addContent(document);
             */
            // document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateBill(Transaction transaction) {
        try {
            Rectangle rect = new Rectangle(270, 240);
            rect.setBorder(Rectangle.BOX);
            rect.setBorderWidth(2);
            Document document = new Document(rect, 10, 10, 10, 10);
            PdfWriter.getInstance(document, new FileOutputStream(transaction
                    .getCustomer().getName()
                    + transaction.getTransactionDate()
                    + ".pdf"));
            document.open();
            generateHeader(transaction, document);
            generateBody(transaction, document);
            generateFooter(transaction, document);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateHeader(Transaction transaction, Document document) {
        try {
            Chunk cell = new Chunk("Cell :", normalFont);
            Chunk contactOne = new Chunk("9290896562,", normalFont);
            Chunk contactTwo = new Chunk("9550024166", normalFont);
            Chunk title = new Chunk(" VIJAYA DIAMONDS", catFont);
            /*
             * Paragraph title = new Paragraph("VIJAYA DIAMONDS",catFont);
             * title.setAlignment(50); title.setIndentationRight(50);
             */

            Chunk location = new Chunk("Secundarabad", subFont);
            location.setTextRise(-5f);

            Chunk mrTitle = new Chunk("M/s    :", normalFont);
            Chunk name = new Chunk(transaction.getCustomer().getName(),
                    normalFont);
            name.setUnderline(0.1f, -2f);

            Chunk dateTitle = new Chunk("Date   :", normalFont);
            Chunk dateValue = new Chunk(transaction.getTransactionDate()
                    .toString(), normalFont);
            dateValue.setUnderline(0.1f, -2f);

            document.add(cell);
            document.add(contactOne);
            document.add(contactTwo);
            document.add(new Paragraph());
            document.add(title);
            document.add(location);
            Paragraph para = new Paragraph();
            addEmptyLine(para, 6);
            document.add(para);

            document.add(mrTitle);
            document.add(name);
            document.add(new Paragraph());
            document.add(dateTitle);
            document.add(dateValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateBody(Transaction transaction, Document document) {
        try {
            PdfPTable table = new PdfPTable(4); // 3 columns.

            table.setWidthPercentage(90);
            float[] columnWidths = { 3f, 1f, 1f, 2f };
            table.setWidths(columnWidths);

            PdfPCell particulars = new PdfPCell(new Paragraph("Particulars",
                    redFont));
            PdfPCell quantity = new PdfPCell(new Paragraph("Qty", redFont));
            PdfPCell rate = new PdfPCell(new Paragraph("Rate", redFont));
            PdfPCell amount = new PdfPCell(new Paragraph("Amount", redFont));

            table.addCell(particulars);
            table.addCell(quantity);
            table.addCell(rate);
            table.addCell(amount);

            Set<Sale> sales = transaction.getSales();

            for (Sale sale : sales) {
                PdfPCell particularsValue = new PdfPCell(new Paragraph(sale
                        .getItem().getName(), redFont));
                PdfPCell quantityValue = new PdfPCell(new Paragraph(sale
                        .getQuantity().toString(), redFont));
                PdfPCell rateValue = new PdfPCell(new Paragraph(sale
                        .getSellingPrice().toString(), redFont));
                PdfPCell amountValue = new PdfPCell(new Paragraph(
                        sale.getQuantity() * sale.getSellingPrice()));

                table.addCell(particularsValue);
                table.addCell(quantityValue);
                table.addCell(rateValue);
                table.addCell(amountValue);

            }
            document.add(table);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateFooter(Transaction transaction, Document document) {
        try {
            document.add(new Chunk("Total Amount:", normalFont));
            document.add(new Chunk("800", normalFont));
            document.add(new Paragraph());
            document.add(new Chunk("Signature :", normalFont));
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
        preface.add(new Paragraph(
                "Report generated by: " + System.getProperty("user.name") + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                smallBold));
        addEmptyLine(preface, 3);
        preface.add(new Paragraph(
                "This document describes something which is very important ",
                smallBold));

        addEmptyLine(preface, 8);

        preface.add(new Paragraph(
                "This document is a preliminary version and not subject to your license agreement or any other agreement with vogella.com ;-).",
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
