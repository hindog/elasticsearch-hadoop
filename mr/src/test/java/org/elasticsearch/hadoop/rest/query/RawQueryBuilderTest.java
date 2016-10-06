/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.elasticsearch.hadoop.rest.query;

import org.junit.Test;

import java.io.IOException;
import java.util.Random;

import static org.elasticsearch.hadoop.rest.QueryBuilderTestUtils.printQueryBuilder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RawQueryBuilderTest {
    private static Random random = new Random();

    @Test
    public void testEquals() throws IOException {
        for (int i = 0; i < 20; i++) {
            QueryBuilder randomQuery = RandomQueryBuilders.randomQuery(random);
            String queryString = printQueryBuilder(randomQuery, false);

            RawQueryBuilder rawQuery = new RawQueryBuilder(queryString, false);
            String rawQueryString = printQueryBuilder(rawQuery, false);
            assertEquals(queryString, rawQueryString);
            if (randomQuery instanceof RawQueryBuilder) {
                assertEquals(randomQuery, rawQuery);
            } else {
                assertNotEquals(randomQuery, rawQuery);
            }
        }
    }
}