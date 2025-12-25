public interface MatchAttemptService {
    MatchAttemptRecord logMatchAttempt(MatchAttemptRecord r);
    MatchAttemptRecord updateAttemptStatus(long id, String status);
    List<MatchAttemptRecord> getAllMatchAttempts();
}
