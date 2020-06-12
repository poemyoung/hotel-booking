package com.hotelbooking.hotelbooking.common.domain;

public class Hotels {
    private Integer hotelid;

    private Integer chainid;

    private Integer brandid;

    private String hotelname;

    private String hotelformerlyname;

    private String hoteltranslatedname;

    private String address;

    private Integer zipcode;

    private Double starrating;

    private Double longitude;

    private Double latitude;

    private String checkin;

    private String checkout;

    private Integer numberrooms;

    private Integer numberfloors;

    private Integer yearopened;

    private Integer yearrenovated;

    private String photoone;

    private String phototwo;

    private String photothree;

    private String photofour;

    private String photofive;

    private String overview;

    private Integer minprice;

    private Integer numberofreviews;

    private Double averagerating;

    public Integer getHotelid() {
        return hotelid;
    }

    public void setHotelid(Integer hotelid) {
        this.hotelid = hotelid;
    }

    public Integer getChainid() {
        return chainid;
    }

    public void setChainid(Integer chainid) {
        this.chainid = chainid;
    }

    public Integer getBrandid() {
        return brandid;
    }

    public void setBrandid(Integer brandid) {
        this.brandid = brandid;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname == null ? null : hotelname.trim();
    }

    public String getHotelformerlyname() {
        return hotelformerlyname;
    }

    public void setHotelformerlyname(String hotelformerlyname) {
        this.hotelformerlyname = hotelformerlyname == null ? null : hotelformerlyname.trim();
    }

    public String getHoteltranslatedname() {
        return hoteltranslatedname;
    }

    public void setHoteltranslatedname(String hoteltranslatedname) {
        this.hoteltranslatedname = hoteltranslatedname == null ? null : hoteltranslatedname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public Double getStarrating() {
        return starrating;
    }

    public void setStarrating(Double starrating) {
        this.starrating = starrating;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin == null ? null : checkin.trim();
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout == null ? null : checkout.trim();
    }

    public Integer getNumberrooms() {
        return numberrooms;
    }

    public void setNumberrooms(Integer numberrooms) {
        this.numberrooms = numberrooms;
    }

    public Integer getNumberfloors() {
        return numberfloors;
    }

    public void setNumberfloors(Integer numberfloors) {
        this.numberfloors = numberfloors;
    }

    public Integer getYearopened() {
        return yearopened;
    }

    public void setYearopened(Integer yearopened) {
        this.yearopened = yearopened;
    }

    public Integer getYearrenovated() {
        return yearrenovated;
    }

    public void setYearrenovated(Integer yearrenovated) {
        this.yearrenovated = yearrenovated;
    }

    public String getPhotoone() {
        return photoone;
    }

    public void setPhotoone(String photoone) {
        this.photoone = photoone == null ? null : photoone.trim();
    }

    public String getPhototwo() {
        return phototwo;
    }

    public void setPhototwo(String phototwo) {
        this.phototwo = phototwo == null ? null : phototwo.trim();
    }

    public String getPhotothree() {
        return photothree;
    }

    public void setPhotothree(String photothree) {
        this.photothree = photothree == null ? null : photothree.trim();
    }

    public String getPhotofour() {
        return photofour;
    }

    public void setPhotofour(String photofour) {
        this.photofour = photofour == null ? null : photofour.trim();
    }

    public String getPhotofive() {
        return photofive;
    }

    public void setPhotofive(String photofive) {
        this.photofive = photofive == null ? null : photofive.trim();
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview == null ? null : overview.trim();
    }

    public Integer getMinprice() {
        return minprice;
    }

    public void setMinprice(Integer minprice) {
        this.minprice = minprice;
    }

    public Integer getNumberofreviews() {
        return numberofreviews;
    }

    public void setNumberofreviews(Integer numberofreviews) {
        this.numberofreviews = numberofreviews;
    }

    public Double getAveragerating() {
        return averagerating;
    }

    public void setAveragerating(Double averagerating) {
        this.averagerating = averagerating;
    }

    @Override
    public String toString() {
        return "Hotels{" +
                "hotelid=" + hotelid +
                ", chainid=" + chainid +
                ", brandid=" + brandid +
                ", hotelname='" + hotelname + '\'' +
                ", hotelformerlyname='" + hotelformerlyname + '\'' +
                ", hoteltranslatedname='" + hoteltranslatedname + '\'' +
                ", address='" + address + '\'' +
                ", zipcode=" + zipcode +
                ", starrating=" + starrating +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                ", numberrooms=" + numberrooms +
                ", numberfloors=" + numberfloors +
                ", yearopened=" + yearopened +
                ", yearrenovated=" + yearrenovated +
                ", photoone='" + photoone + '\'' +
                ", phototwo='" + phototwo + '\'' +
                ", photothree='" + photothree + '\'' +
                ", photofour='" + photofour + '\'' +
                ", photofive='" + photofive + '\'' +
                ", overview='" + overview + '\'' +
                ", minprice=" + minprice +
                ", numberofreviews=" + numberofreviews +
                ", averagerating=" + averagerating +
                '}';
    }
}