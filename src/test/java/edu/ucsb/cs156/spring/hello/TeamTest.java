package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void testEquals_sameObject() {
        // Arrange
        Team team = new Team("TeamName"); // Calling the constructor with the team name

        // Act & Assert
        assertTrue(team.equals(team)); // Same object should be equal to itself
    }

    @Test
    public void testEquals_differentClass() {
        // Arrange
        Team team = new Team("TeamName"); // Creating a Team object
        String notATeam = "Not a team";   // An object of a different class (String)

        // Act & Assert
        assertFalse(team.equals(notATeam)); // A Team should not be equal to a String
    }

    @Test
    public void testEquals_bothNameAndMembersTrue() {
        // Arrange
        Team team1 = new Team("TeamName");
        team1.addMember("Member1");

        Team team2 = new Team("TeamName");
        team2.addMember("Member1");

        // Act & Assert
        assertTrue(team1.equals(team2)); // Both name and members are equal, should return true
    }

    @Test
    public void testEquals_nameTrueMembersFalse() {
        // Arrange
        Team team1 = new Team("TeamName");
        team1.addMember("Member1");

        Team team2 = new Team("TeamName");
        team2.addMember("DifferentMember");

        // Act & Assert
        assertFalse(team1.equals(team2)); // Name is equal, but members are different, should return false
    }

    @Test
    public void testEquals_nameFalseMembersTrue() {
        // Arrange
        Team team1 = new Team("TeamName");
        team1.addMember("Member1");

        Team team2 = new Team("DifferentName"); // Different name from team1
        team2.addMember("Member1"); // Same members as team1

        // Act & Assert
        assertFalse(team1.equals(team2)); // Name differs, so equals should return false even if members are the same
    }

    @Test
    public void testHashCode_equalObjects() {
        // Arrange
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");

        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");

        // Act & Assert
        assertEquals(t1.hashCode(), t2.hashCode()); // If t1 equals t2, their hash codes should be equal
    }

    @Test
    public void testHashCode_defaultConstructor() {
        // Arrange
        Team t = new Team(); // Instantiate Team with default constructor

        // Act
        int result = t.hashCode(); // Get the hashCode of the default Team object

        // Assert
        int expectedResult = 1; // Expecting hashCode to return 0 for default object
        assertEquals(expectedResult, result);
    }

}