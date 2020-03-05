package com.xmobile.pppdemonew.data.repository.v2.remote.res;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.xmobile.xbizv2.XResponseV2;
import com.xmobile.xlogger.XLogger;
import com.xmobile.xretrofit.gson.GsonUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class XResponseV2JSONDeserializerNew implements JsonDeserializer<XResponseV1> {

    Gson gson = GsonUtils.getGson();

    public XResponseV2JSONDeserializerNew() {
    }
    @Override
    public XResponseV1 deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        XResponseV1 xResponseV1 = new XResponseV1();
        if (json.isJsonObject()) {
            JsonObject jsonObject = json.getAsJsonObject();
            xResponseV1.setErrorCode(jsonObject.get("code").getAsInt());
            xResponseV1.setErrorMsg(jsonObject.get("msg").getAsString());
            if (xResponseV1.getErrorCode() == 0) {
                String sdata = jsonObject.get("data").getAsString();
                XLogger.e("sdata:" + sdata, new Object[0]);
                if (!TextUtils.isEmpty(sdata)) {
                    Type ttype = this.getDataType(typeOfT);
                    if (ttype == null) {
                        xResponseV1.setData(sdata);
                    } else {
                        try {
                            Object data = this.gson.fromJson(sdata, ttype);
                            xResponseV1.setData(data);
                        } catch (Exception var9) {
                            xResponseV1.setErrorMsg(var9.getMessage());
                            XLogger.e(var9.getMessage(), new Object[0]);
                        }
                    }
                }
            }

            return xResponseV1;
        } else {
            return null;
        }
    }

    private Type getDataType(Type typeOfT) {
        if (typeOfT == null) {
            return null;
        } else {
            try {
                ParameterizedType theType = (ParameterizedType)typeOfT;
                Type[] actualTypeArguments = theType.getActualTypeArguments();
                return actualTypeArguments != null && actualTypeArguments.length != 0 ? actualTypeArguments[0] : null;
            } catch (Exception var4) {
                return null;
            }
        }
    }
}
