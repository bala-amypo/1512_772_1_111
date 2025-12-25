public interface CompatibilityScoreService {
    CompatibilityScoreRecord computeScore(long a, long b);
    List<CompatibilityScoreRecord> getScoresForStudent(long id);
    CompatibilityScoreRecord getScoreById(long id);
}
