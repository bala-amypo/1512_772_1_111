public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord attempt) {
    attempt.setAttemptedAt(LocalDateTime.now());
    return repo.save(attempt);
}

public MatchAttemptRecord updateAttemptStatus(Long id, String status) {
    MatchAttemptRecord a = repo.findById(id).orElseThrow();
    a.setStatus(MatchAttemptRecord.Status.valueOf(status));
    return repo.save(a);
}
