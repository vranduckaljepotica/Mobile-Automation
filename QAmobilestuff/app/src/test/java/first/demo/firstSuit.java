package first.demo;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

// import io.appium.java_client.MobileElement;
// import io.appium.java_client.android.AndroidDriver;


public class firstSuit {
    private AndroidDriver<MobileElement> driver;
    @Test
    public void setUP() throws MalformedURLException {

        DesiredCapability dc = new DesiredCapability();
        dc.setCapability(MobileCapabilityType.UDID,  "emulator-5554");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3a API 28");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        dc.setCapability(AndroidMobileCapabilityType.AVD, "Pixel");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.sarajevo.food.dictionary");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.sfdmobile.MainActivity");

        driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),dc);
    }
}
