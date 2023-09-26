package dragdrop;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class UsingSelenideActions {
        @BeforeAll
        static void beforeAll() {
            Configuration.baseUrl = "https://the-internet.herokuapp.com";
            Configuration.pageLoadStrategy = "eager";
            Configuration.browserSize = "1920x1080";
        }

        @Test
        void menuSelectionSolution(){

            //открыть страницу Drag&Drop
            open("/drag_and_drop");
            sleep(2000);
            //перенести треугольник А на место треугольника В
            $("#column-a").$("header").shouldHave(text("A"));
            $("#column-b").$("header").shouldHave(text("B"));
            $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));
            //проверить, что треугольники поменялись местами
            $("#column-a").$("header").shouldHave(text("B"));
            $("#column-b").$("header").shouldHave(text("A"));
            sleep(2000);
        }
    }

