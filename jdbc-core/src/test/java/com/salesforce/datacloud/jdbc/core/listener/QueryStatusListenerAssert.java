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
package com.salesforce.datacloud.jdbc.core.listener;

import lombok.SneakyThrows;
import org.assertj.core.api.AbstractObjectAssert;
import org.assertj.core.util.Objects;

/** {@link QueryStatusListener} specific assertions - Generated by CustomAssertionGenerator. */
@javax.annotation.Generated(value = "assertj-assertions-generator")
public class QueryStatusListenerAssert extends AbstractObjectAssert<QueryStatusListenerAssert, QueryStatusListener> {

    /**
     * Creates a new <code>{@link QueryStatusListenerAssert}</code> to make assertions on actual QueryStatusListener.
     *
     * @param actual the QueryStatusListener we want to make assertions on.
     */
    public QueryStatusListenerAssert(QueryStatusListener actual) {
        super(actual, QueryStatusListenerAssert.class);
    }

    /**
     * An entry point for QueryStatusListenerAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
     * With a static import, one can write directly: <code>assertThat(myQueryStatusListener)</code> and get specific
     * assertion with code completion.
     *
     * @param actual the QueryStatusListener we want to make assertions on.
     * @return a new <code>{@link QueryStatusListenerAssert}</code>
     */
    @org.assertj.core.util.CheckReturnValue
    public static QueryStatusListenerAssert assertThat(QueryStatusListener actual) {
        return new QueryStatusListenerAssert(actual);
    }

    /**
     * Verifies that the actual QueryStatusListener's query is equal to the given one.
     *
     * @param query the given query to compare the actual QueryStatusListener's query to.
     * @return this assertion object.
     * @throws AssertionError - if the actual QueryStatusListener's query is not equal to the given one.
     */
    public QueryStatusListenerAssert hasQuery(String query) {
        // check that actual QueryStatusListener we want to make assertions on is not null.
        isNotNull();

        // overrides the default error message with a more explicit one
        String assertjErrorMessage = "\nExpecting query of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

        // null safe check
        String actualQuery = actual.getQuery();
        if (!Objects.areEqual(actualQuery, query)) {
            failWithMessage(assertjErrorMessage, actual, query, actualQuery);
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual QueryStatusListener's queryId is equal to the given one.
     *
     * @param queryId the given queryId to compare the actual QueryStatusListener's queryId to.
     * @return this assertion object.
     * @throws AssertionError - if the actual QueryStatusListener's queryId is not equal to the given one.
     */
    public QueryStatusListenerAssert hasQueryId(String queryId) {
        // check that actual QueryStatusListener we want to make assertions on is not null.
        isNotNull();

        // overrides the default error message with a more explicit one
        String assertjErrorMessage = "\nExpecting queryId of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

        // null safe check
        String actualQueryId = actual.getQueryId();
        if (!Objects.areEqual(actualQueryId, queryId)) {
            failWithMessage(assertjErrorMessage, actual, queryId, actualQueryId);
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual QueryStatusListener is ready.
     *
     * @return this assertion object.
     * @throws AssertionError - if the actual QueryStatusListener is not ready.
     */
    @SneakyThrows
    public QueryStatusListenerAssert isReady() {
        // check that actual QueryStatusListener we want to make assertions on is not null.
        isNotNull();

        // check that property call/field access is true
        if (!actual.isReady()) {
            failWithMessage("\nExpecting that actual QueryStatusListener is ready but is not.");
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual QueryStatusListener is not ready.
     *
     * @return this assertion object.
     * @throws AssertionError - if the actual QueryStatusListener is ready.
     */
    @SneakyThrows
    public QueryStatusListenerAssert isNotReady() {
        // check that actual QueryStatusListener we want to make assertions on is not null.
        isNotNull();

        // check that property call/field access is false
        if (actual.isReady()) {
            failWithMessage("\nExpecting that actual QueryStatusListener is not ready but is.");
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual QueryStatusListener's status is equal to the given one.
     *
     * @param status the given status to compare the actual QueryStatusListener's status to.
     * @return this assertion object.
     * @throws AssertionError - if the actual QueryStatusListener's status is not equal to the given one.
     */
    public QueryStatusListenerAssert hasStatus(String status) {
        // check that actual QueryStatusListener we want to make assertions on is not null.
        isNotNull();

        // overrides the default error message with a more explicit one
        String assertjErrorMessage = "\nExpecting status of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

        // null safe check
        String actualStatus = actual.getStatus();
        if (!Objects.areEqual(actualStatus, status)) {
            failWithMessage(assertjErrorMessage, actual, status, actualStatus);
        }

        // return the current assertion for method chaining
        return this;
    }
}
