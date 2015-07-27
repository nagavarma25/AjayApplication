package com.vijayadiamonds.billgeneration;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vijayadiamonds.exception.ResourceNotFound;
import com.vijayadiamonds.mapper.ItemResourceMapper;
import com.vijayadiamonds.model.Transaction;
import com.vijayadiamonds.service.ItemService;
import com.vijayadiamonds.service.TransactionService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private ItemService itemService;
	@Autowired
	private ItemResourceMapper itemResourceMapper;
	@Autowired
	private TransactionService transactionService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		System.out.println("item count" + itemService.getAllItems());

		return "home";
	}

	@RequestMapping(value = "/billgeneration")
	public ModelAndView getAllItems() {
		return new ModelAndView("billgeneration");
	}

	@RequestMapping(value = "/addcustomer", method = RequestMethod.GET)
	public String loadAddCustomer() {
		return "addcustomer";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String tset() {
		return "test";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Locale locale, Model model) {
		return "search";
	}

	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
	public String transactions(Locale locale, Model model) {
		return "customertransactions";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		return "index";
	}

	@RequestMapping(value = "/partial-home", method = RequestMethod.GET)
	public String partialHome(Locale locale, Model model) {
		return "partial-home";
	}

	@RequestMapping(value = "bill/preview", method = RequestMethod.GET)
	public String billPreview(Locale locale, Model model) {
		return "billpreview";
	}

	@RequestMapping(value = "/files/{transactionId}")
	public void downloadPDF(HttpServletRequest request,
			HttpServletResponse response, @PathVariable Long transactionId)
			throws IOException, ResourceNotFound {
		System.out.println("transactionId" + transactionId);
		Optional<Transaction> transaction = transactionService
				.getTransaction(transactionId);
		transaction.orElseThrow(() -> new ResourceNotFound(
				"Transaction not available for Id :" + transactionId));
		final ServletContext servletContext = request.getSession()
				.getServletContext();
		final File tempDirectory = (File) servletContext
				.getAttribute("javax.servlet.context.tempdir");
		final String temperotyFilePath = tempDirectory.getAbsolutePath();

		String fileName = transaction.get().getCustomer().getName()
				+ transaction.get().getId();
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "attachment; filename="
				+ fileName);

		try {

			CreatePDF.createPDF(temperotyFilePath + "\\" + fileName,
					transaction.get());
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\"
					+ fileName);
			OutputStream os = response.getOutputStream();
			baos.writeTo(os);
			os.flush();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	private ByteArrayOutputStream convertPDFToByteArrayOutputStream(
			String fileName) {

		InputStream inputStream = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {

			inputStream = new FileInputStream(fileName);
			byte[] buffer = new byte[1024];
			baos = new ByteArrayOutputStream();

			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return baos;
	}

}
