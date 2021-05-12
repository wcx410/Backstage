package com;

import java.util.ArrayList;
import java.util.List;

public class Sys_codesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Sys_codesExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andIDIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIDIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIDEqualTo(Integer value) {
            addCriterion("ID =", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThan(Integer value) {
            addCriterion("ID >", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThan(Integer value) {
            addCriterion("ID <", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDIn(List<Integer> values) {
            addCriterion("ID in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDIsNull() {
            addCriterion("PARENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDIsNotNull() {
            addCriterion("PARENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDEqualTo(Integer value) {
            addCriterion("PARENT_ID =", value, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDNotEqualTo(Integer value) {
            addCriterion("PARENT_ID <>", value, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDGreaterThan(Integer value) {
            addCriterion("PARENT_ID >", value, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDGreaterThanOrEqualTo(Integer value) {
            addCriterion("PARENT_ID >=", value, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDLessThan(Integer value) {
            addCriterion("PARENT_ID <", value, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDLessThanOrEqualTo(Integer value) {
            addCriterion("PARENT_ID <=", value, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDIn(List<Integer> values) {
            addCriterion("PARENT_ID in", values, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDNotIn(List<Integer> values) {
            addCriterion("PARENT_ID not in", values, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDBetween(Integer value1, Integer value2) {
            addCriterion("PARENT_ID between", value1, value2, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDNotBetween(Integer value1, Integer value2) {
            addCriterion("PARENT_ID not between", value1, value2, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andCODE_IDIsNull() {
            addCriterion("CODE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCODE_IDIsNotNull() {
            addCriterion("CODE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCODE_IDEqualTo(String value) {
            addCriterion("CODE_ID =", value, "CODE_ID");
            return (Criteria) this;
        }

        public Criteria andCODE_IDNotEqualTo(String value) {
            addCriterion("CODE_ID <>", value, "CODE_ID");
            return (Criteria) this;
        }

        public Criteria andCODE_IDGreaterThan(String value) {
            addCriterion("CODE_ID >", value, "CODE_ID");
            return (Criteria) this;
        }

        public Criteria andCODE_IDGreaterThanOrEqualTo(String value) {
            addCriterion("CODE_ID >=", value, "CODE_ID");
            return (Criteria) this;
        }

        public Criteria andCODE_IDLessThan(String value) {
            addCriterion("CODE_ID <", value, "CODE_ID");
            return (Criteria) this;
        }

        public Criteria andCODE_IDLessThanOrEqualTo(String value) {
            addCriterion("CODE_ID <=", value, "CODE_ID");
            return (Criteria) this;
        }

        public Criteria andCODE_IDLike(String value) {
            addCriterion("CODE_ID like", value, "CODE_ID");
            return (Criteria) this;
        }

        public Criteria andCODE_IDNotLike(String value) {
            addCriterion("CODE_ID not like", value, "CODE_ID");
            return (Criteria) this;
        }

        public Criteria andCODE_IDIn(List<String> values) {
            addCriterion("CODE_ID in", values, "CODE_ID");
            return (Criteria) this;
        }

        public Criteria andCODE_IDNotIn(List<String> values) {
            addCriterion("CODE_ID not in", values, "CODE_ID");
            return (Criteria) this;
        }

        public Criteria andCODE_IDBetween(String value1, String value2) {
            addCriterion("CODE_ID between", value1, value2, "CODE_ID");
            return (Criteria) this;
        }

        public Criteria andCODE_IDNotBetween(String value1, String value2) {
            addCriterion("CODE_ID not between", value1, value2, "CODE_ID");
            return (Criteria) this;
        }

        public Criteria andNAMEIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNAMEIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNAMEEqualTo(String value) {
            addCriterion("NAME =", value, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMENotEqualTo(String value) {
            addCriterion("NAME <>", value, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMEGreaterThan(String value) {
            addCriterion("NAME >", value, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMEGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMELessThan(String value) {
            addCriterion("NAME <", value, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMELessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMELike(String value) {
            addCriterion("NAME like", value, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMENotLike(String value) {
            addCriterion("NAME not like", value, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMEIn(List<String> values) {
            addCriterion("NAME in", values, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMENotIn(List<String> values) {
            addCriterion("NAME not in", values, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMEBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "NAME");
            return (Criteria) this;
        }

        public Criteria andNAMENotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "NAME");
            return (Criteria) this;
        }

        public Criteria andSTATUSIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andSTATUSIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andSTATUSEqualTo(String value) {
            addCriterion("STATUS =", value, "STATUS");
            return (Criteria) this;
        }

        public Criteria andSTATUSNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "STATUS");
            return (Criteria) this;
        }

        public Criteria andSTATUSGreaterThan(String value) {
            addCriterion("STATUS >", value, "STATUS");
            return (Criteria) this;
        }

        public Criteria andSTATUSGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "STATUS");
            return (Criteria) this;
        }

        public Criteria andSTATUSLessThan(String value) {
            addCriterion("STATUS <", value, "STATUS");
            return (Criteria) this;
        }

        public Criteria andSTATUSLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "STATUS");
            return (Criteria) this;
        }

        public Criteria andSTATUSLike(String value) {
            addCriterion("STATUS like", value, "STATUS");
            return (Criteria) this;
        }

        public Criteria andSTATUSNotLike(String value) {
            addCriterion("STATUS not like", value, "STATUS");
            return (Criteria) this;
        }

        public Criteria andSTATUSIn(List<String> values) {
            addCriterion("STATUS in", values, "STATUS");
            return (Criteria) this;
        }

        public Criteria andSTATUSNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "STATUS");
            return (Criteria) this;
        }

        public Criteria andSTATUSBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "STATUS");
            return (Criteria) this;
        }

        public Criteria andSTATUSNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "STATUS");
            return (Criteria) this;
        }

        public Criteria andDEF_VALUEIsNull() {
            addCriterion("DEF_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andDEF_VALUEIsNotNull() {
            addCriterion("DEF_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andDEF_VALUEEqualTo(String value) {
            addCriterion("DEF_VALUE =", value, "DEF_VALUE");
            return (Criteria) this;
        }

        public Criteria andDEF_VALUENotEqualTo(String value) {
            addCriterion("DEF_VALUE <>", value, "DEF_VALUE");
            return (Criteria) this;
        }

        public Criteria andDEF_VALUEGreaterThan(String value) {
            addCriterion("DEF_VALUE >", value, "DEF_VALUE");
            return (Criteria) this;
        }

        public Criteria andDEF_VALUEGreaterThanOrEqualTo(String value) {
            addCriterion("DEF_VALUE >=", value, "DEF_VALUE");
            return (Criteria) this;
        }

        public Criteria andDEF_VALUELessThan(String value) {
            addCriterion("DEF_VALUE <", value, "DEF_VALUE");
            return (Criteria) this;
        }

        public Criteria andDEF_VALUELessThanOrEqualTo(String value) {
            addCriterion("DEF_VALUE <=", value, "DEF_VALUE");
            return (Criteria) this;
        }

        public Criteria andDEF_VALUELike(String value) {
            addCriterion("DEF_VALUE like", value, "DEF_VALUE");
            return (Criteria) this;
        }

        public Criteria andDEF_VALUENotLike(String value) {
            addCriterion("DEF_VALUE not like", value, "DEF_VALUE");
            return (Criteria) this;
        }

        public Criteria andDEF_VALUEIn(List<String> values) {
            addCriterion("DEF_VALUE in", values, "DEF_VALUE");
            return (Criteria) this;
        }

        public Criteria andDEF_VALUENotIn(List<String> values) {
            addCriterion("DEF_VALUE not in", values, "DEF_VALUE");
            return (Criteria) this;
        }

        public Criteria andDEF_VALUEBetween(String value1, String value2) {
            addCriterion("DEF_VALUE between", value1, value2, "DEF_VALUE");
            return (Criteria) this;
        }

        public Criteria andDEF_VALUENotBetween(String value1, String value2) {
            addCriterion("DEF_VALUE not between", value1, value2, "DEF_VALUE");
            return (Criteria) this;
        }

        public Criteria andDESCNIsNull() {
            addCriterion("DESCN is null");
            return (Criteria) this;
        }

        public Criteria andDESCNIsNotNull() {
            addCriterion("DESCN is not null");
            return (Criteria) this;
        }

        public Criteria andDESCNEqualTo(String value) {
            addCriterion("DESCN =", value, "DESCN");
            return (Criteria) this;
        }

        public Criteria andDESCNNotEqualTo(String value) {
            addCriterion("DESCN <>", value, "DESCN");
            return (Criteria) this;
        }

        public Criteria andDESCNGreaterThan(String value) {
            addCriterion("DESCN >", value, "DESCN");
            return (Criteria) this;
        }

        public Criteria andDESCNGreaterThanOrEqualTo(String value) {
            addCriterion("DESCN >=", value, "DESCN");
            return (Criteria) this;
        }

        public Criteria andDESCNLessThan(String value) {
            addCriterion("DESCN <", value, "DESCN");
            return (Criteria) this;
        }

        public Criteria andDESCNLessThanOrEqualTo(String value) {
            addCriterion("DESCN <=", value, "DESCN");
            return (Criteria) this;
        }

        public Criteria andDESCNLike(String value) {
            addCriterion("DESCN like", value, "DESCN");
            return (Criteria) this;
        }

        public Criteria andDESCNNotLike(String value) {
            addCriterion("DESCN not like", value, "DESCN");
            return (Criteria) this;
        }

        public Criteria andDESCNIn(List<String> values) {
            addCriterion("DESCN in", values, "DESCN");
            return (Criteria) this;
        }

        public Criteria andDESCNNotIn(List<String> values) {
            addCriterion("DESCN not in", values, "DESCN");
            return (Criteria) this;
        }

        public Criteria andDESCNBetween(String value1, String value2) {
            addCriterion("DESCN between", value1, value2, "DESCN");
            return (Criteria) this;
        }

        public Criteria andDESCNNotBetween(String value1, String value2) {
            addCriterion("DESCN not between", value1, value2, "DESCN");
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