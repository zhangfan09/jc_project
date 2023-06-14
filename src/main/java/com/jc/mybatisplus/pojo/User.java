package com.jc.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jc.mybatisplus.enums.SexEnum;
import lombok.Data;

/*
@NoArgsConstructor :代替无参构造、
@AllargsConstructor :代替有参构造。
@Getter
@Setter
@EqualsAndHashCode
@Data 相当于 @NoArgsConstructor + @Getter + @Setter +@EqualsAndHashCode。
*/
@Data
@TableName("user")//绑定实体类与表名称。
public class User {
    @TableId(value="id")//设置指定表中的设置。
    private Long id;
    @TableField("name")//绑定实体类与表字段。
    private String name;

    private Integer age;

    private SexEnum sex;

    private  String email;
    //@TableLogic //标记该字段为逻辑删除，执行删除方法时，实际执行的是修改方法。
    @TableField("is_delete_flag")
    private Integer isDeleteFlag;
}
