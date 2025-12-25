@GetMapping("/{id}")
public ResponseEntity<StudentProfile> get(@PathVariable long id) {
    return service.getStudentById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}

@GetMapping("/lookup/{studentId}")
public ResponseEntity<StudentProfile> getByStudentId(@PathVariable String studentId) {
    return service.findByStudentId(studentId)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}
