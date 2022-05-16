package com.cat.controller;

import com.cat.SwaggerConfig;
import com.cat.exception.BusinessErrorResponse;
import com.cat.model.TypeAccessoriesCat;
import com.cat.service.CatClientFlow;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/v1-cat-api-insert")
@CrossOrigin("*")
@Api(value = "v1-cat-api-insert", tags = {SwaggerConfig.CAT_INSERT_DATABASE_CONTROLLER})
public class CatInsertDatabaseController {

    private static String DATABASE_CREATE = " Inserindo dados no banco de dados";

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
    @PostMapping("/breeds/apiTheCat")
    public ResponseEntity<String> insertBreeds() {
        log.info("[RAÇAS]" + DATABASE_CREATE);
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
    @PostMapping("/sunglasses/apiTheCat")
    public ResponseEntity<String> insertCatSunglasses() {
        log.info("[" + TypeAccessoriesCat.GLASSES.getDescription() + "]" + DATABASE_CREATE);
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
        log.info("[" + TypeAccessoriesCat.HAT.getDescription() + "]" + DATABASE_CREATE);
        return ResponseEntity.status(HttpStatus.CREATED).body(catClientFlow.insertImagesUrlsWithSunglassesOrHats(TypeAccessoriesCat.HAT));
    }
}
