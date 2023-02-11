package com.twelvet.utils;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.github.pagehelper.util.StringUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.apache.calcite.linq4j.tree.ExpressionType.Convert;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: Servlet工具
 */
public class ServletUtils {

    public static final String METHOD_DELETE = "DELETE";

    public static final String METHOD_HEAD = "HEAD";

    public static final String METHOD_GET = "GET";

    public static final String METHOD_OPTIONS = "OPTIONS";

    public static final String METHOD_POST = "POST";

    public static final String METHOD_PUT = "PUT";

    public static final String METHOD_TRACE = "TRACE";


    /**
     * 获取request
     *
     * @return HttpServletRequest
     */
    public static Optional<HttpServletRequest> getRequest() {
        return Optional
                .ofNullable(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
    }

    /**
     * 获取getResponse
     *
     * @return HttpServletResponse
     */
    public static HttpServletResponse getResponse() {
        return getRequestAttributes().getResponse();
    }

    /**
     * 获取RequestAttributes
     *
     * @return ServletRequestAttributes
     */
    public static ServletRequestAttributes getRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
    }

    /**
     * 获取session
     *
     * @return HttpSession
     */
    public static HttpSession getSession() {
        return getRequest().get().getSession();
    }

    /**
     * 获取json格式参数
     *
     * @return Map
     */
    public static Map<String, String> getMapParam() {
        return getMapParam(getRequest().get());
    }

    /**
     * 获取json格式参数
     *
     * @param httpServletRequest HttpServletRequest
     * @return Map
     */
    public static Map<String, String> getMapParam(HttpServletRequest httpServletRequest) {
        Map<String, String> map = new HashMap<>(6);
        // 获取所有参数名称
        Enumeration enu = httpServletRequest.getParameterNames();
        // 遍历hash
        while (enu.hasMoreElements()) {
            String paramName = (String) enu.nextElement();
            // 获取参数值
            String[] paramValues = httpServletRequest.getParameterValues(paramName);
            // 是否存在参数
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    map.put(paramName, paramValue);
                }
            }
        }
        return map;
    }

    /**
     * 获取body数据
     *
     * @return String
     */
    public static String getStrFromStream(HttpServletRequest req) {
        StringBuilder sb = new StringBuilder();
        try (ServletInputStream inputStream = req.getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] charBuffer = new char[128];
            int bytesRead;
            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                stringBuilder.append(charBuffer, 0, bytesRead);
            }

            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 获取Integer参数
     *
     * @param name 参数名称
     * @return 返回参数数据
     */
    public static Integer getParameterToInt(String name) {
        String value = getRequest().get().getParameter(name);

        if (value == null) {
            return 1;
        }
        if (StringUtil.isEmpty(value)) {
            return 1;
        }
        try {
            return Integer.parseInt(value.trim());
        } catch (Exception e) {
            return 1;
        }
    }

    /**
     * 获取String参数
     */
    public static String getParameter(String name) {
        return getRequest().get().getParameter(name);
    }


}
