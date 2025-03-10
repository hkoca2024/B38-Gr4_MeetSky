package com.meetSky.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/meetSky/step_definitions",
        dryRun = false,
        tags = "@B38G4-380_tasksmodule_AC01-TC01",
        publish = true //generating a report with public link
)
public class CukesRunner {}


