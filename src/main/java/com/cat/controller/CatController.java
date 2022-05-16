package com.cat.controller;

import com.cat.SwaggerConfig;
import com.cat.request.BreedsRequest;
import com.cat.request.CatAccessoriesRequest;
import com.cat.exception.BusinessErrorResponse;
import com.cat.model.BreedsModel;
import com.cat.model.CatAccessoriesModel;
import com.cat.repository.BreedsRepository;
import com.cat.repository.CatAccessoriesRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/v1-cat-api")
@CrossOrigin("*")
@Api(value = "v1-cat-api", tags = {SwaggerConfig.CAT_CONTROLLER})
public class CatController {

    private static String DATABASE_CREATE = " Inserindo dados no banco de dados";

    @Autowired
    private BreedsRepository breedsRepository;

    @Autowired
    private CatAccessoriesRepository catAccessoriesRepository;

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
    public ResponseEntity<BreedsModel> insertBreeds(@RequestBody @Valid BreedsRequest request) {
        log.info(DATABASE_CREATE);
        return ResponseEntity.status(HttpStatus.CREATED).body(breedsRepository.save(request.toEntity()));
    }

    @ApiOperation("Trazer todos os registros no banco de raças")
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "Busca por dados de raça concluída"),
            @ApiResponse(
                    code = 400,
                    message = "Bad Request",
                    response = BusinessErrorResponse.class)})
    @GetMapping("/breeds")
    public ResponseEntity<List<BreedsModel>> getBreeds() {
        log.info(DATABASE_CREATE);
        return ResponseEntity.status(HttpStatus.OK).body(breedsRepository.findAll());
    }

    @ApiOperation("Trazer o registro no banco de uma raça específica")
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "Busca por raça concluída"),
            @ApiResponse(
                    code = 400,
                    message = "Bad Request",
                    response = BusinessErrorResponse.class)})
    @GetMapping("/cat/breed")
    public ResponseEntity<BreedsModel> getCatForBreed(@ApiParam(value = "Raça do gato", example = "abys", required = true)
                                                                @RequestParam(value = "breed") @Valid String breed) {
        log.info("Relizando a busca do gato pela raça" + breed);
        return ResponseEntity.status(HttpStatus.OK).body(breedsRepository.findByBreed(breed));
    }

    @ApiOperation("Trazer o registro no banco de um temperamento específico")
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "Busca por raça concluída"),
            @ApiResponse(
                    code = 400,
                    message = "Bad Request",
                    response = BusinessErrorResponse.class)})
    @GetMapping("/cat/breed/temperament")
    public ResponseEntity<List<BreedsModel>> getCatTemperament(@ApiParam(value = "Temperamento do gato, pode-se usar somente um dos temperamentos ou todos juntos", example = "Active ou Energetic, Active, Independent, Intelligent, Gentle", required = true)
                                                                @RequestParam(value = "temperament") @Valid String temperament) {
        log.info("Relizando a busca do gato pelo temperamento a seguir: " + temperament);
        return ResponseEntity.status(HttpStatus.OK).body(breedsRepository.findByTemperamentContaining(temperament));
    }

    @ApiOperation("Trazer o registro no banco de uma origem específica")
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "Busca por origem concluída"),
            @ApiResponse(
                    code = 400,
                    message = "Bad Request",
                    response = BusinessErrorResponse.class)})
    @GetMapping("/cat/breed/temperament")
    public ResponseEntity<List<BreedsModel>> getCatOrigin(@ApiParam(value = "Origem do gato", example = "United States ou United Arab Emirates", required = true)
                                                                @RequestParam(value = "origin") @Valid String origin) {
        log.info("Relizando a busca do gato pela origem a seguir: " + origin);
        return ResponseEntity.status(HttpStatus.OK).body(breedsRepository.findByOriginContaining(origin));
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
    @PostMapping("/accessories/insert")
    public ResponseEntity<CatAccessoriesModel> insertAccessories(@RequestBody @Valid CatAccessoriesRequest request) {
        log.info("Insert in database");
        return ResponseEntity.status(HttpStatus.CREATED).body(catAccessoriesRepository.save(request.toEntity()));
    }

}
