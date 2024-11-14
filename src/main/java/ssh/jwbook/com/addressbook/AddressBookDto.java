package ssh.jwbook.com.addressbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddressBookDto {

    int num;

    String name;

    String email;

    String addr;

    String tel;
}
