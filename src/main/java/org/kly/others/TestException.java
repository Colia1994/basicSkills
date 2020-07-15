package org.kly.others;

/**
 * @author colia
 * @date 2019/1/2 21:52
 */
public class TestException {

    public TestException() {
    }

    private Boolean testEx() throws Exception {
        Boolean ret = true;
        try {
            ret = testEx1();
        } catch (Exception e) {
            System.out.println("testEx, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx, finally; return value=" + ret);
            return ret;
        }
    }
    private Boolean testEx1() throws Exception {
        Boolean ret = true;
        try {
            ret = testEx2();
            if (!ret) {
                return false;
            }
            System.out.println("testEx1, at the end of try");
            return ret;
        } catch (Exception e) {
            System.out.println("testEx1, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx1, finally; return value=" + ret);
            return ret;
        }
    }
    private Boolean testEx2() throws Exception {
        Boolean ret = true;
        try {
            int b = 12/0;
            return true;
        } catch (Exception e) {
            System.out.println("testEx2, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx2, finally; return value=" + ret);
            return ret;
        }
    }


    public static void main(String[] args) {
        TestException testException1 = new TestException();
        try {
            testException1.testEx();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
