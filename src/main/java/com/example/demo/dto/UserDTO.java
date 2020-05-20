package com.example.demo.dto;

import com.example.demo.model.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@EqualsAndHashCode
@Data
@Getter
@Setter
public class UserDTO extends BaseDTO {

    private String userName;
    private Long passWord;

}
