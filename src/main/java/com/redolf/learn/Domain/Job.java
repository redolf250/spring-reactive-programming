package com.redolf.learn.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private String id;
    private String title;
    private String employee;

}
