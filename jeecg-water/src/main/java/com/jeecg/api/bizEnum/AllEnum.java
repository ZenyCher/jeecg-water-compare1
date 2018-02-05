package com.jeecg.api.bizEnum;

public enum AllEnum {

	STATE_0(0),
	STATE_1(1),
	STATE_2(2);
	
	private final Integer value;
	
    // 构造器默认也只能是private, 从而保证构造函数只能在内部使用
	AllEnum(Integer value) {
        this.value = value;
    }
    
    public Integer getValue() {
        return value;
    }
}
