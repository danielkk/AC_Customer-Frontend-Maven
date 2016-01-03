/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import contract.DataRepository;
import contract.dto.departure.DepartureDetail;
import contract.dto.departure.DepartureSummary;
import contract.dto.price.PriceDetail;
import contract.dto.reservation.ReservationDetail;
import contract.dto.route.RouteDetail;
import contract.dto.route.RouteSummary;
import contract.dto.schedule.ScheduleDetail;
import contract.dto.schedule.ScheduleSummary;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Anders
 */
public class DummyRepository implements DataRepository {
    
    private ArrayList<ReservationDetail> reservations;
    
    public DummyRepository() {
        //mock vores database her
        reservations = new ArrayList();
        
        //reservationer
        ReservationDetail r1 = new ReservationDetail(1, new Date(), 49.95, "Child", "John", "Doe", "john@doe.com", 1);
        ReservationDetail r2 = new ReservationDetail(2, new Date(), 99.95, "Adult", "Daniel", "Knudsen", "dkk@jumpstyle.dk", 1);
        ReservationDetail r3 = new ReservationDetail(3, new Date(), 49.95, "Child", "Mike", "Hansen", "albinomike@gmail.com", 2);
        ReservationDetail r4 = new ReservationDetail(4, new Date(), 49.95, "Child", "Jens", "Jensen", "jj@hotmail.com", 3);
        ReservationDetail r5 = new ReservationDetail(5, new Date(), 99.95, "Adult", "Hanne", "Hansen", "hh@gmail.com", 4);
        reservations.add(r1);
        reservations.add(r2);
        reservations.add(r3);
        reservations.add(r4);
        reservations.add(r5);
    }
    
    public Collection<ReservationDetail> getReservations() {
        return reservations;
    }
    
    @Override
    public void createReservation(long id, Date date, double price, String ticketType, String firstName, String lastName, String email, int routeId) {
        ReservationDetail r = new ReservationDetail(id, date, price, ticketType, firstName, lastName, email, routeId);
        reservations.add(r);
    }

    @Override
    public ReservationDetail getReservation(long id) throws Exception {
        for (ReservationDetail r : reservations) {
            if (r.getId() == id) {
                return r;
            }
        }
        throw new Exception("Could not find reservation with id: "+id);
    }

    @Override
    public void cancelReservation(long id) throws Exception {
        boolean didExist = false;
        for (int i=0;i<reservations.size();i++) {
            if (reservations.get(i).getId() == id) {
                reservations.remove(i);
                didExist = true;
            }
        }
        if (!didExist) throw new Exception("Could not find reservation with id: "+id);
    }

    @Override
    public ScheduleDetail getScheduleDetail(Date date, long routeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<ScheduleSummary> getScheduleSummary(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DepartureDetail getDepartureDetail(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<DepartureSummary> getDepartureSummaiers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RouteDetail getRouteDetail(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<RouteSummary> getRouteSummaries() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<PriceDetail> getPrices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
