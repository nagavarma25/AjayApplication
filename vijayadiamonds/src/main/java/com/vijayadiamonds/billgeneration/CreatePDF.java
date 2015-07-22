package com.vijayadiamonds.billgeneration;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.vijayadiamonds.model.Sale;
import com.vijayadiamonds.model.Transaction;

public class CreatePDF {

	private static Font TIME_ROMAN = new Font(Font.FontFamily.TIMES_ROMAN, 18,
			Font.BOLD);
	private static Font TIME_ROMAN_SMALL = new Font(
			Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 15,
			Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 5,
			Font.BOLD);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 5,
			Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 6,
			Font.BOLD);
	private static Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 5,
			Font.NORMAL);

	/**
	 * @param args
	 */
	public static Document createPDF(String file, Transaction transaction) {

		Document document = null;

		try {
			Rectangle rect = new Rectangle(300, 500);
			rect.setBorder(Rectangle.BOX);
			rect.setBorderWidth(1);
			document = new Document(rect, 10, 10, 10, 10);
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();

			generateHeader(transaction, document);
			generateBody(transaction, document);
			generateFooter(transaction, document);
			document.close();

			document.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;

	}

	private static void generateHeader(Transaction transaction,
			Document document) {
		try {
			Chunk cell = new Chunk("Cell :", normalFont);
			Chunk contactOne = new Chunk("9290896562,", normalFont);
			Chunk contactTwo = new Chunk("9550024166", normalFont);
			Paragraph title = new Paragraph(" VIJAYA DIAMONDS", catFont);
			title.setLeading(0, 1);
			title.setIndentationLeft(50);

			Chunk location = new Chunk("Secundarabad", subFont);
			location.setTextRise(-3f);

			Paragraph loPara = new Paragraph(location);
			loPara.setIndentationLeft(180);

			Chunk mrTitle = new Chunk("M/s    :", normalFont);
			Chunk name = new Chunk(transaction.getCustomer().getName(),
					normalFont);
			name.setUnderline(0.1f, -2f);

			Chunk dateTitle = new Chunk("Date   :", normalFont);
			Chunk dateValue = new Chunk(
					new SimpleDateFormat("dd-MM-yyyy").format(transaction
							.getTransactionDate().getTime()), normalFont);
			dateValue.setUnderline(0.1f, -2f);

			document.add(cell);
			document.add(contactOne);
			document.add(contactTwo);
			document.add(new Paragraph());
			document.add(title);
			document.add(loPara);
			Paragraph para = new Paragraph();
			addEmptyLine(para, 1);
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

	private static void generateBody(Transaction transaction, Document document) {
		try {
			PdfPTable table = new PdfPTable(4); // 3 columns.

			table.setWidthPercentage(100);
			float[] columnWidths = { 3f, 1f, 1f, 2f };
			table.setWidths(columnWidths);

			PdfPCell particulars = new PdfPCell(new Paragraph("Particulars",
					redFont));
			particulars.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell quantity = new PdfPCell(new Paragraph("Qty", redFont));
			quantity.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell rate = new PdfPCell(new Paragraph("Rate", redFont));
			rate.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell amount = new PdfPCell(new Paragraph("Amount", redFont));
			amount.setHorizontalAlignment(Element.ALIGN_CENTER);

			table.addCell(particulars);
			table.addCell(quantity);
			table.addCell(rate);
			table.addCell(amount);

			Set<Sale> sales = transaction.getSales();

			for (Sale sale : sales) {
				PdfPCell particularsValue = new PdfPCell(new Paragraph(sale
						.getItem().getName(), normalFont));
				particularsValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell quantityValue = new PdfPCell(new Paragraph(sale
						.getQuantity().toString()+" "+sale.getItem().getUnit()+"s", normalFont));
				quantityValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell rateValue = new PdfPCell(new Paragraph(sale
						.getSellingPrice().toString()+" /" + sale.getItem().getUnit(), normalFont));
				rateValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				Long totalAmount = sale.getQuantity() * sale.getSellingPrice();
				PdfPCell amountValue = new PdfPCell(new Paragraph(
						totalAmount.toString(), normalFont));
				amountValue.setHorizontalAlignment(Element.ALIGN_CENTER);

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

	private static void generateFooter(Transaction transaction,
			Document document) {
		try {
			document.add(new Chunk("Total Amount   :", normalFont));
			document.add(new Chunk(transaction.getTotalAmount().toString(),
					normalFont));
			document.add(new Paragraph());
			document.add(new Chunk("Paid Amount    :", normalFont));
			document.add(new Chunk(transaction.getPaidAmount().toString(),
					normalFont));
			document.add(new Paragraph());
			document.add(new Chunk("Balance Amount :", normalFont));
			Long balAmount = transaction.getTotalAmount()
					- transaction.getPaidAmount();
			document.add(new Chunk(balAmount.toString(), normalFont));
			document.add(new Paragraph());
			document.add(new Chunk("Signature      :", normalFont));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void addMetaData(Document document) {
		document.addTitle("Generate PDF report");
		document.addSubject("Generate PDF report");
		document.addAuthor("Java Honk");
		document.addCreator("Java Honk");
	}

	private static void addTitlePage(Document document)
			throws DocumentException {

		Paragraph preface = new Paragraph();
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph("PDF Report", TIME_ROMAN));

		creteEmptyLine(preface, 1);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		preface.add(new Paragraph("Report created on "
				+ simpleDateFormat.format(new Date()), TIME_ROMAN_SMALL));
		document.add(preface);

	}

	private static void creteEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	private static void createTable(Document document) throws DocumentException {
		Paragraph paragraph = new Paragraph();
		creteEmptyLine(paragraph, 2);
		document.add(paragraph);
		PdfPTable table = new PdfPTable(3);

		PdfPCell c1 = new PdfPCell(new Phrase("First Name"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Last Name"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Test"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

		for (int i = 0; i < 5; i++) {
			table.setWidthPercentage(100);
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell("Java");
			table.addCell("Honk");
			table.addCell("Success");
		}

		document.add(table);
	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}
