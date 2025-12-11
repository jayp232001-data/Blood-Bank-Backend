package com.example.model;
import jakarta.persistence.*;



@Entity
@Table(name = "blood_requests")
public class BloodRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;
    private String userName;
    private String userType;            // Receiver / Patient / Other
    private String requiredBloodGroup;
    private int quantityRequired;
    private double totalAmount;
    private String urgencyLevel;        // Normal / High / Emergency
    private String hospitalName;
    private String referredBy;

    @Column(length = 500)
    private String purposeOfIssue;

    public BloodRequest() {}

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }

    public String getRequiredBloodGroup() { return requiredBloodGroup; }
    public void setRequiredBloodGroup(String requiredBloodGroup) { this.requiredBloodGroup = requiredBloodGroup; }

    public int getQuantityRequired() { return quantityRequired; }
    public void setQuantityRequired(int quantityRequired) { this.quantityRequired = quantityRequired; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public String getUrgencyLevel() { return urgencyLevel; }
    public void setUrgencyLevel(String urgencyLevel) { this.urgencyLevel = urgencyLevel; }

    public String getHospitalName() { return hospitalName; }
    public void setHospitalName(String hospitalName) { this.hospitalName = hospitalName; }

    public String getReferredBy() { return referredBy; }
    public void setReferredBy(String referredBy) { this.referredBy = referredBy; }

    public String getPurposeOfIssue() { return purposeOfIssue; }
    public void setPurposeOfIssue(String purposeOfIssue) { this.purposeOfIssue = purposeOfIssue; }
}

