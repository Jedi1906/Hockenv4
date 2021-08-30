package com.hocken.Hockenv4.controller;

import com.hocken.Hockenv4.dto.CandidatoDTO;
import com.hocken.Hockenv4.model.Candidato;
import com.hocken.Hockenv4.services.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value ="api/")
public class CandidatoControl {
    @Autowired
    CandidatoService candidatoService;
    @PostMapping(value = "addCandidato")
    public void registro(@RequestBody Candidato candidato){
    candidatoService.AddCandidato(candidato);
    }
}
