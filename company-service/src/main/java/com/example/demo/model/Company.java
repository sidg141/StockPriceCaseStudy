package com.example.demo.model;


import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ceo")
    private String ceo;
    @Column(name = "about_company")
    private String about;
    @Column(name = "directors")
    private String directors;
    @Column(name = "company_name")
    private String company_name;
    @Column(name = "sector")
    private String sector;
    @Column(name = "is_listed_in_stock")
    private Boolean is_listed_in_stock;
    @Column(name = "se")
    private String se;

    public Company() {
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", ceo='" + ceo + '\'' +
                ", about='" + about + '\'' +
                ", directors='" + directors + '\'' +
                ", company_name='" + company_name + '\'' +
                ", sector='" + sector + '\'' +
                ", is_listed_in_stock=" + is_listed_in_stock +
                ", stock_code='" + se + '\'' +
                '}';
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setIs_listed_in_stock(Boolean is_listed_in_stock) {
        this.is_listed_in_stock = is_listed_in_stock;
    }

    public void setSe(String se) {
        this.se = se;
    }

    public String getAbout() {
        return about;
    }

    public String getDirectors() {
        return directors;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getSector() {
        return sector;
    }

    public Boolean getIs_listed_in_stock() {
        return is_listed_in_stock;
    }

    public String getSe() {
        return se;
    }

    public Company(Long id, String ceo, String about, String directors, String company_name, String sector, Boolean is_listed_in_stock, String se) {
        this.id = id;
        this.ceo = ceo;
        this.about = about;
        this.directors = directors;
        this.company_name = company_name;
        this.sector = sector;
        this.is_listed_in_stock = is_listed_in_stock;
        this.se = se;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
