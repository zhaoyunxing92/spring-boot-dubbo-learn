/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.xyz.boot.core.web.config.jsonformat;

import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author zhaoyunxing
 * @date: 2019-03-14 15:38
 * @des: 格式 BigDecimal 类型数据,只对整数补0,保留两位　eg: 10 >> 10.00    15.589 >> 15.589
 * 暂时没有启用
 */
public class BigDecimalFormat extends BigDecimalCodec {
    public static final BigDecimalFormat instance = new BigDecimalFormat();

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.out;
        if (null == object) {
            // 不起作用
            out.write("0.00");
        } else {
            BigDecimal val = (BigDecimal) object;
            // 整数补00   10 >> 10.00
            String outText;
            if (new BigDecimal(val.intValue()).compareTo(val) == 0) {
                outText = val.setScale(2, RoundingMode.HALF_UP).toString();
            } else if (out.isEnabled(SerializerFeature.WriteBigDecimalAsPlain)) {
                outText = val.toPlainString();
            } else {
                outText = val.toString();
            }
            out.write(outText);

            if (out.isEnabled(SerializerFeature.WriteClassName) && fieldType != BigDecimal.class && val.scale() == 0) {
                out.write('.');
            }
        }

    }
}
