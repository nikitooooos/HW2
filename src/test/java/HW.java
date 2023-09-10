import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HW {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void demoQaTest(){
        open("/automation-practice-form");

        $("#firstName").setValue("Nikita");
        $("#lastName").setValue("Postnikov");
        $("#userEmail").setValue("nikita.postnikov.00@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("2023")).click();
        $(".react-datepicker__month-select").$(byText("September")).click();
        $(".react-datepicker__day--010").click();
        $("#subjectsWrapper input").setValue("Maths").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("qwe.jpg");
        $("#currentAddress").setValue("Address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").shouldHave(text("Nikita Postnikov"));
        $(".modal-content").shouldHave(text("nikita.postnikov.00@gmail.com"));
        $(".modal-content").shouldHave(text("Male"));
        $(".modal-content").shouldHave(text("1234567890"));
        $(".modal-content").shouldHave(text("10 September,2023"));
        $(".modal-content").shouldHave(text("Sports"));
        $(".modal-content").shouldHave(text("qwe.jpg"));
        $(".modal-content").shouldHave(text("Address"));
        $(".modal-content").shouldHave(text("NCR Delhi"));

    }
}
