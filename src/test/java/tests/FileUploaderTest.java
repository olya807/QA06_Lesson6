package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploaderPage;

import java.io.File;

public class FileUploaderTest extends BaseTest {

    @Test
    public void fileUploaderTest() {

        String fileName = "TestUpload.txt";

        File file = new File("src/test/java/files/uploads/" + fileName);
        String absolute = file.getAbsolutePath();

        FileUploaderPage fileUploaderPage = new FileUploaderPage(driver, true);
        fileUploaderPage.getChooseFile().sendKeys(absolute);
        fileUploaderPage.getButtonUpload().click();

        String actualMessage = fileUploaderPage.getMessageUploaded().getText().trim();
        Assert.assertEquals(
                fileName,
                actualMessage,
                String.format("Message is not correct.Expected '%s' but was '%s'.", fileName, actualMessage)
        );
    }
}
