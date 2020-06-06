package com.gxf.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity {

//    @JsonAlias(value = {"111","222"})
//    @JsonAlias(value = "222")
    private String testJsonAlias;

    /**
     * 以这个 testJsonProperty111 的形式返回
     */
    @JsonProperty("testJsonProperty111")
    private String testJsonProperty;

    /**
     * 这个属性就不用返回了
     */
    @JsonIgnore
    private String testJsonIgnore;

    /**
     * 只有 testJsonInclude 不为null的时候，才返回
     * 注意：“”也是不为null的
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String testJsonInclude01;

    /**
     * 注意与上面那个的区别
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String testJsonInclude02;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
    private LocalDateTime testJsonFormat;

}
