package org.scoula.security.account.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

// UserDetails 구현
@Getter
@Setter
public class CustomUser extends User{

    private MemberVO member; // 실질적 사용자 데이터

    /* Collection<? extends GrantedAuthority> : GrantedAuthority를 상속한 것이면 collection에 들어갈 수 있다. */
    // 우리의 경우, AuthVO가 해당할 것임.
    /* 권한 갖고 오기 */
    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public CustomUser(MemberVO vo) {
        super(vo.getUsername(), vo.getPassword(),vo.getAuthList());
        this.member = vo;

    }
}
