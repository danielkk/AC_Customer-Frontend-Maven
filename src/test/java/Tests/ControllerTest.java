package Tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Persistence.DummyRepository;
import contract.dto.reservation.ReservationDetail;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anders
 */
public class ControllerTest {
    
    private DummyRepository repo;
    
    public ControllerTest() {
    }
    
    @Before
    public void setUp() {
        repo = new DummyRepository();
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
     @Test
     public void testCreateReservation() {
         int before = repo.getReservations().size();
         repo.createReservation(10, new Date(), 49.95, "Child", "Jens", "Hansen", "jens@hansen.dk", 1);
         int after = repo.getReservations().size();
         assertTrue(before<after);
     }
     
     @Test
     public void testCancelReservation() throws Exception {
         int before = repo.getReservations().size();
         repo.cancelReservation(1);
         int after = repo.getReservations().size();
         assertTrue(before>after);
     }
     
     @Test (expected=Exception.class)
     public void testCancelReservationDidNotExist() throws Exception {
         repo.cancelReservation(-10);
     }
     
     @Test
     public void testGetReservation() throws Exception {
         long expectedId = 1;
         double expectedPrice = 49.95;
         String expectedTicketType = "Child";
         String expectedFirstName = "John";
         String expectedLastName = "Doe";
         String expectedEmail = "john@doe.com";
         int expectedRouteId = 1;
         ReservationDetail r = repo.getReservation(1);
         assertTrue(expectedId == r.getId());
         assertTrue(expectedPrice == r.getPrice());
         assertTrue(expectedTicketType.equals(r.getTicketType()));
         assertTrue(expectedFirstName.equals(r.getFirstName()));
         assertTrue(expectedLastName.equals(r.getLastName()));
         assertTrue(expectedEmail.equals(r.getEmail()));
         assertTrue(expectedRouteId == r.getRouteId());
     }
     
     @Test (expected = Exception.class)
     public void testGetReservationDidNotExist() throws Exception {
         repo.getReservation(-10);
     }
}