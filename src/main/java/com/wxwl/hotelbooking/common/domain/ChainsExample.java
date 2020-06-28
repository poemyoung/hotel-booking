package com.wxwl.hotelbooking.common.domain;

import java.util.ArrayList;
import java.util.List;

public class ChainsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChainsExample() {
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

        public Criteria andChainidIsNull() {
            addCriterion("chainId is null");
            return (Criteria) this;
        }

        public Criteria andChainidIsNotNull() {
            addCriterion("chainId is not null");
            return (Criteria) this;
        }

        public Criteria andChainidEqualTo(String value) {
            addCriterion("chainId =", value, "chainid");
            return (Criteria) this;
        }

        public Criteria andChainidNotEqualTo(String value) {
            addCriterion("chainId <>", value, "chainid");
            return (Criteria) this;
        }

        public Criteria andChainidGreaterThan(String value) {
            addCriterion("chainId >", value, "chainid");
            return (Criteria) this;
        }

        public Criteria andChainidGreaterThanOrEqualTo(String value) {
            addCriterion("chainId >=", value, "chainid");
            return (Criteria) this;
        }

        public Criteria andChainidLessThan(String value) {
            addCriterion("chainId <", value, "chainid");
            return (Criteria) this;
        }

        public Criteria andChainidLessThanOrEqualTo(String value) {
            addCriterion("chainId <=", value, "chainid");
            return (Criteria) this;
        }

        public Criteria andChainidLike(String value) {
            addCriterion("chainId like", value, "chainid");
            return (Criteria) this;
        }

        public Criteria andChainidNotLike(String value) {
            addCriterion("chainId not like", value, "chainid");
            return (Criteria) this;
        }

        public Criteria andChainidIn(List<String> values) {
            addCriterion("chainId in", values, "chainid");
            return (Criteria) this;
        }

        public Criteria andChainidNotIn(List<String> values) {
            addCriterion("chainId not in", values, "chainid");
            return (Criteria) this;
        }

        public Criteria andChainidBetween(String value1, String value2) {
            addCriterion("chainId between", value1, value2, "chainid");
            return (Criteria) this;
        }

        public Criteria andChainidNotBetween(String value1, String value2) {
            addCriterion("chainId not between", value1, value2, "chainid");
            return (Criteria) this;
        }

        public Criteria andChainnameIsNull() {
            addCriterion("chainName is null");
            return (Criteria) this;
        }

        public Criteria andChainnameIsNotNull() {
            addCriterion("chainName is not null");
            return (Criteria) this;
        }

        public Criteria andChainnameEqualTo(String value) {
            addCriterion("chainName =", value, "chainname");
            return (Criteria) this;
        }

        public Criteria andChainnameNotEqualTo(String value) {
            addCriterion("chainName <>", value, "chainname");
            return (Criteria) this;
        }

        public Criteria andChainnameGreaterThan(String value) {
            addCriterion("chainName >", value, "chainname");
            return (Criteria) this;
        }

        public Criteria andChainnameGreaterThanOrEqualTo(String value) {
            addCriterion("chainName >=", value, "chainname");
            return (Criteria) this;
        }

        public Criteria andChainnameLessThan(String value) {
            addCriterion("chainName <", value, "chainname");
            return (Criteria) this;
        }

        public Criteria andChainnameLessThanOrEqualTo(String value) {
            addCriterion("chainName <=", value, "chainname");
            return (Criteria) this;
        }

        public Criteria andChainnameLike(String value) {
            addCriterion("chainName like", value, "chainname");
            return (Criteria) this;
        }

        public Criteria andChainnameNotLike(String value) {
            addCriterion("chainName not like", value, "chainname");
            return (Criteria) this;
        }

        public Criteria andChainnameIn(List<String> values) {
            addCriterion("chainName in", values, "chainname");
            return (Criteria) this;
        }

        public Criteria andChainnameNotIn(List<String> values) {
            addCriterion("chainName not in", values, "chainname");
            return (Criteria) this;
        }

        public Criteria andChainnameBetween(String value1, String value2) {
            addCriterion("chainName between", value1, value2, "chainname");
            return (Criteria) this;
        }

        public Criteria andChainnameNotBetween(String value1, String value2) {
            addCriterion("chainName not between", value1, value2, "chainname");
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