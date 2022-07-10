package com.example.tracker.beans;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table()
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class blockDetails {
    @Id
    private String block_id;

    @ManyToOne
    private sampleDetails sd;

    private String remarks;

    private int last_updated_station=3;

    @Override
    public String toString() {
        return "blockDetails{" +
                "block_id='" + block_id + '\'' +
                ", sd=" + sd +
                ", remarks='" + remarks + '\'' +
                ", last_updated_station=" + last_updated_station +
                '}';
    }
}
