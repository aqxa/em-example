package com.aqqxa.em.example.query;

import com.aqqxa.em.query.predicate.date.DatePredicate;
import com.aqqxa.em.query.predicate.integer.IntegerPredicate;
import com.aqqxa.em.query.predicate.string.StringPredicate;

import java.util.List;

public class UserQuery {

    private List<StringPredicate> namePredicates;
    private List<IntegerPredicate> heightPredicates;
    private List<DatePredicate> birthdayPredicates;
    private boolean matchAllPredicates;


    public List<StringPredicate> getNamePredicates() {
        return namePredicates;
    }

    public void setNamePredicates(List<StringPredicate> namePredicates) {
        this.namePredicates = namePredicates;
    }

    public List<IntegerPredicate> getHeightPredicates() {
        return heightPredicates;
    }

    public void setHeightPredicates(List<IntegerPredicate> heightPredicates) {
        this.heightPredicates = heightPredicates;
    }

    public List<DatePredicate> getBirthdayPredicates() {
        return birthdayPredicates;
    }

    public void setBirthdayPredicates(List<DatePredicate> birthdayPredicates) {
        this.birthdayPredicates = birthdayPredicates;
    }

    public boolean isMatchAllPredicates() {
        return matchAllPredicates;
    }

    public void setMatchAllPredicates(boolean matchAllPredicates) {
        this.matchAllPredicates = matchAllPredicates;
    }

}
