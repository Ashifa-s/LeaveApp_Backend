package com.project.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import com.example.demo.model.LeaveRequest;
import com.example.demo.repository.LeaveRequestRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
@RestController
@RequestMapping("/api/leaves")
@CrossOrigin(origins = "*")
public class LeaveRequestController {
   @Autowired
   private LeaveRequestRepository leaveRequestRepository;
   private static final int PLANNED_LEAVE_ADVANCE_DAYS = 28;
   @PostMapping("/apply")
   public ResponseEntity<?> applyLeave(@RequestBody LeaveRequest request) {
       List<String> errors = new ArrayList<>();
       // === REQUIRED FIELD VALIDATIONS ===
       if (isBlank(request.getLeaveType())) errors.add("Leave Type is required.");
       if (isBlank(request.getAvailedBy())) errors.add("Availed By is required.");
       if (isBlank(request.getReason())) errors.add("Reason is required.");
       if (request.getBackupContacts() == null || request.getBackupContacts().isEmpty())
           errors.add("Backup Contact is required.");
       if (request.getNotifyToRecipients() == null || request.getNotifyToRecipients().isEmpty())
           errors.add("Notify To Recipient is required.");
       if (isBlank(request.getBaseLocation())) errors.add("Base Location is required.");
       if (isBlank(request.getProjectSow())) errors.add("Project/SOW is required.");
       if (isBlank(request.getSubTeam())) errors.add("Sub-LOB/Team is required.");
       // === DATE VALIDATION ===
       LocalDate start = request.getStartDate();
       LocalDate end = request.getEndDate();
       LocalDate today = LocalDate.now();
       if (start == null) errors.add("Start Date is required.");
       if (end == null) errors.add("End Date is required.");
       if (start != null && end != null) {
           if (end.isBefore(start)) errors.add("End Date cannot be before Start Date.");
           if ("Planned Leave".equalsIgnoreCase(request.getLeaveType()) &&
               start.minusDays(PLANNED_LEAVE_ADVANCE_DAYS).isBefore(today)) {
               errors.add("Planned Leave must be applied at least " + PLANNED_LEAVE_ADVANCE_DAYS + " days in advance.");
           }
       }
       // === OVERLAPPING LEAVE CHECK ===
       if (request.getAvailedBy() != null && start != null && end != null) {
           List<LeaveRequest> existing = leaveRequestRepository.findByAvailedBy(request.getAvailedBy());
           for (LeaveRequest lr : existing) {
               LocalDate exStart = lr.getStartDate();
               LocalDate exEnd = lr.getEndDate();
               if (exStart != null && exEnd != null &&
                   !(end.isBefore(exStart) || start.isAfter(exEnd))) {
                   errors.add("Overlapping leave already exists for the same user.");
                   break;
               }
           }
       }
       if (!errors.isEmpty()) {
           return ResponseEntity.badRequest().body(Map.of("errors", errors));
       }
       // === SET SYSTEM FIELDS ===
       request.setLeaveStatus("Pending");
       request.setCreatedAt(LocalDateTime.now());
       request.setUpdatedAt(LocalDateTime.now());
       LeaveRequest saved = leaveRequestRepository.save(request);
       return ResponseEntity.ok(Map.of("message", "Leave submitted successfully"));
   }
   @ExceptionHandler(HttpMessageNotReadableException.class)
   public ResponseEntity<?> handleBadRequest(HttpMessageNotReadableException ex) {
       return ResponseEntity.badRequest().body(
           Map.of("error", "Invalid date format. Please use MM-DD-YYYY")
       );
   }
   @GetMapping("/all")
   public List<LeaveRequest> getAllLeaves() {
       return leaveRequestRepository.findAll();
   }
   // Sample insert for testing
   @GetMapping("/insertSample")
   public String insertSampleLeaves() {
       LeaveRequest leave = new LeaveRequest();
       leave.setLeaveType("Sick Leave");
       leave.setAvailedBy("alice@example.com");
       leave.setStartDate(LocalDate.of(2025, 9, 10));
       leave.setEndDate(LocalDate.of(2025, 9, 12));
       leave.setReason("Fever");
       leave.setBackupContacts(List.of("backup@example.com"));
       leave.setNotifyToRecipients(List.of("manager@example.com"));
       leave.setBaseLocation("Chennai");
       leave.setProjectSow("Alpha");
       leave.setSubTeam("Dev");
       leave.setLeaveStatus("Pending");
       leave.setComments("N/A");
       leave.setCreatedAt(LocalDateTime.now());
       leave.setUpdatedAt(LocalDateTime.now());
       leaveRequestRepository.save(leave);
       return "Sample inserted!";
   }
   private boolean isBlank(String val) {
       return val == null || val.trim().isEmpty();
   }
}
