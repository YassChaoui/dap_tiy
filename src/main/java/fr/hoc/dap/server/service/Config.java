package fr.hoc.dap.server.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** * @author house * */
public class Config {
    /** . */
    private static final Logger LOG = LogManager.getLogger();
    /** * Fichier de permissions acceptées. */
    private static final String TOKEN_DIR = System.getProperty("user.home") + "/dap/tokens";
    /** * Fichier de config api. */
    private static final String CREDENTIALS_FILE_PATH = System.getProperty("user.home") + "/dap/credentials.json";
    /** * Nom de l'application. */
    private static final String APPLICATION_NAME = "HoC DaP";

    //TODO chy by Djer |javaDoc| Mauvais emplacement de JavaDoc
    /**
     * @param tokenFolderName if
     * @param credFilePath    if
     * @param appName         if
     */

  //TODO chy by Djer |javaDoc| Tes commentaires sur les constantes iraient mieux ici. Pour les constantes ajoute juste "Valeur par defaut pour ...." devant.
    private String tokenDirectory;
    /** . */
    private String credFilePath;
    /** . */
    private String appName;

  //TODO chy by Djer |javaDoc| "Initialise les variables avec les valeurs par defaut" serait mieux.
    /** . */
    public Config() {
        tokenDirectory = TOKEN_DIR;
        credFilePath = CREDENTIALS_FILE_PATH;
        appName = APPLICATION_NAME;
    }

    /**
     * @return tokenFolderName
     */
    public String getTokenDirectory() {
        LOG.info("TokenFolder returned");
        return tokenDirectory;
    }

    /**
     * @return tokenFolderName
     */
    public static String getoAuth2CallbackUrl() {
        return "/oAuth2Callback";
    }

    /**
     * @param tokendirectory .
     */
    public void setTokenDirectory(final String tokendirectory) {
        LOG.info("TokenFolder changed");
        this.tokenDirectory = tokendirectory;
    }

    /**
     * @return tokenFolderName
     */
    public String getAppName() {
        LOG.info("AppName returned");
        return appName;
    }

    /**
     * @param newName d
     */
    public void setAppName(final String newName) {
        LOG.info("AppName changed");
        this.appName = newName;
    }

    /**
     * @return tokenFolderName
     */
    public String getCreditFilePath() {
        LOG.info("CreditFilePath returned");
        return credFilePath;
    }

    /**
     * @param newName d
     */
    public void setCreditFilePath(final String newName) {
        LOG.info("CreditFilePath changed");
        this.credFilePath = newName;
    }

}
