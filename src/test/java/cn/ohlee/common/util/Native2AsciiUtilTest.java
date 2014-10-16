package cn.ohlee.common.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Created by brody on 14-10-15.
 */
public class Native2AsciiUtilTest {
    /**
     * native string
     * <p>{username:"张三", sex:"man", age:10, phone:"13800138000"}</p>
     */
    private String nativeString = "{username:\"张三\", sex:\"man\", age:10, phone:\"13800138000\"}";
    /**
     * ASCII string
     * <p>{username:"\u5f20\u4e09", sex:"man", age:10, phone:"13800138000"}</p>
     */
    private String asciiString = "{username:\"\\u5f20\\u4e09\", sex:\"man\", age:10, phone:\"13800138000\"}";

    /**
     * Test method for {@link cn.ohlee.common.util.Native2AsciiUtil#native2Ascii(java.lang.String)}.
     * @throws UnsupportedEncodingException
     */
    @Test
    public void testNative2Ascii() throws UnsupportedEncodingException {
        Assert.assertEquals(Native2AsciiUtil.native2Ascii(nativeString), asciiString);
    }

    /**
     * Test method for {@link cn.ohlee.common.util.Native2AsciiUtil#ascii2Native(java.lang.String)}.
     */
    @Test
    public void testAscii2Native() {
        Assert.assertEquals(Native2AsciiUtil.ascii2Native(asciiString), nativeString);
    }
}
