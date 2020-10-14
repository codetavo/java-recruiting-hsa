package cl.accenture.javarecruitinghsa.pojo;

import java.util.List;

public class CategoryThree {

    private String id;
    private String name;
    private Integer relevance;
    private List<Categories> subcategories;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRelevance() {
        return relevance;
    }

    public void setRelevance(Integer relevance) {
        this.relevance = relevance;
    }

    public List<Categories> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Categories> subcategories) {
        this.subcategories = subcategories;
    }
    
}
