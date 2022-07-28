import Entity.Agency;
import Services.AgencyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AgencyServiceTest {


    @Test
    public void test_add_agency_expected_true() {
        AgencyService agencyService = new AgencyService();
        Agency agency = new Agency();
        agency.setName("test");
        agency.setEmail("test");
        agency.setAddress("test");
        agency.setCity("test");
        //expected: true
        Assertions.assertTrue(agencyService.addAgency(agency));
        System.out.println("Agency added");
        //grafik datası karışmasın diye eklenen objeyi tekrar siliyorum.
        agencyService.deleteAgency(agency);
    }

    @Test
    public void test_update_agency_expected_true() {

        AgencyService agencyService = new AgencyService();
        Agency agency = new Agency();
        agency.setName("test");
        agency.setEmail("test");
        agency.setAddress("test");
        agency.setCity("test");
        agencyService.addAgency(agency);
        agency.setName("test2");
        agency.setEmail("test2");
        agency.setAddress("test2");
        agency.setCity("test2");

        //expected: true
        Assertions.assertTrue(agencyService.updateAgency(agency));
        System.out.println("Agency updated");
    }

    @Test
    public void test_delete_agency_expected_true() {
        AgencyService agencyService = new AgencyService();
        Agency agency = new Agency();
        agency.setName("test");
        agency.setEmail("test");
        agency.setAddress("test");
        agency.setCity("test");
        agencyService.addAgency(agency);
        //expected: true
        Assertions.assertTrue(agencyService.deleteAgency(agency));
        System.out.println("Agency deleted");
    }
}
