package test;

import core.Constants;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@validado",
        features = "src/test/resources/features",
        glue = "steps",
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = false,
        plugin = {
            "pretty",
            "html:target/cucumber-reports",
            "json:target/cucumber-report.json"
        }

)
public class BaseTest implements Constants {

        @BeforeClass
        public static void setup (){
                RestAssured.baseURI = APP_BASE_URL;
                RestAssured.basePath = APP_BASE_PATH;
                RestAssured.port = APP_PORT;

                RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
                requestSpecBuilder.setContentType(APP_CONTENT_TYPE);
                RestAssured.requestSpecification = requestSpecBuilder.build();

                ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
                responseSpecBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
                RestAssured.responseSpecification = responseSpecBuilder.build();
        }

}
