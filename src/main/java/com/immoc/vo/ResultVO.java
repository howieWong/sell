package com.immoc.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

//return the outmost layer object
@Data
@NoArgsConstructor
public class ResultVO<T> {
        private Integer code;//error code
        private String msg;//hint message
        private T data;//content
}
