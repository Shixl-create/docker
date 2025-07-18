package com.heima.ai.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description
 * @updateRemark
 * @author
 * @updateUser
 * @createDate           2025/7/11 16:49
 * @updateDate           2025/7/11 16:49
 * @version              JDK 17
**/

@Data


public class ContentVo {
    private String role;
    private String content;




    public ContentVo(MessageVo message) {
        this.role=message.getRole();
       /* switch (messageRole) {
            case user -> {
                role="user";
                break;
            }
            case assistant -> {
                role="assistant";
                break;
            }
            default -> {
                role="";
                break;
            }
        }*/
        this.content=message.getContent();
    }
    public ContentVo(){};

    public String getContent() {
        return content;
    }

    public String getRole() {
        return role;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
