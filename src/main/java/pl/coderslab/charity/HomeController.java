package pl.coderslab.charity;
import pl.coderslab.charity.encje.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.encje.Donation;
import pl.coderslab.charity.encje.Institution;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class HomeController {

    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public HomeController(CategoryRepository categoryRepository ,InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public String homeAction(Model model){

        int numberOfBags = donationRepository.getTotalQuantityOfDonations();
        int numberOfDonations = donationRepository.getNumberOfDonations();
        List<Institution> institutions = institutionRepository.findRandomInstitutions();
        model.addAttribute("numberOfDonations", numberOfDonations);
        model.addAttribute("numberOfBags", numberOfBags);
        model.addAttribute("institutions", institutions);
        return "index";
    }



    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        return "register";
    }


    @GetMapping("/form-confirmation")
    public String confirmation(Model model){
        return "form-confirmation";
    }

    @GetMapping("/form")
    public String showDonationForm(Model model) {
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("institutions", institutionRepository.findAll());
        return "form";
    }


    @PostMapping("/submit")
    public String submitDonation(Donation donation, Model model) {

        System.out.println("\"sdsdsd\" = " + "sdsdsd");
        donationRepository.save(donation);
        model.addAttribute(donation);
        return "form-confirmation";
    }
}
