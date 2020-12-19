package org.launchcode.techjobs_oo.tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job job1;
    Job job2;
    Job job3;
    @Before
    public void settingInitialJobObjects(){
         job1 = new Job();
         job2 = new Job();
         job3 = new Job("Product tester",new Employer("ACME"), new Location("Desert"),
                 new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId(){
        assertFalse(job1==job2);
        assertEquals(1,job2.getId()-job1.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        assertEquals("Product tester",job3.getName());
        assertEquals("ACME",job3.getEmployer().getValue());
        assertEquals("Desert",job3.getLocation().getValue());
        assertEquals("Quality control",job3.getPositionType().getValue());
        assertEquals("Persistence",job3.getCoreCompetency().getValue());
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
    }
    @Test
    public void testJobsForEquality(){
        Job job4 = new Job("Product tester",new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job3==job4);
    }


}