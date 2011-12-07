/*
 * Copyright 2011 zhongl
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

package com.github.zhongl.ipage;

import java.nio.ByteBuffer;

/** @author <a href="mailto:zhong.lunfu@gmail.com">zhongl<a> */
public class StringAccessor implements ByteBufferAccessor<String> {

    private static final int LENGTH_BYTES = 4;

    @Override
    public int lengthOf(String record) {
        return LENGTH_BYTES + record.length();
    }

    @Override
    public Writer write(final String record) {
        return new Writer() {
            @Override
            public int to(ByteBuffer buffer) {
                buffer.putInt(record.length());
                buffer.put(record.getBytes());
                return lengthOf(record);
            }
        };
    }

    @Override
    public Reader<String> read(final ByteBuffer buffer) {
        return new Reader<String>() {
            @Override
            public String get() {
                int length = buffer.getInt();
                byte[] bytes = new byte[length];
                buffer.get(bytes);
                return new String(bytes);
            }
        };
    }
}