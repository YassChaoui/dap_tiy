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

@Controller
public class AdminController {
    @Autowired
    private GoogleAdminService gAdminService;

    @RequestMapping("/admin")
    public String admin(ModelMap model) throws GeneralSecurityException, IOException {
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

    @RequestMapping("/delete/user")
    public String deleteUser(final String userkey) throws GeneralSecurityException, IOException {
        DataStore<StoredCredential> deleteuser = gAdminService.deleteUser(userkey);
        return "redirect:/admin";
    }
}
