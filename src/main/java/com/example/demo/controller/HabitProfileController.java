@GetMapping("/student/{studentId}")
public ResponseEntity<HabitProfile> getByStudent(@PathVariable long studentId) {
    return service.getHabitByStudent(studentId)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}

@GetMapping("/{id}")
public ResponseEntity<HabitProfile> get(@PathVariable long id) {
    return service.getHabitById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}
