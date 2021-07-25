package steps;

import baseEntities.BaseStep;
import core.ReadProperties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class DownloadFileSteps extends BaseStep {

    protected ReadProperties properties = new ReadProperties();
    private final File downloadDirectory = new File("src/test/java/files/downloads/");
    private final String downloadDirectoryAbsolutePath = downloadDirectory.getAbsolutePath();

    public DownloadFileSteps(WebDriver driver) {
        super(driver);
    }

    public void downloadFile(String fileDownloadLink) {

        File wgetPath = new File("src/main/java/utils/wget.exe").getAbsoluteFile();
        String wgetAbsolutePath = wgetPath.getAbsolutePath().replace("wget.exe", "wget");

        String wgetCommand = "cmd /c wget -P downloadDestinationPath ".replace("wget", wgetAbsolutePath);

        try {
            Process exec = Runtime.getRuntime().exec(
                    wgetCommand.replace("downloadDestinationPath", downloadDirectoryAbsolutePath) + fileDownloadLink
            );
            int exitVal = exec.waitFor();
            System.out.println("Exit value: " + exitVal);
        } catch (InterruptedException | IOException ex) {
            System.out.println(ex);
        }
    }

    public boolean isFileDownloaded(String fileName){

        return new File("src/test/java/files/downloads/" + fileName).exists();
    }

    public void cleanDirectory() throws IOException {

        FileUtils.cleanDirectory(downloadDirectory.getAbsoluteFile());
    }
}
