package fr.hoc.dap.server.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.util.store.DataStore;

import fr.hoc.dap.server.service.GoogleAdminService;

/** Admin Controlleur Calendar. */
@Controller
public class AdminController {
    /** Acces du GoogleAdminService .*/
    @Autowired
    private GoogleAdminService gAdminService;

    /**
     * Url de la page admin.
     * @return renvoi la page admin.
     * @param model .
     * @throws GeneralSecurityException .
     * @throws IOException              .
     * @throws NumberFormatException    .
     */
    @RequestMapping("/admin")
    public String admin(final ModelMap model) throws GeneralSecurityException, IOException {
        DataStore<StoredCredential> user = gAdminService.getUser();
        Map<String, StoredCredential> userMap = new HashMap<>();
        Set<String> keys = user.keySet();

        for (String key : keys) {
            StoredCredential value = user.get(key);
            userMap.put(key, value);

        }
        model.addAttribute("users", userMap);
        return "admin";
    }

    /**
     * @return renvoi la page delete/user.
     * @param userkey .
     * @throws GeneralSecurityException .
     * @throws IOException              .
     * @throws NumberFormatException    .
     */
    @RequestMapping("/delete/user")
    public String deleteUser(final String userkey) throws GeneralSecurityException, IOException {
      //TODO chy by Djer |Java| Tu n'as pas besoin de la valeur de retour ici, tu peux te passer de la stocker dans une variable.
        DataStore<StoredCredential> deleteuser = gAdminService.deleteUser(userkey);
        return "redirect:/admin";
    }
}
