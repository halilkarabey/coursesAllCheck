package stepdefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.bytebuddy.implementation.bytecode.ShiftRight;
import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AllPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.*;

public class AllCheck {
    AllPage allPage = new AllPage();
    Random random = new Random();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
    List<String> listPublish = new ArrayList<>();
    List<String> listLeo = new ArrayList<>();
    List<String> listCrmCourseName = new ArrayList<>();
    List<String> listCrmRelatedCourses = new ArrayList<>();
    Map<List<String>, List<String>> mapCRMRelatedCourses = new HashMap<>();
    List<String> listLeoRelatedCourses = new ArrayList<>();
    List<String> listLeoCourseName = new ArrayList<>();
    Map<List<String>, List<String>> mapLeoRelatedCourses = new HashMap<>();
    List<String> listCRMPM = new ArrayList<>();
    Map<List<String>, List<String>> mapCRMPM = new HashMap<>();
    List<String> listLeoPM = new ArrayList<>();
    Map<List<String>, List<String>> mapLeoPM = new HashMap<>();
    List<String> listCRMPrice = new ArrayList<>();
    Map<List<String>, List<String>> mapCRMPrice = new HashMap<>();
    List<String> listLeoPrice = new ArrayList<>();
    Map<List<String>, List<String>> mapLeoPrice = new HashMap<>();
    List<String> listCRMAcademyName = new ArrayList<>();
    Map<List<String>, List<String>> mapCRMAcademyName = new HashMap<>();
    List<String> listLeoAcademyName = new ArrayList<>();
    Map<List<String>, List<String>> mapLeoAcademyName = new HashMap<>();
    Map<List<String>, List<String>> mapAcademyNameAtLeo2 = new HashMap<>();
    Map<List<String>, List<String>> mapAcademyNameAtLeo1 = new HashMap<>();
    List<String> listCRMOverview = new ArrayList<>();
    Map<List<String>, List<String>> mapCRMOverview = new HashMap<>();
    List<String> listLeoOverview = new ArrayList<>();
    Map<List<String>, List<String>> mapLeoOverview = new HashMap<>();
    List<String> listCRMKeyTakeAway = new ArrayList<>();
    Map<List<String>, List<String>> mapCRMKeyTakeAway = new HashMap<>();
    List<String> listLeoKeyTakeAway = new ArrayList<>();
    List<String> listLeoKeyTakeAway1 = new ArrayList<>();
    Map<List<String>, List<String>> mapLeoKeyTakeAway = new HashMap<>();
    List<String> listCRMOutline = new ArrayList<>();
    Map<List<String>, List<String>> mapCRMOutline = new HashMap<>();
    List<String> listLeoOutline = new ArrayList<>();
    Map<List<String>, List<String>> mapLeoOutline = new HashMap<>();


    @Given("User goes to {string} for crm")
    public void user_goes_to_for_crm(String crmEnv) {
        Driver.getDriver().get(ConfigReader.getProperty(crmEnv));
    }

    @And("user enters {string} in emailBox")
    public void user_enters_in_email_box(String emailForCRM) {
        allPage.checked().email.sendKeys(ConfigReader.getProperty(emailForCRM));
    }

    @And("User enters {string} in passwordBox")
    public void user_enters_in_password_box(String passwordForCRM) {
        allPage.checked().password.sendKeys(ConfigReader.getProperty(passwordForCRM));
    }

    @And("user clicks login button")
    public void user_clicks_login_button() {
        allPage.checked().signInButton.click();
    }

    @And("user hoverOver campaigns")
    public void user_hover_over_campaigns() {
        ReusableMethods.hover(allPage.checked().campaigns);
    }

    @And("user clicks campaigns at crm")
    public void user_clicks_campaigns_at_crm() {
        allPage.checked().campaigns.click();
    }

    @And("user clicks courses at crm")
    public void user_clicks_courses_at_crm() {
        allPage.checked().coursesButton.click();
    }

    @And("user clicks loadMore until it is unClickable")
    public void user_clicks_load_more_until_it_is_un_clickable() throws InterruptedException {
        boolean flag = true;

        while (flag) {

            int size1 = allPage.checked().coursesSize.size();
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("window.scrollBy(0,500)", "");
            allPage.checked().loadMoreButton.click();
            Thread.sleep(2000);
            int size2 = allPage.checked().coursesSize.size();
            if (size1 == size2) {
                flag = false;
            }
        }
    }

