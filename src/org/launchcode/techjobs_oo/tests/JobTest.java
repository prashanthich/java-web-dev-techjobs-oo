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
    public void settingInitialJobObjects() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        assertFalse(job1 == job2);
        assertEquals(1, job2.getId() - job1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job3 == job4);
    }

    @Test
    public void testToStringFormat() {

        int id = job3.getId();
        String name = "Product tester";
        String employer = "ACME";
        String location = "Desert";
        String positionType = "Quality control";
        String coreCompetency = "Persistence";
        String expectedString =
                "ID: " + id + System.lineSeparator() +
                        "Name: " + name + System.lineSeparator() +
                        "Employer: " + employer + System.lineSeparator() +
                        "Location: " + location + System.lineSeparator() +
                        "Position Type: " + positionType + System.lineSeparator() +
                        "Core Competency: " + coreCompetency + System.lineSeparator();
        assertEquals(expectedString, job3.toString());
    }

    @Test
    public void testToStringFormatWithMissingData() {
        Job job = new Job("Full Stack Dev", new Employer(""), new Location(""),
                null, new CoreCompetency(""));
        int id = job.getId();
        String noData = "Data not available";
        String name = "Full Stack Dev";
        String expectedString =
                "ID: " + id + System.lineSeparator() +
                        "Name: " + name + System.lineSeparator() +
                        "Employer: " + noData + System.lineSeparator() +
                        "Location: " + noData + System.lineSeparator() +
                        "Position Type: " + noData + System.lineSeparator() +
                        "Core Competency: " + noData + System.lineSeparator();
        assertEquals(expectedString, job.toString());
    }

    @Test
    public void testToStringEmptyObject(){
        Job job = new Job();
        assertEquals("OOPS! This job does not seem to exist.",job.toString());

    }


}