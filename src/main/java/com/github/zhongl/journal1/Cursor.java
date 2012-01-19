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

package com.github.zhongl.journal1;

/** @author <a href="mailto:zhong.lunfu@gmail.com">zhongl<a> */
class Cursor {
    private final Object object;
    private final long position;

    public Cursor(Object object, long position) {
        this.object = object;
        this.position = position;
    }

    public long position() {
        return position;
    }

    public Object get() {
        return object;
    }

}
