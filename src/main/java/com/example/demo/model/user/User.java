package com.example.demo.model.user;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.base.BaseEntity;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Audited
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {
    private String userName;
    private String passWord;

    public UserDTO toDTO(){
        UserDTO dto = new UserDTO();
        dto.setUserName(this.userName);
        dto.setId(this.getId());
        dto.setPassWord(this.passWord);
        return dto;
    }
}
