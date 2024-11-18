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

import lombok.Getter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class QueryResources {
    @Getter(lazy = true)
    private final String columnsQuery = loadQuery("get_columns_query");

    @Getter(lazy = true)
    private final String schemasQuery = loadQuery("get_schemas_query");

    @Getter(lazy = true)
    private final String tablesQuery = loadQuery("get_tables_query");

    private static String loadQuery(String name) {
        return ResourceReader.readResourceAsString("/sql/" + name + ".sql");
    }
}
