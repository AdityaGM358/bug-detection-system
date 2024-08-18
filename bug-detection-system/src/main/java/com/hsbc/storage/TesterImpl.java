package com.hsbc.storage;

import com.hsbc.models.Bug;
import com.hsbc.models.BugSeverity;
import com.hsbc.models.BugStatus;
import com.hsbc.models.Project;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TesterImpl implements TesterDAL{
    private List<Bug> bugList = new ArrayList<>();
    @Override
    public void raiseBug(int bugId, String bugMessage, BugSeverity bugSeverity, Project project) {
        Bug bug = new Bug(bugId, bugMessage, LocalDateTime.now(), null, BugStatus.PENDING, bugSeverity, project);
        bugList.add(bug);
        System.out.println("Bug raised: " + bug);


    }
    private Bug findBugById(int bugId) {
        return bugList.stream()
                .filter(bug -> bug.getBugId() == bugId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void inspectBug(int bugId) {
        Bug bug = findBugById(bugId);
        if (bug != null) {
            System.out.println("Inspecting Bug: " + bug);
            // Additional inspection logic can be added here
        } else {
            System.out.println("Bug with ID " + bugId + " not found.");
        }

    }

    @Override
    public void createReport() {
        System.out.println("Creating bug report...");
        for (Bug bug : bugList) {
            System.out.println(bug);
        }
        System.out.println("Bug report created.");


    }
}
