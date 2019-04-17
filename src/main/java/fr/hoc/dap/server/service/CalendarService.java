package fr.hoc.dap.server.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;

/** . */
@Service
public final class CalendarService extends GoogleService {

    /**
     * @return httptransp
     * @param userKey . //TODO chy by Djer |JavaDoc| "Identifiant de l'utilisateur DaP" serait plus claire
     * @throws IOException              .
     * @throws GeneralSecurityException .
     */
    //TODO chy by Djer |Java| "BuildService" serait mieux comme nom de méthode
    //TODO chy by Djer |Java| Devrait être privée, inutile à l'extérieur de cette classe
    public Calendar getService(final String userKey) throws GeneralSecurityException, IOException {
        final NetHttpTransport httptransport = GoogleNetHttpTransport.newTrustedTransport();
        return new Calendar.Builder(httptransport, JSON_FACTORY, getCredentials(userKey))
                .setApplicationName(getConfig().getAppName()).build();
    }

    //TODO chy by Djer |JavaDoc| Ton commentaire JavaDoc n'est plus du tout à jour.
    /**
     * Creates an authorized Credential object.
     *
     * @param userKey .
     * @return . //TODO chy by Djer |JavaDoc| "Representation textuel des prochains évènnements" serait plus claire.
     * @param maxResults .
     * @throws IOException              If the credentials.json file cannot be found.
     * @throws GeneralSecurityException regroups every class related to security
     */

    public List<String> getNextEvents(final Integer maxResults, final String userKey)
            throws IOException, GeneralSecurityException {
        //TODO chy by Djer |Log4J| Une petite log ? "Searching for the " + maxResults + " nexts events for user : " + userkey.
        // List the next 10 events from the primary calendar.

        DateTime now = new DateTime(System.currentTimeMillis());
        Events events = getService(userKey).events().list("primary").setMaxResults(maxResults).setTimeMin(now)
                .setOrderBy("startTime").setSingleEvents(true).execute();

        //TODO chy by Djer |Java| Nom de variable pas très claire "eventsInfo" serait mieux.
        List<String> test = new ArrayList<String>();
        List<Event> items = events.getItems();
        if (items.isEmpty()) {
            //TODO chy by Djer |Java| Pas de SysOut sur un serveur !
            System.out.println("No upcoming events found.");
        } else {
            //TODO chy by Djer |Java| pas de Sysout sur un serveur !
            System.out.println("Upcoming events");
            int a = 0;
            for (Event event : items) {
                DateTime start = event.getStart().getDateTime();
                if (start == null) {
                    start = event.getStart().getDate();
                }
                test.add(a, "event name : " + event.getSummary() + " event date:  " + start + " event status: "
                        + event.getStatus() + "Event attendees :->" + event.getAttendees());
                System.out.println(test);
                a++;
            }
        }
        return test;
    }

    /*
     * public String getNextEvent(final int a) throws IOException, GeneralSecurityException { // List the next 10 events
     * from the primary calendar.
     *
     * DateTime now = new DateTime(System.currentTimeMillis()); Events events =
     * getService().events().list("primary").setMaxResults(a).setTimeMin(now).setOrderBy("startTime")
     * .setSingleEvents(true).execute();
     *
     * String test = new String(); List<Event> items = events.getItems(); if (items.isEmpty()) {
     * System.out.println("No upcoming events found."); } else { System.out.println("Upcoming events"); for (Event event
     * : items) { DateTime start = event.getStart().getDateTime(); if (start == null) { start =
     * event.getStart().getDate(); } test = "event name : " + event.getSummary() + " event date:  " + start +
     * " event status: " + event.getStatus() + "Event attendees :->" + event.getAttendees(); } } return test; }
     */
}
