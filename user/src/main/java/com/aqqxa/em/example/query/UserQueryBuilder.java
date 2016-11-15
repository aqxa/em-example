package com.aqqxa.em.example.query;

import com.aqqxa.em.query.predicate.date.*;
import com.aqqxa.em.query.predicate.integer.*;
import com.aqqxa.em.query.predicate.string.*;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserQueryBuilder {

    private List<StringPredicate> namePredicates = new ArrayList<StringPredicate>();
    private List<IntegerPredicate> heightPredicates = new ArrayList<IntegerPredicate>();
    private List<DatePredicate> birthdayPredicates = new ArrayList<DatePredicate>();
    private boolean matchAllPredicates = true;

    private final static String PROPERTY_NAME = "name";
    private final static String PROPERTY_AGE = "height";
    private final static String PROPERTY_BIRTHDAY = "birthday";

    private UserQueryBuilder addNamePredicate(StringPredicate predicate) {
        this.namePredicates.add(predicate);
        return this;
    }

    private UserQueryBuilder addHeightPredicate(IntegerPredicate predicate) {
        this.heightPredicates.add(predicate);
        return this;
    }

    private UserQueryBuilder addBirthdayPredicate(DatePredicate predicate) {
        this.birthdayPredicates.add(predicate);
        return this;
    }

    // =================== matchAllPredicates ===================
    public UserQueryBuilder matchAll() {
        this.matchAllPredicates = true;
        return this;
    }

    public UserQueryBuilder matchAny() {
        this.matchAllPredicates = false;
        return this;
    }

    // =================== name ====================
    public UserQueryBuilder nameIs(String name) {
        return addNamePredicate(StringEqualPredicate.create(PROPERTY_NAME, name));
    }

    public UserQueryBuilder nameNotIs(String name) {
        return addNamePredicate(StringNotEqualPredicate.create(PROPERTY_NAME, name));
    }

    public UserQueryBuilder nameStartsWith(String prefix) {
        return addNamePredicate(StringStartsWithPredicate.create(PROPERTY_NAME, prefix));
    }

    public UserQueryBuilder nameEndsWith(String suffix) {
        return addNamePredicate(StringEndsWithPredicate.create(PROPERTY_NAME, suffix));
    }

    public UserQueryBuilder nameContainsWith(String substring) {
        return addNamePredicate(StringContainsPredicate.create(PROPERTY_NAME, substring));
    }

    public UserQueryBuilder nameNotContainsWith(String substring) {
        return addNamePredicate(StringNotContainsPredicate.create(PROPERTY_NAME, substring));
    }

    public UserQueryBuilder nameIsUnknown() {
        return addNamePredicate(StringUnknownPredicate.create(PROPERTY_NAME));
    }

    public UserQueryBuilder nameIsKnown() {
        return addNamePredicate(StringKnownPredicate.create(PROPERTY_NAME));
    }


    // =================== height ====================
    public UserQueryBuilder heightIs(Integer height) {
        return addHeightPredicate(IntegerEqualPredicate.create(PROPERTY_AGE, height));
    }

    public UserQueryBuilder heightNotIs(Integer height) {
        return addHeightPredicate(IntegerNotEqualPredicate.create(PROPERTY_AGE, height));
    }

    public UserQueryBuilder heightIsGreaterThan(Integer height) {
        return heightIsGreaterThan(height, false);
    }

    public UserQueryBuilder heightIsLessThan(Integer height) {
        return heightIsLessThan(height, false);
    }

    public UserQueryBuilder heightIsGreaterThan(Integer height, boolean withEqual) {
        return addHeightPredicate(IntegerGreaterThanPredicate.create(PROPERTY_AGE, height, withEqual));
    }

    public UserQueryBuilder heightIsLessThan(Integer height, boolean withEqual) {
        return addHeightPredicate(IntegerLessThanPredicate.create(PROPERTY_AGE, height, withEqual));
    }

    public UserQueryBuilder heightIsUnknown() {
        return addHeightPredicate(IntegerUnknownPredicate.create(PROPERTY_AGE));
    }

    public UserQueryBuilder heightIsKnown() {
        return addHeightPredicate(IntegerKnownPredicate.create(PROPERTY_AGE));
    }

    // =================== birthday ====================
    public UserQueryBuilder birthdayOn(Date date) {
        return addBirthdayPredicate(DateEqualPredicate.create(PROPERTY_BIRTHDAY, date));
    }

    public UserQueryBuilder birthdayAfter(Date date) {
        return birthdayAfter(date, false);
    }

    public UserQueryBuilder birthdayBefore(Date date) {
        return birthdayBefore(date, false);
    }

    public UserQueryBuilder birthdayAfter(Date date, boolean withEqual) {
        return addBirthdayPredicate(DateGreaterThanPredicate.create(PROPERTY_BIRTHDAY, date, withEqual));
    }

    public UserQueryBuilder birthdayBefore(Date date, boolean withEqual) {
        return addBirthdayPredicate(DateLessThanPredicate.create(PROPERTY_BIRTHDAY, date, withEqual));
    }

    public UserQueryBuilder birthdayIsUnknown() {
        return addBirthdayPredicate(DateUnknownPredicate.create(PROPERTY_BIRTHDAY));
    }

    public UserQueryBuilder birthdayIsKnown() {
        return addBirthdayPredicate(DateKnownPredicate.create(PROPERTY_BIRTHDAY));
    }

    public UserQueryBuilder birthdayMoreThanAgo(int days) {
        return birthdayBefore(LocalDate.now().minusDays(days).toDate());
    }

    public UserQueryBuilder birthdayLessThanAgo(int days) {
        return birthdayAfter(LocalDate.now().minusDays(days).toDate());
    }

    public UserQueryBuilder birthdayExactlyAgo(int days) {
        LocalDate now = LocalDate.now();
        birthdayBefore(now.minusDays(days - 1).toDate());
        birthdayAfter(now.minusDays(days).toDate());
        return this;
    }

    public UserQuery build() {
        UserQuery query = new UserQuery();
        query.setNamePredicates(namePredicates);
        query.setHeightPredicates(heightPredicates);
        query.setBirthdayPredicates(birthdayPredicates);
        query.setMatchAllPredicates(matchAllPredicates);
        return query;
    }

    public static UserQueryBuilder create(){
        return new UserQueryBuilder();
    }

}
