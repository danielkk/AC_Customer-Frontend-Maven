/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Persistence.DummyRepository;
import contract.dto.reservation.ReservationDetail;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Anders
 */
public class SimpleGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DummyRepository dr = new DummyRepository();
        Scanner scan = new Scanner(System.in);
        boolean runBool = true;
        System.out.println("Welcome To The Ferry Reservation System!");
        System.out.println("Please choose an action..");
        System.out.println("Type:\n\"create\" to create a reservation\n\"cancel\" to cancel a reservation\n\"lookup\" to lookup a reservation\n\"quit\" to close the program");
        while (runBool) {
            String action = scan.nextLine();
            if ("create".equals(action)) {
                System.out.println("You chose CREATE. Follow the instructions to make a reservation!");
                long id = dr.getReservations().size() + 1;
                Date date = new Date();
                double price = 49.95;
                System.out.println("Type of ticket:\n\"adult\" to reservate adult ticket\n\"child\" to reservate child ticket");
                String ticketType = scan.nextLine();
                System.out.println("Insert your first name:");
                String firstName = scan.nextLine();
                System.out.println("Insert your last name:");
                String lastName = scan.nextLine();
                System.out.println("Insert your email:");
                String email = scan.nextLine();
                int routeId = 2;
                ReservationDetail rd = new ReservationDetail(id, date, price, ticketType, firstName, lastName, email, routeId);
                System.out.println("Reservation succesfully made!");
                System.out.println("Your reservation ID is " + id);
            } else if ("cancel".equals(action)) {
                System.out.println("To cancel a reservation, insert the reservation ID:");
                long id = scan.nextLong();
                try {
                    dr.cancelReservation(id);
                } catch (Exception ex) {
                    Logger.getLogger(SimpleGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if ("lookup".equals(action)) {
                System.out.println("To lookup a reservation, insert the reservation ID:");
                long id = scan.nextLong();
                try {
                    ReservationDetail rd = dr.getReservation(id);
                    System.out.println("Date: " + rd.getDate().toString() + "\nTicket type: " + rd.getTicketType() + "\nFirst name: " + rd.getFirstName() + "\nLast name: " + rd.getLastName() + "\nEmail: " + rd.getEmail() + "\nRoute ID: " + rd.getRouteId());
                } catch (Exception ex) {
                    Logger.getLogger(SimpleGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if ("quit".equals(action)) {
                System.out.println("Exiting application..");
                runBool = false;
            }
        }
    }

}
