package com.capgemini.dag9.utility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QueryBuilderUtil {
    private static QueryBuilderUtil queryBuilderUtil;

    private QueryBuilderUtil(){ }

    public static synchronized QueryBuilderUtil getInstance( ) {
        if (queryBuilderUtil == null)
            queryBuilderUtil = new QueryBuilderUtil();
        return queryBuilderUtil;
    }

    public String buildInsertQuery(String table, List<String> fieldsList, List<String> valuesList){
        Stream<String> fieldsStream = fieldsList.stream();
        String fields = fieldsStream
                .collect(Collectors.joining(","));

        Stream<String> valuesStream = valuesList.stream();
        String values = valuesStream
                .collect(Collectors.joining(","));

        String sql = String.format("INSERT INTO %s(%s) VALUES (%s);", table, fields, values);
        return sql;
    }
}
