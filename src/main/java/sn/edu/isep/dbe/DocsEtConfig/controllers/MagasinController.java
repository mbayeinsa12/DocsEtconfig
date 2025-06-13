package sn.edu.isep.dbe.DocsEtConfig.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.edu.isep.dbe.DocsEtConfig.entities.Magasin;
import sn.edu.isep.dbe.DocsEtConfig.services.MagasinService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/magasins")
public class MagasinController {

    private final MagasinService magasinService;

    public MagasinController(MagasinService magasinService) {
        this.magasinService = magasinService;
    }
    @GetMapping
    public List<Magasin> getAllMagasins() {
        return magasinService.getAllMagasins();
    }
}
