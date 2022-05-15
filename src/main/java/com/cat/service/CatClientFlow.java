package com.cat.service;

import com.cat.dto.BreedsDTO;
import com.cat.dto.CatAccessoriesDTO;
import com.cat.model.BreedsModel;
import com.cat.model.CatAccessoriesModel;
import com.cat.model.TypeAccessoriesCat;
import com.cat.repository.BreedsRepository;
import com.cat.repository.CatAccessoriesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class CatClientFlow {

    private final BreedsRepository breedsRepository;

    private final CatAccessoriesRepository catAccessoriesRepository;

    private final RestTemplate rest;

    @Value("${host.api.thecat}")
    private String hostApiCat;

    public CatClientFlow(BreedsRepository repository, CatAccessoriesRepository catAccessoriesRepository) {

        rest = new RestTemplateBuilder(rt -> rt.getInterceptors().add((request, body, execution) -> {
            request.getHeaders()
                    .add("x-api-key", "d40cdc46-df68-4dac-882d-41353c4d4838");
            return execution.execute(request, body);
        })).build();

        this.breedsRepository = repository;
        this.catAccessoriesRepository = catAccessoriesRepository;
    }

    public List<BreedsDTO> getBreeds() {
        String url = hostApiCat + "breeds";
        return Arrays.asList(Objects.requireNonNull(this.rest.getForObject(url, BreedsDTO[].class)));
    }

    public String insertBreed() {

        var result = getBreeds();
        var listBanco = breedsRepository.findAll();

        var listBreeds = new ArrayList<BreedsModel>();
        if (!result.isEmpty() && listBanco.isEmpty()) {
            result.forEach(breed -> {
                log.info("Iniciando inserção na base de dados");
                BreedsModel model = new BreedsModel();
                model.setOrigin(breed.getOrigin());
                model.setDescription(breed.getDescription());
                model.setTemperament(breed.getTemperament());
                model.setBreed(breed.getBreed());
                model.setPictureUrl(breed.getImage() != null ? breed.getImage().getUrl() : "https://www.pngfind.com/pngs/m/137-1375476_wearing-cat-github-sunglasses-sunscreen-free-transparent-gato.png");
                // não encontrei nenhum que tenha mais de uma imagem, então usei imagens da internet
                model.setPictureUrl2(breed.getImage2() != null ? breed.getImage2() : "https://a-static.mlcdn.com.br/800x560/oculos-de-sol-para-gato-pet-glasses/redemundopetparacambi/28f4aad2221411ec9d954201ac185013/5b53f29cf262ba765eba3accedd9f51c.jpg");
                model.setPictureUrl3(breed.getImage3() != null ? breed.getImage3() : "https://img2.gratispng.com/20180216/cuq/kisspng-cat-kitten-glasses-pet-clip-art-cat-wearing-sunglasses-5a86f3023c1a06.0649140015187934742462.jpg");
                listBreeds.add(model);

            });
            this.breedsRepository.saveAll(listBreeds);
            return "Inserção na base de dados concluída";
        }
        log.info("A inserção na base de dados não pode ser concluida pois já existe os mesmos dados");
        return "Inserção na base não pode ser concluida pois já existe os mesmos dados";
    }

    public List<CatAccessoriesDTO> getImagesCatSunglasses() {
        String url = hostApiCat + "images/search?category_ids={0}&limit={1}";
        return Arrays.asList(Objects.requireNonNull(this.rest.getForObject(url, CatAccessoriesDTO[].class, 4, 3)));
    }

    public List<CatAccessoriesDTO> getImagesCatHats() {
        String url = hostApiCat + "images/search?category_ids={0}&limit={1}";
        return Arrays.asList(Objects.requireNonNull(this.rest.getForObject(url, CatAccessoriesDTO[].class, 1, 3)));
    }

    public String insertImagesUrlsWithSunglassesOrHats(TypeAccessoriesCat typeAccessoriesCat) {

        var result = typeAccessoriesCat == TypeAccessoriesCat.GLASSES ? getImagesCatSunglasses() : getImagesCatHats() ;
        var listBanco = catAccessoriesRepository.findByTypeAccessoriesCat(typeAccessoriesCat.getDescription());

        var listAccessories = new ArrayList<CatAccessoriesModel>();
        if (!result.isEmpty() && listBanco.isEmpty()) {
            result.forEach(accessorie -> {
                log.info("Iniciando inserção na base de dados");
                CatAccessoriesModel model = new CatAccessoriesModel();
                model.setBreed(accessorie.getBreed());
                model.setPictureUrl(accessorie.getImage());
                model.setPictureUrl2(accessorie.getImage2() != null ? accessorie.getImage2() : "https://a-static.mlcdn.com.br/800x560/oculos-de-sol-para-gato-pet-glasses/redemundopetparacambi/28f4aad2221411ec9d954201ac185013/5b53f29cf262ba765eba3accedd9f51c.jpg");
                model.setPictureUrl3(accessorie.getImage3() != null ? accessorie.getImage3() : "https://img2.gratispng.com/20180216/cuq/kisspng-cat-kitten-glasses-pet-clip-art-cat-wearing-sunglasses-5a86f3023c1a06.0649140015187934742462.jpg");
                model.setTypeAccessoriesCat(typeAccessoriesCat.getDescription());
                listAccessories.add(model);
            });
            this.catAccessoriesRepository.saveAll(listAccessories);
            return "Inserção na base de dados concluída";
        }
        log.info("A inserção na base de dados não pode ser concluida pois já existe os mesmos dados");
        return "Inserção na base não pode ser concluida pois já existe os mesmos dados";
    }

}



















