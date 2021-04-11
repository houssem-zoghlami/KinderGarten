package tn.esprit.spring.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ResetPassword {
    private String username;
    private String password;
    private String newpassword;


}
