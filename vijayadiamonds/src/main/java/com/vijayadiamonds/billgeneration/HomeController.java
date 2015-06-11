package com.vijayadiamonds.billgeneration;

import com.vijayadiamonds.mapper.ItemResourceMapper;
import com.vijayadiamonds.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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


}
