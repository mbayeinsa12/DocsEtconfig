package sn.edu.isep.dbe.DocsEtConfig.services;


import org.springframework.stereotype.Service;
import sn.edu.isep.dbe.DocsEtConfig.entities.Droit;
import sn.edu.isep.dbe.DocsEtConfig.repositories.DroitRepository;

import java.util.Optional;

@Service
public class DroitService {

    private final DroitRepository droitRepository;

    public DroitService(DroitRepository droitRepository) {
        this.droitRepository = droitRepository;
    }

    public Optional<Droit> findByNom(String nom){
        return droitRepository.findByNom(nom);
    }
}
