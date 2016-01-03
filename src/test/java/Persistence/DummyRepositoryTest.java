/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import contract.dto.reservation.ReservationDetail;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anders
 */
public class DummyRepositoryTest {
    
    DummyRepository repo;
    
    public DummyRepositoryTest() {
    }
    
    @Before
    public void setUp() {
        repo = new DummyRepository();
    }

    @Test
     public void testCreateReservation() {
         System.out.println("testCreateReservation");
         int before = repo.getReservations().size();
         repo.createReservation(10, new Date(), 49.95, "Child", "Jens", "Hansen", "jens@hansen.dk", 1);
         int after = repo.getReservations().size();
         assertTrue(before<after);
     }
     
     @Test
     public void testCancelReservation() throws Exception {
         System.out.println("testCancelReservation");
         int before = repo.getReservations().size();
         repo.cancelReservation(1);
         int after = repo.getReservations().size();
         assertTrue(before>after);
     }
     
     @Test (expected=Exception.class)
     public void testCancelReservationDidNotExist() throws Exception {
         System.out.println("testCreateReservationDidNotExist");
         repo.cancelReservation(-10);
     }
     
     @Test
     public void testGetReservation() throws Exception {
         System.out.println("testGetReservation");
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
         System.out.println("testGetReservationDidNotExist");
         repo.getReservation(-10);
     }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetScheduleDetail() {
        System.out.println("testGetScheduleDetail - not implemented yet");
        repo.getScheduleDetail(null, 0);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetScheduleSummary() {
        System.out.println("testGetScheduleSummary - not implemented yet");
        repo.getScheduleSummary(null);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetDepartureDetail() {
        System.out.println("testGetDepartureDetail - not implemented yet");
        repo.getDepartureDetail(1);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetDepartureSummaiers() {
        System.out.println("testGetDepartureSummaries - not implemented yet");
        repo.getDepartureSummaiers();
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetRouteDetail() {
        System.out.println("testGetRouteDetail - not implemented yet");
        repo.getRouteDetail(1);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetRouteSummaries() {
        System.out.println("testGetRouteSummaries - not implemented yet");
        repo.getRouteSummaries();
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetPrices() {
        System.out.println("testGetPrices - not implemented yet");
        repo.getPrices();
    }
    
}
