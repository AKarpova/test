package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

/**
 * Created by гро on 30.10.17.
 */
public class StartPage {
    private static final Logger log = Logger.getLogger(StartPage.class);

    @FindBy(xpath = ".//*[@name='email']")
    private SelenideElement email;

    @FindBy(xpath = ".//*[@name='password']")
    private SelenideElement password;

    @FindBy(xpath = ".//*[contains(@class, 'submit') and contains(@onclick,'Login')]")
    private SelenideElement buttonSubmit;

    @FindBy(xpath = ".//*[@class='sel_login']")
    private SelenideElement login;

    @FindBy(xpath = ".//*[@class = 'ist_button ist_button_google']")
    private SelenideElement loginGoogle;

    @FindBy(xpath = ".//*[@id='quick_add_task_holder']")
    private SelenideElement buttonAddPlus;

    @FindBy(xpath = ".//*[@id='filter_inbox']/text()='Входящие'")
    private SelenideElement inbox;

    @FindBy(xpath = ".//*[@class = 'action action_add_item']")
    private SelenideElement addTask;

    @FindBy(xpath = ".//*[@class='rich_text_placeholder']")
    private SelenideElement fieldTextPlaceholder;

    public void setEmail(String emailAddress){
        log.info("Вводим email");
        email.setValue(emailAddress);
    }

    public void setPassword(String Password){
        log.info("Вводим пароль");
        password.setValue(Password);
    }

    public void pressButtonSubmit(){
        log.info("Нажимаем на кнопку Войти");
        buttonSubmit.shouldBe(visible).pressEnter();
    }

    public void clickLogin(){
        log.info("Нажимаем в верхнем меню на пункт Войти");
        login.click();
    }

    public void openInbox(){
        inbox.click();
    }

    public void clickAddTask(){
        addTask.shouldBe(visible).click();
    }

    public void loginWithGoogle() {
        log.info("Логинимся через аккаунт Google");
        loginGoogle.click();
    }

    public void clckButtonAdd(){
        log.info("Нажимаем на кнопку Добавить задачу");
        buttonAddPlus.shouldBe(visible).click();
    }

    public void setFieldTextPlaceholder(String text){
        log.info("");
        fieldTextPlaceholder.setValue(text);
    }


}