    @Then("User lists academyName, keyTakeAway,overview,PM,price,relatedCourses, statusCheck,courseOutline at crm")
    public void user_lists_academy_name_key_take_away_overview_pm_price_related_courses_status_check_course_outline_at_crm() throws InterruptedException {
//statusCheck
        for (int i = 0; i < allPage.checked().published.size(); i++) {
            listPublish.add(allPage.checked().published.get(i).getText());
        }
        Collections.sort(listPublish);
        System.out.println("Publish Courses amount at crm = " + listPublish.size());
//Random Number
        for (int i = 0; i < 1; i++) {
            int size = random.nextInt(allPage.checked().published.size());
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", allPage.checked().published.get(size));
            Thread.sleep(2000);
//relatedCoursesCheck
            listCrmCourseName.add(allPage.checked().nameOfCourse.getText());
            for (int j = 0; j < allPage.checked().relatedCoursesAtCrm.size(); j++) {
                listCrmRelatedCourses.add(allPage.checked().relatedCoursesAtCrm.get(j).getText());
            }
//PM Check
            listCRMPM.addAll(Arrays.asList(allPage.checked().pmName.getText(), allPage.checked().pmEmail.getText(), allPage.checked().pmPhone.getText()));
//PriceCheck
            List<String> lvtText1 = new ArrayList<>();
            try {
                if (allPage.checked().viewAll.isDisplayed()) {
                    wait.until(ExpectedConditions.elementToBeClickable(allPage.checked().viewAll));
                    allPage.checked().viewAll.click();
                    Thread.sleep(1000);
                    for (int y = 0; y < allPage.checked().cellValue.size(); y++) {
                        lvtText1.add(allPage.checked().cellValue.get(y).getText());
                        Thread.sleep(1000);

                    }
                    Driver.getDriver().navigate().back();
                    wait.until(ExpectedConditions.elementToBeClickable(allPage.checked().viewAll));
                } else if (!allPage.checked().viewAll.isDisplayed() && allPage.checked().sessionLvtPublic.isEnabled()) {
                    listCRMPrice.add(allPage.checked().lvtPrice.getText());
                } else if (!allPage.checked().viewAll.isDisplayed() && allPage.checked().sessionPublic.isEnabled()) {
                    listCRMPrice.add(allPage.checked().face2FacePrice.getText());

                } else {
                    listCRMPrice.add("");
                }
            } catch (Exception e) {

            }
            try {
                if (lvtText1.contains("LVT Public") && !lvtText1.contains("Public")) {
                    listCRMPrice.add(allPage.checked().lvtPrice.getText());
                } else if (!lvtText1.contains("LVT Public") && lvtText1.contains("Public")) {
                    listCRMPrice.add(allPage.checked().face2FacePrice.getText());
                } else if (lvtText1.contains("LVT Public") && lvtText1.contains("Public")) {
                    listCRMPrice.add(allPage.checked().lvtPrice.getText());
                    listCRMPrice.add(allPage.checked().face2FacePrice.getText());
                }
            } catch (Exception e) {
            }
//academyNameCheck
            String academyNameAtCrm = allPage.checked().academyNameAtCrm.getText();
            //manipulationOfAcademyName
            String academyNameAtCrmNew = academyNameAtCrm.split("-")[academyNameAtCrm.split("-").length - 1].trim();
            listCRMAcademyName.add(academyNameAtCrmNew);
//overviewCheck
            listCRMOverview.add(allPage.checked().overviewCrm.getText());
//keyTakeAwayCheck
            for (int j = 0; j < allPage.checked().listTakeAway.size(); j++) {
                listCRMKeyTakeAway.add(allPage.checked().listTakeAway.get(j).getText());
            }
//courseOutlineCheck
            for (int j = 0; j < allPage.checked().outlineDay.size(); j++) {
                wait.until(ExpectedConditions.elementToBeClickable(allPage.checked().outlineDay.get(j)));
                JSUtils.elementiGoreneKadarKaydirVeTikla(allPage.checked().outlineDay.get(j));
                for (int k = 0; k < allPage.checked().buttons.size(); k++) {
                    wait.until(ExpectedConditions.elementToBeClickable(allPage.checked().buttons.get(k)));
                    JSUtils.elementiGoreneKadarKaydirVeTikla(allPage.checked().buttons.get(k));
                    listCRMOutline.add(allPage.checked().ıntro.getText());
                    JSUtils.elementiGoreneKadarKaydirVeTikla(allPage.checked().buttons.get(k));
                }
            }


//this method is continuing until navigate works properly. then it will be changed
            user_hover_over_campaigns();
            Thread.sleep(1000);
            user_clicks_courses_at_crm();
//for loading all courses again
            user_clicks_load_more_until_it_is_un_clickable();
        }
        mapCRMRelatedCourses.put(listCrmCourseName, listCrmRelatedCourses);
        System.out.println("mapCRMRelatedCourses = " + mapCRMRelatedCourses);
        mapCRMPM.put(listCrmCourseName, listCRMPM);
        System.out.println("mapCRMPM = " + mapCRMPM);
        mapCRMPrice.put(listCrmCourseName, listCRMPrice);
        System.out.println("mapCRMPrice = " + mapCRMPrice);
        mapCRMAcademyName.put(listCrmCourseName, listCRMAcademyName);
        System.out.println("mapCRMAcademyName = " + mapCRMAcademyName);
        mapCRMOverview.put(listCrmCourseName, listCRMOverview);
        System.out.println("mapCRMOverview = " + mapCRMOverview);
        mapCRMKeyTakeAway.put(listCrmCourseName, listCRMKeyTakeAway);
        System.out.println("mapCRMKeyTakeAway = " + mapCRMKeyTakeAway);
        mapCRMOutline.put(listCrmCourseName, listCRMOutline);
        System.out.println("mapCRMOutline = " + mapCRMOutline);
        System.out.println("-------------------");
    }

