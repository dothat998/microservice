package com.base.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_id_seq",
            sequenceName = "employee_id_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_id_seq"
    )
    private Integer id;
    private String employeeId;
    private Integer customerId;
    private String employeeName;
    private String email;
    private String revenue;
}
