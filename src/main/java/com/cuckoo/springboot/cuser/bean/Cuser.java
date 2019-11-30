package com.cuckoo.springboot.cuser.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

@Data
@TableName(value = "cuser")
public class Cuser implements Serializable {
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Integer id;

    @TableField(value = "username")
    private String username;

    @TableField(value = "pwd")
    private String pwd;

    @TableField(value = "is_active")
    private String isActive;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_USERNAME = "username";

    public static final String COL_PWD = "pwd";

    public static final String COL_IS_ACTIVE = "is_active";
}