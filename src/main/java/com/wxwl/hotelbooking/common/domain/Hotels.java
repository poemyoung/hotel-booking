package com.wxwl.hotelbooking.common.domain;

public class Hotels {
    private Integer hotelId;

    private Integer chainId;

    private Integer brandId;

    private String hotelName;

    private String hotelFormerlyName;

    private String hotelTranslatedName;

    private String address;

    private Integer zipcode;

    private Double starRating;

    private Double longitude;

    private Double latitude;

    private String checkin;

    private String checkout;

    private Integer numberRooms;

    private Integer numberFloors;

    private Integer yearOpened;

    private Integer yearRenovated;

    private String photoOne;

    private String photoTwo;

    private String photoThree;

    private String photoFour;

    private String photoFive;

    private String overview;

    private Integer minPrice;

    private Integer numberOfReviews;

    private Double averageRating;

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getChainId() {
        return chainId;
    }

    public void setChainId(Integer chainId) {
        this.chainId = chainId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName == null ? null : hotelName.trim();
    }

    public String getHotelFormerlyName() {
        return hotelFormerlyName;
    }

    public void setHotelFormerlyName(String hotelFormerlyName) {
        this.hotelFormerlyName = hotelFormerlyName == null ? null : hotelFormerlyName.trim();
    }

    public String getHotelTranslatedName() {
        return hotelTranslatedName;
    }

    public void setHotelTranslatedName(String hotelTranslatedName) {
        this.hotelTranslatedName = hotelTranslatedName == null ? null : hotelTranslatedName.trim();
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

    public Double getStarRating() {
        return starRating;
    }

    public void setStarRating(Double starRating) {
        this.starRating = starRating;
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

    public Integer getNumberRooms() {
        return numberRooms;
    }

    public void setNumberRooms(Integer numberRooms) {
        this.numberRooms = numberRooms;
    }

    public Integer getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(Integer numberFloors) {
        this.numberFloors = numberFloors;
    }

    public Integer getYearOpened() {
        return yearOpened;
    }

    public void setYearOpened(Integer yearOpened) {
        this.yearOpened = yearOpened;
    }

    public Integer getYearRenovated() {
        return yearRenovated;
    }

    public void setYearRenovated(Integer yearRenovated) {
        this.yearRenovated = yearRenovated;
    }

    public String getPhotoOne() {
        return photoOne;
    }

    public void setPhotoOne(String photoOne) {
        this.photoOne = photoOne == null ? null : photoOne.trim();
    }

    public String getPhotoTwo() {
        return photoTwo;
    }

    public void setPhotoTwo(String photoTwo) {
        this.photoTwo = photoTwo == null ? null : photoTwo.trim();
    }

    public String getPhotoThree() {
        return photoThree;
    }

    public void setPhotoThree(String photoThree) {
        this.photoThree = photoThree == null ? null : photoThree.trim();
    }

    public String getPhotoFour() {
        return photoFour;
    }

    public void setPhotoFour(String photoFour) {
        this.photoFour = photoFour == null ? null : photoFour.trim();
    }

    public String getPhotoFive() {
        return photoFive;
    }

    public void setPhotoFive(String photoFive) {
        this.photoFive = photoFive == null ? null : photoFive.trim();
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview == null ? null : overview.trim();
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(Integer numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
}