package pl.coderslab.charity.Controllers;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.Entities.User;
import pl.coderslab.charity.Repo.CategoryRepository;
import pl.coderslab.charity.Repo.DonationRepository;
import pl.coderslab.charity.Repo.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.Entities.Donation;
import pl.coderslab.charity.Entities.Institution;
import pl.coderslab.charity.UserService;

import java.util.List;


@Controller
public class HomeController {

    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;
    private final CategoryRepository categoryRepository;
    private final UserService userService;

    @Autowired
    public HomeController(UserService userService , CategoryRepository categoryRepository ,InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.userService = userService;

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

        model.addAttribute("user", new User());

        return "register";
    }


    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        userService.saveUser(user);
        model.addAttribute("username", user.getUsername());

        return "main/home";
    }



    @GetMapping("/form-confirmation")
    public String confirmation(Model model){
        return "form-confirmation";
    }



    @PostMapping("/form-confirmation")
    public String submitDonation(Donation donation, Model model) {

        donationRepository.save(donation);
        model.addAttribute(donation);
        return "form-confirmation";
    }
}
