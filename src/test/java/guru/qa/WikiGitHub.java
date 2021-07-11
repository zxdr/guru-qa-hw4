package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
        $("span[data-content=Wiki]").click();

        //Pages list has SoftAssertions, open it
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();

        //SoftAssertions page has Junit5 code sample
        $("ol[start='3'] li").shouldHave(text("Using JUnit5 extend test class:"));
    }

}
