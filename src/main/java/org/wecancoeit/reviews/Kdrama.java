package org.wecancoeit.reviews;

public class Kdrama {

    private Long id;
    private String name;
    private String description;
    private String imgUrl;
    private String genre;

    public Long getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String getImgUrl(){return imgUrl;}

    public String getContent(){return genre;}

    public Kdrama(long id, String title, String description, String imgUrl, String genre) {
        this.id=id;
        this.name =title;
        this.description=description;
        this.imgUrl=imgUrl;
        this.genre=genre;

    }

}
