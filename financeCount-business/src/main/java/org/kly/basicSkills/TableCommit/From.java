package org.kly.basicSkills.TableCommit;

import org.kly.basicSkills.TableCommit.Validation.DateString;

/**
 * 自定义校验-testvo
 * @author kongly
 * @date 2017-07-03 10:00:00
 */
public class From {
    @DateString
    private  String current;

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }
}
