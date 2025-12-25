@Entity
public class MatchAttemptRecord {

    public enum Status { MATCHED, NOT_COMPATIBLE, PENDING_REVIEW }

    @Id @GeneratedValue
    private Long id;

    private Long initiatorStudentId;
    private Long candidateStudentId;
    private Long resultScoreId;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime attemptedAt;

    public void setId(Long id) { this.id = id; }
    public void setAttemptedAt(LocalDateTime attemptedAt) { this.attemptedAt = attemptedAt; }
    public void setStatus(Status status) { this.status = status; }
}
