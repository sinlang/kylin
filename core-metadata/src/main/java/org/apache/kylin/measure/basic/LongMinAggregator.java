/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.apache.kylin.measure.basic;

import org.apache.kylin.measure.MeasureAggregator;

/**
 */
@SuppressWarnings("serial")
public class LongMinAggregator extends MeasureAggregator<Long> {

    Long min = null;

    @Override
    public void reset() {
        min = null;
    }

    @Override
    public void aggregate(Long value) {
        if (value != null) {
            if (min == null)
                min = Long.MAX_VALUE;

            min = Math.min(value, min);
        }
    }

    @Override
    public Long aggregate(Long value1, Long value2) {
        if (value1 == null)
            return value2;
        if (value2 == null)
            return value1;

        return Math.min(value1, value2);
    }

    @Override
    public Long getState() {
        return min;
    }

    @Override
    public int getMemBytesEstimate() {
        return guessLongMemBytes();
    }

}
