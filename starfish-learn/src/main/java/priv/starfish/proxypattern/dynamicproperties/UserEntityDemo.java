package priv.starfish.proxypattern.dynamicproperties;

import lombok.*;

/**
 * @author: jiahaixin
 * @date: 2019/6/21 14:39
 * @description:
 */

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntityDemo {

    private String userId;
    private String userName;
    private Integer age;



}
