@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRecordRepository repo;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository r) { this.repo = r; }

    public RoomAssignmentRecord assignRoom(RoomAssignmentRecord r) {
        return repo.save(r);
    }

    public RoomAssignmentRecord updateStatus(long id, String s) {
        RoomAssignmentRecord r = repo.findById(id).orElseThrow();
        r.setStatus(RoomAssignmentRecord.Status.valueOf(s));
        return repo.save(r);
    }

    public List<RoomAssignmentRecord> getAssignmentsByStudent(long id) {
        return repo.findByStudentAIdOrStudentBId(id, id);
    }

    public List<RoomAssignmentRecord> getAllAssignments() {
        return repo.findAll();
    }
}
