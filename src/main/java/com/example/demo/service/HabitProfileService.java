coder@8b592b60d705:~/Workspace/demo$ mvn clean install
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------------< com.example:demo >--------------------------
[INFO] Building demo 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:3.3.2:clean (default-clean) @ demo ---
[INFO] Deleting /home/coder/Workspace/demo/target
[INFO] 
[INFO] --- maven-resources-plugin:3.3.1:resources (default-resources) @ demo ---
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] Copying 0 resource from src/main/resources to target/classes
[INFO] 
[INFO] --- maven-compiler-plugin:3.13.0:compile (default-compile) @ demo ---
[INFO] Recompiling the module because of changed source code.
[INFO] Compiling 39 source files with javac [debug parameters release 17] to target/classes
[INFO] /home/coder/Workspace/demo/src/main/java/com/example/demo/security/JwtUtil.java: /home/coder/Workspace/demo/src/main/java/com/example/demo/security/JwtUtil.java uses or overrides a deprecated API.
[INFO] /home/coder/Workspace/demo/src/main/java/com/example/demo/security/JwtUtil.java: Recompile with -Xlint:deprecation for details.
[INFO] Some messages have been simplified; recompile with -Xdiags:verbose to get full output
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/HabitProfileController.java:[29,33] incompatible types: inference variable T has incompatible bounds
    equality constraints: com.example.demo.model.HabitProfile
    lower bounds: java.util.Optional<com.example.demo.model.HabitProfile>
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/HabitProfileController.java:[34,33] incompatible types: inference variable T has incompatible bounds
    equality constraints: com.example.demo.model.HabitProfile
    lower bounds: java.util.Optional<com.example.demo.model.HabitProfile>
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/StudentProfileController.java:[27,33] incompatible types: inference variable T has incompatible bounds
    equality constraints: com.example.demo.model.StudentProfile
    lower bounds: java.util.Optional<com.example.demo.model.StudentProfile>
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/StudentProfileController.java:[37,33] incompatible types: inference variable T has incompatible bounds
    equality constraints: com.example.demo.model.StudentProfile
    lower bounds: java.util.Optional<com.example.demo.model.StudentProfile>
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/HabitProfileServiceImpl.java:[13,8] com.example.demo.service.impl.HabitProfileServiceImpl is not abstract and does not override abstract method getHabitById(java.lang.Long) in com.example.demo.service.HabitProfileService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/HabitProfileServiceImpl.java:[34,25] getHabitById(java.lang.Long) in com.example.demo.service.impl.HabitProfileServiceImpl cannot implement getHabitById(java.lang.Long) in com.example.demo.service.HabitProfileService
  return type com.example.demo.model.HabitProfile is not compatible with java.util.Optional<com.example.demo.model.HabitProfile>
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/HabitProfileServiceImpl.java:[28,25] getHabitByStudent(java.lang.Long) in com.example.demo.service.impl.HabitProfileServiceImpl cannot implement getHabitByStudent(java.lang.Long) in com.example.demo.service.HabitProfileService
  return type com.example.demo.model.HabitProfile is not compatible with java.util.Optional<com.example.demo.model.HabitProfile>
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/HabitProfileServiceImpl.java:[27,5] method does not override or implement a method from a supertype
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/HabitProfileServiceImpl.java:[33,5] method does not override or implement a method from a supertype
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/MatchAttemptServiceImpl.java:[27,16] cannot find symbol
  symbol:   method setAttemptedAt(java.time.LocalDateTime)
  location: variable attempt of type com.example.demo.model.MatchAttemptRecord
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/MatchAttemptServiceImpl.java:[35,21] incompatible types: java.lang.String cannot be converted to com.example.demo.model.MatchAttemptRecord.Status
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/StudentProfileServiceImpl.java:[13,8] com.example.demo.service.impl.StudentProfileServiceImpl is not abstract and does not override abstract method findByStudentId(java.lang.String) in com.example.demo.service.StudentProfileService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/StudentProfileServiceImpl.java:[39,27] findByStudentId(java.lang.String) in com.example.demo.service.impl.StudentProfileServiceImpl cannot implement findByStudentId(java.lang.String) in com.example.demo.service.StudentProfileService
  return type com.example.demo.model.StudentProfile is not compatible with java.util.Optional<com.example.demo.model.StudentProfile>
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/StudentProfileServiceImpl.java:[28,27] getStudentById(java.lang.Long) in com.example.demo.service.impl.StudentProfileServiceImpl cannot implement getStudentById(java.lang.Long) in com.example.demo.service.StudentProfileService
  return type com.example.demo.model.StudentProfile is not compatible with java.util.Optional<com.example.demo.model.StudentProfile>
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/StudentProfileServiceImpl.java:[27,5] method does not override or implement a method from a supertype
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/StudentProfileServiceImpl.java:[38,5] method does not override or implement a method from a supertype
[INFO] 16 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  11.110 s
[INFO] Finished at: 2025-12-25T20:50:05Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.13.0:compile (default-compile) on project demo: Compilation failure: Compilation failure: 
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/HabitProfileController.java:[29,33] incompatible types: inference variable T has incompatible bounds
[ERROR]     equality constraints: com.example.demo.model.HabitProfile
[ERROR]     lower bounds: java.util.Optional<com.example.demo.model.HabitProfile>
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/HabitProfileController.java:[34,33] incompatible types: inference variable T has incompatible bounds
[ERROR]     equality constraints: com.example.demo.model.HabitProfile
[ERROR]     lower bounds: java.util.Optional<com.example.demo.model.HabitProfile>
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/StudentProfileController.java:[27,33] incompatible types: inference variable T has incompatible bounds
[ERROR]     equality constraints: com.example.demo.model.StudentProfile
[ERROR]     lower bounds: java.util.Optional<com.example.demo.model.StudentProfile>
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/StudentProfileController.java:[37,33] incompatible types: inference variable T has incompatible bounds
[ERROR]     equality constraints: com.example.demo.model.StudentProfile
[ERROR]     lower bounds: java.util.Optional<com.example.demo.model.StudentProfile>
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/HabitProfileServiceImpl.java:[13,8] com.example.demo.service.impl.HabitProfileServiceImpl is not abstract and does not override abstract method getHabitById(java.lang.Long) in com.example.demo.service.HabitProfileService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/HabitProfileServiceImpl.java:[34,25] getHabitById(java.lang.Long) in com.example.demo.service.impl.HabitProfileServiceImpl cannot implement getHabitById(java.lang.Long) in com.example.demo.service.HabitProfileService
[ERROR]   return type com.example.demo.model.HabitProfile is not compatible with java.util.Optional<com.example.demo.model.HabitProfile>
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/HabitProfileServiceImpl.java:[28,25] getHabitByStudent(java.lang.Long) in com.example.demo.service.impl.HabitProfileServiceImpl cannot implement getHabitByStudent(java.lang.Long) in com.example.demo.service.HabitProfileService
[ERROR]   return type com.example.demo.model.HabitProfile is not compatible with java.util.Optional<com.example.demo.model.HabitProfile>
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/HabitProfileServiceImpl.java:[27,5] method does not override or implement a method from a supertype
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/HabitProfileServiceImpl.java:[33,5] method does not override or implement a method from a supertype
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/MatchAttemptServiceImpl.java:[27,16] cannot find symbol
[ERROR]   symbol:   method setAttemptedAt(java.time.LocalDateTime)
[ERROR]   location: variable attempt of type com.example.demo.model.MatchAttemptRecord
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/MatchAttemptServiceImpl.java:[35,21] incompatible types: java.lang.String cannot be converted to com.example.demo.model.MatchAttemptRecord.Status
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/StudentProfileServiceImpl.java:[13,8] com.example.demo.service.impl.StudentProfileServiceImpl is not abstract and does not override abstract method findByStudentId(java.lang.String) in com.example.demo.service.StudentProfileService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/StudentProfileServiceImpl.java:[39,27] findByStudentId(java.lang.String) in com.example.demo.service.impl.StudentProfileServiceImpl cannot implement findByStudentId(java.lang.String) in com.example.demo.service.StudentProfileService
[ERROR]   return type com.example.demo.model.StudentProfile is not compatible with java.util.Optional<com.example.demo.model.StudentProfile>
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/StudentProfileServiceImpl.java:[28,27] getStudentById(java.lang.Long) in com.example.demo.service.impl.StudentProfileServiceImpl cannot implement getStudentById(java.lang.Long) in com.example.demo.service.StudentProfileService
[ERROR]   return type com.example.demo.model.StudentProfile is not compatible with java.util.Optional<com.example.demo.model.StudentProfile>
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/StudentProfileServiceImpl.java:[27,5] method does not override or implement a method from a supertype
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/StudentProfileServiceImpl.java:[38,5] method does not override or implement a method from a supertype
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
coder@8b592b60d705:~/Workspace/demo$ 