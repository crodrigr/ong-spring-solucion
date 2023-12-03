package com.ong.help.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ong.help.dto.EnvioDTO;
import com.ong.help.dto.EnvioSaveDTO;
import com.ong.help.services.EnvioService;
import com.ong.help.util.exceptions.ExceptionNotFoundEnvio;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/envios")
@AllArgsConstructor
public class EnvioControllers {

    private EnvioService envioService;

    @GetMapping("/{id}")
    public ResponseEntity<EnvioDTO> findById(@PathVariable Long id) {
        try {
            EnvioDTO envioDTO = envioService.findById(id);
            return ResponseEntity.ok(envioDTO);
        } catch (ExceptionNotFoundEnvio e) {

            return ResponseEntity.notFound().build();

        }

    }

    @PostMapping("/")
    public ResponseEntity<Long> save(@RequestBody EnvioSaveDTO envio){
        try{
        Long id=envioService.save(envio);
        return ResponseEntity.ok(id);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        //comentario
        
    }

}
