/**
 * fr.hoc.dap.server is a group of bar utils for operating on foo things.
 */
package fr.hoc.dap.server;

import java.io.IOException;
import java.security.GeneralSecurityException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**.*/
@SpringBootApplication
    /**.
     * @param args arguments
     * */

/**.
 * classe principale
 */
abstract class Launcher {

    /**
     * @throws IOException              If the credentials.json file cannot be
     *                                  found.
     * @throws GeneralSecurityException If the file cannot be found.
     * @param args main arguments.
     */
    public static void main(final String[] args) throws IOException, GeneralSecurityException {

        //Faire un appel avec AppName defaut
        SpringApplication.run(Application.class, args);


        /*gm.getStuff("me", conf1);
        cq.main();
        pq.main();*/
        // *faire un autre appel appName "bob"
    }
}
