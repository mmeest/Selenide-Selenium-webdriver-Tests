import com.codeborne.selenide.Condition;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WoodTest {

    @Test
    public void woodMaterialApartment50(){
        //open Swedbank home insurance page
        open("https://swedbank.ee/private/insurance/home/ihome?language=ENG");
        //check Total area: value
        $(By.id("totalArea")).shouldHave(Condition.value("50"));
        //check Monthly payment: string
        $(By.id("homeInsurancePrice")).shouldHave(Condition.text("13.46"));
        //clear cookies notification
        $(By.id("cookiesInfoBlock")).click();
        //select Building material: wood
        $(By.xpath("/html/body/div[1]/div[2]/div/form[2]/section[2]/div/div/div[1]/dl/dd[5]/label")).click();
        //button click "Calculate price"
        $(By.id("calculateActive")).click();
        //check Monthly payment: string (change)
        $(By.id("homeInsurancePrice")).shouldNotHave(Condition.text("13.46"));
    }

    @Test
    public void woodMaterialApartmentNul(){
        //open Swedbank home insurance page
        open("https://swedbank.ee/private/insurance/home/ihome?language=ENG");
        //check Total area: value
        $(By.id("totalArea")).shouldHave(Condition.value("50"));
        //check Monthly payment: string
        $(By.id("homeInsurancePrice")).shouldHave(Condition.text("13.46"));
        //clear cookies notification
        $(By.id("cookiesInfoBlock")).click();
        //select Building material: wood
        $(By.xpath("/html/body/div[1]/div[2]/div/form[2]/section[2]/div/div/div[1]/dl/dd[5]/label")).click();
        //clear Total area:
        $(By.id("totalArea")).setValue("");
        //check red error
        $(By.id("errorBox")).shouldNotBe(Condition.visible);
        //button click "Calculate price"
        $(By.id("calculateActive")).click();
        //check red error
        $(By.id("errorBox")).shouldBe(Condition.visible).shouldHave(Condition.text("Please enter the total area!"));
    }

    @Test
    public void woodMaterialResidentialBuilding50(){
        //open Swedbank home insurance page
        open("https://swedbank.ee/private/insurance/home/ihome?language=ENG");
        //check Total area: value
        $(By.id("totalArea")).shouldHave(Condition.value("50"));
        //select Building type: Residential Building
        //clear cookies notification
        $(By.id("cookiesInfoBlock")).click();
        $(By.xpath("/html/body/div[1]/div[2]/div/form[2]/section[2]/div/div/div[1]/dl/dd[2]/label")).click();
        //button click "Calculate price"
        $(By.id("calculateActive")).click();
        //check Monthly payment: string
        $(By.id("homeInsurancePrice")).shouldHave(Condition.text("12.90"));
        //select Building material: wood
        $(By.xpath("/html/body/div[1]/div[2]/div/form[2]/section[2]/div/div/div[1]/dl/dd[5]/label")).click();
        //button click "Calculate price"
        $(By.id("calculateActive")).click();
        //check Monthly payment: string (change)
        $(By.id("homeInsurancePrice")).shouldNotHave(Condition.text("12.90"));
    }

}
