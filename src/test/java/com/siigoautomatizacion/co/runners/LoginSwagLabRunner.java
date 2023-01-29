package com.siigoautomatizacion.co.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features="src/test/resources/features/LoginSwagLab.feature",
        glue = "com.siigoautomatizacion.co.stepsdefinition",
        snippets = CAMELCASE,
        tags = "@loginSwagLab"
)
public class LoginSwagLabRunner {
}
