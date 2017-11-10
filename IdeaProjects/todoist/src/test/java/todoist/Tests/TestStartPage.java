package todoist.Tests;

import PageObjects.StartPage;
import org.junit.Test;
import org.openqa.selenium.By;
import todoist.BaseTest;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by гро on 30.10.17.
 */
public class TestStartPage extends BaseTest {
    @Test
    /*Зайти на totdoist. Залогиниться*/
    public void login(){

        StartPage startPage = page(StartPage.class);
        open("Users/showlogin");
        startPage.setEmail("ol-olena@mail.ru");
        startPage.setPassword("123456");
        startPage.pressButtonSubmit();
        sleep(15000);
    }

    @Test
    /**/
    public void addTask() {
        open("");
        $(By.className("agenda_add_task")).shouldBe(visible).click();
        $(By.className("richtext_editor")).shouldBe(visible).setValue("Work").pressEnter();
        $(By.id("quick_add_task_holder")).shouldBe(visible).click();
        $(By.className("richtext_editor")).shouldBe(visible).setValue("Eat").pressEnter();
        $(By.id("quick_add_task_holder")).shouldBe(visible).click();
        $(By.className("richtext_editor")).shouldBe(visible).setValue("Sleep").pressEnter();
        $(By.id("quick_add_task_holder")).shouldBe(visible).click();
        $(By.className("richtext_editor")).shouldBe(visible).setValue("Art").pressEnter();

//        sleep(10000);
//        startPage.openInbox();
//        startPage.clickAddTask();
//        startPage.setFieldTextPlaceholder("Shopping");
//        sleep(10000);

    }
}
