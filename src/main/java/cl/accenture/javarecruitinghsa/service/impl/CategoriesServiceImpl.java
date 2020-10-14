package cl.accenture.javarecruitinghsa.service.impl;

import org.springframework.stereotype.Service;

import cl.accenture.javarecruitinghsa.pojo.CategoryThree;
import cl.accenture.javarecruitinghsa.service.CategoriesService;

@Service("categoriesService")
public class CategoriesServiceImpl implements CategoriesService{

    @Override
    public CategoryThree getCategoriesService(){

        CategoryThree categoryThree = new CategoryThree();

        return categoryThree;
    }
    
}
