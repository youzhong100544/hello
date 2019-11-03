package hello.java.demo.demo_interface;

interface DemoInterface {

    /**
     * Modifier 'public' is redundant for interface fields
     * Inspection info: Reports any redundant modifiers on interfaces or interface components
     * 修饰词“public”对于接口字段是多余的
     * 检查信息:报告接口或接口组件上的任何冗余修饰符
     *
     * Modifier 'static' is redundant for interface fields
     * Inspection info: Reports any redundant modifiers on interfaces or interface components
     * 修饰词“static”对于接口字段是多余的
     * 检查信息:报告接口或接口组件上的任何冗余修饰符
     *
     * Modifier 'final' is redundant for interface fields
     * Inspection info: Reports any redundant modifiers on interfaces or interface components
     * 修饰词“final”对于接口字段是多余的
     * 检查信息:报告接口或接口组件上的任何冗余修饰符
     */
    public int a = 1;
    static int b = 2;
    final int c = 3;
    public static final int d = 4;




}

public interface A {

}

protected interface B {

}

interface C {

}

private interface D {

}
