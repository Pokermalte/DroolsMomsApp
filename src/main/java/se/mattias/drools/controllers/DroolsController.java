package se.mattias.drools.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.mattias.drools.services.DroolsService;
import se.mattias.model.*;

@RestController
public class DroolsController {
    private static final Logger LOG = LoggerFactory.getLogger(DroolsController.class);
    @Autowired
    DroolsService droolsService;

    @PostMapping(value = "/moms", consumes = "application/json", produces = "application/json")
    public Svar getSvar(@RequestBody Leverantorsfaktura leverantorsfaktura){
        LOG.debug("Skickar faktura till DroolsService");
        return droolsService.getSvar(leverantorsfaktura);
    }
}
