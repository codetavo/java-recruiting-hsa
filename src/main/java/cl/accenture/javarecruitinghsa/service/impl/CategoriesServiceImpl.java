package cl.accenture.javarecruitinghsa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.accenture.javarecruitinghsa.pojo.CategoryThree;
import cl.accenture.javarecruitinghsa.service.CategoriesService;

@Service("categoriesService")
public class CategoriesServiceImpl implements CategoriesService{

    @Autowired
	RestTemplate restTemplate;

    @Override
    public CategoryThree getCategoriesService(){
        CategoryThree categoryThree = new CategoryThree();
        String urlCategories = "http://localhost:8082/categories";
        HttpHeaders headersCategories = new HttpHeaders();
        HttpEntity<?> requestEntityCategories = new HttpEntity<>(headersCategories);
        ResponseEntity<CategoryThree> categoriesAPI = restTemplate.exchange(urlCategories, HttpMethod.GET, requestEntityCategories, CategoryThree.class);
        categoryThree = categoriesAPI.getBody();
        return categoryThree;
    }
    
}
