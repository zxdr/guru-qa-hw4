package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HerokuApp {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.startMaximized = true;
    }

    @Test
    void dragAndDrop() {
        open("/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-b").shouldHave(text("A"));

        /* didn't get how to use actions in this case but I tried
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b"))
                .release().perform();
         */
    }

}
