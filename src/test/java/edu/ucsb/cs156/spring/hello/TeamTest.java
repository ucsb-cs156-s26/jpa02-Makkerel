package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
    }

    @Test
    public void getName_returns_correct_name() {
        assert (team.getName().equals("test-team"));
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void is_equals_returns_properly() {
        assertEquals(true, team.equals(team));
        String test = "anime";
        assertEquals(false, team.equals(test));

        Team other_team = new Team("test-team");
        assertEquals(true, team.equals(other_team));

        other_team = new Team("bad_name");
        assertEquals(false, team.equals(other_team));
        other_team.addMember("Some Dude");
        other_team.setName("test-team");
        assertEquals(false, team.equals(other_team));
    }

    @Test
    public void check_hashCode_works() {
        Team t1 = new Team();
        t1.setName("Anime");
        t1.addMember("Goku");
        Team t2 = new Team();
        t2.setName("Anime");
        t2.addMember("Goku");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void equivalent_mutation_test() {
        int result = team.hashCode();
        int expected_hash = -1226298695;
        assertEquals(expected_hash, result);
    }
}
