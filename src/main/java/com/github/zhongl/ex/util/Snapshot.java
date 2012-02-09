package com.github.zhongl.ex.util;

import com.github.zhongl.ex.nio.Closable;

/** @author <a href="mailto:zhong.lunfu@gmail.com">zhongl<a> */
public interface Snapshot<I> extends Closable {
    Snapshot merge(I input);

    void remove();
}