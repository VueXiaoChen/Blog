package com.example.blog.domain;

import java.util.ArrayList;
import java.util.List;

public class RedisTestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RedisTestExample() {
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

        public Criteria andRedisidIsNull() {
            addCriterion("redisid is null");
            return (Criteria) this;
        }

        public Criteria andRedisidIsNotNull() {
            addCriterion("redisid is not null");
            return (Criteria) this;
        }

        public Criteria andRedisidEqualTo(Integer value) {
            addCriterion("redisid =", value, "redisid");
            return (Criteria) this;
        }

        public Criteria andRedisidNotEqualTo(Integer value) {
            addCriterion("redisid <>", value, "redisid");
            return (Criteria) this;
        }

        public Criteria andRedisidGreaterThan(Integer value) {
            addCriterion("redisid >", value, "redisid");
            return (Criteria) this;
        }

        public Criteria andRedisidGreaterThanOrEqualTo(Integer value) {
            addCriterion("redisid >=", value, "redisid");
            return (Criteria) this;
        }

        public Criteria andRedisidLessThan(Integer value) {
            addCriterion("redisid <", value, "redisid");
            return (Criteria) this;
        }

        public Criteria andRedisidLessThanOrEqualTo(Integer value) {
            addCriterion("redisid <=", value, "redisid");
            return (Criteria) this;
        }

        public Criteria andRedisidIn(List<Integer> values) {
            addCriterion("redisid in", values, "redisid");
            return (Criteria) this;
        }

        public Criteria andRedisidNotIn(List<Integer> values) {
            addCriterion("redisid not in", values, "redisid");
            return (Criteria) this;
        }

        public Criteria andRedisidBetween(Integer value1, Integer value2) {
            addCriterion("redisid between", value1, value2, "redisid");
            return (Criteria) this;
        }

        public Criteria andRedisidNotBetween(Integer value1, Integer value2) {
            addCriterion("redisid not between", value1, value2, "redisid");
            return (Criteria) this;
        }

        public Criteria andLeftIsNull() {
            addCriterion("`left` is null");
            return (Criteria) this;
        }

        public Criteria andLeftIsNotNull() {
            addCriterion("`left` is not null");
            return (Criteria) this;
        }

        public Criteria andLeftEqualTo(Integer value) {
            addCriterion("`left` =", value, "left");
            return (Criteria) this;
        }

        public Criteria andLeftNotEqualTo(Integer value) {
            addCriterion("`left` <>", value, "left");
            return (Criteria) this;
        }

        public Criteria andLeftGreaterThan(Integer value) {
            addCriterion("`left` >", value, "left");
            return (Criteria) this;
        }

        public Criteria andLeftGreaterThanOrEqualTo(Integer value) {
            addCriterion("`left` >=", value, "left");
            return (Criteria) this;
        }

        public Criteria andLeftLessThan(Integer value) {
            addCriterion("`left` <", value, "left");
            return (Criteria) this;
        }

        public Criteria andLeftLessThanOrEqualTo(Integer value) {
            addCriterion("`left` <=", value, "left");
            return (Criteria) this;
        }

        public Criteria andLeftIn(List<Integer> values) {
            addCriterion("`left` in", values, "left");
            return (Criteria) this;
        }

        public Criteria andLeftNotIn(List<Integer> values) {
            addCriterion("`left` not in", values, "left");
            return (Criteria) this;
        }

        public Criteria andLeftBetween(Integer value1, Integer value2) {
            addCriterion("`left` between", value1, value2, "left");
            return (Criteria) this;
        }

        public Criteria andLeftNotBetween(Integer value1, Integer value2) {
            addCriterion("`left` not between", value1, value2, "left");
            return (Criteria) this;
        }

        public Criteria andRigthIsNull() {
            addCriterion("rigth is null");
            return (Criteria) this;
        }

        public Criteria andRigthIsNotNull() {
            addCriterion("rigth is not null");
            return (Criteria) this;
        }

        public Criteria andRigthEqualTo(Integer value) {
            addCriterion("rigth =", value, "rigth");
            return (Criteria) this;
        }

        public Criteria andRigthNotEqualTo(Integer value) {
            addCriterion("rigth <>", value, "rigth");
            return (Criteria) this;
        }

