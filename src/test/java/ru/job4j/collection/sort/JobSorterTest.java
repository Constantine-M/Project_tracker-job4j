package ru.job4j.collection.sort;

import org.junit.Test;

import java.util.Comparator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class JobSorterTest {
    @Test
    public void whenJobAscByName() {
        Comparator<Job> cmpJobAscName = new JobAscByName();
        int rsl = cmpJobAscName.compare(
                new Job("Fix bug", 0),
                new Job(("Reboot server"), 1)
        );
        assertThat(rsl,lessThan(0));
    }

    @Test
    public void whenJobAscByPriority() {
        Comparator<Job> cmpJobAscPriority = new JobAscByPriority();
        int rsl = cmpJobAscPriority.compare(
                new Job("Fix bug", 2),
                new Job(("Reboot server"), 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenJobDescByName() {
        Comparator<Job> cmpJobDescName = new JobDescByName();
        int rsl = cmpJobDescName.compare(
                new Job("Fix bug", 0),
                new Job(("Reboot server"), 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenJobDescByPriority() {
        Comparator<Job> cmpJobDescPrior = new JobDescByPriority();
        int rsl = cmpJobDescPrior.compare(
                new Job("Fix bug", 0),
                new Job(("Reboot server"), 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameLnAndPriority() {
        Comparator<Job> cmpJobDescNameAndPrior = new JobDescByNameLn().thenComparing(new JobDescByPriority());
        int rsl = cmpJobDescNameAndPrior.compare(
                new Job("Fix bug", 0),
                new Job(("Reboot server"), 1)
        );
        assertThat(rsl,greaterThan(0));
    }
}