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
package com.salesforce.datacloud.jdbc.util;

import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import lombok.experimental.UtilityClass;
import lombok.val;

@UtilityClass
public class PropertiesExtensions {
    public static Optional<String> optional(Properties properties, String key) {
        if (properties == null) {
            return Optional.empty();
        }

        if (key == null || !properties.containsKey(key)) {
            return Optional.empty();
        }

        val value = properties.getProperty(key);
        return (value == null || StringCompatibility.isBlank(value)) ? Optional.empty() : Optional.of(value);
    }

    public static String required(Properties properties, String key) {
        val result = optional(properties, key);
        if (!result.isPresent()) {
            throw new IllegalArgumentException(Messages.REQUIRED_MISSING_PREFIX + key);
        }
        return result.get();
    }

    public static Properties copy(Properties properties, Set<String> filterKeys) {
        val result = new Properties();
        for (val key : filterKeys) {
            val value = properties.getProperty(key);
            if (value != null) {
                result.setProperty(key, value);
            }
        }
        return result;
    }

    public static Integer getIntegerOrDefault(Properties properties, String key, Integer defaultValue) {
        return optional(properties, key)
                .map(PropertiesExtensions::toIntegerOrNull)
                .orElse(defaultValue);
    }

    public static Integer toIntegerOrNull(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception ex) {
            return null;
        }
    }

    public static Boolean getBooleanOrDefault(Properties properties, String key, Boolean defaultValue) {
        return optional(properties, key)
                .map(PropertiesExtensions::toBooleanOrDefault)
                .orElse(defaultValue);
    }

    public static Boolean toBooleanOrDefault(String s) {
        return Boolean.valueOf(s);
    }

    @UtilityClass
    class Messages {
        static final String REQUIRED_MISSING_PREFIX = "Properties missing required value for key: ";
    }
}
