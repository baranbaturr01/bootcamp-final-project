package Services;

import Entity.Agency;
import Repository.AgencyRepository;

public class AgencyService {
    /**
     * @param agency
     * @return boolean
     */
    public boolean addAgency(Agency agency) {

        AgencyRepository agencyRepository = new AgencyRepository();
        return agencyRepository.save(agency);
    }

    /**
     * @param agency
     * @return boolean
     */
    public boolean deleteAgency(Agency agency) {
        AgencyRepository agencyRepository = new AgencyRepository();
        agencyRepository.delete(agency);
        return true;
    }

    /**
     * @param agency
     * @return boolean
     */
    public boolean updateAgency(Agency agency) {
        AgencyRepository agencyRepository = new AgencyRepository();
        return agencyRepository.update(agency);
    }

}
