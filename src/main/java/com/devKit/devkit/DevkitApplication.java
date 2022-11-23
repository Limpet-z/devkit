package com.devKit.devkit;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class DevkitApplication {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(DevkitApplication.class);

        app.setBanner((environment, sourceClass, out) -> out.print(
                " .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------. \n" +
                        "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\n" +
                        "| |   _____      | || |     _____    | || | ____    ____ | || |   ______     | || |  _________   | || |  _________   | |\n" +
                        "| |  |_   _|     | || |    |_   _|   | || ||_   \\  /   _|| || |  |_   __ \\   | || | |_   ___  |  | || | |  _   _  |  | |\n" +
                        "| |    | |       | || |      | |     | || |  |   \\/   |  | || |    | |__) |  | || |   | |_  \\_|  | || | |_/ | | \\_|  | |\n" +
                        "| |    | |   _   | || |      | |     | || |  | |\\  /| |  | || |    |  ___/   | || |   |  _|  _   | || |     | |      | |\n" +
                        "| |   _| |__/ |  | || |     _| |_    | || | _| |_\\/_| |_ | || |   _| |_      | || |  _| |___/ |  | || |    _| |_     | |\n" +
                        "| |  |________|  | || |    |_____|   | || ||_____||_____|| || |  |_____|     | || | |_________|  | || |   |_____|    | |\n" +
                        "| |              | || |              | || |              | || |              | || |              | || |              | |\n" +
                        "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\n" +
                        " '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' \n" +
                        "                                                                                                                        \n" +
                        "                                                                                                                        "));

        app.run(args);
    }

}
