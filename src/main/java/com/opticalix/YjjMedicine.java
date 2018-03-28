package com.opticalix;

public class YjjMedicine {
    private long id;
    private String approval_number;
    private String product_name;
    private String english_name;
    private String goods_name;
    private String dosage_form;
    private String specification;
    private String production_unit;
    private String production_address;
    private String product_category;
    private String approval_date;
    private String original_approval_number;
    private String drug_code;
    private String drug_code_note;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApproval_number() {
        return approval_number;
    }

    public void setApproval_number(String approval_number) {
        this.approval_number = approval_number;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getEnglish_name() {
        return english_name;
    }

    public void setEnglish_name(String english_name) {
        this.english_name = english_name;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getDosage_form() {
        return dosage_form;
    }

    public void setDosage_form(String dosage_form) {
        this.dosage_form = dosage_form;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getProduction_unit() {
        return production_unit;
    }

    public void setProduction_unit(String production_unit) {
        this.production_unit = production_unit;
    }

    public String getProduction_address() {
        return production_address;
    }

    public void setProduction_address(String production_address) {
        this.production_address = production_address;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public String getApproval_date() {
        return approval_date;
    }

    public void setApproval_date(String approval_date) {
        this.approval_date = approval_date;
    }

    public String getOriginal_approval_number() {
        return original_approval_number;
    }

    public void setOriginal_approval_number(String original_approval_number) {
        this.original_approval_number = original_approval_number;
    }

    public String getDrug_code() {
        return drug_code;
    }

    public void setDrug_code(String drug_code) {
        this.drug_code = drug_code;
    }

    public String getDrug_code_note() {
        return drug_code_note;
    }

    public void setDrug_code_note(String drug_code_note) {
        this.drug_code_note = drug_code_note;
    }

    @Override
    public String toString() {
        return "YjjMedicine{" +
                "id=" + id +
                ", approval_number='" + approval_number + '\'' +
                ", product_name='" + product_name + '\'' +
                ", english_name='" + english_name + '\'' +
                ", goods_name='" + goods_name + '\'' +
                ", dosage_form='" + dosage_form + '\'' +
                ", specification='" + specification + '\'' +
                ", production_unit='" + production_unit + '\'' +
                ", production_address='" + production_address + '\'' +
                ", product_category='" + product_category + '\'' +
                ", approval_date='" + approval_date + '\'' +
                ", original_approval_number='" + original_approval_number + '\'' +
                ", drug_code='" + drug_code + '\'' +
                ", drug_code_note='" + drug_code_note + '\'' +
                '}';
    }
}
