package models;

import com.ebay.xcelite.annotations.Column;

public class Candidate {

    @Column(name="Name")
    private String name;
    @Column(name="PrivateLink")
    private String privateLink;
    @Column(name="PublicLink")
    private String publicLink;

    public void setPublicLink(String publicLink) {
        this.publicLink = publicLink;
    }

    public String getPublicLink() {
        return publicLink;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrivateLink(String privateLink) {
        this.privateLink = privateLink;
    }

    public String getName() {
        return name;
    }
    public String getPrivateLink() {
        return privateLink;
    }



}
