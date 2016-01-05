package org.sanelib.eboss.common.utils;

import org.junit.Test;
import org.sanelib.eboss.common.properties.AppProperties;

import static org.junit.Assert.assertEquals;

public class ReflectionHelperTest {

    @Test
    public void testSameTypeObjectShouldCopyByReflection() throws Exception {
        AppProperties src = new AppProperties();
        src.setName("Test");
        src.setLocale("EN");
        src.setMessageBundle("yml");
        src.setReleaseDate("2016/01/01");
        src.setVersion("0.0");

        AppProperties dest = new AppProperties();

        ReflectionHelper.copy(src, dest);

        assertEquals(src.getName(), dest.getName());
        assertEquals(src.getLocale(), dest.getLocale());
        assertEquals(src.getMessageBundle(), dest.getMessageBundle());
        assertEquals(src.getReleaseDate(), dest.getReleaseDate());
        assertEquals(src.getVersion(), dest.getVersion());
    }
}
