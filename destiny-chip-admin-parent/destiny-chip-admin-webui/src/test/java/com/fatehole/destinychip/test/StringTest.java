package com.fatehole.destinychip.test;

import com.fatehole.destinychip.util.DestinyChipUtil;
import org.junit.Test;

/**
 * @author FateCat
 * @version 2020-10-07-16:56
 */
public class StringTest {

    @Test
    public void testSource() {
        String source = "23a34342";
        String md5 = DestinyChipUtil.md5(source);
        System.out.println(md5);
    }
}
