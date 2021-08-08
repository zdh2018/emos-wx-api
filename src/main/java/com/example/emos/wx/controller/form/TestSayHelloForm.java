package com.example.emos.wx.controller.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author zdh
 * @date 2021/7/28 16:17
 */

@ApiModel
@Data
public class TestSayHelloForm {

   /* @NotNull
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{2,15}$")*/
    @ApiModelProperty("姓名")
    private String name;
}
