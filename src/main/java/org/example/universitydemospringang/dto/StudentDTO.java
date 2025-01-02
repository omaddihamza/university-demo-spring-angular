package org.example.universitydemospringang.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String code;
    private String programId;
    private String photo;
}
