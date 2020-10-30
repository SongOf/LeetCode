package exforjava.Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TargetObject {
    private String value;
    public TargetObject(){
        this.value="JavaReflect";
    }

    public void publicMethod(String s){
        System.out.println("publicMethod:"+s);
    }

    private void privateMethod(){
        System.out.println("privateMethod:"+value);
    }

    public static void main(String[] args) throws ClassNotFoundException,IllegalAccessException,InstantiationException,NoSuchMethodException, InvocationTargetException,NoSuchFieldException {
        Class<?> targetClass=Class.forName("exforjava.Reflect.TargetObject");
        TargetObject targetObject=(TargetObject)targetClass.newInstance();

        Method[] methods=targetClass.getDeclaredMethods();
        for(Method method:methods){
            System.out.println(method.getName());
        }

        Method puclicMethod=targetClass.getDeclaredMethod("publicMethod", String.class);
        puclicMethod.invoke(targetObject,"java");

        Field field=targetClass.getDeclaredField("value");
        field.setAccessible(true);
        field.set(targetObject,"afterEdit");
        System.out.println(targetObject.value);

        Method privateMethod=targetClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);
    }
}
