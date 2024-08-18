package com.hsbc.storage;

import com.hsbc.models.BugSeverity;
import com.hsbc.models.Project;

public interface TesterDAL {

    void raiseBug(int bugId, String bugMessage, BugSeverity bugSeverity, Project project);

    void inspectBug(int bugId);

    void createReport();
}
