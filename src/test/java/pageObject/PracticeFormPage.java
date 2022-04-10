package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    //locators
    SelenideElement formHeaderLocator = $("#stateCity-wrapper");
    final String formHeaderText = "Student Registration Form";

    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement genderInput = $("#genterWrapper");
    SelenideElement phoneInput =  $("#userNumber");
    SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    SelenideElement subjectInput = $("#subjectsInput");
    SelenideElement hobbiesInput = $("#hobbiesWrapper");
    SelenideElement pictureInput = $("#uploadPicture");
    SelenideElement currentAddressInput = $("#currentAddress");
    SelenideElement stateInput= $("#state");
    SelenideElement cityInput= $("#city");
    SelenideElement stateCityWrapperInput = $("#stateCity-wrapper");

    //actions
    public PracticeFormPage openPage() {

        open("/automation-practice-form");
        formHeaderLocator.shouldHave(text(formHeaderText));

        //remove header & footer
        executeJavaScript("$('fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public PracticeFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public PracticeFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }


    public PracticeFormPage setGender(Gender gender) {
        genderInput.$(byText(gender.toString())).click();
        return this;
    }

    public PracticeFormPage setPhone(String phoneNumber) {
        phoneInput.setValue(phoneNumber);
        return this;
    }

    public PracticeFormPage setDateOfBirthByTyping(String dateOfBirth) {
        //Does not work here
        //$("[id=dateOfBirthInput]").clear();

        dateOfBirthInput.sendKeys((Keys.COMMAND + "a"));
        dateOfBirthInput.sendKeys(Keys.SPACE);
        dateOfBirthInput.setValue(dateOfBirth).pressEnter();
        return this;
    }

    //
    /*<div class="subjects-auto-complete__control css-yk16xz-control">
       <div class="subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3">
          <div class="subjects-auto-complete__placeholder css-1wa3eu0-placeholder"></div>
          <div class="css-1g6gooi">
             <div class="subjects-auto-complete__input" style="display: inline-block;">
                <input autocapitalize="none" autocomplete="off" autocorrect="off" id="subjectsInput" spellcheck="false" tabindex="0" type="text" aria-autocomplete="list" value="" style="box-sizing: content-box; width: 2px; background: 0px center; border: 0px; font-size: inherit; opacity: 1; outline: 0px; padding: 0px; color: inherit;">
                <div style="position: absolute; top: 0px; left: 0px; visibility: hidden; height: 0px; overflow: scroll; white-space: pre; font-size: 16px; font-family: -apple-system, &quot;system-ui&quot;, &quot;Segoe UI&quot;, Roboto, &quot;Helvetica Neue&quot;, Arial, &quot;Noto Sans&quot;, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Noto Color Emoji&quot;; font-weight: 400; font-style: normal; letter-spacing: normal; text-transform: none;"></div>
             </div>
          </div>
       </div>
       <div class="subjects-auto-complete__indicators css-1wy0on6">
          <span class="subjects-auto-complete__indicator-separator css-1okebmr-indicatorSeparator"></span>
       </div>
    </div>*/

    public PracticeFormPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public PracticeFormPage setHobby(String hobbies) {
        hobbiesInput.$(byText(hobbies)).click();
        return this;
    }

    public PracticeFormPage setPicture(String imgPath) {
        pictureInput.uploadFromClasspath(imgPath);
        //will also work
        //src/test/resources/image.jpeg
        //$("#uploadPicture").uploadFile(new File(fullImgPath);
        return this;
    }

    public PracticeFormPage setCurrAddress(String currAddr) {
        currentAddressInput.setValue(currAddr);
        return this;
    }

    public PracticeFormPage setState(String state) {
        stateInput.click();
        stateCityWrapperInput.$(byText(state)).click();
        return this;
    }

    public PracticeFormPage setCity(String city) {
        cityInput.click();
        stateCityWrapperInput.$(byText(city)).click();

        return this;
    }








    public PracticeFormPage checkResult(String value) {
        $(".table-responsive").shouldHave(text(value));
        return this;

    }

}
