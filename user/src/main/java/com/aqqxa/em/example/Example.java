package com.aqqxa.em.example;

import com.aqqxa.em.example.query.UserQuery;
import com.aqqxa.em.example.query.UserQueryBuilder;
import org.joda.time.DateTime;

public class Example {

    public static void main(String[] args) {

        // 姓名：张三、身高：180、生日在 1950 年 5 月内
        DateTime may1950 = DateTime.parse("1950-05");
        DateTime june1950 = may1950.plusMonths(1);
        UserQuery qo = UserQueryBuilder.create()
                .nameIs("张三")
                .heightIs(180)
                .birthdayAfter(may1950.toDate())
                .birthdayBefore(june1950.toDate())
                .build();

        // 姓名：未知、身高：未知
        qo = UserQueryBuilder.create()
                .nameIsUnknown()
                .heightIsKnown()
                .build();

        // 身高：160 ~ 180
        qo = UserQueryBuilder.create()
                .heightIsGreaterThan(160, true)
                .heightIsLessThan(180, true)
                .build();

        // 姓名：张三 或 李四、身高：未知
        qo = UserQueryBuilder.create()
                .nameIs("张三")
                .nameIs("李四")
                .heightIsUnknown()
                .matchAny()
                .build();

    }
}
