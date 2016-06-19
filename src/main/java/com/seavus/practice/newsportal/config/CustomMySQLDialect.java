package com.seavus.practice.newsportal.config;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * Created by MK on 19.06.2016.
 */
public class CustomMySQLDialect extends MySQL5InnoDBDialect {
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
