package sn.edu.isep.dbe.DocsEtConfig.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.isep.dbe.DocsEtConfig.entities.Droit;

import java.util.List;
import java.util.Optional;

public interface DroitRepository extends JpaRepository<Droit, Integer> {
    Optional<Droit> findByName(String name);

}