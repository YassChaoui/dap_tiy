package fr.hoc.dap.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import fr.hoc.dap.server.service.Config;

/** . */
@SpringBootApplication
public class Application {
    /** . */
    // private static final Logger LOG = LogManager.getLogger();

    /**
     * .
     *
     * @param args arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * @return a default config
     */
    @Bean
    public Config createConf() {
        Config conf = new Config();
        return conf;
    }

    /**
     * @return .
     * @param ctx .
     */
    @Bean
    public CommandLineRunner commandLineRunner(final ApplicationContext ctx) {
        return args -> {
//            // Faire un appel avec AppName defaut
//            LOG.info("infotest");
//            LOG.error("errortest");
//            LOG.debug("debugtest");
//
//            Config conf = new Config();
//            System.out.println(conf.getAppName());
//            conf.setAppName("bob");
//
//            System.out.println(conf.getAppName());

//            GMailService gs = GMailService.getInstance();
//            gs.setConfig(conf);
//            CalendarService cs = CalendarService.getInstance();
//            cs.setConfig(conf);
//            PeoplService ps = PeoplService.getInstance();
//            ps.setConfig(conf);
            /*
             * int numberOfUnreadMessages = gs.getNumberUnreadEmails(); System.out.println(numberOfUnreadMessages);
             * String[BUFFSIZE] test; test = cs.getNextEvent(); System.out.println(Arrays.toString(test));
             */
            // ps.getPeople();

            /*
             * gm.getStuff("me", conf1); cq.main(); pq.main();
             */
            // *faire un autre appel appName "bob"

        };
    }
}
