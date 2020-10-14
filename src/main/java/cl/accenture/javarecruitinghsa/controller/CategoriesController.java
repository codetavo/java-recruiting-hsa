package cl.accenture.javarecruitinghsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.accenture.javarecruitinghsa.pojo.CategoryThree;
import cl.accenture.javarecruitinghsa.pojo.ErrorResponse;
import cl.accenture.javarecruitinghsa.service.CategoriesService;

@Component("categoriesController")
@RestController
public class CategoriesController {

    @Autowired
    @Qualifier("categoriesService")
    CategoriesService categoriesService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
	public ResponseEntity<?> getCategories() {
        ResponseEntity<?> response = null;
        try{
            CategoryThree categoryThree = new CategoryThree();
            categoryThree = this.categoriesService.getCategoriesService();
            response = new ResponseEntity<CategoryThree>(categoryThree,HttpStatus.OK);
        }catch(Exception e){
            ErrorResponse error = new ErrorResponse();
            error.setCode("500");
            error.setMessage(e.getMessage());
            response = new ResponseEntity<ErrorResponse>(error,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
}
