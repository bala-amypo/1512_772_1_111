@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository repo;

    public MatchAttemptServiceImpl(MatchAttemptRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord r) {
        if (r.getScore() != null) {
            r.setStatus(MatchAttemptRecord.Status.MATCHED);
        } else {
            r.setStatus(MatchAttemptRecord.Status.PENDING_REVIEW);
        }
        return repo.save(r);
    }
}
