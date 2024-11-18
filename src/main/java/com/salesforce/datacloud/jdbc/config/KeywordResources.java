/*
 * Copyright (c) 2024, Salesforce, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.salesforce.datacloud.jdbc.config;

import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import lombok.val;

@UtilityClass
public class KeywordResources {

    // spotless:off
    public static final Set<String> SQL_2003_KEYWORDS = Set.of("ADD","ALL","ALLOCATE","ALTER","AND","ANY","ARE","ARRAY",
            "AS","ASENSITIVE","ASYMMETRIC","AT","ATOMIC","AUTHORIZATION","BEGIN","BETWEEN","BIGINT","BINARY","BLOB",
            "BOOLEAN","BOTH","BY","CALL","CALLED","CASCADED","CASE","CAST","CHAR","CHARACTER","CHECK","CLOB","CLOSE",
            "COLLATE","COLUMN","COMMIT","CONDITION","CONNECT","CONSTRAINT","CONTINUE","CORRESPONDING","CREATE","CROSS",
            "CUBE","CURRENT","CURRENT_DATE","CURRENT_DEFAULT_TRANSFORM_GROUP","CURRENT_PATH","CURRENT_ROLE",
            "CURRENT_TIME","CURRENT_TIMESTAMP","CURRENT_TRANSFORM_GROUP_FOR_TYPE","CURRENT_USER","CURSOR","CYCLE",
            "DATE","DAY","DEALLOCATE","DEC","DECIMAL","DECLARE","DEFAULT","DELETE","DEREF","DESCRIBE","DETERMINISTIC",
            "DISCONNECT","DISTINCT","DO","DOUBLE","DROP","DYNAMIC","EACH","ELEMENT","ELSE","ELSEIF","END","ESCAPE",
            "EXCEPT","EXEC","EXECUTE","EXISTS","EXIT","EXTERNAL","FALSE","FETCH","FILTER","FLOAT","FOR","FOREIGN",
            "FREE","FROM","FULL","FUNCTION","GET","GLOBAL","GRANT","GROUP","GROUPING","HANDLER","HAVING","HOLD","HOUR",
            "IDENTITY","IF","IMMEDIATE","IN","INDICATOR","INNER","INOUT","INPUT","INSENSITIVE","INSERT","INT","INTEGER",
            "INTERSECT","INTERVAL","INTO","IS","ITERATE","JOIN","LANGUAGE","LARGE","LATERAL","LEADING","LEAVE","LEFT",
            "LIKE","LOCAL","LOCALTIME","LOCALTIMESTAMP","LOOP","MATCH","MEMBER","MERGE","METHOD","MINUTE","MODIFIES",
            "MODULE","MONTH","MULTISET","NATIONAL","NATURAL","NCHAR","NCLOB","NEW","NO","NONE","NOT","NULL","NUMERIC",
            "OF","OLD","ON","ONLY","OPEN","OR","ORDER","OUT","OUTER","OUTPUT","OVER","OVERLAPS","PARAMETER","PARTITION",
            "PRECISION","PREPARE","PROCEDURE","RANGE","READS","REAL","RECURSIVE","REF","REFERENCES","REFERENCING",
            "RELEASE","REPEAT","RESIGNAL","RESULT","RETURN","RETURNS","REVOKE","RIGHT","ROLLBACK","ROLLUP","ROW","ROWS",
            "SAVEPOINT","SCOPE","SCROLL","SEARCH","SECOND","SELECT","SENSITIVE","SESSION_USER","SET","SIGNAL","SIMILAR",
            "SMALLINT","SOME","SPECIFIC","SPECIFICTYPE","SQL","SQLEXCEPTION","SQLSTATE","SQLWARNING","START","STATIC",
            "SUBMULTISET","SYMMETRIC","SYSTEM","SYSTEM_USER","TABLE","TABLESAMPLE","THEN","TIME","TIMESTAMP",
            "TIMEZONE_HOUR","TIMEZONE_MINUTE","TO","TRAILING","TRANSLATION","TREAT","TRIGGER","TRUE","UNDO","UNION",
            "UNIQUE","UNKNOWN","UNNEST","UNTIL","UPDATE","USER","USING","VALUE","VALUES","VARCHAR","VARYING","WHEN",
            "WHENEVER","WHERE","WHILE","WINDOW","WITH","WITHIN","WITHOUT","YEAR");
    // spotless:on

    @Getter(lazy = true)
    private final String sqlKeywords = loadSqlKeywords();

    private static String loadSqlKeywords() {
        val hyperSqlLexerKeywords = ResourceReader.readResourceAsStringList("/keywords/hyper_sql_lexer_keywords.txt");
        val difference = hyperSqlLexerKeywords.stream()
                .map(String::toUpperCase)
                .distinct()
                .filter(keyword -> !SQL_2003_KEYWORDS.contains(keyword))
                .sorted()
                .collect(Collectors.toList());
        return String.join(",", difference);
    }
}
