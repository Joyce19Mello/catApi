package com.cat.controller;

import com.cat.dto.BreedsDTO;
import com.cat.dto.CatAccessoriesDTO;
import com.cat.exception.BusinessErrorResponse;
import com.cat.model.BreedsModel;
import com.cat.model.CatAccessoriesModel;
import com.cat.model.TypeAccessoriesCat;
import com.cat.repository.BreedsRepository;
import com.cat.repository.CatAccessoriesRepository;
import com.cat.service.CatClientFlow;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/cat")
@CrossOrigin("*")
public class CatController {

    @Autowired
    private BreedsRepository repository;

    @Autowired
    private CatAccessoriesRepository catAccessoriesRepository;

    @Autowired
    private CatClientFlow catClientFlow;

    @ApiOperation("Inserindo dados de raça api.thecatapi.com no banco de dados")
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "Inserção na base de dados concluida"),
            @ApiResponse(
                    code = 400,
                    message = "Bad Request",
                    response = BusinessErrorResponse.class)})
    @PostMapping("/insert/breeds/apiTheCat")
    public ResponseEntity<String> insertBreeds()  {
        log.info("Inserindo dados no banco de dados");
        return ResponseEntity.status(HttpStatus.CREATED).body(catClientFlow.insertBreed());
    }

    @ApiOperation("Inserindo dados de urls de gatos de óculos da api.thecatapi.com no banco de dados")
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "Inserção na base de dados concluida"),
            @ApiResponse(
                    code = 400,
                    message = "Bad Request",
                    response = BusinessErrorResponse.class)})
    @PostMapping("/insert/sunglasses/apiTheCat")
    public ResponseEntity<String> insertCatSunglasses() {
        log.info("Inserindo dados no banco de dados");
        return ResponseEntity.status(HttpStatus.CREATED).body(catClientFlow.insertImagesUrlsWithSunglassesOrHats(TypeAccessoriesCat.GLASSES));
    }

    @ApiOperation("Inserindo dados de urls de gatos de chapéu da api.thecatapi.com no banco de dados")
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "Inserção na base de dados concluida"),
            @ApiResponse(
                    code = 400,
                    message = "Bad Request",
                    response = BusinessErrorResponse.class)})
    @PostMapping("/insert/hats/apiTheCat")
    public ResponseEntity<String> insertCatHat() {
        log.info("Inserindo dados no banco de dados");
        return ResponseEntity.status(HttpStatus.CREATED).body(catClientFlow.insertImagesUrlsWithSunglassesOrHats(TypeAccessoriesCat.HAT));
    }

    @ApiOperation("Inserir dados de raça no banco de dados")
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "Inserção na base de dados concluida"),
            @ApiResponse(
                    code = 400,
                    message = "Bad Request",
                    response = BusinessErrorResponse.class)})
    @PostMapping("/breeds/insert")
    public ResponseEntity<BreedsModel> post(@RequestBody @Valid BreedsDTO request) {
        log.info("Insert in database");
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(request.toEntity()));
    }

    @ApiOperation("Inserir dados de acessórios de gatos no banco de dados")
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "Inserção na base de dados concluida"),
            @ApiResponse(
                    code = 400,
                    message = "Bad Request",
                    response = BusinessErrorResponse.class)})
    @PostMapping("/insert/accessories")
    public ResponseEntity<CatAccessoriesModel> post(@RequestBody @Valid CatAccessoriesDTO dto) {
        log.info("Insert in database");
        return ResponseEntity.status(HttpStatus.CREATED).body(catAccessoriesRepository.save(dto.toEntity()));
    }

}
