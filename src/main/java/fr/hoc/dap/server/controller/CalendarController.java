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
    /** Acces to Calendar API. */
    @Autowired
    private CalendarService cs;

    /**
     * @return .
     * @param userKey .
     * @param role    .
     * @param eventNb .
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
