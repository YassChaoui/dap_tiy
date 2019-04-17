package fr.hoc.dap.server.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.hoc.dap.server.service.CalendarService;

/** Controlleur Calendar. */
@RestController
public class CalendarController {
  //TODO chy by Djer |JavaDoc| Tu ne payeras jamais l'encre de ton écran, n'économise pas trop de caracères, ca rarement efficace.
    /** Acces to Calendar API. */
    @Autowired
    private CalendarService cs;

  //TODO chy by Djer |JavaDoc| "liste des prochains évènnemnts" serait mieux.
    /**
     * @return .
     * @param userKey . //TODO chy by Djer |JavaDoc| "Identifiant de l'utilisateur DaP" serait mieux.
     * @param role    . //TODO chy by Djer |JavaDoc| "Devenu utile car non implementé" serait mieux ?
     * @param eventNb . //TODO chy by Djer |JavaDoc| "Nombre de prochains évènnements à récupérer" serait mieux.
     * @throws GeneralSecurityException .
     * @throws IOException              .
     * @throws NumberFormatException    .
     */
    @RequestMapping("/event/next")
    public List<String> nextEvents(@RequestParam(name = "eventNb", defaultValue = "1") final Integer eventNb,
            @RequestParam(name = "userKey") final String userKey,
            @RequestParam(name = "role", defaultValue = "user") final String role)
            throws NumberFormatException, IOException, GeneralSecurityException {
        return cs.getNextEvents(eventNb, userKey);
    }

    //    /**
    //     * @return .
    //     * @throws GeneralSecurityException .
    //     * @throws IOException              .
    //     * @throws NumberFormatException    .
    //     */
    //    @RequestMapping("/event/next")
    //    public String nextEvent(@RequestParam(name = "eventNb", defaultValue = "1") final Integer eventNb,
    //            @RequestParam(name = "userKey") final String userKey,
    //            @RequestParam(name = "role", defaultValue = "user") final String role)
    //            throws NumberFormatException, IOException, GeneralSecurityException {
    //        return cs.getNextEvents(eventNb, userKey);
    //    }
}
