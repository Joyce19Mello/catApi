package com.cat.controller;

import com.cat.model.BreedsModel;
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
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Slf4j
@ContextConfiguration(classes = {MockServletContext.class})
public class CatControllerTest extends AbstractTestNGSpringContextTests {

    @InjectMocks
    private CatController controller;

    @Mock
    private BreedsRepository breedsRepository;

    @InjectMocks
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

    @Test
    public void testMockCreation() {
        assertNotNull(breedsRepository);
    }

    public List<BreedsModel> mockBreeds() {
        var list = new ArrayList<BreedsModel>();
        list.add(new BreedsModel(1L, "EUR", "HAPPY", "agys", "", "", "", ""));
        list.add(new BreedsModel(1L, "EUR", "HAPPY", "agys", "", "", "", ""));
        list.add(new BreedsModel(1L, "EUR", "HAPPY", "agys", "", "", "", ""));
        list.add(new BreedsModel(1L, "EUR", "BAD", "aege", "", "", "", ""));
        list.add(new BreedsModel(1L, "Greece", "BAD", "aege", "", "url", "", ""));
        list.add(new BreedsModel(1L, "Greece", "BAD", "aege", "", "url", "", ""));

        return list;
    }

    @Test(description = "should bring alls race")
    public void findAllBreeds() {

        var list = mockBreeds();

        log.info("testFindAll() – findAll() to return " + list);
        when(breedsRepository.findAll()).thenReturn(list);

        log.info("testFindAll() – findAll() calling");
        List<BreedsModel> result = breedsRepository.findAll();

        log.info("testFindAll() – Verifying findAll() is called at least once");
        verify(breedsRepository, atLeastOnce()).findAll();

        var resultController = controller.getBreeds().getBody();

        log.info("testFindAll() – Asserting that the result is not null or empty");
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(result, resultController);
    }

    @Test(description = "should bring determined race")
    public void getCatBreed() {
        var list = mockBreeds().get(0);
        when(breedsRepository.findByBreed("agys")).thenReturn(list);
        var resultController = controller.getCatBreed("agys");
        assertNotNull(resultController);
        assertEquals("HAPPY", Objects.requireNonNull(resultController.getBody()).getTemperament());
    }

    @Test(description = "should bring cat determined temperament ")
    public void getCatTemperament() {
        var list = mockBreeds();
        when(breedsRepository.findByTemperamentContaining("BAD")).thenReturn(list.stream()
                .filter(x -> Objects.equals(x.getTemperament(), "BAD"))
                .collect(Collectors.toList()));
        var resultController = Objects.requireNonNull(controller.getCatTemperament("BAD").getBody()).get(0);
        assertNotNull(resultController);
        assertEquals("BAD", Objects.requireNonNull(resultController).getTemperament());
    }

    @Test(description = "should bring cat determined origin")
    public void getCatOrigin() {
        var list = mockBreeds();
        when(breedsRepository.findByOriginContaining("Greece")).thenReturn(list.stream()
                .filter(x -> Objects.equals(x.getOrigin(), "Greece"))
                .collect(Collectors.toList()));
        var resultController = Objects.requireNonNull(controller.getCatOrigin("Greece").getBody()).get(0);
        assertNotNull(resultController);
        assertEquals("url", Objects.requireNonNull(resultController).getPictureUrl2());
    }


}
