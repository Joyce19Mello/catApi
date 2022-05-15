package com.cat.controller;

import com.cat.dto.BreedsDTO;
import com.cat.dto.CatAccessoriesDTO;
import com.cat.model.BreedsModel;
import com.cat.model.CatAccessoriesModel;
import com.cat.repository.BreedsRepository;
import com.cat.repository.CatAccessoriesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/cat")
@CrossOrigin("*")
public class CatController {

    @Autowired
    private BreedsRepository repository;

    @Autowired
    private CatAccessoriesRepository catAccessoriesRepository;

    @GetMapping
    public ResponseEntity<List<BreedsModel>> getAll(){
        log.info("List and breeds");
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/breeds/insert")
    public ResponseEntity<BreedsModel> post(@RequestBody @Valid BreedsDTO request){
        log.info("Insert in database");
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(request.toEntity()));
    }

    @PostMapping("/accessories/insert")
    public ResponseEntity<CatAccessoriesModel> post(@RequestBody @Valid CatAccessoriesDTO dto){
        log.info("Insert in database");
        return ResponseEntity.status(HttpStatus.CREATED).body(catAccessoriesRepository.save(dto.toEntity()));
    }

}
