@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository repo;

    public MatchAttemptServiceImpl(MatchAttemptRecordRepository r) { this.repo = r; }

    public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord r) {
        return repo.save(r);
    }

    public MatchAttemptRecord updateAttemptStatus(long id, String s) {
        MatchAttemptRecord r = repo.findById(id).orElseThrow();
        r.setStatus(MatchAttemptRecord.Status.valueOf(s));
        return repo.save(r);
    }

    public List<MatchAttemptRecord> getAllMatchAttempts() {
        return repo.findAll();
    }
}
