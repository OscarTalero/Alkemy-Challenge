package com.alkemy.disney.controller;

import com.alkemy.disney.DTO.GenderDTO;
import com.alkemy.disney.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("genders")
public class GenderController {

    @Autowired
    private GenderService genderService;

    @GetMapping
    public ResponseEntity<List<GenderDTO>> getAllGenders() {
        List<GenderDTO> gendersDTO = genderService.getAllGenders();
        return ResponseEntity.ok().body(gendersDTO);
    }

    @PostMapping
    public ResponseEntity<GenderDTO> addGender(@RequestBody GenderDTO gender) {
        GenderDTO genderSaved = genderService.addGender(gender);
        return ResponseEntity.status(HttpStatus.CREATED).body(genderSaved);
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGender(@PathVariable Long id) {
        genderService.deleteGender(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenderDTO> updateGender(@PathVariable Long id, @RequestBody GenderDTO gender) {
        GenderDTO result = genderService.updateGender(id, gender);
        return ResponseEntity.ok().body(result);
    }
}
