package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DownloadFilePage;
import steps.DownloadFileSteps;

import java.io.IOException;

public class DownloadFileTest extends BaseTest {

    private final String fileToDownload = "sample.png";

    @Test
    public void fileUploaderTest() {

        DownloadFilePage downloadFilePage = new DownloadFilePage(driver, true);
        String fileLink = downloadFilePage.getFileDownloadLink(fileToDownload);

        DownloadFileSteps downloadFileSteps = new DownloadFileSteps(driver);
        downloadFileSteps.downloadFile(fileLink);

        Assert.assertTrue(
                downloadFileSteps.isFileDownloaded(fileToDownload),
                String.format("File '%s' doesn't exist.", fileToDownload)
        );
    }

    @Test(dependsOnMethods = "fileUploaderTest")
    public void cleanUploadedFiles() throws IOException {

        DownloadFileSteps downloadFileSteps = new DownloadFileSteps(driver);
        downloadFileSteps.cleanDirectory();

        Assert.assertFalse(
                downloadFileSteps.isFileDownloaded(fileToDownload),
                String.format("File '%s' wasn't removed.", fileToDownload)
        );
    }
}
