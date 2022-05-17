package com.cat.controller;

import com.cat.model.BreedsModel;
import com.cat.model.TypeAccessoriesCat;
import com.cat.repository.BreedsRepository;
import com.cat.service.CatClientService;
import lombok.extern.slf4j.Slf4j;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@Slf4j
@ContextConfiguration(classes = {MockServletContext.class})
public class CatInsertDatabaseControllerTest extends AbstractTestNGSpringContextTests {

    @InjectMocks
    private CatInsertDatabaseController controller;

    @Mock
    private BreedsRepository breedsRepository;

    @Mock
    private CatClientService catClientService;

    @Autowired
    private MockServletContext servletContext;

    protected MockMvc mvc;

    @BeforeMethod
    public void beforeMethod() {
        MockitoAnnotations.openMocks(this);
        final GenericWebApplicationContext context = new GenericWebApplicationContext(servletContext);
        context.refresh();
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test(description = "should bring cat determined origin")
    public void insertBreeds() {

        BreedsModel breed = new BreedsModel();
        breed.setBreed("agys");

        when(breedsRepository.findByBreed("agys")).thenReturn(breed);
        when(breedsRepository.findAll()).thenReturn(new ArrayList<>());
        when(catClientService.insertBreed()).thenReturn("Insercao na base de dados concluida");

        var result = controller.insertBreeds().getBody();
        assertNotNull(result);
    }

    @Test(description = "should insert image cat glasses")
    public void insertCatSunglasses() {
        when(catClientService.insertImagesUrlsWithSunglassesOrHats(TypeAccessoriesCat.GLASSES)).thenReturn("Insercao na base de dados concluida");
        var result = controller.insertCatSunglasses().getBody();
        assertNotNull(result);
    }

    @Test(description = "should insert image cat hat")
    public void insertCatHat() {
        when(catClientService.insertImagesUrlsWithSunglassesOrHats(TypeAccessoriesCat.HAT)).thenReturn("Insercao na base de dados concluida");
        var result = controller.insertCatHat().getBody();
        assertNotNull(result);
    }

    @Test(description = "should cleanup database")
    public void databaseCleanup() {
        when(catClientService.databaseCleanup()).thenReturn("Base limpa com sucesso");
        var result = controller.databaseCleanup().getBody();
        assertNotNull(result);
    }

}
