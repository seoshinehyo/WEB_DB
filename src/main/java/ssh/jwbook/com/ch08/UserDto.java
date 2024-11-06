package ssh.jwbook.com.ch08;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private int num;
    private String name;
    private String email;

    public UserDto(int num, String name, String email) {
        this.num = num;
        this.name = name;
        this.email = email;
    }
}