    @And("user goes to {string} for leo")
    public void user_goes_to_for_leo(String leoEnv) {
        Driver.getDriver().get(ConfigReader.getProperty(leoEnv));
    }

    @And("user clicks courses at leo")
    public void user_clicks_courses_at_leo() {
        allPage.checked().courses.click();
    }

    @And("user scrolls down")
    public void user_scrolls_down() {
        try {
            while (allPage.checked().buttonMoreLeo.isDisplayed()) {
                ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,250)");
            }
        } catch (Exception e) {

        }
    }

    @And("user lists all courses academyName, keyTakeAway,overview,PM,price,relatedCourses, statusCheck,courseOutline at leo")
    public void user_lists_all_courses_academy_name_key_take_away_overview_pm_price_related_courses_status_check_course_outline_at_leo() throws InterruptedException {
        for (int i = 0; i < allPage.checked().leoCourses.size(); i++) {
            listLeo.add(allPage.checked().leoCourses.get(i).getText());
        }
        Collections.sort(listLeo);
        System.out.println("Amount of courses at leo = " + listLeo.size());
//random Number
        for (int i = 0; i < 1; i++) {
            for (int x = 0; x < allPage.checked().leoCourses.size(); x++)
                if (allPage.checked().leoCourses.get(x).getText().equals(listCrmCourseName.get(i))) {
                    ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", allPage.checked().leoCourses.get(x));
                    Thread.sleep(2000);
                }
//relatedCourseCheck
            for (int j = 0; j < allPage.checked().relatedCoursesAtLeo.size(); j++) {
                listLeoRelatedCourses.add(allPage.checked().relatedCoursesAtLeo.get(j).getText());
            }
            listLeoCourseName.add(allPage.checked().nameOfCourseAtLeo.getText());
//PMCheck
            listLeoPM.addAll(Arrays.asList(allPage.checked().pmNameOfMentor.getText(), allPage.checked().pmEmailLeo.getText(), allPage.checked().pmPhoneNumber.getText()));
//PriceCheck
            //lvtControlAndAdd
            try {
                if (allPage.checked().live.isDisplayed()) {
                    allPage.checked().live.click();
                    for (int j = 0; j < 1; j++) {
                        int size1 = random.nextInt(allPage.checked().amountOfLeoCourses.size() - 1);
                        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", allPage.checked().amountOfLeoCourses.get(size1));
                    }
                    wait.until(ExpectedConditions.elementToBeClickable(allPage.checked().addToChart));
                    allPage.checked().addToChart.click();
                    Thread.sleep(1000);
                    listLeoPrice.add(allPage.checked().priceLvtLeo.getText());
                    wait.until(ExpectedConditions.elementToBeClickable(allPage.checked().close));
                    allPage.checked().close.click();
                    wait.until(ExpectedConditions.elementToBeClickable(allPage.checked().chart));
                    allPage.checked().chart.click();
                    wait.until(ExpectedConditions.elementToBeClickable(allPage.checked().delete));
                    allPage.checked().delete.click();
                    Thread.sleep(1000);
                    Driver.getDriver().navigate().back();

                }
            } catch (Exception e) {

            }

            //face2faceControlAndAdd
            try {
                if (allPage.checked().faceToFace.isDisplayed()) {
                    allPage.checked().faceToFace.click();

                    for (int j = 0; j < 1; j++) {
                        int size1 = random.nextInt(allPage.checked().amountOfLeoCourses.size() - 1);
                        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", allPage.checked().amountOfLeoCourses.get(size1));
                    }
                    wait.until(ExpectedConditions.elementToBeClickable(allPage.checked().addToChart));
                    allPage.checked().addToChart.click();
                    Thread.sleep(1000);
                    listLeoPrice.add(allPage.checked().priceFace2FaceLeo.getText());
                    wait.until(ExpectedConditions.elementToBeClickable(allPage.checked().close));
                    allPage.checked().close.click();
                    wait.until(ExpectedConditions.elementToBeClickable(allPage.checked().chart));
                    allPage.checked().chart.click();
                    wait.until(ExpectedConditions.elementToBeClickable(allPage.checked().delete));
                    allPage.checked().delete.click();
                    Thread.sleep(1000);
                    Driver.getDriver().navigate().back();

                }
            } catch (Exception e) {

            }
//academyNameCheck
            String academyNameAtLeo = allPage.checked().academyNameAtLeo.getText();
            listLeoAcademyName.add(academyNameAtLeo);
            //click face to face button and check academyName
            try {
                if (allPage.checked().faceToFace.isDisplayed()) {
                    allPage.checked().faceToFace.click();
                    for (int j = 0; j < allPage.checked().amountOfLeoCourses.size() - 1; j++) {
                        allPage.checked().amountOfLeoCourses.get(j).click();
                        // mapAcademyNameAtLeo1.put(allPage.checked().nameOfCourseAtLeo.getText(), allPage.checked().academyNameAtLeo.getText());
                        Assert.assertEquals(allPage.checked().academyNameAtCrm.getText(), allPage.checked().academyNameAtLeo.getText());

                    }
                }
            } catch (Exception e) {
            }
            //click live button and check academyName
            try {
                if (allPage.checked().live.isDisplayed()) {
                    allPage.checked().live.click();
                    for (int j = 0; j < allPage.checked().amountOfLeoCourses.size() - 1; j++) {
                        allPage.checked().amountOfLeoCourses.get(j).click();
                        // mapAcademyNameAtLeo2.put(allPage.checked().nameOfCourseAtLeo.getText(), allPage.checked().academyNameAtLeo.getText());
                        Assert.assertEquals(allPage.checked().academyNameAtCrm.getText(), allPage.checked().academyNameAtLeo.getText());
                    }
                }
            } catch (Exception e) {

            }
//overviewCheck
            listLeoOverview.add(allPage.checked().overview.getText());
            //click face to face button and check overview
            try {
                if (allPage.checked().faceToFace.isDisplayed()) {
                    allPage.checked().faceToFace.click();
                    String overview = allPage.checked().overview.getText();
                    for (int j = 0; j < allPage.checked().amountOfLeoCourses.size() - 1; j++) {
                        allPage.checked().amountOfLeoCourses.get(j).click();
                        Assert.assertEquals(overview, allPage.checked().overview.getText());
                    }
                }
            } catch (Exception e) {
            }
            //click live button and check overview
            try {
                if (allPage.checked().live.isDisplayed()) {
                    allPage.checked().live.click();
                    String overview1 = allPage.checked().overview.getText();
                    for (int j = 0; j < allPage.checked().amountOfLeoCourses.size() - 1; j++) {
                        allPage.checked().amountOfLeoCourses.get(j).click();
                        Assert.assertEquals(overview1, allPage.checked().overview.getText());
                    }
                }
            } catch (Exception e) {
            }
//keyTakeAwayCheck
            for (int j = 0; j < allPage.checked().listTakeAwayLeo.size(); j++) {
                listLeoKeyTakeAway.add(allPage.checked().listTakeAwayLeo.get(j).getText());
            }
            //string manipulation for keyTakeAway
            for (int x = 0; x < listLeoKeyTakeAway.size(); x++) {
                String s = listLeoKeyTakeAway.get(x).split("[0-9]")[1].trim();
                listLeoKeyTakeAway1.add(s);
            }
//courseOutlineCheck
            try {
                if (allPage.checked().viewMore.isDisplayed()) {
                    wait.until(ExpectedConditions.elementToBeClickable(allPage.checked().viewMore));
                    JSUtils.elementiGoreneKadarKaydirVeTikla(allPage.checked().viewMore);
                    allPage.checked().emailForOutline.sendKeys(ConfigReader.getProperty("emailForLeo"));
                    allPage.checked().passwordForOutline.sendKeys(ConfigReader.getProperty("passwordForLeo"));
                    allPage.checked().sıgnIn.click();

                    wait.until(ExpectedConditions.elementToBeClickable(allPage.checked().viewMore));
                    JSUtils.elementiGoreneKadarKaydirVeTikla(allPage.checked().viewMore);

                    Thread.sleep(2000);
                }
            } catch (Exception e) {
            }
            for (int j = 0; j < allPage.checked().buttonsLeo.size(); j++) {
                JSUtils.elementiGoreneKadarKaydirVeTikla(allPage.checked().buttonsLeo.get(j));
                listLeoOutline.add(allPage.checked().ıntroLeo.get(j).getText());
            }
//back
            allPage.checked().courses.click();
            Thread.sleep(1000);
        }
        mapLeoRelatedCourses.put(listLeoCourseName, listLeoRelatedCourses);
        System.out.println("mapLeoRelatedCourses = " + mapLeoRelatedCourses);
        mapLeoPM.put(listLeoCourseName, listLeoPM);
        System.out.println("mapLeoPM = " + mapLeoPM);
        mapLeoPrice.put(listLeoCourseName, listLeoPrice);
        System.out.println("mapLeoPrice = " + mapLeoPrice);
        mapLeoAcademyName.put(listLeoCourseName, listLeoAcademyName);
        System.out.println("mapLeoAcademyName = " + mapLeoAcademyName);
        mapLeoOverview.put(listLeoCourseName, listLeoOverview);
        System.out.println("mapLeoOverview = " + mapLeoOverview);
        mapLeoKeyTakeAway.put(listLeoCourseName, listLeoKeyTakeAway1);
        System.out.println("mapLeoKeyTakeAway = " + mapLeoKeyTakeAway);
        mapLeoOutline.put(listLeoCourseName, listLeoOutline);
        System.out.println("mapLeoOutline = " + mapLeoOutline);

    }

    @Then("user checks info StatusCheck at CRM with info StatusCheck at loe")
    public void user_checks_info_status_check_at_crm_with_info_status_check_at_loe() {
//statusCheck
        if (listPublish.size() == listLeo.size()) {
            for (String each : listLeo) {
                if (listPublish.contains(each)) {
                    return;
                } else {
                    Assert.fail();
                }
            }
        } else {
            Assert.fail();
        }
    }

    @Then("user checks info relatedCourses at CRM with info relatedCourses at loe")
    public void user_checks_info_related_courses_at_crm_with_info_related_courses_at_loe() {
//relatedCourses
        for (Map.Entry<List<String>, List<String>> each1 : mapCRMRelatedCourses.entrySet()) {
            for (Map.Entry<List<String>, List<String>> each2 : mapLeoRelatedCourses.entrySet()) {
                if (each1.getKey().equals(each2.getKey())) {
                    Assert.assertEquals(each1.getValue(), each2.getValue());
                } else {
                    Assert.fail();
                }
            }
        }
    }

    @Then("user checks info PM at CRM with info PM at loe")
    public void user_checks_info_pm_at_crm_with_info_pm_at_loe() {
        //PMCheck
        for (Map.Entry<List<String>, List<String>> each1 : mapCRMPM.entrySet()) {
            for (Map.Entry<List<String>, List<String>> each2 : mapLeoPM.entrySet()) {
                if (each1.getKey().equals(each2.getKey())) {
                    Assert.assertEquals(each1.getValue(), each2.getValue());
                } else {
                    Assert.fail();
                }
            }
        }
    }

    @Then("user checks info price at CRM with info price at loe")
    public void user_checks_info_price_at_crm_with_info_price_at_loe() {
        //PriceCheck
        List<String> price1 = new ArrayList<>();
        for (int i = 0; i < listCRMPrice.size(); i++) {
            price1.add(listCRMPrice.get(i).replaceFirst("[$] ", ""));
        }
        List<String> price2 = new ArrayList<>();
        for (int i = 0; i < listLeoPrice.size(); i++) {
            price2.add(listLeoPrice.get(i).replaceFirst(".00 USD", ""));
        }
        Map<List<String>, List<String>> mapCrm2 = new HashMap<>();
        Map<List<String>, List<String>> mapLeo2 = new HashMap<>();
        mapCrm2.put(listCrmCourseName, price1);
        mapLeo2.put(listLeoCourseName, price2);
        for (Map.Entry<List<String>, List<String>> each1 : mapCrm2.entrySet()) {
            for (Map.Entry<List<String>, List<String>> each2 : mapLeo2.entrySet()) {
                if (each1.getKey().equals(each2.getKey())) {
                    Assert.assertEquals(each1.getValue(), each2.getValue());
                } else {
                    Assert.fail();
                }
            }
        }
    }

    @Then("user checks info academyName at CRM with info academyName at loe")
    public void user_checks_info_academy_name_at_crm_with_info_academy_name_at_loe() {
        //academyNameCheck
        for (Map.Entry<List<String>, List<String>> each1 : mapCRMAcademyName.entrySet()) {
            for (Map.Entry<List<String>, List<String>> each2 : mapLeoAcademyName.entrySet()) {
                if (each1.getKey().equals(each2.getKey())) {
                    Assert.assertEquals(each2.getValue(), each1.getValue());
                } else {
                    Assert.fail();
                }
            }
        }
    }

    @Then("user checks info overview at CRM with info overview at loe")
    public void user_checks_info_overview_at_crm_with_info_overview_at_loe() {
        //overviewCheck
        for (Map.Entry<List<String>, List<String>> each1 : mapCRMOverview.entrySet()) {
            for (Map.Entry<List<String>, List<String>> each2 : mapLeoOverview.entrySet()) {
                if (each1.getKey().equals(each2.getKey())) {
                    Assert.assertEquals(each2.getValue(), each1.getValue());
                } else {
                    Assert.fail();
                }
            }
        }
    }

    @Then("user checks info keyTakeAway at CRM with info keyTakeAway at loe")
    public void user_checks_info_key_take_away_at_crm_with_info_key_take_away_at_loe() {
        //keyTakeAwayCheck
        for (Map.Entry<List<String>, List<String>> each1 : mapCRMKeyTakeAway.entrySet()) {
            for (Map.Entry<List<String>, List<String>> each2 : mapLeoKeyTakeAway.entrySet()) {
                if (each1.getKey().equals(each2.getKey())) {
                    Assert.assertEquals(each2.getValue(), each1.getValue());
                } else {
                    Assert.fail();
                }
            }
        }
    }

    @Then("user checks info courseOutline at CRM with info courseOutline at loe")
    public void user_checks_info_course_outline_at_crm_with_info_course_outline_at_loe() {
        //outlineCheck
        for (Map.Entry<List<String>, List<String>> each1 : mapCRMOutline.entrySet()) {
            for (Map.Entry<List<String>, List<String>> each2 : mapLeoOutline.entrySet()) {
                if (each1.getKey().equals(each2.getKey())) {
                    Assert.assertEquals(each2.getValue(), each1.getValue());
                } else {
                    Assert.fail();
                }
            }
        }
    }

}

