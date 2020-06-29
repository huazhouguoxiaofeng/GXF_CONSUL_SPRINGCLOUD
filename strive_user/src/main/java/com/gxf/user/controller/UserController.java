package com.gxf.user.controller;

import com.gxf.common.entity.TestEntity;
import com.gxf.common.entity.UserEntity;
import com.gxf.user.back.handler.MyException;
import com.gxf.user.configuration.GuoXiaoProperties;
import com.gxf.user.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private GuoXiaoProperties guoXiaoProperties;

    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private String serverPort;

    @Value("${xixi.haha:10086}")
    private String myName;

    @ApiOperation(value="获取用户详情", notes="获取用户详情")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long",paramType = "path")
    @GetMapping("/get-user-by-id/{id}")
    public UserEntity getUserById(@PathVariable long id){
        UserEntity userEntity = userService.getUserById(id);
//        return "SUCCESS: " + serverPort + ": id" + id;
        log.info(" \n guoXiaoProperties的属性为：{}", guoXiaoProperties.toString());
        System.out.println("userEntity: " + userEntity);
        return userEntity;
    }

    /**
     * 单个对象参数
     * @return
     */
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "UserEntity")
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @PostMapping(value = "/add")
    public Long add(@RequestBody UserEntity user){
        return userService.add(user);
    }

    @GetMapping("/test-json-diff")
    public TestEntity testJsonDiff(){
        TestEntity testEntity = new TestEntity();
        testEntity.setTestJsonInclude02(" ");
        return testEntity;
    }

    @GetMapping("/test-exception")
    public String testException(int digit){

        switch (digit){
            case 1:
                String a = null;
                a.concat("afgsafd");
                return a;
            case 2:
                int b = 1 / 0;
                return "fail";
            case 3:
                throw new MyException("100856", "出MyException异常了");
            default:
                return "thankYou";

        }

    }

}
