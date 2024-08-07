package pl.coderslab.charity.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.Entities.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("SELECT SUM(d.quantity) FROM Donation d")
    Integer getTotalQuantityOfDonations();

    @Query("SELECT COUNT(*) AS total_donations FROM Donation")
    Integer getNumberOfDonations();
}