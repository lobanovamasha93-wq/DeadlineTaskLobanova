package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {

    private final SelenideElement codeField = $("[data-test-id=code] input");
    private final SelenideElement verifyButton = $("[data-test-id=action-verify]");
    private final SelenideElement errorNotification = $("[data-test-id=error-notification]");

    public VerificationPage() {
        codeField.shouldBe(visible);
    }

    public DashboardPage validVerify(String code) {
        codeField.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        codeField.setValue(code);
        verifyButton.click();
        return new DashboardPage();
    }

    public void errorNotificationShouldBeVisible() {
        errorNotification.shouldBe(visible).shouldHave(text("Ошибка"));
    }
}
