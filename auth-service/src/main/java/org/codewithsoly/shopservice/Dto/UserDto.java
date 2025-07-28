package org.codewithsoly.shopservice.Dto;

import lombok.*;
import org.codewithsoly.shopservice.model.Role;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Setter
@Getter
public class UserDto {
    private String name;
    private String email;
    private String password;
    private Role role;
}
