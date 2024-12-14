package Models;

import java.time.LocalDate;

public class PerformanceReport {
    private String reportId;
    private String employeeId; // Employee the report is about
    private String managerId;  // Manager who created the report
    private String comments;
    private LocalDate dateCreated;
    private double performanceScore; // A score between 0.0 and 10.0

    public PerformanceReport(String reportId, String employeeId, String managerId, 
                             String comments, LocalDate dateCreated, double performanceScore) {
        this.reportId = reportId;
        this.employeeId = employeeId;
        this.managerId = managerId;
        this.comments = comments;
        this.dateCreated = dateCreated;
        this.performanceScore = performanceScore;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(double performanceScore) {
        if (performanceScore < 0.0 || performanceScore > 10.0) {
            throw new IllegalArgumentException("Performance score must be between 0.0 and 10.0");
        }
        this.performanceScore = performanceScore;
    }

    @Override
    public String toString() {
        return "Report ID: " + reportId +
               "\nEmployee ID: " + employeeId +
               "\nManager ID: " + managerId +
               "\nComments: " + comments +
               "\nDate Created: " + dateCreated +
               "\nPerformance Score: " + performanceScore;
    }
}
