package com.example.tracker.beans;
import com.example.tracker.utils.SexEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table()
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class patientDetails {
    @Id
    private String patient_id;
    private String name;
    @Column(unique = true)
    private String email;
    private Integer age;
    private boolean accept;
    private String sex;
    private String report;


    @CreationTimestamp
    private Date currDate;

    @Override
    public String toString() {
        return "patientDetails{" +
                "patient_id='" + patient_id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", accept=" + accept +
                ", sex='" + sex + '\'' +
                ", report='" + report + '\'' +
                ", currDate=" + currDate +
                '}';
    }
}
