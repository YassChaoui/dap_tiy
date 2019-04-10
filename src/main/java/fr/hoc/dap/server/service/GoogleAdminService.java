package fr.hoc.dap.server.service;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.stereotype.Service;

import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.util.store.DataStore;

@Service
public class GoogleAdminService extends GoogleService {

    public DataStore<StoredCredential> getUser() throws GeneralSecurityException, IOException {
        GoogleAuthorizationCodeFlow theFlow = super.getFlow();
        DataStore<StoredCredential> datas = theFlow.getCredentialDataStore();
        return datas;
    }

    public DataStore<StoredCredential> deleteUser(final String userkey) throws GeneralSecurityException, IOException {

        DataStore<StoredCredential> datas = getFlow().getCredentialDataStore().delete(userkey);
        return datas;
    }
}
