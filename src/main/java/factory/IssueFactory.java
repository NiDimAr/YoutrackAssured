package factory;

import config.ConfigProvider;
import dto.request.IssueRequest;
import dto.request.ProjectDto;

public class IssueFactory {
    private IssueFactory() {
    }


    public static IssueRequest create(
            String summary,
            String description
    ) {

        return IssueRequest.builder()
                .summary(summary)
                .description(description)
                .project(
                        new ProjectDto(
                                ConfigProvider.CONFIG.projectId()
                        )
                )
                .build();
    }
}
