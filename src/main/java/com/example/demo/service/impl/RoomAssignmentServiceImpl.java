@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRecordRepository repo;
    private final StudentProfileRepository studentRepo;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository repo,
                                     StudentProfileRepository studentRepo) {
        this.repo = repo;
        this.studentRepo = studentRepo;
    }

    @Override
    public RoomAssignmentRecord assignRoom(long studentId, String room) {
        StudentProfile s = studentRepo.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        if (!"ACTIVE".equalsIgnoreCase(s.getStatus())) {
            throw new IllegalArgumentException("Student inactive");
        }

        RoomAssignmentRecord r = new RoomAssignmentRecord();
        r.setStudent(s);
        r.setRoom(room);
        r.setStatus(RoomAssignmentRecord.Status.ASSIGNED);

        return repo.save(r);
    }
}
