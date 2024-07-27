package pl.coderslab.charity.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Entities.Donation;
import pl.coderslab.charity.Repo.CategoryRepository;
import pl.coderslab.charity.Repo.DonationRepository;
import pl.coderslab.charity.Repo.InstitutionRepository;
import pl.coderslab.charity.UserService;


@Controller("/")

public class FormController {

    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;
    private final CategoryRepository categoryRepository;
    private final UserService userService;

    public FormController(UserService userService , CategoryRepository categoryRepository , InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.userService = userService;

    }


    @PostMapping("/donation")
    public String submitDonation(Donation donation, Model model) {

        donationRepository.save(donation);
        model.addAttribute(donation);
        return "redirect:/form-confirmation";
    }


    @GetMapping("/donation")
    public String showDonationForm(Model model) {
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("institutions", institutionRepository.findAll());
        return "form";
    }



//    @GetMapping("/confirmation")
//    public String confirmation(Model model){
//        return "form-confirmation";
//    }



}
