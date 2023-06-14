package com.jc.mybatisplus.controller;/*
 *@title SwaggerController
 *@description
 *@author 小沥青
 *@version 1.0
 *@create 2023/6/14 10:23
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jc.mybatisplus.mapper.UserMapper;
import com.jc.mybatisplus.pojo.SwaggerReqVO;
import com.jc.mybatisplus.pojo.SwaggerResVO;
import com.jc.mybatisplus.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author （接口类总设计负责人）:张帆
 * @version （接口版本）:1.0
 * @BelongsProject : mybatisplus
 * @BelongsPackage : com.jc.mybatisplus.controller
 * @Description swagger接口测试.
 * <p>
 * <strong>提供者：</strong>（提供业务组）
 * <p>
 * <strong>使用者：</strong>（使用业务组，若分方法描述可省略此项）
 * <p>
 * <strong>设计状态：</strong> 默认风格访问地址：http://192.168.42.1:8080/swagger-ui.html#/
 *  bootstrap 风格访问地址 ：http://192.168.42.1:8080/doc.html
 * <p>
 * @CreateTime : 2023-06-14  10:23
 */
@RestController
@RequestMapping("/swagger")
/**
* @Api 用在请求的类上，表示对类的说明，也代表了这个类是swagger2的资源
* tags：说明该类的作用，参数是个数组，可以填多个。
* value="该参数没什么意义，在UI界面上不显示，所以不用配置"
* description = "用户基本信息操作"
* */
@Api(value = "用户接口", tags = {"用户接口"})
public class SwaggerController {
    @Autowired
    private UserMapper userMapper;

    /**
     * @ApiOperation()：用于方法，表示一个http请求访问该方法的操作
     * value="方法的用途和作用"
     * notes="方法的注意事项和备注"
     * tags：说明该方法的作用，参数是个数组，可以填多个。
     * 格式：tags={"作用1","作用2"}
     * （在这里建议不使用这个参数，会使界面看上去有点乱，前两个常用）
     */
    @ApiOperation("新增用户")
    @PostMapping("save")
    public String save(@RequestBody SwaggerReqVO req) {
        return "success";
    }

    @GetMapping("getById")
    @ApiOperation("根据条件查询用户")
    public SwaggerResVO getById(@RequestBody SwaggerResVO req) {
        return new SwaggerResVO();
    }

    @RequestMapping("login")
    public  String login(){
        System.out.println("已进入login方法-----------------------------------------");
        return "login";
    }

    /**
     * @ApiImplicitParams：用在请求的方法上，包含多@ApiImplicitParam
     * @ApiImplicitParam 用于方法，表示单独的请求参数
     *  name="参数ming"
     * value="参数说明"
     * dataType="数据类型"
     * paramType="query" 表示参数放在哪里
     *     · header 请求参数的获取：@RequestHeader
     *     · query   请求参数的获取：@RequestParam
     *     · path（用于restful接口） 请求参数的获取：@PathVariable
     *     · body（不常用）
     *     · form（不常用）
     * defaultValue="参数的默认值"
     * required="true" 表示参数是否必须传
     *
     * @ApiParam()：用于方法，参数，字段说明表示对参数的要求和说明
     * 参数：
     *
     * name="参数名称"
     * value="参数的简要说明"
     * defaultValue="参数默认值"
     * required="true" 表示属性是否必填，默认为false
     * @ApiResponses：用于请求的方法上，根据响应码表示不同响应。(一个@ApiResponses包含多个@ApiResponse)
     * @ApiResponse：用在请求的方法上，表示不同的响应
     * code="404"    表示响应码(int型)，可自定义
     * message="状态码对应的响应信息"
     * @ApiIgnore()：用于类或者方法上，不被显示在页面上
     * @Profile({"dev", "test"})：用于配置类上，表示只对开发和测试环境有用
     */
    @ApiOperation(value = "查询人员信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "小沥青", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "age", value = "10", paramType = "query", dataType = "int"),
    })
    @RequestMapping("testSelectList")
    @ResponseBody
    public List<User> testSelectList(String name , Integer age) {
        //查询条件构造器查询一个list集合，若没有条件，则可以设置null为参数。
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("name", name);
        queryWrapper.isNotNull("email");
        queryWrapper.orderByDesc(age);//按年龄降序
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
        System.out.println("查询结束-----------------------------------------");
        return userList;
    }
}
