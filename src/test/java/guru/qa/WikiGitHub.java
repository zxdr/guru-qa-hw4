package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WikiGitHub {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://github.com";
        Configuration.startMaximized = true;
    }

    @Test
    void findSelenideWikishouldHaveSoftAssertions() {
        // open https://github.com project selenide
        open("/selenide/selenide");

        //go to Wiki
        $(byText("Wiki")).click();

        //Pages list has SoftAssertions, open it
        $x("//button[contains(text(),'Show 1 more pages')]").click();
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();

        //SoftAssertions page has Junit5 code sample
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}