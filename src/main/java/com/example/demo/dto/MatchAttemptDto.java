package com.example.demo.dto;

public class MatchAttemptDto {

    private Long initiatorStudentId;
    private Long candidateStudentId;
    private Long resultScoreId;
    private String status;

    public MatchAttemptDto() {}

    public Long getInitiatorStudentId() { return initiatorStudentId; }
    public void setInitiatorStudentId(Long initiatorStudentId) { this.initiatorStudentId = initiatorStudentId; }

    public Long getCandidateStudentId() { return candidateStudentId; }
    public void setCandidateStudentId(Long candidateStudentId) { this.candidateStudentId = candidateStudentId; }

    public Long getResultScoreId() { return resultScoreId; }
    public void setResultScoreId(Long resultScoreId) { this.resultScoreId = resultScoreId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
