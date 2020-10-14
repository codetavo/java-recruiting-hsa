package cl.accenture.javarecruitinghsa.pojo;

import java.util.List;

public class SubcategoryLevel2 {

    private String id;
    private String name;
    private Integer relevance;
    private String iconImageUrl;
    private List<SubcategoryLevel3> subcategories;

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

    public String getIconImageUrl() {
        return iconImageUrl;
    }

    public void setIconImageUrl(String iconImageUrl) {
        this.iconImageUrl = iconImageUrl;
    }

    public List<SubcategoryLevel3> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<SubcategoryLevel3> subcategories) {
        this.subcategories = subcategories;
    }
    
}
