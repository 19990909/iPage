/*
 * Copyright 2012 zhongl
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.github.zhongl.durable;

import com.github.zhongl.sequence.Cursor;

/** @author <a href="mailto:zhong.lunfu@gmail.com">zhongl<a> */
public class ValueAndNextCursor<T> {
    private final T value;
    private final Cursor next;

    public ValueAndNextCursor(T value, Cursor next) {
        this.next = next;
        this.value = value;
    }

    public T value() {
        return value;
    }

    public Cursor next() {
        return next;
    }
}