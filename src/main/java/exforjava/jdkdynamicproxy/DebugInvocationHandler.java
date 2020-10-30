package exforjava.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DebugInvocationHandler implements InvocationHandler{
    private final Object object;
    public DebugInvocationHandler(Object target){
        object=target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException,IllegalAccessException {
        System.out.println("Before method "+method.getName());
        Object result=method.invoke(object,args);
        System.out.println("After method "+method.getName());
        return result;
    }
}
