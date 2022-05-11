package ru.job4j.course.pojo;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        License second = new License();
        first.setCode("audio");
        second.setCode("audio");
        assertThat(first, is(second));
    }

}