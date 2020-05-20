package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@Getter
@Setter
public class BaseDTO {
    @NonNull
    private Long id;
}
