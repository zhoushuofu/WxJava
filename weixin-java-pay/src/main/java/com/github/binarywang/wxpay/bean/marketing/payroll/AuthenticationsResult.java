package com.github.binarywang.wxpay.bean.marketing.payroll;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <pre>
 * 获取核身结果
 * 文档地址：https://pay.weixin.qq.com/wiki/doc/apiv3_partner/Offline/apis/chapter4_1_4.shtml
 *
 * 适用对象：服务商
 * 请求URL：https://api.mch.weixin.qq.com/v3/payroll-card/authentications/{authenticate_number}
 * 请求方式：GET
 * </pre>
 *
 * @author xiaoqiang
 * @date 2021/12/2
 */
@Data
@NoArgsConstructor
public class AuthenticationsResult implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * <pre>
   * 字段名：商户号
   * 变量名：mchid
   * 是否必填：是
   * 类型：string[1, 32]
   * 描述：
   *  query微信服务商下特约商户的商户号，由微信支付生成并下发
   *     示例值：1111111
   * </pre>
   */
  @SerializedName(value = "mchid")
  private String mchid;

  /**
   * <pre>
   * 字段名：子商户号
   * 变量名：sub_mchid
   * 是否必填：是
   * 类型：string[1, 32]
   * 描述：
   *  query微信服务商下特约商户的商户号，由微信支付生成并下发
   *  示例值：1111111
   * </pre>
   */
  @SerializedName(value = "sub_mchid")
  private String subMchid;
  /**
   * <pre>
   * 字段名：用户标识
   * 变量名：authenticate_number
   * 是否必填：是
   * 类型：string[1, 64]
   * 描述：
   *  用户在商户对应appid下的唯一标识
   * 示例值：onqOjjmo8wmTOOtSKwXtGjg9Gb58
   * </pre>
   */
  @SerializedName(value = "openid")
  private String openid;

  /**
   * <pre>
   * 字段名：核身渠道
   * 变量名：authenticate_scene
   * 是否必填：是
   * 类型：string[1, 16]
   * 描述：
   *   核身渠道，发起核身时的来源渠道，如通过小程序，硬件设备等
   *     FROM_MINI_APP：来自小程序方式核身
   *     FROM_HARDWARE：来自硬件设备方式核身
   *  示例值：onqOjjmo8wmTOOtSKwXtGjg9Gb58
   * </pre>
   */
  @SerializedName(value = "authenticate_scene")
  private String authenticateScene;

  /**
   * <pre>
   * 字段名：核身渠道标识
   * 变量名：authenticate_source
   * 是否必填：是
   * 类型：string[1, 64]
   * 描述：
   *    核身渠道标识，用于定位渠道具体来源，如果是扫码打卡渠道标识就是具体的小程序appid，若是硬件设备，则是设备的序列号等
   * 示例值：wdiooewl7587443649000
   * </pre>
   */
  @SerializedName(value = "authenticate_source")
  private String authenticateSource;

  /**
   * <pre>
   * 字段名：项目名称
   * 变量名：project_name
   * 是否必填：是
   * 类型：string[1, 12]
   * 描述：
   *    该项目的名称
   *  示例值：某项目
   * </pre>
   */
  @SerializedName(value = "project_name")
  private String projectName;

  /**
   * <pre>
   * 字段名：单位名称
   * 变量名：employer_name
   * 是否必填：是
   * 类型：string[1, 12]
   * 描述：
   *    该用户所属的单位名称。
   *  示例值：某单位名称
   * </pre>
   */
  @SerializedName(value = "employer_name")
  private String employerName;

  /**
   * <pre>
   * 字段名：核身状态
   * 变量名：authenticate_state
   * 是否必填：是
   * 类型：string[1, 32]
   * 描述：
   *    核身状态
   *     AUTHENTICATE_PROCESSING：核身中
   *     AUTHENTICATE_SUCCESS：核身成功
   *     AUTHENTICATE_FAILED：核身失败
   *  示例值：AUTHENTICATE_PROCESSING
   * </pre>
   */
  @SerializedName(value = "authenticate_state")
  private String authenticateState;
  /**
   * <pre>
   * 字段名：核身时间
   * 变量名：authenticate_time
   * 是否必填：是
   * 类型：string[1, 32]
   * 描述：
   *   核身时间，遵循RFC3339标准格式，格式为YYYY-MM-DDTHH:mm:ss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。
   *   示例值：2015-05-20T13:29:35+08:00
   * </pre>
   */
  @SerializedName(value = "authenticate_time")
  private String authenticateTime;
  /**
   * <pre>
   * 字段名：商家核身单号
   * 变量名：authenticate_number
   * 是否必填：是
   * 类型：string[1, 64]
   * 描述：
   *  商户系统内部的商家核身单号，要求此参数只能由数字、大小写字母组成，在服务商内部唯一
   *  示例值：mcdhehfgisdhfjghed39384564i83
   * </pre>
   */
  @SerializedName(value = "authenticate_number")
  private String authenticateNumber;

  /**
   * <pre>
   * 字段名：核身失败原因
   * 变量名：authenticate_failed_reason
   * 是否必填：否
   * 类型：string[1, 128]
   * 描述：
   *  结果为核身失败时的原因描述，仅在失败记录返回
   *  示例值：人脸验证未通过
   * </pre>
   */
  @SerializedName(value = "authenticate_failed_reason")
  private String authenticateFailedReason;
}
