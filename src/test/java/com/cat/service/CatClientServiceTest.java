package com.cat.service;

import com.cat.model.BreedsModel;
import com.cat.model.CatAccessoriesModel;
import com.cat.model.TypeAccessoriesCat;
import com.cat.repository.BreedsRepository;
import com.cat.repository.CatAccessoriesRepository;
import com.cat.request.CatAccessoriesRequest;
import lombok.extern.slf4j.Slf4j;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.util.ReflectionTestUtils;
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
public class CatClientServiceTest extends AbstractTestNGSpringContextTests {


    @InjectMocks
    private CatClientService catClientService;

    @Mock
    private CatAccessoriesRepository catAccessoriesRepository;

    @Mock
    private BreedsRepository breedsRepository;

    @Autowired
    private MockServletContext servletContext;

    protected MockMvc mvc;

    private ArrayList<CatAccessoriesModel> catList;

    @BeforeMethod
    public void beforeMethod() {
        MockitoAnnotations.openMocks(this);
        final GenericWebApplicationContext context = new GenericWebApplicationContext(servletContext);
        context.refresh();
        mvc = MockMvcBuilders.standaloneSetup(catClientService).build();
        ReflectionTestUtils.setField(catClientService, "hostApiCat", "https://api.thecatapi.com/v1/");

    }

    @Test
    public void testMockCreation() {
        assertNotNull(catClientService);
    }

    private ArrayList<CatAccessoriesModel> getMockAccessoriesCat() {
        var catList = new ArrayList<CatAccessoriesModel>();
        CatAccessoriesModel catAccessoriesModel = new CatAccessoriesModel();
        catAccessoriesModel.setTypeAccessoriesCat("OCULOS");
        catAccessoriesModel.setPictureUrl("url");
        catAccessoriesModel.setPictureUrl2("url2");
        catAccessoriesModel.setPictureUrl3("url3");
        catAccessoriesModel.setBreed("agys");
        catList.add(catAccessoriesModel);
        return catList;
    }

    @Test(description = "should bring alls race")
    public void getBreeClient() {
        var result = catClientService.getBreeds();
        assertNotNull(result);
        assertEquals("Egypt", result.get(0).getOrigin());
    }


    @Test(description = "should return image cats Sunglasses")
    public void getImagesCatSunglasses() {
        var result = catClientService.getImagesCatSunglasses();
        assertNotNull(result);
    }


    @Test(description = "should return image cats hat")
    public void getImagesCatHats() {
        var result = catClientService.getImagesCatHats();
        assertNotNull(result);
    }

    @Test(description = "should insert images cats glasses in the database")
    public void insertImagesUrlsWithSunglassesSucess() {

        when(catAccessoriesRepository.findByTypeAccessoriesCat(TypeAccessoriesCat.GLASSES.getDescription())).thenReturn(new ArrayList<>());
        var result = catClientService.insertImagesUrlsWithSunglassesOrHats(TypeAccessoriesCat.GLASSES);
        assertNotNull(result);
        assertEquals("Insercao na base de dados concluida", result);
    }

    @Test(description = "should insert images cats glasses in the database")
    public void insertImagesUrlsWithHatsSucess() {
        var catList1 = getMockAccessoriesCat();

        when(catAccessoriesRepository.findByTypeAccessoriesCat(TypeAccessoriesCat.HAT.getDescription())).thenReturn(new ArrayList<>());
        when(catAccessoriesRepository.saveAll(new ArrayList<>())).thenReturn(catList1);

        var result = catClientService.insertImagesUrlsWithSunglassesOrHats(TypeAccessoriesCat.HAT);
        assertNotNull(result);
        assertEquals("Insercao na base de dados concluida", result);
    }

    @Test(description = "should insert breeds in the database")
    public void insertBreed() {

        BreedsModel breed = new BreedsModel();
        breed.setBreed("agys");

        when(breedsRepository.findByBreed("agys")).thenReturn(breed);
        when(breedsRepository.findAll()).thenReturn(new ArrayList<>());

        var result = catClientService.insertBreed();
        assertNotNull(result);
        assertEquals("Insercao na base de dados concluida", result);
    }

}
