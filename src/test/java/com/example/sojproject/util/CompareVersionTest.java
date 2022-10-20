package com.example.sojproject.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompareVersionTest {

    @Test
    public void shouldReturnValueWhenCompareVersions(){
        Assertions.assertEquals(0, CompareVersion.compare("0.1", "0.1.0"));
        Assertions.assertEquals(0, CompareVersion.compare("1.1.0.1", "1.1.0.1"));
        Assertions.assertEquals(-1, CompareVersion.compare("1.1.0.1", "1.2.0"));
        Assertions.assertEquals(-1, CompareVersion.compare("1.2.0.1", "1.2.0.3"));
        Assertions.assertEquals(-1, CompareVersion.compare("0.1", "1.0"));
        Assertions.assertEquals(-1, CompareVersion.compare("1.1", "2.5"));
        Assertions.assertEquals(1, CompareVersion.compare("1.1.0.1", "1.1.0"));
        Assertions.assertEquals(1, CompareVersion.compare("1.2.0.1", "1.2.0"));
        Assertions.assertEquals(1, CompareVersion.compare("1.0.1", "1.0"));
        Assertions.assertEquals(1, CompareVersion.compare("2.5", "2.4.9"));
    }


}
