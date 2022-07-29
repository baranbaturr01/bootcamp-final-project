package com.baranbatur.javabootcamp.finalproject.services;

import com.baranbatur.javabootcamp.finalproject.entity.Agency;
import com.baranbatur.javabootcamp.finalproject.repository.AgencyRepository;
import jakarta.transaction.Transactional;

public class AgencyService {
    /**
     * @param agency
     * @return boolean
     */
    @Transactional
    public boolean addAgency(Agency agency) {

        AgencyRepository agencyRepository = new AgencyRepository();
        return agencyRepository.save(agency);
    }

    /**
     * @param agency
     * @return boolean
     */
    @Transactional
    public boolean deleteAgency(Agency agency) {
        AgencyRepository agencyRepository = new AgencyRepository();
        return agencyRepository.delete(agency);
    }

    /**
     * @param agency
     * @return boolean
     */
    @Transactional
    public boolean updateAgency(Agency agency) {
        AgencyRepository agencyRepository = new AgencyRepository();
        return agencyRepository.update(agency);
    }

}
