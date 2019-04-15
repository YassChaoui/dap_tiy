package fr.hoc.dap.server.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.hoc.dap.server.service.GMailService;

/** . */
@RestController
public class MailController {
    /** Acces to Gmail API. */
    @Autowired
    private GMailService gs;

  //TODO chy by Djer |JavaDoc| CF remarques sur le "CalendarController".
    /**
     * @return .
     * @param userKey .
     * @param role    .
     * @throws GeneralSecurityException .
     * @throws IOException              .
     * @throws NumberFormatException    .
     */
    @RequestMapping("/email/nbunread")
    public Integer index(@RequestParam(name = "userKey") final String userKey,
            @RequestParam(name = "role", defaultValue = "user") final String role)
            throws NumberFormatException, IOException, GeneralSecurityException {
        return gs.getNumberUnreadEmails(userKey);
    }
}
