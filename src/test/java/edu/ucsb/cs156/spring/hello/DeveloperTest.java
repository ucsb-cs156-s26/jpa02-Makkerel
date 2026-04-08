package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor =
            Developer.class.getDeclaredConstructor();
        assertTrue(
            Modifier.isPrivate(constructor.getModifiers()),
            "Constructor is not private"
        );

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Kevin", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("Makkerel", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("s26-02", t.getName());
        assertTrue(
            t.getMembers().contains("Arman"),
            "Team should contain Arman"
        );
        assertTrue(
            t.getMembers().contains("David Chen"),
            "Team should contain David Chen"
        );
        assertTrue(
            t.getMembers().contains("Kevin"),
            "Team should contain Kevin"
        );
        assertTrue(t.getMembers().contains("Kai"), "Team should contain Kai");
        assertTrue(
            t.getMembers().contains("Andrew B"),
            "Team should contain Andrew B"
        );
        assertTrue(
            t.getMembers().contains("Justin"),
            "Team should contain Justin"
        );
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
}
