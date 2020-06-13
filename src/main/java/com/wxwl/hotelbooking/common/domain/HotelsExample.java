package com.wxwl.hotelbooking.common.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HotelsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;


    public HotelsExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andHotelidIsNull() {
            addCriterion("hotelId is null");
            return (Criteria) this;
        }

        public Criteria andHotelidIsNotNull() {
            addCriterion("hotelId is not null");
            return (Criteria) this;
        }

        public Criteria andHotelidEqualTo(Integer value) {
            addCriterion("hotelId =", value, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidNotEqualTo(Integer value) {
            addCriterion("hotelId <>", value, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidGreaterThan(Integer value) {
            addCriterion("hotelId >", value, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotelId >=", value, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidLessThan(Integer value) {
            addCriterion("hotelId <", value, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidLessThanOrEqualTo(Integer value) {
            addCriterion("hotelId <=", value, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidIn(List<Integer> values) {
            addCriterion("hotelId in", values, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidNotIn(List<Integer> values) {
            addCriterion("hotelId not in", values, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidBetween(Integer value1, Integer value2) {
            addCriterion("hotelId between", value1, value2, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidNotBetween(Integer value1, Integer value2) {
            addCriterion("hotelId not between", value1, value2, "hotelid");
            return (Criteria) this;
        }

        public Criteria andChainidIsNull() {
            addCriterion("chainId is null");
            return (Criteria) this;
        }

        public Criteria andChainidIsNotNull() {
            addCriterion("chainId is not null");
            return (Criteria) this;
        }

        public Criteria andChainidEqualTo(Integer value) {
            addCriterion("chainId =", value, "chainid");
            return (Criteria) this;
        }

        public Criteria andChainidNotEqualTo(Integer value) {
            addCriterion("chainId <>", value, "chainid");
            return (Criteria) this;
        }

        public Criteria andChainidGreaterThan(Integer value) {
            addCriterion("chainId >", value, "chainid");
            return (Criteria) this;
        }

        public Criteria andChainidGreaterThanOrEqualTo(Integer value) {
            addCriterion("chainId >=", value, "chainid");
            return (Criteria) this;
        }

        public Criteria andChainidLessThan(Integer value) {
            addCriterion("chainId <", value, "chainid");
            return (Criteria) this;
        }

        public Criteria andChainidLessThanOrEqualTo(Integer value) {
            addCriterion("chainId <=", value, "chainid");
            return (Criteria) this;
        }

        public Criteria andChainidIn(List<Integer> values) {
            addCriterion("chainId in", values, "chainid");
            return (Criteria) this;
        }

        public Criteria andChainidNotIn(List<Integer> values) {
            addCriterion("chainId not in", values, "chainid");
            return (Criteria) this;
        }

        public Criteria andChainidBetween(Integer value1, Integer value2) {
            addCriterion("chainId between", value1, value2, "chainid");
            return (Criteria) this;
        }

        public Criteria andChainidNotBetween(Integer value1, Integer value2) {
            addCriterion("chainId not between", value1, value2, "chainid");
            return (Criteria) this;
        }

        public Criteria andBrandidIsNull() {
            addCriterion("brandId is null");
            return (Criteria) this;
        }

        public Criteria andBrandidIsNotNull() {
            addCriterion("brandId is not null");
            return (Criteria) this;
        }

        public Criteria andBrandidEqualTo(Integer value) {
            addCriterion("brandId =", value, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidNotEqualTo(Integer value) {
            addCriterion("brandId <>", value, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidGreaterThan(Integer value) {
            addCriterion("brandId >", value, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidGreaterThanOrEqualTo(Integer value) {
            addCriterion("brandId >=", value, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidLessThan(Integer value) {
            addCriterion("brandId <", value, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidLessThanOrEqualTo(Integer value) {
            addCriterion("brandId <=", value, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidIn(List<Integer> values) {
            addCriterion("brandId in", values, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidNotIn(List<Integer> values) {
            addCriterion("brandId not in", values, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidBetween(Integer value1, Integer value2) {
            addCriterion("brandId between", value1, value2, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidNotBetween(Integer value1, Integer value2) {
            addCriterion("brandId not between", value1, value2, "brandid");
            return (Criteria) this;
        }

        public Criteria andHotelnameIsNull() {
            addCriterion("hotelName is null");
            return (Criteria) this;
        }

        public Criteria andHotelnameIsNotNull() {
            addCriterion("hotelName is not null");
            return (Criteria) this;
        }

        public Criteria andHotelnameEqualTo(String value) {
            addCriterion("hotelName =", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameNotEqualTo(String value) {
            addCriterion("hotelName <>", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameGreaterThan(String value) {
            addCriterion("hotelName >", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameGreaterThanOrEqualTo(String value) {
            addCriterion("hotelName >=", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameLessThan(String value) {
            addCriterion("hotelName <", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameLessThanOrEqualTo(String value) {
            addCriterion("hotelName <=", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameLike(String value) {
            addCriterion("hotelName like", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameNotLike(String value) {
            addCriterion("hotelName not like", value, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameIn(List<String> values) {
            addCriterion("hotelName in", values, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameNotIn(List<String> values) {
            addCriterion("hotelName not in", values, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameBetween(String value1, String value2) {
            addCriterion("hotelName between", value1, value2, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelnameNotBetween(String value1, String value2) {
            addCriterion("hotelName not between", value1, value2, "hotelname");
            return (Criteria) this;
        }

        public Criteria andHotelformerlynameIsNull() {
            addCriterion("hotelFormerlyName is null");
            return (Criteria) this;
        }

        public Criteria andHotelformerlynameIsNotNull() {
            addCriterion("hotelFormerlyName is not null");
            return (Criteria) this;
        }

        public Criteria andHotelformerlynameEqualTo(String value) {
            addCriterion("hotelFormerlyName =", value, "hotelformerlyname");
            return (Criteria) this;
        }

        public Criteria andHotelformerlynameNotEqualTo(String value) {
            addCriterion("hotelFormerlyName <>", value, "hotelformerlyname");
            return (Criteria) this;
        }

        public Criteria andHotelformerlynameGreaterThan(String value) {
            addCriterion("hotelFormerlyName >", value, "hotelformerlyname");
            return (Criteria) this;
        }

        public Criteria andHotelformerlynameGreaterThanOrEqualTo(String value) {
            addCriterion("hotelFormerlyName >=", value, "hotelformerlyname");
            return (Criteria) this;
        }

        public Criteria andHotelformerlynameLessThan(String value) {
            addCriterion("hotelFormerlyName <", value, "hotelformerlyname");
            return (Criteria) this;
        }

        public Criteria andHotelformerlynameLessThanOrEqualTo(String value) {
            addCriterion("hotelFormerlyName <=", value, "hotelformerlyname");
            return (Criteria) this;
        }

        public Criteria andHotelformerlynameLike(String value) {
            addCriterion("hotelFormerlyName like", value, "hotelformerlyname");
            return (Criteria) this;
        }

        public Criteria andHotelformerlynameNotLike(String value) {
            addCriterion("hotelFormerlyName not like", value, "hotelformerlyname");
            return (Criteria) this;
        }

        public Criteria andHotelformerlynameIn(List<String> values) {
            addCriterion("hotelFormerlyName in", values, "hotelformerlyname");
            return (Criteria) this;
        }

        public Criteria andHotelformerlynameNotIn(List<String> values) {
            addCriterion("hotelFormerlyName not in", values, "hotelformerlyname");
            return (Criteria) this;
        }

        public Criteria andHotelformerlynameBetween(String value1, String value2) {
            addCriterion("hotelFormerlyName between", value1, value2, "hotelformerlyname");
            return (Criteria) this;
        }

        public Criteria andHotelformerlynameNotBetween(String value1, String value2) {
            addCriterion("hotelFormerlyName not between", value1, value2, "hotelformerlyname");
            return (Criteria) this;
        }

        public Criteria andHoteltranslatednameIsNull() {
            addCriterion("hotelTranslatedName is null");
            return (Criteria) this;
        }

        public Criteria andHoteltranslatednameIsNotNull() {
            addCriterion("hotelTranslatedName is not null");
            return (Criteria) this;
        }

        public Criteria andHoteltranslatednameEqualTo(String value) {
            addCriterion("hotelTranslatedName =", value, "hoteltranslatedname");
            return (Criteria) this;
        }

        public Criteria andHoteltranslatednameNotEqualTo(String value) {
            addCriterion("hotelTranslatedName <>", value, "hoteltranslatedname");
            return (Criteria) this;
        }

        public Criteria andHoteltranslatednameGreaterThan(String value) {
            addCriterion("hotelTranslatedName >", value, "hoteltranslatedname");
            return (Criteria) this;
        }

        public Criteria andHoteltranslatednameGreaterThanOrEqualTo(String value) {
            addCriterion("hotelTranslatedName >=", value, "hoteltranslatedname");
            return (Criteria) this;
        }

        public Criteria andHoteltranslatednameLessThan(String value) {
            addCriterion("hotelTranslatedName <", value, "hoteltranslatedname");
            return (Criteria) this;
        }

        public Criteria andHoteltranslatednameLessThanOrEqualTo(String value) {
            addCriterion("hotelTranslatedName <=", value, "hoteltranslatedname");
            return (Criteria) this;
        }

        public Criteria andHoteltranslatednameLike(String value) {
            addCriterion("hotelTranslatedName like", value, "hoteltranslatedname");
            return (Criteria) this;
        }

        public Criteria andHoteltranslatednameNotLike(String value) {
            addCriterion("hotelTranslatedName not like", value, "hoteltranslatedname");
            return (Criteria) this;
        }

        public Criteria andHoteltranslatednameIn(List<String> values) {
            addCriterion("hotelTranslatedName in", values, "hoteltranslatedname");
            return (Criteria) this;
        }

        public Criteria andHoteltranslatednameNotIn(List<String> values) {
            addCriterion("hotelTranslatedName not in", values, "hoteltranslatedname");
            return (Criteria) this;
        }

        public Criteria andHoteltranslatednameBetween(String value1, String value2) {
            addCriterion("hotelTranslatedName between", value1, value2, "hoteltranslatedname");
            return (Criteria) this;
        }

        public Criteria andHoteltranslatednameNotBetween(String value1, String value2) {
            addCriterion("hotelTranslatedName not between", value1, value2, "hoteltranslatedname");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andZipcodeIsNull() {
            addCriterion("zipcode is null");
            return (Criteria) this;
        }

        public Criteria andZipcodeIsNotNull() {
            addCriterion("zipcode is not null");
            return (Criteria) this;
        }

        public Criteria andZipcodeEqualTo(Integer value) {
            addCriterion("zipcode =", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotEqualTo(Integer value) {
            addCriterion("zipcode <>", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeGreaterThan(Integer value) {
            addCriterion("zipcode >", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("zipcode >=", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLessThan(Integer value) {
            addCriterion("zipcode <", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLessThanOrEqualTo(Integer value) {
            addCriterion("zipcode <=", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeIn(List<Integer> values) {
            addCriterion("zipcode in", values, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotIn(List<Integer> values) {
            addCriterion("zipcode not in", values, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeBetween(Integer value1, Integer value2) {
            addCriterion("zipcode between", value1, value2, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("zipcode not between", value1, value2, "zipcode");
            return (Criteria) this;
        }

        public Criteria andStarratingIsNull() {
            addCriterion("starRating is null");
            return (Criteria) this;
        }

        public Criteria andStarratingIsNotNull() {
            addCriterion("starRating is not null");
            return (Criteria) this;
        }

        public Criteria andStarratingEqualTo(Double value) {
            addCriterion("starRating =", value, "starrating");
            return (Criteria) this;
        }

        public Criteria andStarratingNotEqualTo(Double value) {
            addCriterion("starRating <>", value, "starrating");
            return (Criteria) this;
        }

        public Criteria andStarratingGreaterThan(Double value) {
            addCriterion("starRating >", value, "starrating");
            return (Criteria) this;
        }

        public Criteria andStarratingGreaterThanOrEqualTo(Double value) {
            addCriterion("starRating >=", value, "starrating");
            return (Criteria) this;
        }

        public Criteria andStarratingLessThan(Double value) {
            addCriterion("starRating <", value, "starrating");
            return (Criteria) this;
        }

        public Criteria andStarratingLessThanOrEqualTo(Double value) {
            addCriterion("starRating <=", value, "starrating");
            return (Criteria) this;
        }

        public Criteria andStarratingIn(List<Double> values) {
            addCriterion("starRating in", values, "starrating");
            return (Criteria) this;
        }

        public Criteria andStarratingNotIn(List<Double> values) {
            addCriterion("starRating not in", values, "starrating");
            return (Criteria) this;
        }

        public Criteria andStarratingBetween(Double value1, Double value2) {
            addCriterion("starRating between", value1, value2, "starrating");
            return (Criteria) this;
        }

        public Criteria andStarratingNotBetween(Double value1, Double value2) {
            addCriterion("starRating not between", value1, value2, "starrating");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(Double value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(Double value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(Double value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(Double value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(Double value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<Double> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<Double> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(Double value1, Double value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(Double value1, Double value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Double value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Double value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Double value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Double value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Double> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Double> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Double value1, Double value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andCheckinIsNull() {
            addCriterion("checkin is null");
            return (Criteria) this;
        }

        public Criteria andCheckinIsNotNull() {
            addCriterion("checkin is not null");
            return (Criteria) this;
        }

        public Criteria andCheckinEqualTo(String value) {
            addCriterion("checkin =", value, "checkin");
            return (Criteria) this;
        }

        public Criteria andCheckinNotEqualTo(String value) {
            addCriterion("checkin <>", value, "checkin");
            return (Criteria) this;
        }

        public Criteria andCheckinGreaterThan(String value) {
            addCriterion("checkin >", value, "checkin");
            return (Criteria) this;
        }

        public Criteria andCheckinGreaterThanOrEqualTo(String value) {
            addCriterion("checkin >=", value, "checkin");
            return (Criteria) this;
        }

        public Criteria andCheckinLessThan(String value) {
            addCriterion("checkin <", value, "checkin");
            return (Criteria) this;
        }

        public Criteria andCheckinLessThanOrEqualTo(String value) {
            addCriterion("checkin <=", value, "checkin");
            return (Criteria) this;
        }

        public Criteria andCheckinLike(String value) {
            addCriterion("checkin like", value, "checkin");
            return (Criteria) this;
        }

        public Criteria andCheckinNotLike(String value) {
            addCriterion("checkin not like", value, "checkin");
            return (Criteria) this;
        }

        public Criteria andCheckinIn(List<String> values) {
            addCriterion("checkin in", values, "checkin");
            return (Criteria) this;
        }

        public Criteria andCheckinNotIn(List<String> values) {
            addCriterion("checkin not in", values, "checkin");
            return (Criteria) this;
        }

        public Criteria andCheckinBetween(String value1, String value2) {
            addCriterion("checkin between", value1, value2, "checkin");
            return (Criteria) this;
        }

        public Criteria andCheckinNotBetween(String value1, String value2) {
            addCriterion("checkin not between", value1, value2, "checkin");
            return (Criteria) this;
        }

        public Criteria andCheckoutIsNull() {
            addCriterion("checkout is null");
            return (Criteria) this;
        }

        public Criteria andCheckoutIsNotNull() {
            addCriterion("checkout is not null");
            return (Criteria) this;
        }

        public Criteria andCheckoutEqualTo(String value) {
            addCriterion("checkout =", value, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutNotEqualTo(String value) {
            addCriterion("checkout <>", value, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutGreaterThan(String value) {
            addCriterion("checkout >", value, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutGreaterThanOrEqualTo(String value) {
            addCriterion("checkout >=", value, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutLessThan(String value) {
            addCriterion("checkout <", value, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutLessThanOrEqualTo(String value) {
            addCriterion("checkout <=", value, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutLike(String value) {
            addCriterion("checkout like", value, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutNotLike(String value) {
            addCriterion("checkout not like", value, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutIn(List<String> values) {
            addCriterion("checkout in", values, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutNotIn(List<String> values) {
            addCriterion("checkout not in", values, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutBetween(String value1, String value2) {
            addCriterion("checkout between", value1, value2, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutNotBetween(String value1, String value2) {
            addCriterion("checkout not between", value1, value2, "checkout");
            return (Criteria) this;
        }

        public Criteria andNumberroomsIsNull() {
            addCriterion("numberRooms is null");
            return (Criteria) this;
        }

        public Criteria andNumberroomsIsNotNull() {
            addCriterion("numberRooms is not null");
            return (Criteria) this;
        }

        public Criteria andNumberroomsEqualTo(Integer value) {
            addCriterion("numberRooms =", value, "numberrooms");
            return (Criteria) this;
        }

        public Criteria andNumberroomsNotEqualTo(Integer value) {
            addCriterion("numberRooms <>", value, "numberrooms");
            return (Criteria) this;
        }

        public Criteria andNumberroomsGreaterThan(Integer value) {
            addCriterion("numberRooms >", value, "numberrooms");
            return (Criteria) this;
        }

        public Criteria andNumberroomsGreaterThanOrEqualTo(Integer value) {
            addCriterion("numberRooms >=", value, "numberrooms");
            return (Criteria) this;
        }

        public Criteria andNumberroomsLessThan(Integer value) {
            addCriterion("numberRooms <", value, "numberrooms");
            return (Criteria) this;
        }

        public Criteria andNumberroomsLessThanOrEqualTo(Integer value) {
            addCriterion("numberRooms <=", value, "numberrooms");
            return (Criteria) this;
        }

        public Criteria andNumberroomsIn(List<Integer> values) {
            addCriterion("numberRooms in", values, "numberrooms");
            return (Criteria) this;
        }

        public Criteria andNumberroomsNotIn(List<Integer> values) {
            addCriterion("numberRooms not in", values, "numberrooms");
            return (Criteria) this;
        }

        public Criteria andNumberroomsBetween(Integer value1, Integer value2) {
            addCriterion("numberRooms between", value1, value2, "numberrooms");
            return (Criteria) this;
        }

        public Criteria andNumberroomsNotBetween(Integer value1, Integer value2) {
            addCriterion("numberRooms not between", value1, value2, "numberrooms");
            return (Criteria) this;
        }

        public Criteria andNumberfloorsIsNull() {
            addCriterion("numberFloors is null");
            return (Criteria) this;
        }

        public Criteria andNumberfloorsIsNotNull() {
            addCriterion("numberFloors is not null");
            return (Criteria) this;
        }

        public Criteria andNumberfloorsEqualTo(Integer value) {
            addCriterion("numberFloors =", value, "numberfloors");
            return (Criteria) this;
        }

        public Criteria andNumberfloorsNotEqualTo(Integer value) {
            addCriterion("numberFloors <>", value, "numberfloors");
            return (Criteria) this;
        }

        public Criteria andNumberfloorsGreaterThan(Integer value) {
            addCriterion("numberFloors >", value, "numberfloors");
            return (Criteria) this;
        }

        public Criteria andNumberfloorsGreaterThanOrEqualTo(Integer value) {
            addCriterion("numberFloors >=", value, "numberfloors");
            return (Criteria) this;
        }

        public Criteria andNumberfloorsLessThan(Integer value) {
            addCriterion("numberFloors <", value, "numberfloors");
            return (Criteria) this;
        }

        public Criteria andNumberfloorsLessThanOrEqualTo(Integer value) {
            addCriterion("numberFloors <=", value, "numberfloors");
            return (Criteria) this;
        }

        public Criteria andNumberfloorsIn(List<Integer> values) {
            addCriterion("numberFloors in", values, "numberfloors");
            return (Criteria) this;
        }

        public Criteria andNumberfloorsNotIn(List<Integer> values) {
            addCriterion("numberFloors not in", values, "numberfloors");
            return (Criteria) this;
        }

        public Criteria andNumberfloorsBetween(Integer value1, Integer value2) {
            addCriterion("numberFloors between", value1, value2, "numberfloors");
            return (Criteria) this;
        }

        public Criteria andNumberfloorsNotBetween(Integer value1, Integer value2) {
            addCriterion("numberFloors not between", value1, value2, "numberfloors");
            return (Criteria) this;
        }

        public Criteria andYearopenedIsNull() {
            addCriterion("yearOpened is null");
            return (Criteria) this;
        }

        public Criteria andYearopenedIsNotNull() {
            addCriterion("yearOpened is not null");
            return (Criteria) this;
        }

        public Criteria andYearopenedEqualTo(Integer value) {
            addCriterion("yearOpened =", value, "yearopened");
            return (Criteria) this;
        }

        public Criteria andYearopenedNotEqualTo(Integer value) {
            addCriterion("yearOpened <>", value, "yearopened");
            return (Criteria) this;
        }

        public Criteria andYearopenedGreaterThan(Integer value) {
            addCriterion("yearOpened >", value, "yearopened");
            return (Criteria) this;
        }

        public Criteria andYearopenedGreaterThanOrEqualTo(Integer value) {
            addCriterion("yearOpened >=", value, "yearopened");
            return (Criteria) this;
        }

        public Criteria andYearopenedLessThan(Integer value) {
            addCriterion("yearOpened <", value, "yearopened");
            return (Criteria) this;
        }

        public Criteria andYearopenedLessThanOrEqualTo(Integer value) {
            addCriterion("yearOpened <=", value, "yearopened");
            return (Criteria) this;
        }

        public Criteria andYearopenedIn(List<Integer> values) {
            addCriterion("yearOpened in", values, "yearopened");
            return (Criteria) this;
        }

        public Criteria andYearopenedNotIn(List<Integer> values) {
            addCriterion("yearOpened not in", values, "yearopened");
            return (Criteria) this;
        }

        public Criteria andYearopenedBetween(Integer value1, Integer value2) {
            addCriterion("yearOpened between", value1, value2, "yearopened");
            return (Criteria) this;
        }

        public Criteria andYearopenedNotBetween(Integer value1, Integer value2) {
            addCriterion("yearOpened not between", value1, value2, "yearopened");
            return (Criteria) this;
        }

        public Criteria andYearrenovatedIsNull() {
            addCriterion("yearRenovated is null");
            return (Criteria) this;
        }

        public Criteria andYearrenovatedIsNotNull() {
            addCriterion("yearRenovated is not null");
            return (Criteria) this;
        }

        public Criteria andYearrenovatedEqualTo(Integer value) {
            addCriterion("yearRenovated =", value, "yearrenovated");
            return (Criteria) this;
        }

        public Criteria andYearrenovatedNotEqualTo(Integer value) {
            addCriterion("yearRenovated <>", value, "yearrenovated");
            return (Criteria) this;
        }

        public Criteria andYearrenovatedGreaterThan(Integer value) {
            addCriterion("yearRenovated >", value, "yearrenovated");
            return (Criteria) this;
        }

        public Criteria andYearrenovatedGreaterThanOrEqualTo(Integer value) {
            addCriterion("yearRenovated >=", value, "yearrenovated");
            return (Criteria) this;
        }

        public Criteria andYearrenovatedLessThan(Integer value) {
            addCriterion("yearRenovated <", value, "yearrenovated");
            return (Criteria) this;
        }

        public Criteria andYearrenovatedLessThanOrEqualTo(Integer value) {
            addCriterion("yearRenovated <=", value, "yearrenovated");
            return (Criteria) this;
        }

        public Criteria andYearrenovatedIn(List<Integer> values) {
            addCriterion("yearRenovated in", values, "yearrenovated");
            return (Criteria) this;
        }

        public Criteria andYearrenovatedNotIn(List<Integer> values) {
            addCriterion("yearRenovated not in", values, "yearrenovated");
            return (Criteria) this;
        }

        public Criteria andYearrenovatedBetween(Integer value1, Integer value2) {
            addCriterion("yearRenovated between", value1, value2, "yearrenovated");
            return (Criteria) this;
        }

        public Criteria andYearrenovatedNotBetween(Integer value1, Integer value2) {
            addCriterion("yearRenovated not between", value1, value2, "yearrenovated");
            return (Criteria) this;
        }

        public Criteria andPhotooneIsNull() {
            addCriterion("photoOne is null");
            return (Criteria) this;
        }

        public Criteria andPhotooneIsNotNull() {
            addCriterion("photoOne is not null");
            return (Criteria) this;
        }

        public Criteria andPhotooneEqualTo(String value) {
            addCriterion("photoOne =", value, "photoone");
            return (Criteria) this;
        }

        public Criteria andPhotooneNotEqualTo(String value) {
            addCriterion("photoOne <>", value, "photoone");
            return (Criteria) this;
        }

        public Criteria andPhotooneGreaterThan(String value) {
            addCriterion("photoOne >", value, "photoone");
            return (Criteria) this;
        }

        public Criteria andPhotooneGreaterThanOrEqualTo(String value) {
            addCriterion("photoOne >=", value, "photoone");
            return (Criteria) this;
        }

        public Criteria andPhotooneLessThan(String value) {
            addCriterion("photoOne <", value, "photoone");
            return (Criteria) this;
        }

        public Criteria andPhotooneLessThanOrEqualTo(String value) {
            addCriterion("photoOne <=", value, "photoone");
            return (Criteria) this;
        }

        public Criteria andPhotooneLike(String value) {
            addCriterion("photoOne like", value, "photoone");
            return (Criteria) this;
        }

        public Criteria andPhotooneNotLike(String value) {
            addCriterion("photoOne not like", value, "photoone");
            return (Criteria) this;
        }

        public Criteria andPhotooneIn(List<String> values) {
            addCriterion("photoOne in", values, "photoone");
            return (Criteria) this;
        }

        public Criteria andPhotooneNotIn(List<String> values) {
            addCriterion("photoOne not in", values, "photoone");
            return (Criteria) this;
        }

        public Criteria andPhotooneBetween(String value1, String value2) {
            addCriterion("photoOne between", value1, value2, "photoone");
            return (Criteria) this;
        }

        public Criteria andPhotooneNotBetween(String value1, String value2) {
            addCriterion("photoOne not between", value1, value2, "photoone");
            return (Criteria) this;
        }

        public Criteria andPhototwoIsNull() {
            addCriterion("photoTwo is null");
            return (Criteria) this;
        }

        public Criteria andPhototwoIsNotNull() {
            addCriterion("photoTwo is not null");
            return (Criteria) this;
        }

        public Criteria andPhototwoEqualTo(String value) {
            addCriterion("photoTwo =", value, "phototwo");
            return (Criteria) this;
        }

        public Criteria andPhototwoNotEqualTo(String value) {
            addCriterion("photoTwo <>", value, "phototwo");
            return (Criteria) this;
        }

        public Criteria andPhototwoGreaterThan(String value) {
            addCriterion("photoTwo >", value, "phototwo");
            return (Criteria) this;
        }

        public Criteria andPhototwoGreaterThanOrEqualTo(String value) {
            addCriterion("photoTwo >=", value, "phototwo");
            return (Criteria) this;
        }

        public Criteria andPhototwoLessThan(String value) {
            addCriterion("photoTwo <", value, "phototwo");
            return (Criteria) this;
        }

        public Criteria andPhototwoLessThanOrEqualTo(String value) {
            addCriterion("photoTwo <=", value, "phototwo");
            return (Criteria) this;
        }

        public Criteria andPhototwoLike(String value) {
            addCriterion("photoTwo like", value, "phototwo");
            return (Criteria) this;
        }

        public Criteria andPhototwoNotLike(String value) {
            addCriterion("photoTwo not like", value, "phototwo");
            return (Criteria) this;
        }

        public Criteria andPhototwoIn(List<String> values) {
            addCriterion("photoTwo in", values, "phototwo");
            return (Criteria) this;
        }

        public Criteria andPhototwoNotIn(List<String> values) {
            addCriterion("photoTwo not in", values, "phototwo");
            return (Criteria) this;
        }

        public Criteria andPhototwoBetween(String value1, String value2) {
            addCriterion("photoTwo between", value1, value2, "phototwo");
            return (Criteria) this;
        }

        public Criteria andPhototwoNotBetween(String value1, String value2) {
            addCriterion("photoTwo not between", value1, value2, "phototwo");
            return (Criteria) this;
        }

        public Criteria andPhotothreeIsNull() {
            addCriterion("photoThree is null");
            return (Criteria) this;
        }

        public Criteria andPhotothreeIsNotNull() {
            addCriterion("photoThree is not null");
            return (Criteria) this;
        }

        public Criteria andPhotothreeEqualTo(String value) {
            addCriterion("photoThree =", value, "photothree");
            return (Criteria) this;
        }

        public Criteria andPhotothreeNotEqualTo(String value) {
            addCriterion("photoThree <>", value, "photothree");
            return (Criteria) this;
        }

        public Criteria andPhotothreeGreaterThan(String value) {
            addCriterion("photoThree >", value, "photothree");
            return (Criteria) this;
        }

        public Criteria andPhotothreeGreaterThanOrEqualTo(String value) {
            addCriterion("photoThree >=", value, "photothree");
            return (Criteria) this;
        }

        public Criteria andPhotothreeLessThan(String value) {
            addCriterion("photoThree <", value, "photothree");
            return (Criteria) this;
        }

        public Criteria andPhotothreeLessThanOrEqualTo(String value) {
            addCriterion("photoThree <=", value, "photothree");
            return (Criteria) this;
        }

        public Criteria andPhotothreeLike(String value) {
            addCriterion("photoThree like", value, "photothree");
            return (Criteria) this;
        }

        public Criteria andPhotothreeNotLike(String value) {
            addCriterion("photoThree not like", value, "photothree");
            return (Criteria) this;
        }

        public Criteria andPhotothreeIn(List<String> values) {
            addCriterion("photoThree in", values, "photothree");
            return (Criteria) this;
        }

        public Criteria andPhotothreeNotIn(List<String> values) {
            addCriterion("photoThree not in", values, "photothree");
            return (Criteria) this;
        }

        public Criteria andPhotothreeBetween(String value1, String value2) {
            addCriterion("photoThree between", value1, value2, "photothree");
            return (Criteria) this;
        }

        public Criteria andPhotothreeNotBetween(String value1, String value2) {
            addCriterion("photoThree not between", value1, value2, "photothree");
            return (Criteria) this;
        }

        public Criteria andPhotofourIsNull() {
            addCriterion("photoFour is null");
            return (Criteria) this;
        }

        public Criteria andPhotofourIsNotNull() {
            addCriterion("photoFour is not null");
            return (Criteria) this;
        }

        public Criteria andPhotofourEqualTo(String value) {
            addCriterion("photoFour =", value, "photofour");
            return (Criteria) this;
        }

        public Criteria andPhotofourNotEqualTo(String value) {
            addCriterion("photoFour <>", value, "photofour");
            return (Criteria) this;
        }

        public Criteria andPhotofourGreaterThan(String value) {
            addCriterion("photoFour >", value, "photofour");
            return (Criteria) this;
        }

        public Criteria andPhotofourGreaterThanOrEqualTo(String value) {
            addCriterion("photoFour >=", value, "photofour");
            return (Criteria) this;
        }

        public Criteria andPhotofourLessThan(String value) {
            addCriterion("photoFour <", value, "photofour");
            return (Criteria) this;
        }

        public Criteria andPhotofourLessThanOrEqualTo(String value) {
            addCriterion("photoFour <=", value, "photofour");
            return (Criteria) this;
        }

        public Criteria andPhotofourLike(String value) {
            addCriterion("photoFour like", value, "photofour");
            return (Criteria) this;
        }

        public Criteria andPhotofourNotLike(String value) {
            addCriterion("photoFour not like", value, "photofour");
            return (Criteria) this;
        }

        public Criteria andPhotofourIn(List<String> values) {
            addCriterion("photoFour in", values, "photofour");
            return (Criteria) this;
        }

        public Criteria andPhotofourNotIn(List<String> values) {
            addCriterion("photoFour not in", values, "photofour");
            return (Criteria) this;
        }

        public Criteria andPhotofourBetween(String value1, String value2) {
            addCriterion("photoFour between", value1, value2, "photofour");
            return (Criteria) this;
        }

        public Criteria andPhotofourNotBetween(String value1, String value2) {
            addCriterion("photoFour not between", value1, value2, "photofour");
            return (Criteria) this;
        }

        public Criteria andPhotofiveIsNull() {
            addCriterion("photoFive is null");
            return (Criteria) this;
        }

        public Criteria andPhotofiveIsNotNull() {
            addCriterion("photoFive is not null");
            return (Criteria) this;
        }

        public Criteria andPhotofiveEqualTo(String value) {
            addCriterion("photoFive =", value, "photofive");
            return (Criteria) this;
        }

        public Criteria andPhotofiveNotEqualTo(String value) {
            addCriterion("photoFive <>", value, "photofive");
            return (Criteria) this;
        }

        public Criteria andPhotofiveGreaterThan(String value) {
            addCriterion("photoFive >", value, "photofive");
            return (Criteria) this;
        }

        public Criteria andPhotofiveGreaterThanOrEqualTo(String value) {
            addCriterion("photoFive >=", value, "photofive");
            return (Criteria) this;
        }

        public Criteria andPhotofiveLessThan(String value) {
            addCriterion("photoFive <", value, "photofive");
            return (Criteria) this;
        }

        public Criteria andPhotofiveLessThanOrEqualTo(String value) {
            addCriterion("photoFive <=", value, "photofive");
            return (Criteria) this;
        }

        public Criteria andPhotofiveLike(String value) {
            addCriterion("photoFive like", value, "photofive");
            return (Criteria) this;
        }

        public Criteria andPhotofiveNotLike(String value) {
            addCriterion("photoFive not like", value, "photofive");
            return (Criteria) this;
        }

        public Criteria andPhotofiveIn(List<String> values) {
            addCriterion("photoFive in", values, "photofive");
            return (Criteria) this;
        }

        public Criteria andPhotofiveNotIn(List<String> values) {
            addCriterion("photoFive not in", values, "photofive");
            return (Criteria) this;
        }

        public Criteria andPhotofiveBetween(String value1, String value2) {
            addCriterion("photoFive between", value1, value2, "photofive");
            return (Criteria) this;
        }

        public Criteria andPhotofiveNotBetween(String value1, String value2) {
            addCriterion("photoFive not between", value1, value2, "photofive");
            return (Criteria) this;
        }

        public Criteria andOverviewIsNull() {
            addCriterion("overview is null");
            return (Criteria) this;
        }

        public Criteria andOverviewIsNotNull() {
            addCriterion("overview is not null");
            return (Criteria) this;
        }

        public Criteria andOverviewEqualTo(String value) {
            addCriterion("overview =", value, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewNotEqualTo(String value) {
            addCriterion("overview <>", value, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewGreaterThan(String value) {
            addCriterion("overview >", value, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewGreaterThanOrEqualTo(String value) {
            addCriterion("overview >=", value, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewLessThan(String value) {
            addCriterion("overview <", value, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewLessThanOrEqualTo(String value) {
            addCriterion("overview <=", value, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewLike(String value) {
            addCriterion("overview like", value, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewNotLike(String value) {
            addCriterion("overview not like", value, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewIn(List<String> values) {
            addCriterion("overview in", values, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewNotIn(List<String> values) {
            addCriterion("overview not in", values, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewBetween(String value1, String value2) {
            addCriterion("overview between", value1, value2, "overview");
            return (Criteria) this;
        }

        public Criteria andOverviewNotBetween(String value1, String value2) {
            addCriterion("overview not between", value1, value2, "overview");
            return (Criteria) this;
        }

        public Criteria andMinpriceIsNull() {
            addCriterion("minPrice is null");
            return (Criteria) this;
        }

        public Criteria andMinpriceIsNotNull() {
            addCriterion("minPrice is not null");
            return (Criteria) this;
        }

        public Criteria andMinpriceEqualTo(Integer value) {
            addCriterion("minPrice =", value, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceNotEqualTo(Integer value) {
            addCriterion("minPrice <>", value, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceGreaterThan(Integer value) {
            addCriterion("minPrice >", value, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("minPrice >=", value, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceLessThan(Integer value) {
            addCriterion("minPrice <", value, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceLessThanOrEqualTo(Integer value) {
            addCriterion("minPrice <=", value, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceIn(List<Integer> values) {
            addCriterion("minPrice in", values, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceNotIn(List<Integer> values) {
            addCriterion("minPrice not in", values, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceBetween(Integer value1, Integer value2) {
            addCriterion("minPrice between", value1, value2, "minprice");
            return (Criteria) this;
        }

        public Criteria andMinpriceNotBetween(Integer value1, Integer value2) {
            addCriterion("minPrice not between", value1, value2, "minprice");
            return (Criteria) this;
        }

        public Criteria andNumberofreviewsIsNull() {
            addCriterion("numberOfReviews is null");
            return (Criteria) this;
        }

        public Criteria andNumberofreviewsIsNotNull() {
            addCriterion("numberOfReviews is not null");
            return (Criteria) this;
        }

        public Criteria andNumberofreviewsEqualTo(Integer value) {
            addCriterion("numberOfReviews =", value, "numberofreviews");
            return (Criteria) this;
        }

        public Criteria andNumberofreviewsNotEqualTo(Integer value) {
            addCriterion("numberOfReviews <>", value, "numberofreviews");
            return (Criteria) this;
        }

        public Criteria andNumberofreviewsGreaterThan(Integer value) {
            addCriterion("numberOfReviews >", value, "numberofreviews");
            return (Criteria) this;
        }

        public Criteria andNumberofreviewsGreaterThanOrEqualTo(Integer value) {
            addCriterion("numberOfReviews >=", value, "numberofreviews");
            return (Criteria) this;
        }

        public Criteria andNumberofreviewsLessThan(Integer value) {
            addCriterion("numberOfReviews <", value, "numberofreviews");
            return (Criteria) this;
        }

        public Criteria andNumberofreviewsLessThanOrEqualTo(Integer value) {
            addCriterion("numberOfReviews <=", value, "numberofreviews");
            return (Criteria) this;
        }

        public Criteria andNumberofreviewsIn(List<Integer> values) {
            addCriterion("numberOfReviews in", values, "numberofreviews");
            return (Criteria) this;
        }

        public Criteria andNumberofreviewsNotIn(List<Integer> values) {
            addCriterion("numberOfReviews not in", values, "numberofreviews");
            return (Criteria) this;
        }

        public Criteria andNumberofreviewsBetween(Integer value1, Integer value2) {
            addCriterion("numberOfReviews between", value1, value2, "numberofreviews");
            return (Criteria) this;
        }

        public Criteria andNumberofreviewsNotBetween(Integer value1, Integer value2) {
            addCriterion("numberOfReviews not between", value1, value2, "numberofreviews");
            return (Criteria) this;
        }

        public Criteria andAverageratingIsNull() {
            addCriterion("averageRating is null");
            return (Criteria) this;
        }

        public Criteria andAverageratingIsNotNull() {
            addCriterion("averageRating is not null");
            return (Criteria) this;
        }

        public Criteria andAverageratingEqualTo(Double value) {
            addCriterion("averageRating =", value, "averagerating");
            return (Criteria) this;
        }

        public Criteria andAverageratingNotEqualTo(Double value) {
            addCriterion("averageRating <>", value, "averagerating");
            return (Criteria) this;
        }

        public Criteria andAverageratingGreaterThan(Double value) {
            addCriterion("averageRating >", value, "averagerating");
            return (Criteria) this;
        }

        public Criteria andAverageratingGreaterThanOrEqualTo(Double value) {
            addCriterion("averageRating >=", value, "averagerating");
            return (Criteria) this;
        }

        public Criteria andAverageratingLessThan(Double value) {
            addCriterion("averageRating <", value, "averagerating");
            return (Criteria) this;
        }

        public Criteria andAverageratingLessThanOrEqualTo(Double value) {
            addCriterion("averageRating <=", value, "averagerating");
            return (Criteria) this;
        }

        public Criteria andAverageratingIn(List<Double> values) {
            addCriterion("averageRating in", values, "averagerating");
            return (Criteria) this;
        }

        public Criteria andAverageratingNotIn(List<Double> values) {
            addCriterion("averageRating not in", values, "averagerating");
            return (Criteria) this;
        }

        public Criteria andAverageratingBetween(Double value1, Double value2) {
            addCriterion("averageRating between", value1, value2, "averagerating");
            return (Criteria) this;
        }

        public Criteria andAverageratingNotBetween(Double value1, Double value2) {
            addCriterion("averageRating not between", value1, value2, "averagerating");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}