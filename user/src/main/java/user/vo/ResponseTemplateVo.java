package user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import user.model.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVo {
    private User user;
    public void setUser(User user) {
        this.user = user;
    }
}
