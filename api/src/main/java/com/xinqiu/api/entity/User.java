package com.xinqiu.api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor //无参构造函数
@Data // 提供类的get、set、equals、hashCode、canEqual、toString 方法
@Accessors(chain = true)
public class User implements Serializable {
    private String userName;
    private String password;
    private String phone;
    private String id;
    private String nickName;

}