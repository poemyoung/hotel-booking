package com.wxwl.hotelbooking.common.domain;

import org.springframework.stereotype.Repository;

@Repository
public class HotelResult {
    private Integer hotelid;

    private String chainName;

    private String brandName;

    private String hotelname;

    private String hotelformerlyname;

    public Integer getHotelid() {
        return hotelid;
    }

    public void setHotelid(Integer hotelid) {
        this.hotelid = hotelid;
    }

    public String getChainName() {
        return chainName;
    }

    public void setChainName(String chainName) {
        this.chainName = chainName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getHotelformerlyname() {
        return hotelformerlyname;
    }

    public void setHotelformerlyname(String hotelformerlyname) {
        this.hotelformerlyname = hotelformerlyname;
    }

    public String getHoteltranslatedname() {
        return hoteltranslatedname;
    }

    public void setHoteltranslatedname(String hoteltranslatedname) {
        this.hoteltranslatedname = hoteltranslatedname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
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
        this.photoone = photoone;
    }

    public String getPhototwo() {
        return phototwo;
    }

    public void setPhototwo(String phototwo) {
        this.phototwo = phototwo;
    }

    public String getPhotothree() {
        return photothree;
    }

    public void setPhotothree(String photothree) {
        this.photothree = photothree;
    }

    public String getPhotofour() {
        return photofour;
    }

    public void setPhotofour(String photofour) {
        this.photofour = photofour;
    }

    public String getPhotofive() {
        return photofive;
    }

    public void setPhotofive(String photofive) {
        this.photofive = photofive;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
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

}