        public Criteria andRigthGreaterThan(Integer value) {
            addCriterion("rigth >", value, "rigth");
            return (Criteria) this;
        }

        public Criteria andRigthGreaterThanOrEqualTo(Integer value) {
            addCriterion("rigth >=", value, "rigth");
            return (Criteria) this;
        }

        public Criteria andRigthLessThan(Integer value) {
            addCriterion("rigth <", value, "rigth");
            return (Criteria) this;
        }

        public Criteria andRigthLessThanOrEqualTo(Integer value) {
            addCriterion("rigth <=", value, "rigth");
            return (Criteria) this;
        }

        public Criteria andRigthIn(List<Integer> values) {
            addCriterion("rigth in", values, "rigth");
            return (Criteria) this;
        }

        public Criteria andRigthNotIn(List<Integer> values) {
            addCriterion("rigth not in", values, "rigth");
            return (Criteria) this;
        }

        public Criteria andRigthBetween(Integer value1, Integer value2) {
            addCriterion("rigth between", value1, value2, "rigth");
            return (Criteria) this;
        }

        public Criteria andRigthNotBetween(Integer value1, Integer value2) {
            addCriterion("rigth not between", value1, value2, "rigth");
            return (Criteria) this;
        }

        public Criteria andTopIsNull() {
            addCriterion("`top` is null");
            return (Criteria) this;
        }

        public Criteria andTopIsNotNull() {
            addCriterion("`top` is not null");
            return (Criteria) this;
        }

        public Criteria andTopEqualTo(Integer value) {
            addCriterion("`top` =", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotEqualTo(Integer value) {
            addCriterion("`top` <>", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopGreaterThan(Integer value) {
            addCriterion("`top` >", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopGreaterThanOrEqualTo(Integer value) {
            addCriterion("`top` >=", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopLessThan(Integer value) {
            addCriterion("`top` <", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopLessThanOrEqualTo(Integer value) {
            addCriterion("`top` <=", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopIn(List<Integer> values) {
            addCriterion("`top` in", values, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotIn(List<Integer> values) {
            addCriterion("`top` not in", values, "top");
            return (Criteria) this;
        }

        public Criteria andTopBetween(Integer value1, Integer value2) {
            addCriterion("`top` between", value1, value2, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotBetween(Integer value1, Integer value2) {
            addCriterion("`top` not between", value1, value2, "top");
            return (Criteria) this;
        }

        public Criteria andBottomIsNull() {
            addCriterion("bottom is null");
            return (Criteria) this;
        }

        public Criteria andBottomIsNotNull() {
            addCriterion("bottom is not null");
            return (Criteria) this;
        }

        public Criteria andBottomEqualTo(Integer value) {
            addCriterion("bottom =", value, "bottom");
            return (Criteria) this;
        }

        public Criteria andBottomNotEqualTo(Integer value) {
            addCriterion("bottom <>", value, "bottom");
            return (Criteria) this;
        }

        public Criteria andBottomGreaterThan(Integer value) {
            addCriterion("bottom >", value, "bottom");
            return (Criteria) this;
        }

        public Criteria andBottomGreaterThanOrEqualTo(Integer value) {
            addCriterion("bottom >=", value, "bottom");
            return (Criteria) this;
        }

        public Criteria andBottomLessThan(Integer value) {
            addCriterion("bottom <", value, "bottom");
            return (Criteria) this;
        }

        public Criteria andBottomLessThanOrEqualTo(Integer value) {
            addCriterion("bottom <=", value, "bottom");
            return (Criteria) this;
        }

        public Criteria andBottomIn(List<Integer> values) {
            addCriterion("bottom in", values, "bottom");
            return (Criteria) this;
        }

        public Criteria andBottomNotIn(List<Integer> values) {
            addCriterion("bottom not in", values, "bottom");
            return (Criteria) this;
        }

        public Criteria andBottomBetween(Integer value1, Integer value2) {
            addCriterion("bottom between", value1, value2, "bottom");
            return (Criteria) this;
        }

        public Criteria andBottomNotBetween(Integer value1, Integer value2) {
            addCriterion("bottom not between", value1, value2, "bottom");
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