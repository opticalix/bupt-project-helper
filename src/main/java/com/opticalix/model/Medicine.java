package com.opticalix.model;

public class Medicine {
    private Long id;
    private String drug_name;
    private String brand;
    private String manufacturer;
    private String license_number;
    private Integer recommend;
    private String drug_form;
    private String type;
    private String drug_type1;
    private String drug_type2;
    private String drug_type3;
    private String prescription_type;
    private String import_type;
    private String drug_specifications;
    private String product_place;
    private String valid_period;
    private String use_for_illness;
    private String use_for_people;
    private String use_function;
    private String dosage_use;
    private String Storage_condition;
    private String product_weight;
    private Double price;
    private Integer hot;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getLicense_number() {
        return license_number;
    }

    public void setLicense_number(String license_number) {
        this.license_number = license_number;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public String getDrug_form() {
        return drug_form;
    }

    public void setDrug_form(String drug_form) {
        this.drug_form = drug_form;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDrug_type1() {
        return drug_type1;
    }

    public void setDrug_type1(String drug_type1) {
        this.drug_type1 = drug_type1;
    }

    public String getDrug_type2() {
        return drug_type2;
    }

    public void setDrug_type2(String drug_type2) {
        this.drug_type2 = drug_type2;
    }

    public String getDrug_type3() {
        return drug_type3;
    }

    public void setDrug_type3(String drug_type3) {
        this.drug_type3 = drug_type3;
    }

    public String getPrescription_type() {
        return prescription_type;
    }

    public void setPrescription_type(String prescription_type) {
        this.prescription_type = prescription_type;
    }

    public String getImport_type() {
        return import_type;
    }

    public void setImport_type(String import_type) {
        this.import_type = import_type;
    }

    public String getDrug_specifications() {
        return drug_specifications;
    }

    public void setDrug_specifications(String drug_specifications) {
        this.drug_specifications = drug_specifications;
    }

    public String getProduct_place() {
        return product_place;
    }

    public void setProduct_place(String product_place) {
        this.product_place = product_place;
    }

    public String getValid_period() {
        return valid_period;
    }

    public void setValid_period(String valid_period) {
        this.valid_period = valid_period;
    }

    public String getUse_for_illness() {
        return use_for_illness;
    }

    public void setUse_for_illness(String use_for_illness) {
        this.use_for_illness = use_for_illness;
    }

    public String getUse_for_people() {
        return use_for_people;
    }

    public void setUse_for_people(String use_for_people) {
        this.use_for_people = use_for_people;
    }

    public String getUse_function() {
        return use_function;
    }

    public void setUse_function(String use_function) {
        this.use_function = use_function;
    }

    public String getDosage_use() {
        return dosage_use;
    }

    public void setDosage_use(String dosage_use) {
        this.dosage_use = dosage_use;
    }

    public String getStorage_condition() {
        return Storage_condition;
    }

    public void setStorage_condition(String storage_condition) {
        Storage_condition = storage_condition;
    }

    public String getProduct_weight() {
        return product_weight;
    }

    public void setProduct_weight(String product_weight) {
        this.product_weight = product_weight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", drug_name='" + drug_name + '\'' +
                ", brand='" + brand + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", license_number='" + license_number + '\'' +
//                ", recommend=" + recommend +
//                ", drug_form='" + drug_form + '\'' +
//                ", type='" + type + '\'' +
//                ", drug_type1='" + drug_type1 + '\'' +
//                ", drug_type2='" + drug_type2 + '\'' +
//                ", drug_type3='" + drug_type3 + '\'' +
//                ", prescription_type='" + prescription_type + '\'' +
//                ", import_type='" + import_type + '\'' +
//                ", drug_specifications='" + drug_specifications + '\'' +
//                ", product_place='" + product_place + '\'' +
//                ", valid_period='" + valid_period + '\'' +
//                ", use_for_illness='" + use_for_illness + '\'' +
//                ", use_for_people='" + use_for_people + '\'' +
//                ", use_function='" + use_function + '\'' +
//                ", dosage_use='" + dosage_use + '\'' +
//                ", Storage_condition='" + Storage_condition + '\'' +
//                ", product_weight='" + product_weight + '\'' +
//                ", price=" + price +
//                ", hot=" + hot +
                '}';
    }
}
