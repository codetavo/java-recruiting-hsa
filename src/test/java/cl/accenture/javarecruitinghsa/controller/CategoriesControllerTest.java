package cl.accenture.javarecruitinghsa.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cl.accenture.javarecruitinghsa.pojo.Categories;
import cl.accenture.javarecruitinghsa.pojo.CategoryThree;
import cl.accenture.javarecruitinghsa.pojo.SubcategoryLevel2;
import cl.accenture.javarecruitinghsa.pojo.SubcategoryLevel3;
import cl.accenture.javarecruitinghsa.pojo.SubcategoryLevel4;
import cl.accenture.javarecruitinghsa.service.CategoriesService;

public class CategoriesControllerTest {

    @Mock
    private CategoriesService categoriesService;
    
    private CategoriesController categoriesController;
    private CategoryThree categoryThree;
    private List<Categories> listSubcategories;
    private Categories subcategories;
    private List<SubcategoryLevel2> listSubcategories2;
    private SubcategoryLevel2 subcategories2;
    private List<SubcategoryLevel3> listSubcategories3;
    private SubcategoryLevel3 subcategories3;
    private List<SubcategoryLevel4> listSubcategories4;
    private SubcategoryLevel4 subcategories4;
    
    @BeforeEach
	public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        subcategories4 = new SubcategoryLevel4();
        subcategories4.setId("id");
        subcategories4.setName("name");
        subcategories4.setRelevance(0);

        listSubcategories4 = new ArrayList<SubcategoryLevel4>();
        listSubcategories4.add(subcategories4);

        subcategories3 = new SubcategoryLevel3();
        subcategories3.setId("id");
        subcategories3.setName("name");
        subcategories3.setRelevance(0);
        subcategories3.setLargeImageUrl("largeImageUrl");
        subcategories3.setMediumImageUrl("mediumImageUrl");
        subcategories3.setSmallImageUrl("smallImageUrl");
        subcategories3.setSubcategories(listSubcategories4);

        listSubcategories3 = new ArrayList<SubcategoryLevel3>();
        listSubcategories3.add(subcategories3);

        subcategories2 = new SubcategoryLevel2();
        subcategories2.setId("id");
        subcategories2.setName("name");
        subcategories2.setRelevance(0);
        subcategories2.setIconImageUrl("iconImageUrl");
        subcategories2.setSubcategories(listSubcategories3);

        listSubcategories2 = new ArrayList<SubcategoryLevel2>();
        listSubcategories2.add(subcategories2);

        subcategories = new Categories();
        subcategories.setId("id");
        subcategories.setName("name");
        subcategories.setRelevance(0);
        subcategories.setSubcategories(listSubcategories2);

        listSubcategories = new ArrayList<Categories>();
        listSubcategories.add(subcategories);

        categoryThree = new CategoryThree();
        categoryThree.setId("id");
        categoryThree.setName("name");
        categoryThree.setRelevance(0);
        categoryThree.setSubcategories(listSubcategories);

        categoriesController = new CategoriesController();
    }

    @Test
    public void getCategoriesCorrecto() throws Exception{
        Mockito.when(categoriesService.getCategoriesService()).thenReturn(categoryThree);
        Whitebox.setInternalState(categoriesController, "categoriesService",categoriesService);
        ResponseEntity<CategoryThree> response = (ResponseEntity<CategoryThree>) categoriesController.getCategories();
        Assertions.assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
    }
    
}
