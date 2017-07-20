package org.kly;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        String s1 = " plan_id=123123123a123123k123123jdg222ha asd ";
        App app = new App();
        System.out.print(app.matchExg(s1,"plan_id="));
    }

    private String matchExg(String longString ,String shortMatch){
        //匹配结果
        String resultMatch = "";
        //正则， 匹配模式为固定字符连接多个不间断的数字
        //+代表n前面符合条件，不间断连接，若需要固定长度，更换为[3] 例如:" [0-9]{3}"
        String exg = shortMatch + "[0-9]+";
        Pattern p = Pattern.compile(exg);
        //构建正则匹配对象
        Matcher m = p.matcher(longString);
        //判断待匹配字符串中是否包含结果
        Boolean result = m.find();
        if(result){
            //获取匹配到的对象组（默认不传index为获取第一个匹配项目）
            resultMatch = m.group();
            resultMatch = resultMatch.replaceAll(shortMatch,"");
            return  resultMatch;
        }
        return null;
    }
}
