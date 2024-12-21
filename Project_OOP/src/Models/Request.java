package Models;

import java.time.LocalDate;

public class Request {
    private String requestId;
    private String userId; 
    private String description;
    private LocalDate dateSubmitted;
    private boolean isApproved;

    public Request(String requestId, String userId, String description, LocalDate dateSubmitted) {
        this.requestId = requestId;
        this.userId = userId;
        this.description = description;
        this.dateSubmitted = dateSubmitted;
        this.isApproved = false; 
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(LocalDate dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void approve() {
        this.isApproved = true;
    }

    public void deny() {
        this.isApproved = false;
    }

    @Override
    public String toString() {
        return "Request ID: " + requestId +
               "\nEmployee ID: " + userId +
               "\nDescription: " + description +
               "\nDate Submitted: " + dateSubmitted +
               "\nApproved: " + (isApproved ? "Yes" : "No");
    }
}
