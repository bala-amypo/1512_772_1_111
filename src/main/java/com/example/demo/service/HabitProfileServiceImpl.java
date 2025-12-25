@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repo;

    public HabitProfileServiceImpl(HabitProfileRepository r) { this.repo = r; }

    public HabitProfile createOrUpdateHabit(HabitProfile h) {
        h.setUpdatedAt(LocalDateTime.now());
        return repo.save(h);
    }

    public HabitProfile getHabitByStudent(long id) {
        return repo.findByStudentId(id).orElse(null);
    }

    public HabitProfile getHabitById(long id) {
        return repo.findById(id).orElse(null);
    }

    public List<HabitProfile> getAllHabits() {
        return repo.findAll();
    }
}
