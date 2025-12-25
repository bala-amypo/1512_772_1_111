public interface RoomAssignmentService {
    RoomAssignmentRecord assignRoom(RoomAssignmentRecord r);
    RoomAssignmentRecord updateStatus(long id, String status);
    List<RoomAssignmentRecord> getAssignmentsByStudent(long id);
    List<RoomAssignmentRecord> getAllAssignments();
}
