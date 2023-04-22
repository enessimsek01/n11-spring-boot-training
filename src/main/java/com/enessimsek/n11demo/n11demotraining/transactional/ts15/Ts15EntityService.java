package com.enessimsek.n11demo.n11demotraining.transactional.ts15;

import com.enessimsek.n11demo.n11demotraining.dao.CategoryDao;
import com.enessimsek.n11demo.n11demotraining.entity.Category;
import jakarta.persistence.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class Ts15EntityService {

    private Map<Long, Category> categoryMap = new LinkedHashMap<>();

    @Autowired
    private CategoryDao categoryDao;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Category findById(Long id){

        Category category = categoryMap.get(id);

        if (category != null){
            return category;
        }

        Optional<Category> optionalCategory = categoryDao.findById(id);

        if (optionalCategory.isPresent()){
            category = optionalCategory.get();
        }

        categoryMap.put(id, category);

        return category;
    }
}
