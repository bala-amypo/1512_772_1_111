public interface HabitProfileService {
    HabitProfile createOrUpdateHabit(HabitProfile habit);
    HabitProfile getHabitByStudent(long id);
    HabitProfile getHabitById(long id);
    List<HabitProfile> getAllHabits();
}
