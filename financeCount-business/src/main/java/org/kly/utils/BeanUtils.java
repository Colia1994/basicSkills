package org.kly.utils;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Colia
 * @Date 2018-4-23.
 */
public class BeanUtils {

    /**
     * 比较POJO对象 生成固定的（可优化）差异list
     * @param befObject 修改前pojo
     * @param aftObject 修改后pojo
     * @return 差异化list
     */
    public static List<String> compareBeanInfo(Object befObject, Object aftObject) {
        List<String> resultList = new ArrayList<>();

        try {
            BeanInfo befBeanInfo = Introspector.getBeanInfo(befObject.getClass());
            BeanInfo aftBeanInfo = Introspector.getBeanInfo(aftObject.getClass());
            PropertyDescriptor[] befPDs = befBeanInfo.getPropertyDescriptors();
            PropertyDescriptor[] aftPDs = aftBeanInfo.getPropertyDescriptors();

            for (PropertyDescriptor befPd : befPDs) {
                String befKey = befPd.getName();
                for (PropertyDescriptor aftPd:aftPDs) {
                    String aftKey = aftPd.getName();
                    if(StringUtils.equals(befKey,aftKey)){
                        Method befMethod = befPd.getReadMethod();
                        Method aftMethod = aftPd.getReadMethod();
                        if(null != befMethod && null != aftMethod){
                            Object befValue = befMethod.invoke(befBeanInfo);
                            Object aftValue = aftMethod.invoke(aftBeanInfo);
                            if(ObjectUtils.compare(befKey,aftKey) != 0){
                                resultList.add(befKey+" " + befValue + "->" +aftValue + ";" );
                            }
                        }
                    }
                }
            }

        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return resultList;
    }

}
