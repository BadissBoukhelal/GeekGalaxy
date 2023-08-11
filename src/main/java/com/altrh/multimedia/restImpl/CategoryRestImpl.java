package com.altrh.multimedia.restImpl;

import com.altrh.multimedia.constents.GeekGalaxyConstants;
import com.altrh.multimedia.models.Category;
import com.altrh.multimedia.rest.CategoryRest;
import com.altrh.multimedia.serviceImpl.CategoryServiceImpl;
import com.altrh.multimedia.utils.GeekGalaxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class CategoryRestImpl implements CategoryRest {
    @Autowired
    CategoryServiceImpl categoryService;
    @Override
    public ResponseEntity<String> addNewCategory(Map<String, String> requestMap) {
        try {
            return categoryService.addNewCategory(requestMap);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return GeekGalaxyUtils.getResponseEntity(GeekGalaxyConstants.SOMTING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<Category>> getAllCategory(String filterValue) {
        try {
            return categoryService.getAllCategory(filterValue);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> updateCategory(Map<String, String> requestMap) {
        try {
            return categoryService.updateCategory(requestMap);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return GeekGalaxyUtils.getResponseEntity(GeekGalaxyConstants.SOMTING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
