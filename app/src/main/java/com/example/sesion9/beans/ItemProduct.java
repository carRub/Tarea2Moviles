package com.example.sesion9.beans;

public class ItemProduct {

    private int image;
    private String name;
    private String store;
    private String location;
    private String phone;
    private String description;

    public ItemProduct(){
        this.image = 0;
        this.name = "";
        this.store = "";
        this.location = "";
        this.phone = "";
        this.description = "";
    }

    public ItemProduct(int image, String name, String store, String location,  String phone, String description){
        this.image = image;
        this.name = name;
        this.store = store;
        this.location = location;
        this.phone = phone;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ItemProduct{" +
                "image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", store='" + store + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
