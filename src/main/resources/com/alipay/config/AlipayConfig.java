package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091500517555";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCQUvasmlHG5Vs7eesmdsqm34E0GW+uVNm38UJEl5fxNGEXjJJD69jXYWlRTPOl8uzrgP1GlSc4j5srebxguHq3jEtaVufT9fCASYQXLDM8+37fR1nN9hGA0slOPSyk7ROEFnF3hXghhDkJklgEMdsSfZoLGVOtT1L4q0jigPgh6dEQ+BOUKWYLflOp4UhS/xNHGGx6QaOHD++x68aQR8rvgjukTEMgvoki+H0GbvUluNjyUaPrVHOFjoNHGLH6IgyOoOC/qHesJhFqp1YyjEOhfbZLpZ+oaf7tPddoVbAD2vSx4ZDYhoQkThH8KBfbAxDGvXDOh26XtZIfJvpnJq4xAgMBAAECggEAfiN0ovCRbrPA5B+vrUN/5Q9NPnrIyGYyj3jWQVr5GoB8J3fd0m1MbRofUUZfYPgLp91qAAmWaPHiXcIdKa+y2b9NkJyKLBA07frS7unbsn3gqkcTL1bUf3I7LR18an0mZHi1HRBTKYAF1d7I/ImSffu26eJt5viAfQQ/RHAR7pi2b6NnG/C7Jb4VTRGYCx+WXDi6QkOyl6KGrsUiMCKZ/JDQMWLgrmo9v6bDFQxenCr5X+X3+fJn1K0FYCFKByxYam822lDmLG7Jpj0lFUt423okiaxfvHMW7VRD5c895ispDk10zL+dqUSGtXCmJG35vCAXzcHTwjH5Qe8rDcblEQKBgQDma49EIy19G1XKxPkcN5t66votLLyP/5wibV0zmbLjt/HzVlnZFYRCK4nVAIfh6FYSlDy1abuT/GiB3nHOMfwY2i1PXjYj87VHiW1yRQgQdZ1pDmhcv+MiXLMlqJY807RPqBfVSDGPk3OVDB8wiI/s4hzAD4kSd/LfnxiQ3qhfxQKBgQCgWJdGWxkrnUA2ko9BCKRKlJ+vvigYtkpmmv/eLBk+n5fXWF6AMC0WYXTWsWBRGQHWMIh3CCrqKv9tAyHQaf/rbJX+eH8DaeadHn4whYaIPugcDy217YiDeH7s7ozfIUpDsHBc8TZOofqsBJeaWb0e4w9KEDnINM/4HqY7UNvvfQKBgQCp2iPTwHKpxFqrjCNtr3gHVetxHYcqRuwbXK7VeLkrr87E56R3p6rE9D84Kpn/5zp7m5ZczEIfxnJrOUR/EM2arEm2NeaG/gFlaGKrV0OojmqopJw9sp2GGPteCTYmRJCoH2riJ8OQ6MrM1hCvwBsILW2wDkOmv5DjUu3S7K8FWQKBgDByM9qNAbDcxR737xJuIv1ppEm8AW9d/GK96BrfZg02uPDWgU7nv2eosF2BoCFAlf56EXEtZZH0xdHRBXFr5WfjGfqVu4Jzh7rnEKdmYHxfzU9VArGaAAoA6RB7DtMHwuFquLhMJOVjKVK53HhFLs/bOK5e8qZb1o4X7I+1YY4dAoGAbAVBYyLEUGeozmaOPefR573jMp7jjzXNdgzqtCIT+67/+oi+iDySm81MAzw310rA88rdURFhGPBowDUUKeFGY5bKstIxlaMw1XY6s3qwpa1Ro65DRJ2pC/BOZ0xpYXpsGM/mo7B5tR1VwxQhlb9Z8vlh45tpucRsW5p6ftAGtWQ=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA3uF8oN05w+BdakQnzEA581oXtlt4iE45lp0qQWuaJ6WNPhy2zbjaBCfWl5+qlngILNNet5eVAnpRisZMrif+vjKyJsu8A+af3QBj0BkK/Bw9e/b6cQRjzs0387XgB13RyCjMOY+TH/BxrYbsnvqEfSw6bmk2OIyjPIqglYJBbnJ5MaftsJss4tV6pF5SB4+k4sTV4lCUZPeVAxbnGkGOg8f2bKR6cukjzgPgw2FpIHoz6ArDSIsB1TYYFg4g6QkOOLzCEhfyhXrlvgorxvaJsu1oOWpS7QJfZk5wSNSgFqvKFgTUn/Shr6/pAreZ05mkZdpeVu536WnHLTzhmSlKRwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8088/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8088/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

