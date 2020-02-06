package first.amna;


import android.text.method.Touch;

import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class secondSuite {
    private AndroidDriver<MobileElement> driver;

    @BeforeTest
    public void setUP() throws MalformedURLException {
        File app = new File("./Application/sfd.apk");

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());

//        dc.setCapability(MobileCapabilityType.UDID,  "emulator-5554");
//        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus");
//        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
//        dc.setCapability(AndroidMobileCapabilityType.AVD, "Nexus");
//        //dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
//
//        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.sarajevo.food.dictionary");
//        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.sfdmobile.MainActivity");
//        dc.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
//        dc.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);

        dc.setCapability(MobileCapabilityType.UDID, "7EX0217B16003695");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "VTR_L29");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.1.0");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.sarajevo.food.dictionary");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.sfdmobile.MainActivity");
        dc.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        dc.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);

        driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),dc);
    }
    //1
    @Test
    public void Verify_user_can_login_as_tourist() throws InterruptedException {
        long timeOutInSeconds;
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = 'Next']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text = 'Next']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text = 'Next']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text = 'Next']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text = 'Tourist']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text = 'Get Started']")).click();
        Thread.sleep(500);
        driver.findElements(By.className("android.widget.ImageView")).get(0).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//android.widget.TextView[@text = 'Settings']")).click();
        Thread.sleep(500);
        MobileElement tourist = driver.findElement(By.xpath("//android.widget.TextView[@text = 'Tourist']"));
        Assert.assertEquals(tourist.getText(), "Tourist");
    }

    //2
    @Test
    public void Verify_user_can_login_as_local() throws InterruptedException {
        long timeOutInSeconds;
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Next']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Local']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Get Started']")).click();
        Thread.sleep(1000);
        driver.findElements(By.className("android.widget.ImageView")).get(0).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Settings']")).click();
        Thread.sleep(500);
        MobileElement local = driver.findElement(By.xpath("//android.widget.TextView[@text='Local']"));
        Assert.assertEquals(local.getText(), "Local");
    }

    //3
    @Test
    public void Verify_user_can_use_filters() throws InterruptedException {
        long timeOutInSeconds;
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Skip']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Skip']")).click();
        Thread.sleep(500);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Get Started\")")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Filter\")")).click();
        Thread.sleep(3000);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\"))" +
                ".getChildByText(new UiSelector().className(\"android.widget.TextView\"), \"Pork free?\")")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\"))" +
                ".getChildByText(new UiSelector().className(\"android.widget.TextView\"), \"Non alcoholic?\")")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Apply\")")).click();
    }

    //4
    @Test
    public void Verfy_user_can_search() throws InterruptedException {
        long timeOutInSeconds;
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Skip']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Skip']")).click();
        Thread.sleep(500);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Get Started\")")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Search\")")).click();
        Thread.sleep(500);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Search\")")).sendKeys("Coff");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.widget.EditText[contains(@text, 'Cof')]")).getAttribute("text");
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath("//android.widget.EditText[contains(@text, 'Cof')]")).getAttribute("text"));
    }

    //5
    @Test
    public void Verfy_user_can_swipe_menu() throws InterruptedException {
        long timeOutInSeconds;
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Skip']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Skip']")).click();
        Thread.sleep(500);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Get Started\")")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        new TouchAction(driver).press(PointOption.point(1028, 943)).moveTo(PointOption.point(672, 943)).release().perform();
        System.out.println(driver.findElements(By.className("android.widget.TextView")).get(2).getAttribute("text"));
        MobileElement weRecommendYou = driver.findElement(By.xpath("//android.widget.TextView[@text='WE RECOMMEND YOU']"));
        Assert.assertEquals(weRecommendYou.getText(), "WE RECOMMEND YOU");
    }

    //6
    @Test
    public void Verify_user_can_hide_seek_Places_Nearby() throws InterruptedException {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Skip']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Skip']")).click();
        Thread.sleep(500);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Get Started\")")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        new TouchAction(driver).press(PointOption.point(139,1299)).moveTo(PointOption.point(139, 1748)).release().perform();
        new TouchAction(driver).press(PointOption.point(139,1748)).moveTo(PointOption.point(139, 1299)).release().perform();
    }

    //7
    @Test
    public void Verify_user_have_notifications_bar() throws InterruptedException {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Skip']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Skip']")).click();
        Thread.sleep(500);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Get Started\")")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By
                .xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget" +
                        ".LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view" +
                        ".ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android" +
                        ".view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android" +
                        ".view.ViewGroup[3]/android.view.ViewGroup/android.widget.ImageView")).click();
        Thread.sleep(2000);
        MobileElement nofif = driver.findElement(By.xpath("//android.widget.TextView[@text='Notifikacije']"));
        Assert.assertEquals(nofif.getText(), "Notifikacije");
    }

    //8
    @Test
    public void Verify_user_can_change_lang_to_BHS() throws InterruptedException {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Skip']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Skip']")).click();
        Thread.sleep(500);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Get Started\")")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElements(By.className("android.widget.ImageView")).get(0).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//android.widget.TextView[@text = 'Settings']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Language']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Bosanski']")).click();
        MobileElement postavke = driver.findElement(By.xpath("//android.widget.TextView[@text='Postavke']"));
        Assert.assertEquals(postavke.getText(), "Postavke");
    }

    //9
    @Test
    public void Verify_user_can_open_FB_page() throws InterruptedException {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Skip']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Skip']")).click();
        Thread.sleep(500);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Get Started\")")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElements(By.className("android.widget.ImageView")).get(0).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//android.widget.TextView[@text='sfd.ba']")).click();
        MobileElement facebook = driver.findElement(By.xpath("//android.view.View[@text='Sarajevo Food Dictionary']"));
        Assert.assertEquals(facebook.getText(), "Sarajevo Food Dictionary");
    }

    //9
    @Test
    public void Verify_user_can_open_YouTube_page() throws InterruptedException {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Skip']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Skip']")).click();
        Thread.sleep(500);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Get Started\")")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElements(By.className("android.widget.ImageView")).get(0).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Sarajevo Food Dictionary']")).click();
        MobileElement youtube = driver.findElement(By.xpath("//android.widget.TextView[@text='Sarajevo Food Dictionary']"));
        Thread.sleep(500);
        Assert.assertEquals(youtube.getText(), "Sarajevo Food Dictionary");
    }

    //10
    @Test
    public void Verify_user_can_open_IG_page() throws InterruptedException {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Skip']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Skip']")).click();
        Thread.sleep(500);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Get Started\")")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElements(By.className("android.widget.ImageView")).get(0).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//android.widget.TextView[@text='sarajevo.food.dictionary']")).click();
        MobileElement insta = driver.findElement(By.xpath("//android.widget.TextView[@text='Sarajevo Food Dictionary']"));
        Thread.sleep(500);
        Assert.assertEquals(insta.getText(), "Sarajevo Food Dictionary");
    }

    //11
    @Test
    public void Verify_user_can_open_place_from_search() throws InterruptedException {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Skip']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Skip']")).click();
        Thread.sleep(500);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Get Started\")")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Search\")")).click();
        Thread.sleep(500);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Search\")")).sendKeys("Manolo");
        Thread.sleep(5000);
        new TouchAction(driver).press(PointOption.point(226, 648)).release().perform();
        new TouchAction(driver).press(PointOption.point(225, 648)).release().perform();
        MobileElement title = driver.findElement(By.xpath("//android.widget.TextView[@text='Manolo']"));
        Thread.sleep(500);
        Assert.assertEquals(title.getText(), "Manolo");

    }

    public void tearDown (){
        driver.quit();
    }
}
