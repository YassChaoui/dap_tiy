package fr.hoc.dap.server.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.people.v1.PeopleService;
import com.google.api.services.people.v1.model.ListConnectionsResponse;
import com.google.api.services.people.v1.model.Name;
import com.google.api.services.people.v1.model.Person;

/** . */
public final class PeoplService extends GoogleService {

    /**
     * @return PeopleService qui renvoit le service associé a Google.
     * @throws GeneralSecurityException .
     * @throws IOException              .
     */
    //TODO chy by Djer |Java| "BuildService" serait mieux comme nom de méthode
    //TODO chy by Djer |Java| Devrait être privée, inutile à l'extérieur de cette classe
    public PeopleService getService() throws GeneralSecurityException, IOException {
        final NetHttpTransport httptransport = GoogleNetHttpTransport.newTrustedTransport();
        GoogleService gs = new GoogleService();
        return new PeopleService.Builder(httptransport, JSON_FACTORY, getCredentials("me"))
                .setApplicationName(gs.getConfig().getAppName()).build();
    }

    /**
     * Creates an authorized Credential object.
     *
     * @throws IOException              If the credentials.json file cannot be found.
     * @throws GeneralSecurityException If can't connect.
     */

    public void getPeople() throws IOException, GeneralSecurityException {
        //TODO chy by Djer |JavaDoc| Ce commentaire (de Code) est devenu FAUX !
        // Request 10 connections.
        ListConnectionsResponse response = getService().people().connections().list("people/me").setPageSize(1)
                .setPersonFields("names,emailAddresses").execute();

        // Print display name of connections if available.
        List<Person> connections = response.getConnections();

        if (connections != null && connections.size() > 0) {
            for (Person person : connections) {
                List<Name> names = person.getNames();
                if (names != null && names.size() > 0) {
                    //TODO chy by Djer |Java| pas de SysOut sur un serveur !
                    System.out.println("Name: " + person.getNames().get(0).getDisplayName());
                } else {
                    //TODO chy by Djer |Java| pas de SysOut sur un serveur !
                    System.out.println("No names available for connection.");
                }
            }
        } else {
            //TODO chy by Djer |Java| pas de SysOut sur un serveur !
            System.out.println("No connections found.");
        }
    }
}
