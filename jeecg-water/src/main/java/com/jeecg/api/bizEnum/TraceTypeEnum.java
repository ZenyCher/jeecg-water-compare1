package com.jeecg.api.bizEnum;

public enum TraceTypeEnum {

		/**支付*/
		PAY,
		/**支付订单*/
		QUERY,
		/**发送支付短信验证码*/
		SEND_SMS,
		/**退款*/
		RETURN,
		/**撤消*/
		CANCEL,
		/**签约 */
		SIGNING, //add by ky_qbq
		/**解签 */
		UNSIGNING, 
		/**解签 */
		SIGN_QUERY
}
