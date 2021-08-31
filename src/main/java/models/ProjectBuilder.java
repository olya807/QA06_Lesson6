package models;

public class ProjectBuilder {

    private String projectName;
    private String projectEditName;
    private String projectAnnouncementText;
    private String projectAnnouncementEditText;

    public String getProjectName() {
        return projectName;
    }

    public String getProjectEditName() {
        return projectEditName;
    }

    public String getProjectAnnouncementText() {
        return projectAnnouncementText;
    }

    public String getProjectAnnouncementEditText() {
        return projectAnnouncementEditText;
    }

    public static class Builder {
        private ProjectBuilder projectBuilder;

        public Builder() {

            projectBuilder = new ProjectBuilder();
        }

        public Builder withProjectName(String projectName) {

            projectBuilder.projectName = projectName;
            return this;
        }

        public Builder withProjectEditName(String projectEditName) {

            projectBuilder.projectEditName = projectEditName;
            return this;
        }

        public Builder withAnnouncementText(String projectAnnouncementText) {

            projectBuilder.projectAnnouncementText = projectAnnouncementText;
            return this;
        }

        public Builder withAnnouncementEditText(String projectAnnouncementEditText) {

            projectBuilder.projectAnnouncementEditText = projectAnnouncementEditText;
            return this;
        }

        public ProjectBuilder build() {

            return projectBuilder;
        }
    }
}
