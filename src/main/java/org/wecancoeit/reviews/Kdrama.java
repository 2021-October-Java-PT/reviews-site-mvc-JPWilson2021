package org.wecancoeit.reviews;

public class Kdrama {

    private Long id;
    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public Kdrama(long id, String title, String description) {
        this.id=id;
        this.name =title;
        this.description=description;
    }

}
