package com.example.blog.domain;

import java.util.ArrayList;
import java.util.List;

public class VideoAddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VideoAddressExample() {
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

        public Criteria andVideoidIsNull() {
            addCriterion("videoid is null");
            return (Criteria) this;
        }

        public Criteria andVideoidIsNotNull() {
            addCriterion("videoid is not null");
            return (Criteria) this;
        }

        public Criteria andVideoidEqualTo(Long value) {
            addCriterion("videoid =", value, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidNotEqualTo(Long value) {
            addCriterion("videoid <>", value, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidGreaterThan(Long value) {
            addCriterion("videoid >", value, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidGreaterThanOrEqualTo(Long value) {
            addCriterion("videoid >=", value, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidLessThan(Long value) {
            addCriterion("videoid <", value, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidLessThanOrEqualTo(Long value) {
            addCriterion("videoid <=", value, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidIn(List<Long> values) {
            addCriterion("videoid in", values, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidNotIn(List<Long> values) {
            addCriterion("videoid not in", values, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidBetween(Long value1, Long value2) {
            addCriterion("videoid between", value1, value2, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideoidNotBetween(Long value1, Long value2) {
            addCriterion("videoid not between", value1, value2, "videoid");
            return (Criteria) this;
        }

        public Criteria andVideotagIsNull() {
            addCriterion("videotag is null");
            return (Criteria) this;
        }

        public Criteria andVideotagIsNotNull() {
            addCriterion("videotag is not null");
            return (Criteria) this;
        }

        public Criteria andVideotagEqualTo(String value) {
            addCriterion("videotag =", value, "videotag");
            return (Criteria) this;
        }

        public Criteria andVideotagNotEqualTo(String value) {
            addCriterion("videotag <>", value, "videotag");
            return (Criteria) this;
        }

        public Criteria andVideotagGreaterThan(String value) {
            addCriterion("videotag >", value, "videotag");
            return (Criteria) this;
        }

        public Criteria andVideotagGreaterThanOrEqualTo(String value) {
            addCriterion("videotag >=", value, "videotag");
            return (Criteria) this;
        }

        public Criteria andVideotagLessThan(String value) {
            addCriterion("videotag <", value, "videotag");
            return (Criteria) this;
        }

        public Criteria andVideotagLessThanOrEqualTo(String value) {
            addCriterion("videotag <=", value, "videotag");
            return (Criteria) this;
        }

        public Criteria andVideotagLike(String value) {
            addCriterion("videotag like", value, "videotag");
            return (Criteria) this;
        }

        public Criteria andVideotagNotLike(String value) {
            addCriterion("videotag not like", value, "videotag");
            return (Criteria) this;
        }

        public Criteria andVideotagIn(List<String> values) {
            addCriterion("videotag in", values, "videotag");
            return (Criteria) this;
        }

        public Criteria andVideotagNotIn(List<String> values) {
            addCriterion("videotag not in", values, "videotag");
            return (Criteria) this;
        }

        public Criteria andVideotagBetween(String value1, String value2) {
            addCriterion("videotag between", value1, value2, "videotag");
            return (Criteria) this;
        }

        public Criteria andVideotagNotBetween(String value1, String value2) {
            addCriterion("videotag not between", value1, value2, "videotag");
            return (Criteria) this;
        }

        public Criteria andVideosourceIsNull() {
            addCriterion("videosource is null");
            return (Criteria) this;
        }

        public Criteria andVideosourceIsNotNull() {
            addCriterion("videosource is not null");
            return (Criteria) this;
        }

        public Criteria andVideosourceEqualTo(String value) {
            addCriterion("videosource =", value, "videosource");
            return (Criteria) this;
        }

        public Criteria andVideosourceNotEqualTo(String value) {
            addCriterion("videosource <>", value, "videosource");
            return (Criteria) this;
        }

        public Criteria andVideosourceGreaterThan(String value) {
            addCriterion("videosource >", value, "videosource");
            return (Criteria) this;
        }

        public Criteria andVideosourceGreaterThanOrEqualTo(String value) {
            addCriterion("videosource >=", value, "videosource");
            return (Criteria) this;
        }

        public Criteria andVideosourceLessThan(String value) {
            addCriterion("videosource <", value, "videosource");
            return (Criteria) this;
        }

        public Criteria andVideosourceLessThanOrEqualTo(String value) {
            addCriterion("videosource <=", value, "videosource");
            return (Criteria) this;
        }

        public Criteria andVideosourceLike(String value) {
            addCriterion("videosource like", value, "videosource");
            return (Criteria) this;
        }

        public Criteria andVideosourceNotLike(String value) {
            addCriterion("videosource not like", value, "videosource");
            return (Criteria) this;
        }

        public Criteria andVideosourceIn(List<String> values) {
            addCriterion("videosource in", values, "videosource");
            return (Criteria) this;
        }

        public Criteria andVideosourceNotIn(List<String> values) {
            addCriterion("videosource not in", values, "videosource");
            return (Criteria) this;
        }

        public Criteria andVideosourceBetween(String value1, String value2) {
            addCriterion("videosource between", value1, value2, "videosource");
            return (Criteria) this;
        }

        public Criteria andVideosourceNotBetween(String value1, String value2) {
            addCriterion("videosource not between", value1, value2, "videosource");
            return (Criteria) this;
        }

        public Criteria andVideoaddressIsNull() {
            addCriterion("videoaddress is null");
            return (Criteria) this;
        }

        public Criteria andVideoaddressIsNotNull() {
            addCriterion("videoaddress is not null");
            return (Criteria) this;
        }

        public Criteria andVideoaddressEqualTo(String value) {
            addCriterion("videoaddress =", value, "videoaddress");
            return (Criteria) this;
        }

        public Criteria andVideoaddressNotEqualTo(String value) {
            addCriterion("videoaddress <>", value, "videoaddress");
            return (Criteria) this;
        }

        public Criteria andVideoaddressGreaterThan(String value) {
            addCriterion("videoaddress >", value, "videoaddress");
            return (Criteria) this;
        }

        public Criteria andVideoaddressGreaterThanOrEqualTo(String value) {
            addCriterion("videoaddress >=", value, "videoaddress");
            return (Criteria) this;
        }

        public Criteria andVideoaddressLessThan(String value) {
            addCriterion("videoaddress <", value, "videoaddress");
            return (Criteria) this;
        }

        public Criteria andVideoaddressLessThanOrEqualTo(String value) {
            addCriterion("videoaddress <=", value, "videoaddress");
            return (Criteria) this;
        }

        public Criteria andVideoaddressLike(String value) {
            addCriterion("videoaddress like", value, "videoaddress");
            return (Criteria) this;
        }

        public Criteria andVideoaddressNotLike(String value) {
            addCriterion("videoaddress not like", value, "videoaddress");
            return (Criteria) this;
        }

        public Criteria andVideoaddressIn(List<String> values) {
            addCriterion("videoaddress in", values, "videoaddress");
            return (Criteria) this;
        }

        public Criteria andVideoaddressNotIn(List<String> values) {
            addCriterion("videoaddress not in", values, "videoaddress");
            return (Criteria) this;
        }

        public Criteria andVideoaddressBetween(String value1, String value2) {
            addCriterion("videoaddress between", value1, value2, "videoaddress");
            return (Criteria) this;
        }

        public Criteria andVideoaddressNotBetween(String value1, String value2) {
            addCriterion("videoaddress not between", value1, value2, "videoaddress");
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