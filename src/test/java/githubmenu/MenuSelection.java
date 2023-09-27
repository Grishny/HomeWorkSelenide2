package githubmenu;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MenuSelection {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void menuSelectionSolutionTest(){

        //открыть главную страницу GitHub
        open(Configuration.baseUrl);
        //навести мышку на меню Solutions
        $(byTagAndText("button", "Solutions")).hover();
        //перейти на страницу Enterprise
        $(byText("Enterprise")).click();
        //проверить, что открылась страница Enterprise
        $$(".font-mktg h1").first().shouldHave(text("Build like the best"));
    }
}
