@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final CompatibilityScoreRecordRepository repo;
    private final HabitProfileRepository habitRepo;

    public CompatibilityScoreServiceImpl(CompatibilityScoreRecordRepository r, HabitProfileRepository h) {
        this.repo = r; this.habitRepo = h;
    }

    public CompatibilityScoreRecord computeScore(long a, long b) {
        HabitProfile A = habitRepo.findByStudentId(a).orElseThrow();
        HabitProfile B = habitRepo.findByStudentId(b).orElseThrow();

        double score = 100 - Math.abs(A.getStudyHoursPerDay() - B.getStudyHoursPerDay()) * 5;

        CompatibilityScoreRecord rec = new CompatibilityScoreRecord();
        rec.setStudentAId(a);
        rec.setStudentBId(b);
        rec.setScore(score);

        return repo.save(rec);
    }

    public List<CompatibilityScoreRecord> getScoresForStudent(long id) {
        return repo.findByStudentAIdOrStudentBId(id, id);
    }

    public CompatibilityScoreRecord getScoreById(long id) {
        return repo.findById(id).orElse(null);
    }
}
