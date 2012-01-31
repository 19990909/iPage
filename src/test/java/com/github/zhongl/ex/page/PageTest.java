package com.github.zhongl.ex.page;

import com.github.zhongl.ex.codec.Codec;
import com.github.zhongl.ex.codec.ComposedCodecBuilder;
import com.github.zhongl.ex.codec.LengthCodec;
import com.github.zhongl.ex.codec.StringCodec;
import com.github.zhongl.util.FileTestContext;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.github.zhongl.ex.page.OverflowCallback.THROW_BY_OVERFLOW;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/** @author <a href="mailto:zhong.lunfu@gmail.com">zhongl<a> */
public class PageTest extends FileTestContext {

    private Page page;

    private Page newPage() throws IOException {
        dir = testDir("fcp");
        Codec codec = ComposedCodecBuilder.compose(new StringCodec())
                                          .with(LengthCodec.class)
                                          .build();
        return new Page(new File(dir, "0"), 0L, 4096, codec) {
            @Override
            protected Batch newBatch(File file, int position, Codec codec, int estimateBufferSize) {
                return new DefaultBatch(file, position, codec, estimateBufferSize);
            }
        };
    }

    @Test
    public void get() throws Exception {
        page = newPage();

        String one = "1";

        Cursor<String> cursor = page.append(one, true, THROW_BY_OVERFLOW);
        assertThat(cursor.get(), is(one));

        page.close();

        assertThat(cursor.get(), is(one));
    }

    @Test(expected = IllegalStateException.class)
    public void getAfterDeleted() throws Exception {
        page = newPage();
        Cursor<String> cursor = page.append("value", true, THROW_BY_OVERFLOW);
        page.file().delete();
        cursor.get();
    }

    @After
    public void tearDown() throws Exception {
        if (page != null) page.close();
    }
}