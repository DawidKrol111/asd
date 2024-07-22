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


    @GetMapping("/form-confirmation")
    public String formConfirmation(Model model){

        return "form-confirmation";
    }



    @PostMapping("/form-confirmation")
    public String formConfirmationPost(@RequestParam("quantity") Integer quantity,
                                       @RequestParam("categories") List<String> categoryIds,
                                       @RequestParam("institution") Integer institutionId,
                                       @RequestParam("street") String street,
                                       @RequestParam("city") String city,
                                       @RequestParam("zipCode") String zipCode,
                                       @RequestParam("phone") String phone,
                                       @RequestParam("pickUpDate") String pickUpDateString,
                                       @RequestParam("pickUpTime") String pickUpTimeString,
                                       @RequestParam("pickUpComment") String pickUpComment) {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalDate pickUpDate = LocalDate.parse(pickUpDateString, dateFormatter);
        LocalTime pickUpTime = LocalTime.parse(pickUpTimeString, timeFormatter);

        Institution institution = institutionRepository.findById(institutionId).orElseThrow();




        Donation donation = new Donation();
        donation.setQuantity(quantity);
        donation.setPhone(phone);
        donation.setInstitution(institution);
        donation.setStreet(street);
        donation.setCity(city);
        donation.setZipCode(zipCode);
        donation.setPickUpDate(pickUpDate);
        donation.setPickUpTime(pickUpTime);
        donation.setPickUpComment(pickUpComment);

        donationRepository.save(donation);

        System.out.println("donation = " + donation);
        return "redirect:/confirmation-page";
    }



    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        return "register";
    }

    @GetMapping("/form")
    public String showDonationForm(Model model) {
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("institutions", institutionRepository.findAll());
        return "form";
    }

    @PostMapping("/submit")
    public String submitDonation(Donation donation) {
        donationRepository.save(donation);
        return "redirect:/form-confirmation";
    }
}
